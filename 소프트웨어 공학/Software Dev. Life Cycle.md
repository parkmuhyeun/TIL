# Software Dev. Life Cycle
#소프트웨어 공학/Software Dev. Life Cycle

---
Process
- 일이 처리되는 과정이나 공정
- A set of procedures for the purpose of solving a given task

## What is software process model?
determines the order of stages

### Process models have a 2-fold effect
- Provide guidance to software engineers on the order(Various technical activities)
- afford a framwork for managing development and maintenance

## Why are Process Models Important?
- uniformity of performance across diffrent projects and productivity
- quality

![](./img/SDLC_1.PNG)

Which one prefer?
- As a Developer - Black Box
- As a project manager - White Box

Process quality will lead to product quality

### Role of software process model
- Building baisc framework
- Scheduling
- Cost estimation
- Communication
- Standardization of terminology
- Cleary understading of software development

### CASE(Computer-Aided Software Engineering)
소프트웨어 공학의 여러 작업들을 자동화하는 도구

## Build-and-Fix Model
공식적인 가이드라인이나 프로세스가 없는 개발요구 분석

![](./img/SDLC_2.PNG)

- 개발자 한명이 단 시간에 마칠수 있는 경우에 적합

단점
- 문서가 없어 관리 및 유지보수가 힘듬
- 좋은 SW architecture을 만들 수 없다

## Waterfall model

![](./img/SDLC_3.PNG)

- 1970년대 인기, 요즘은 무거워서 많이 안씀
- 문서에 많이 의존적
- 다시 올라가기 힘듬

Types of maintenance
- Corrective: 20%(오류 수정 활동)
- Adaptive: 20%(환경변화를 반영하기 위한 활동)
- Perfective: 60%(새로운 기능 추가, 성능 개선을 위한 확장 활동)
- Protective (미래의 유지보수를 위한 활동)

Requirements analysis is a serious source of problems

### Waterfall Model에 대한 고찰
- Linear(순차적인)
- Rigid(엄격한)
- Monolithic (획일적이고 자유성이 떨어지는)

장점
- 관리의 용이
- 체계적인 문서화
- 요구사항의 변화가 적은 프로젝트에 적합

단점
- 각 단계의 결과물이 완벽한 수준으로 작성되어야 다음 단계에 오류를 넘겨주지 않는다.
- 사용자가 중간에 가시적인 결과를 볼 수 없어 답답해할 수 있다.

## Prototyping model
대량 생산에 앞서 미리 제작해보고 그걸 이용

### Throwaway prototyping
최종 프로토타입을 통해 결정된 사용자의 요구를 가지고 다시 처음부터 본격적으로 제품 개발

![](./img/SDLC_4.PNG)

### Incremental prototyping
사용자의 요구사항을 반복적으로 반영하여 구현된 프로토타입을 버리지 않고 지속적으로 개선 보완하여 최종시스템으로 완성

![](./img/SDLC_5.PNG)

장점
- 사용자 요구가 충분히 반영된 요구 분석 명세서 작성
- 오류를 일찍 발견 하는데 큰 도움

단점
- 반복적 개발을 통한 투입 입력 및 비용 산정의 어려움
- Documentation 관리 어려움
- 불명확한 개발범위로 인한 개발 종료 및 목표의 불확실성

## Incremental & Iterative model

![](./img/SDLC_6.PNG)

- Stepwise development
- Must retain the discipline introduced by the waterfall model at each build

장점
- 사용자에게 조정할 시간을 줌
- 변경 수용하기 쉬움
- 많은 자금 요구 x

단점
- 기존의 구조에 통합해야 되기 때문에 추가적인 빌드 필요
- Careful design 요구

## Spiral model(나선형 모델)
진화적 프로토타입 모델 + 위험 분석(risk analysis)

![](./img/SDLC_7.PNG)

Example of risk(위험 분석 단계의 위험 요소 예)
- 빈번히 변경되는 요구사항
- 팀원들의 경험 부족
- 결속력이 떨어지는 팀워크
- 프로젝트 관리 부족

장점
- 사전 위험 분석을 통한 돌출 위험 요소 감소 
- 사용자 평가에 의한 개발 방식

단점
- 반복적 개발로 인한 프로젝트 기간 연장 가능성
- 반복 회수의 증가에 따른 프로젝트 관리의 어려움
- 위험 관리의 중요 -> 관리 전문가 필요

## V model
Water fall model + Extended testing phases

![](./img/SDLC_8.PNG)

## Agile software development
보다 가벼운 개발 프로세스에 대한 논의 시작

Agile process model
- 고객의 요구에 민첩하게 대응하고 그때 그때 주어지는 문제를 풀어나가는 방법론

Agile의 기본 가치(Agile 선언문)
- 프로세스와 도구 중심이 아닌, 개개인간의 상호 소통 중시
- 문서 중심이 아닌, 실행 가능한 소프트웨어 중시
- 계약과 협상 중심이 아닌, 고객과의 협력 중시
- 계획 중심이 아닌, 변화에 따른 민첩한 대응 중시

### Extreme programming(xp)
- Emphasizes teamwork
- Improves a software project in five essential ways
    - Communication, simplicity, feedback, respect, and courage
- Pair programming, Small release, Incremental planning

![](./img/SDLC_9.PNG)

### Dynamic Systems Develpment Method(DSDM)
- 개발 80%는 총 시간의 20%를 사용하여 개발 가능
- 80%에 집중하고, 나머지 20%은 뒷 버젼에서
- MoSCow rules(prioritization)
    - M: Must have requirements
    - S: Should have if at all possible
    - C: Could have but not critical
    - W: Won't have this time, but potentially later

![](./img/SDLC_10.PNG)

### Lean
- Originated from manufacturing pratices
- Main principles
    - Eliminating Waste
    - Amplifying Learning
    - Deciding as Late as Possible
    - Deliver as Fast as Possible
    - Empowering the Team
    - 빠른 피드백
    - 반복을 통한 지속적인 혁신

### Scrum
초기단계부터 development, delivering, sustaining 고려해서 개발

- Main artifacts
    - Product backlog: 제품 기능 우선순위 정리
    - Sprint backlog: 하나의 sprint 동안 개발할 목록
    - Burndown chart: 개발을 완료하기 까지 남은 작업량 보여주는 그래프
- Characteristics
    - 하나의 Sprint 마다 위의 3가지 산출물 관리
    - 하나의 Sprint 마다 회의(일일스크럼, Sprint 계획, Sprint 리뷰)
    - 하나의 Sprint가 끝나면 개발된 결과물을 가지고 고객 확인과 피드백

    ![](./img/SDLC_11.PNG)

### There is no absolute solution woring for every project
### Need expertise to select the right model for your project