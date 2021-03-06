# Querydsl
#TIL/Querydsl/

---
## 기본문법

### JPQL vs Querydsl

#### JPQL
```java
String qlString =
    "select m from Member m " +
    "where m.usrename = :username";

Member findMember = em.createQuery(qlString, Member.class)
        .setParameter("username", "member1")
        .getSingleResult();
```

#### Querydsl
```java
JPAQueryFactory queryFactory = new JPAQueryFactory(em);
                QMember m = new QMember("m");

        Member findMember = queryFactory
                .select(m)
                .from(m)
                .where(m.username.eq("member1"))    //파라미터 바인딩 처리
        .fetchOne();
```

- EntityManager로 JPAQueryFactory 생성
- Querydsl은 JPQL 빌더
- JPQL: 문자(실행 시점 오류), Querydsl: 코드(컴파일 시점 오류)
- JPQL: 파라미터 바인딩 직접, Querydsl: 파라미터 바인딩 자동 처리

### 기본 Q-Type 활용
Q클래스 인스턴스를 사용하는 2가지 방법
```java
QMember qMember = new QMember("m"); //별칭 직접 지정
QMember qMember = QMember.meber; //기본 인스턴스 사용
```

### 결과 조회

- fetch(): 리스트 조회, 데이터 없으면 빈 리스트 반환
- fetchOne(): 단 건 조회
    - 결과가 없으면 : null
    - 결과가 둘 이상이면 : NonUniqueResultException
- fetchFirst(): limit(1).fetchOne();
- fetchResults(): 페이징 정보 포함, total count 쿼리 추가 실행
- fetchCount(): count 쿼리로 변경해서 count 수 조회

### 조인 - 기본 조인
join(조인 대상, 별칭으로 사용할 Q타입)
```java
.join(member.team, team)
```

#### 세타 조인
연관관계가 없는 필드로 조인
```java
.from(member, team)
```
- from 절에 여러 엔티티 선택해서 세타 조인

### 조인 - on절
- on절을 활용한 조인
1. 조인 대상 필터링 (외부조인이 필요한 경우)
```java
.leftJoin(member.team, team).on(team.name.eq("teamA"))
```

2. 연관관계 없는 엔티티 외부 조인
```java
.leftJoin(team).on(member.username.eq(team.name))
```
- leftJoin()부분에 일반 조인과 다르게 엔티티 하나만 들어감
    - 일반조인: leftJoin(member.team, team)
    - on조인: from(member).leftJoin(team).on(xxx)

### 조인 - 페치 조인
join(), leftjoin()등 조인기능 뒤에 fetchJoin() 이라고 추가

### 서브 쿼리
com.querydsl.jpa.JPAExpressions 사용
```java
        QMember membersub = new QMember("memberSub");

List<Member> result = queryFactory
                .selectFrom(member)
                .where(member.age.eq(
                        JPAExpressions
                        .select(memberSub.age.max())
                        .from(memberSub)
            ))
            .fetch();
```

#### from 절의 서브쿼리 한계
JPA JPQL 서브쿼리의 한계점으로 from 절의 서브쿼리는 지원하지 않는다.(select, where 가능)

#### from 절의 서브쿼리 해결방안
1. 서브쿼리를 join으로 변경한다.
2. 애플리케이션에서 쿼리를 2번 분리해서 실행한다.
3. nativeSQL을 사용한다.

### 상수,문자 더하기

#### 상수더하기
상수가 필요하면 Expressions.constant(xxx) 사용
```java
Tuple result = queryFactory
                .select(member.username, Expressions,constant("A")) // -> [{member.username}, A]
                .from(member)
                .fetchFirst();
```

#### 문자 더하기 concat
```java
String result = queryFactory
                                .select(member.username.concat("_").concat(member.age.stringValue()))   // -> [{member.username}_{member.age}]
        .from(member)
        .where(member.username.eq("member1"))
        .fetchOne();
```
참고: 문자가 아닌 다른 타입들은 stringValue()로 문자로 변환할 수 있다. 이 방법은 ENUM을 처리할 때도 자주 사용

