# 스프링 데이터 JPA
#TIL/스프링 데이터 JPA/

---
## 공통 인터페이스 기능

### JavaConfig 설정 - 스프링 부트 사용시 생략 가능

```java
@Configuration
@EnableJpaRepositories(basePackages = "jpabook.jpashop.repository")
public class AppConfig {}
```
- 스프링 부트 사용시 @SpringBootApplication 위치를 지정
- 만약 위치가 달라지면 @EnableJpaRepositories 필요

![](./images/스데J_1.PNG)

### 공통 인터페이스 적용
순수 JPA로 구현한 Repository 대신 스프링 데이터 JPA가 제공하는 공통 인터페이스 사용
```java
public interface MemberRepository extends JpaRepository<T, ID> {
}   //T: 엔티티타입, ID: 식별자 타입(PK)
```

---
## 쿼리 메소드 기능

### 메소드 이름으로 쿼리 생성
```java
List<Member> findByUsernameAndAgeGreaterThan(String username, int age);
```
- 스프링 데이터 JPA는 메소드 이름을 분석해서 JPQL을 생성하고 실행

### @Query, 리포지토리 메소드에 쿼리 정의
```java
@Query("select m from Member m where m.username = :username and m.age = :age")
List<Member> findUser(@param("username") String username, @param("age") int age)
```

### Query, 값, DTO조회하기
단순히 값 하나를 조회
```java
@Query("select m.username from Member m")
List<String> findUsernameList();
```

DTO로 직접 조회
```java
@Query("select new study.datajpa.dto.MemberDto(m.id, m.username, t.name)" + "from Member m join m.team t)"
List<MemberDto> findMemberdto();
```

### 파라미터 바인딩
```java
select m from Member m where m.username = ?0 //위치 기반
select m from Member m where m.username = :name //이름 기반
```

코드 가독성과 유지보수를 위해 이름 기반 파라미터 바인딩 쓰자

#### 컬렉션 파라미터 바인딩
Collection 타입으로 in절 지원
```java
@Query("select m from Member m where m.username in :names")
List<Member> findByNames(@Param("names") List<String> names);
```

### 스프링 데이터 JPA 페이징과 정렬

#### 페이징과 정렬 파라미터
- org.springframework.data.domain.Sort: 정렬기능
- org.springframework.data.domain.pageable: 페이징 기능 (내부에 Sort 포함)

#### 특별한 반환 타입
- org.springframework.data.domain.Page: 추가 count 쿼리 결과를 포함하는 페이징
- org.springframework.data.domain.Slice: 추가 count 쿼리 없이 다음 페이지만 확인 가능(내부적으로 limit + 1조회)
- List: 추가 count 쿼리 없이 결과만 반환

카운트 쿼리 분리(복잡한 sql에서 사용, 데이터는 left join, 카운트는 left join 안해도 됨)
```java
@Query(value = "select m from Member m ",
        countQuery = "select count(m.username) from Member m")
Page<Member> findMemberAllCountBy(Pageable pageable);
```

#### 페이지를 유지하면서 엔티티를 DTO로 변환
```java
Page<Member> page = meberRepostiory.findByAge(10, pageRequest);
Page<MemberDto> dtoPage = page.map(m -> new MemberDto());
```

### 벌크성 수정 쿼리

### JPA를 사용한 벌크성 수정 쿼리
```java
em.createQuery(
        "update Member m set m.age = m.age + 1" +
                "where m.age >= :age")
        .setParameter("age", age)
        .executeUpdate();
)
```

### 스프링 데이터 JPA를 사용한 벌크성 수정 쿼리
```java
@Modifying(claerAutomatically = true)
@Query("update Member m set m.age = m.age + 1 where m.age >= :age")
int bulkAgePlus(@Param("age") int age);
```

- 벌크성 수정, 삭제 쿼리는 @Modifying 어노테이션 사용
- 벌크성 쿼리를 실행하고 나서 영속성 컨텍스트 초기화: clearAutomatically = true
  - 이 옵션 없이 회원을 다시 조회하면 영속성 컨텍스트에 과거 값이 남아서 문제(벌크 연산은 영속성 컨텍스트 무시 하고 실행 하기 때문)

### @EntityGraph

연관된 엔티티를 한번에 조회하려면 페치 조인 필요

JPQL 페치 조인
```java
@Query("select m from Member m left join fetch m.team")
List<Member> findMemberFetchJoin();
```

