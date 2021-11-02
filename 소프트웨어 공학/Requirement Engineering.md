# Requirement Engineering
#소프트웨어 공학/Requirement Engineering

---
## 요구 사항과 요구 분석 명세서의 이해
- SW 개발의 목적
    - 개발된 소프트웨어의 고객 만족
- 고객 만족을 위한 특성
    - 적시성: 빠른 출시를 통한 시장의 점유
    - 유연성: 다양한 환경에서의 적응성
    - 통합: 기존 시스템과의 쉬운 통합
- 고객 만족의 개발 조건
    - 고품질의 제품 개발
    - 정해진 기간내의 개발
    - 주어진 예산내의 개발

요구 사항
- 이용자가 어떤 문제를 풀거나 목표를 달성하기 위해 필요한 조건이나 능력(사전적 의미)- 사용자와 개발자 간에 합의한 개발 범위에서 시스템이 제공하는 기능(SW 개발 의미)

요구 분석 명세서
- 개발 초기에 사용자의 요구 사항(비기능 요구 사항 포함)을 추출하여 정리한 문서
- what에만 초점, how는 고려치 않음

요구 분석
- 소프트웨어 요구 사항 정의를 위해 사용자의 요구 사항을 조사하고 확인하는 과정
- 소프트웨어 개발 생명주기의 첫 단계
- 소프트웨어 개발 성패의 열쇠

## 요구 분석의 어려움
- 문제 영역(개발 도메인)에 대한 이해력 부족
- 의사 소통의 문제
    - 견본이 없어 요구 사항 설명이 어려움
    - 사용자가 요구 사항에 대한 설명 방법을 잘 모름
- 계속 변하는 요구 사항
    - 관련 지식의 증가로 인한 요구 사항 변경
- 애매모호한 요구 사항
    - 사용자의 일관성 없는 요구
    - 해석을 달리할 수 있는 애매한 표현의 요구

=> 요구사항 분석가의 역활
- 사용자의 요구를 정확하고 완전하게 획득하는 것

## Requirements Engineering
Emphasizes an iterative and cooperative process of
- analyze the problem(gathering and analysis)
- documents the resulting observations (specification)
- checking the accuracy of the understanding gained(verification)


### Requirements Elicitation
- 자료 수집
    - 문서 수집 -> 전반적인 업무 흐름 파악 및 이해
    - 현행 시스템 분석
- 인터뷰
    - 수집된 자료 분석 -> 인터뷰 -> 요구 삭제 및 추가 -> 수정된 요구 확인
- 설문 조사
    - 설문을 통한 또 한번의 요구사항 추출

인터뷰
- 사용자의 심층 대화로부터 요구를 끌어내는 방법
- 질문의 준비가 중요

JAD(Joint Application Development)
- 프로젝트 팀, 사용자, 관리자의 협의 회의
- 브레인스토밍 아이디어 회의
- 각 stackholder별 요구사항 추출 필요

### Requirements Analysis and Specification

![](./img/RE_1.PNG)

- Functional & nonfunctional
- Must state what to do, not how to do
- Used by both customers and designers
- Seperate functional requirements into 3 views:
    - A model of data: Entity relationshiop diagram, ...
    - A model of function: Use case diagram, ..
    - A model of control: Control flow diagrams, ...

## 요구 사항의 표현(Representation of requirements)
SW 개발에서의 모델
- 여러 설계 도면을 보고 건물을 시공하는 것처럼 SW 개발 시에도 여러 관점의 모델 사용
- UML의 다양한 다이어그램을 통해 소프트웨어의 범위나 개략적인 구조와 기능을 이해

SW에서의 모델 사용의 장점
- 개발될 소프트웨어에 대한 이해도 및 이해 당사자 간의 의사소통 향상
- 유지보수 용이

SW에서 모델 사용의 단점
- 과도한 문서 작업으로 인한 일정 지연 가능성
- 형식적인 산출물로 전락 가능성

모델링
- 모델을 제작하는 과정 또는 작업
- 현실 세계를 단순화하여 표현하는 기법

SW 개발에서의 모델링
- UML 다이어그램을 이용하여 표현

### Data Flow Diagram (DFD)

![](./img/RE_2.PNG)

### Entity Relationship Diagram (ERD)

![](./img/RE_3.PNG)

### Use Case Diagram

![](./img/RE_4.PNG)

### 요구 분석 명세서 작성시 주의 사항
- 사용자가 읽기 쉽고, 이해할 수 있도록 작성
- 개발자가 설계와 코딩에 효과적으로 사용할 수 있도록 작성
- 비기능적 요구를 명확히 작성
- 테스트 기준 용도로 사용할 수 있도록 정량적으로 작성
- 품질에 대한 우선순위를 명시

### The 7 Deadly Sins in RE
- Noise
    - Irrelevant information
    - Confusing presentation
- Silence
    - Omissions
- Over-specification
- Contradiction
    - Inconsistency
- Ambiguity
- Forward reference
- Wishful thinking

### Specification Qualities
Requirement specification이 갖추어야 할 조건
- Clear, understandable
- unambiguous
- Consistent
- Complete
- Verifiable
    - 체계적으로 검사할 수 있게 작성
    - ex) 많은 학생이 동시에 수강신청을 해도 문제가 없어야한다.( 많은 학생 -> 10000명의 학생)
- Easily changed
    - 요구 사항이 서로 의존적이지 않고 독립적으로 서술
- Traceable

## Nonfuctional Requirements
비 기능적 요구 사항
- 수행 가능한 환경, 제약 사항, 품질

### 품질
신뢰성, 보안성, 성능, 안전성

- 신뢰성(reliability)
    - 신뢰: 사용자가 주어진 시간과 환경에서 고장 없이 사용할 수 있어야 한다는 것
- 보안성(security)
    - 인증을 받지 않은 사람이 시스템에 접근하는 것을 차단
- 성능(performance)
    - 사용자가 시스템에 어떤 요구를 했을 때 해당 기능을 정상적으로 수행하는 것은 물론, 사용자가 원하는 조건(응답 시간, 데이터의 처리량 등)을 만족하는 것
- 안전성(safety)
    - 작동하는 모든 시스템이 소프트웨어 오류로 인해 인명 피해가 발생하지 않도록 하는 것