# Relational Model
#데이터베이스/Relational Model

---
## 기본적인 구조
관계형 데이터베이스(Relational Database)
- ER모델의 개체와 관계가 모두 릴레이션으로 표현

릴레이션(테이블)구조
- 스키마: 이름과 일정 수의 속성들의 집합
- 인스턴스: 릴레이션에 포함된 레코드들의 집합


### 속성, 열, 필드

![](./img/RM_1.png)

- 차수(degree): 릴레이션을 구성하는 속성의 수

### 레코드, 행, 튜플

![](./img/RM_2.png)

- 기수(Cardinality): 릴레이션의 레코드 개수

### 도메인(domain)
각 속성에 허용되는 값들의 집합
- ex) 사원( 사원번호 - 4자리 정수, 이름 - 문자 20, ...)

![](./img/RM_3.png)

### 릴레이션의 특징
- 상이한 레코드
    - 릴레이션에 포함된 레코드들은 모두 다르다.
- 레코드의 순서
    - 릴레이션에 포함된 레코드의 순서는 중요하지 않다.
- 릴레이션의 변동성
    - 레코드의 삽입, 삭제 등으로 인해 릴레이션은 시간에 따라 변한다.
- 속성 간의 순서
    - 속성들의 순서는 중요하지 않다.
    - 단, 대부분의 DBMS들은 속성에 순서를 부여함.
- 속성의 명칭과 값
    - 속성들의 명칭은 상이해야 하지만, 값은 같을 수 있음
    - 값도 상이한 속성 = 후보 키
- 속성 값의 원자성
    - 단순 속성 및 단일 값 속성만 지원

## 데이터베이스 언어
Query Language(질의어)
- 사용자가 데이터베이스의 정보를 액세스하기 위해 사용하는 언어

관계형 모델의 개념을 설명하기 위한 개념적인 언어
- 관계 대수(Relational Algebra)
- 관계 해석(Relational Calculus)

### 관계 대수(Relational Alegra)
하나 이상의 릴레이션을 입력으로 하여 새로운 결과 릴레이션을 생성

기본적인 연사자
- 입력 릴레이션이 하나인 연산자
    - Select, Project
- 입력 릴레이션이 두 개인 연산자
    - Cartesian Product, Union, Set Differnece

추가적인 연산자
- Set Intersection, Join, Division

### Select
릴레이션 r에서 조건 P를 만족하는 레코드들의 집합으로 구성된 새로운 릴레이션을 생성

![](./img/RM_4.png)

### Project
릴레이션 r의 속성 A1,A2,...,Ar을 가져와서 새로운 릴레이션으로 생성

![](./img/RM_5.png)

### Union
릴레이션 r 또는 s에 존재하는 모든 레코드들로 구성된 새로운 릴레이션을 생성

![](./img/RM_6.png)

### Set Difference
Notation: r - s
- 릴레이션 r에는 속하지만 s에는 존재하지 않는 레코들들로 구성된 새로운 릴레이션을 생성

![](./img/RM_7.png)

### Cartesian Product
Notation: r x s
- 릴레이션 r과 s의 레코드들의 모든 가능한 조합으로 구성된 새로운 릴레이션을 생성

![](./img/RM_8.png)

### Set Intersection
Notation: r x s
- r과 s에 모두 포함되는 레코드들로 구성된 새로운 릴레이션

## Join
공통 속성을 중심으로 두개의 릴레이션을 합쳐 새로운 릴레이션을 생성

Join의 종류
- Natural Join
- Theta Join, Equi Join
- Outer Join

### Natural Join
공통 속성을 중심으로 두개의 릴레이션을 하나로 합치는 연산. 중복되는 부분을 최소화

![](./img/RM_9.png)

### Theta Join, Equi Join

![](./img/RM_10.png)

### Outer Join
정보 손실을 피하기 위하여 join 연산을 확장
- 다른 테이블에 대응되는 레코드가 없는 레코드들을 join 결과에 추가(Null값 이용)
    - Left Outer Join
    - Right Outer Join
    - Full Outer Join

![](./img/RM_11.png)

![](./img/RM_12.png)

### Division

![](./img/RM_13.png)