## 중급 문법

### 프로젝션과 결과 반환 - 기본
프로젝션: select 대상 지정

#### 프로젝션 대상이 하나
```java
List<String> result = queryFactory
                .select(member.username)
                .from(member)
                .fetch();
```
- 프로젝션 대상이 하나면 타입을 명확하게 지정할 수 있음
- 프로젝션 대상이 둘 이상이면 튜플이나 DTO로 조회

#### 튜플 조회
프로젝션 대상이 둘 이상일 때 사용
```java
List<Tuple> result = queryFactory
                .select(member.username, member.age)
                .from(member)
                .fetch();
```

### 프로젝션과 결과 반환 - DTO 조회

#### 순수 JPA에서 DTO 조회
```java
List<MemberDto> result = em.create("select new study.querydsl.dto.MemberDto(m.username, m.age) " +
                "from Member m", MemberDto.class)
                .getResultList();
```
- 순수 JPA에서 DTO 조회할 때는 new 명령어 사용
- DTO의 패키지 이름을 다 적어야됨
- 생성자 방식만 지원

#### Querydsl 빈 생성
결과를 DTO 반환할 때 사용

- 프로퍼티 접근
```java
List<MemberDto> result = queryFactory
                .select(Projections.bean(MemberDto.class,
                        member.username,
                        member.age))
        .from(member)
        .fetch();
```

- 필드 직접 접근
```java
List<MemberDto> result = queryFactory
                .select(Projections.fields(MemberDto.class,
                        member.username,
                        member.age))
        .from(member)
        .fetch();
```

- 별칭이 다를 때
```java
List<UserDto> fetch = queryFactory
                .select(Projections.fileds(UserDto.class,
                        member.username.as("name"),
                        ExpressionUtills.as(
                        JPAExpression
                                .select(MemberSub.age.max())
                                .from(memberSub),"age")
               )                
        ).from(member)
        .fetch();
```
- 프로퍼티나, 필드 접근 생성 방식에서 이름이 다를 때 해결 방안
- ExpressionsUtills.as(source, alias): 필드나, 서브 쿼리에 별칭 적용
- username.as("memberName"): 필드에 별칭 적용

        - 생성자 사용
```java
List<MemberDto> result = queryFactory
                .select(Projections.constructor(MemberDto.class,
                        member.username,
                        member.age))
        .from(member)
        .fetch();
```

### 프로젝션과 결과 반환 - @QueryProjection
생성자 + @QueryProjection(QMemberDto 있어야 함)

```java
.select(new QMemberDto(member.username, member.age))
```
이 방법은 컴파일로 타입을 체크할 수 있으므로 가장 안전한 방법. 다만 DTO에 QueryDSL 어노테이션을 유지해야 하는점과 DTO까지 Q 파일을 생성해야 하는 단점이 있음.

### 동적 쿼리를 해결하는 두가지 방식
- BooleanBuilder
```java
BooleanBuilder builder = new BooleanBuilder();
if(usrenameCond != null) {
        builder.and(member.username.eq(usernameCond));
}

if (ageCond != null) {
        builder.and(member.age.eq(ageCond));
 }

return queryFactory
        .selectFrom(member)
        .where(builder)
        .fetch();
```

- Where 다중 파라미터 사용
```java
return queryFactory
        .selectFrom(member)
        .where(usernameEq(usernameCond), ageEq(ageCond))
        .fetch();

private BooleanExpression usernameEq(String usernameCond) {
        return usernameCond != null ? member.username.eq(usernameCond) : null;
}

private BooleanExpression ageEq(Integer ageCond) {
        return ageCond != null ? member.age.eq(ageCond) : null;
}
```

조합 가능
```java
private BooleanExpression allEq(String usernameCond, Integer ageCond) {
        return usernameEq(usernameCond).and(ageEq(ageCond));
}
```


---
참고
https://www.inflearn.com/course/Querydsl-%EC%8B%A4%EC%A0%84

