# 질의 처리(review)
#etc/질의 처리(review)

---
## Overview
- Steps in Query Processing

### Query Optimization
- Network/Hierarchical Model
    - Application Programmer가 수행
- Relational Model
    - Automatic Optimization

## Catalog Information
- n(r): record 수
- b(r): block 수
- s(r): record size
- f(r): blocking factor(b(r) = n(r)/f(r))
- V(A,r): Attribute의 서로 다른 값의 수 in r
- SC(A,r): 예상값 = n(r) / V(A,r)

## 질의 처리 비용의 계산
- 질의의 실행 비용을 결정하는 요인들
    - 디스크 액세스 시간(!)
    - 질의를 실행하기 위한 CPU 시간
    - 통신 시간

### Basic Algorithms
- A1(linear search) - File Scan

### Selection Using Index
- Index Scan 필요
- A2(primary index, equality on key)
    - E(A2) = HT(i) + 1
- A3(secondary index (clustered), equality on non-key)
    - E(A3) = HT(i) + SC(A,r) / f(r)
- A4(secondary index (non-clustered), equality on non-key)
    - E(A4) = HT(i) + SC(A,r)

## Join Operation
- Nested-Loop Join (하나씩 다찾음)
- Block Nested-Loop Join (Block 단위의 비교)
- Indexed Nested-Loop Join(file scan대신 index lookup)
- Sort Merge Join(작은거 -> 큰거)
- Hash join ( 0 -> 9)
- Sort-Merge Join vs Hash Join
- Joins in oracle
- N-way Join

## Evaluation of Expressions
- Materialization
    - 중간 결과들을 임시 릴레이션에 저장
- Piplining

## Transformation of Relational Expressions
- Equivalence Rules
- Query Tree

## Choice of Evaluatiohn Plans
- Cost-Based Optimization
    - 최소 cost를 갖는 evaluation plan 선정
    - Evaluation plan이 많을 경우, 많은 시간 소요
- Heuristic Optimization
    - 일반적인 규칙들을 이용한 질의 최적화(경험적)

