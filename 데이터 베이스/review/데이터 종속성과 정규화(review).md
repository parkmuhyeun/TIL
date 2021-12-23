# 데이터 종속성과 정규화(review)
#etc/데이터 종속성과 정규화(review)

---
## 관계형 데이터베이스 설계의 문제점
- 잘못된 데이터베이스 설계의 문제점
    - 정보의 중복
    - 특정 정보를 나타낼 수 없음
        - 삽입 이상(Insert Anomaly)
        - 삭제 이상(Delete Anomaly)
        - 갱신 이상(Update Anomaly)

## 분할
- 정보 중복 및 이상 현상을 해결하는 방법
    - 릴레이션을 분할
    - 잘못된 분할은 정보 손실(Information Loss) 초래

## 무손실 조인 분할(Lossless Join Decomposition)

## 함수 종속성
- 기본 개념

### 함수 종속성 집합의 Closure
- 함수 종속성 집합 F의 Closure: F+
    - 단순 종속성(Trivial Dependency)
    - 부분 종속성(Partial Dependency)

### Armstrong의 원칙
- 기본 규칙
    - 반사, 첨가, 이행
- 추가 규칙
    - 결합, 분할, 의사 이행

### Canonical Cover
- 필요성
- 군더더기 속성

## 함수 종속성을 이용한 정규화

### 분할의 바람직한 속성
- 분할의 바람직한 두 가지 속성
    - 무손실 조인 분할(Lossless Join Decomposition)
    - 종속성 보전 분할(Dependency Preserving Decomposition)

### 정규화
문제점(데이터 중복, 삽입/삭제/갱신 이상현상)이 있는 릴레이션을 분할하는 과정. 단, 정보 손실이 없도록(무손실 조인 분할, 종속성 보전 분할) 분할

### 제1정규형(1NF: 1st Normal Form)
모든 속성들이 원자 값(atomic value)만을 갖는 경우.

### 제2정규형(2NF: 2nd Normal Form
- 제1정규형의 문제점
    - 부분 종속성
- 제2정규형의 정의

### 제3정규형(3NF: 3rd Normal Form)
- 제2정규형의 문제점
    - 이행 종속성
- 제3정규형의 정의

### Boyce-Codd 정규형(BCNF)
- 제3정규형의 문제점
- BCNF의 정의

## BCNF와 3NF의 비교

## 다중치 종속성을 이용한 정규화