스프링 데이터 JPA는 JPQL 없이 페치조인 사용할수 있게해줌
```java
@EntityGraph(attributePaths = {"team"})
@Query("select m from Member m")
List<Member> findMemberEntityGraph();
```

- 사실상 페치조인의 간편 버전

### JPA Hint
JPA 쿼리 힌트(SQL 힌트가 아니라 JPA 구현체에게 제공하는 힌트)
```java
@QueryHints(value = @QueryHint(name = "org.hibernate.readOnly", value = "true"))
Member findReadOnlyByUsername(String username);
```

---

## 확장기능 

### 사용자 정의 리포지토리 구현
- 스프링 데이터 JPA 리포지토리는 인터페이스만 정의하고 구현체는 스프링이 자동 생성
- 스프링 데이터 JPA가 제공하는 인터페이스를 직접 구현하면 구현해야 하는 기능이 너무 많음
- 다양한 이유로 인터페이스 메서드를 직접 구현하고 싶다면?
  - JPA 직접 사용
  - 스프링 JDBC template 사용
  - MyBatis 사용
  - 데이터베이스 커넥션 직접 사용
  - Querydsl 사용

#### 사용자 정의 인터페이스
```java
public interface MemberRepositoryCustom {
        List<Member> findMemberCustom();
}
```

#### 사용자 정의 인터페이스 구현 클래스
```java
public class MemberRepositoryImpl implements MemberRepostioryCustom {
        private final EntityManager em;

        @Override
        public List<Member> findMemberCustom(){
                return em.createQuery(" ")
                .getResultList();
        }
}
```

#### 사용자 정의 인터페이스 상속
```java
public interface MemberRepostiory extends JpaRepository<Member, Long>, MemberRepositoryCustom{
}
```

사용자 정의 구현 클래스
- 규칙: 리포지토리 인터페이스 이름 + Impl ( 스프링 데이터 2.X부터는 사용자 정의 인터페이스 명 + Impl 방식도 지원 ex)MemberRepositoryCustomImpl )
- 스프링 데이터 JPA가 인식해서 스프링 빈으로 등록

### Auditing
- 엔티티를 생성, 변경할 때 변경한 사람과 시간을 추적하고 싶으면?
  - 등록일
  - 수정일
  - 등록자
  - 수정자

#### 순수 JPA 사용
```java
@MappedSuperclass
@Getter
public class JpaBaseEntity {

        @Column(updatable = false)
        private LocalDateTime createdDate;
        private LocalDateTime updatedDate;
        
        @PrePersist
        public void prePersist() {
                LocalDateTime now = LocalDateTime.now();
                createdDate = now;
                updatedDate = now;
        }

        @PreUpdate
        public void preUpdate() {
                updatedDate = LocalDateTime.now();
        }
}
```

#### 스프링 데이터 JPA 사용
설정
- @EnableJpaAuditing -> 스프링 부트 설정 클래스에 적용해야함
- @EntityListeners(AuditingEntityListener.class) -> 엔티티에 적용

사용 어노테이션
- @CreatedDate
- @LastModifiedDate
- @CreatedBy
- @LastModifiedBy

```java
@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public class BaseEntity {

        @CreatedDate
        @Column(updatable = false)
        private LocalDateTime createdDate;

        @LastModifiedDate private LocalDateTime lastModifiedDate;

        @CreatedBy
        @Column(updatable = false)
        private String createdBy;
        
        @LastModifiedBy
        private String lastModifiedBy;
}
```

등록자, 수정자를 처리해주는 AuditorAware 스프링 빈 등록
```java
@Bean
public AuditorAware<String> auditorProvider() {
        return {} -> Optional.of(UUID.randomUUID().toString());
}
```
실무에서는 세션 정보나, 스프링 시큐리티 로그인 정보에서 ID를 받음

### WEB 확장 - 페이징과 정렬
```java
@GetMapping("/members")
public Page<Member> list(Pageable pageable) {
        Page<Member> page = memberRepository.findAll(pageable);
        return page;
}
```

#### Page 내용을 DTO로 변환
```java
@GetMapping("/members")
public Page<MemberDto> list(Pageable pageable) {
 Page<Member> page = memberRepository.findAll(pageable);
 Page<MemberDto> pageDto = page.map(MemberDto::new);
 return pageDto;
}
```


---
참고
https://www.inflearn.com/course/%EC%8A%A4%ED%94%84%EB%A7%81-%EB%8D%B0%EC%9D%B4%ED%84%B0-JPA-%EC%8B%A4%EC%A0%84#