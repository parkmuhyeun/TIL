# Logical Design(review)
#etc/Logical Design(review)

---
## ER 모델에서 관계형 모델로 변환
- 7가지 단계로 진행
- 변환에서 지켜야 할 지침

### 단계 1: 일반 Entity Type의 변환

### 단계 2: Weak Entity Type의 변환

### 단계 3: 이진 1:1 관계의 변환
- 외래키 방법
- 하나의 테이블로 병합
- 관계 테이블 R을 생성 (3개의 테이블)

### 단계 4: 이진 1:N 관계의 변환

### 단계 5: 이진 M:N 관계의 변환

### 단계 6: 다중치 속성의 변환

### 단계 7: N-ary 관계의 변환

## EER 모델에서 관계형 모델로 변환
단계8: 특수화/일반화의 변환
- 8A: 상위 클래스와 하위 클래스를 모두 테이블로 변환
- 8B: 하위 클래스만 테이블로 변환
- 8C: 모든 클래스를 하나의 테이블에 통합하여, 하나의 타입 속성을 추가
- 8D: 모든 클래스를 하나의 테이블에 통합하여, 여러 개의 타입 속성을 추가

### 공유 하위 클래스(다중 상속)의 변환

### 단계9: Union Type의 변환
대리키(surrogate key)를 이용하여 상위 클래스의 키를 통합