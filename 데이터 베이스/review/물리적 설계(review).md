# 물리적 설계(review)
#etc/물리적 설계(review)

---
## 데이터베이스의 물리적 설계
- 물리적 설계란?
- 물리적 데이터베이스의 구조
- 참고사항

## 파일 구성(File Organization)
- 파일 구성이란?
- 가장 단순한 데이터베이스 구성 방법
- 고려 사항
    - 레코드의 표현 방법(고정 vs. 가변)
    - 파일에서 레코드 저장 방법(순차 vs. 클러스터링) 

### 레코드 표현 방법
- 고정 길이 레코드
    - Free list
- 가변 길이 레코드
    - 가변 길이 레코드를 위한 블록 구조

### 파일에서 레코드 저장 방법
- Heap 방식
- 순차 파일 구성
- 해싱
- 다중-테이블 클러스터링 파일 구성

## 접근 방법 설계
- 접근 방법 (Access Method)란?
- 인덱스
    - 유일 인덱스
    - 보조 인덱스
- 해싱
- Clustering
- Clustered Index

### B 트리
- 속성

### B* 트리
- two-to-three split

### B+ 트리
- 구조
    - 인덱스 세트(index set): 리프 노드가 아닌 노드들
    - 순차 세트(sequence set): 리프 노드
- B+ 트리의 Index Set 변경 과정

### B-Tree Family의 비교
- B-Tree Family가 항상 최선의 선택은 아니다
- B-Tree Family의 공통점

### Comparison of B-Tree and Hashing

### 보조 인덱스
- 보조 인덱스의 필요성
- 보조 인덱스에서 고려 사항
    - (key, value) 쌍에서 value에 저장하는 값?
        - 데이터 레코드의 주소
        - 주 키
    - 중복 키의 저장 방법
        - 역 인덱스 (Inverted Index)
        - 다중 리스트(Multi-list File)
- 역 인덱스
    - 기본 개념
    - 문제점
- 다중 리스트 파일
    - 구성 방식
    - 다중 리스트 파일의 구조
- 역 인덱스와 다중 리스트의 비교