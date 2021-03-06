# Software Design
#Data Processing Engineer/Software Design

```
소프트웨어 설계

폭포수 모형
: 폭포수가 거슬러 올라갈 수 없듯이 이전 단계를 확실히 마무리하고 다음 단계로 진행하는 개발 방법론
[순서]
타당성에 대해 검토 -> 계획 -> 요구 분석 -> 설계 -> 구현-> 시험 과정을 거침

프로토타입 모형
: 요구사항을 정확히 파악하기 위해 실제 개발될 소프트웨어에 대한 시제품을 만들어 최종 결과물을 예측하는 모형

나선형 모형
: 폭포수 모형과 프로토타입 모형의 장점에 위험 분석 기능을 추가한 모형
- 나선을 따라 돌 듯 여러 번의 개발 과정을 거쳐 점진적으로 완벽한 최종 소프트웨어를 개발
- 소프트웨어를 개발하면서 발생할 수 있는 위험을 관리하고 최소화하는 것이 목적
- 대규모 프로젝트에서 많이 쓰임

애자일 모형
: 고객의 요구사항 변화에 유연하게 대응할 수 있도록 일정한 주기를 반복하면서 진행하는 모형
- 좋은 것을 빠르고 낭비 없게 만들기 위해 고객과의 소통에 초점을 맞춘 모든 방법론을 통칭

ㄱ. 스크럼
- 협업하면서 개발하는 것
- 팀이 중심이 되어 개발의 효율성을 높임

스크럼의 구성 요소

1. 제품 책임자
개발될 제품에 대한 이해도가 높고 요구사항을 책임지고 의사 결정을 할 사람

2. 스크럼 마스터
팀이 잘 수행할 수 있도록 객관적인 시각에서 조언을 해주는 가이드 역할

3. 개발팀
개발자 외에도 디자이너, 테스터 등 제품 개발을 위해 참여하는 모든 사람을 지칭

4. 제품 백로그(Product Backlog)
개발에 필요한 요구사항을 우선순위에 따라 나열한 목록

5.  스프린트(Sprint)
실제 개발 작업을 진행하는 과정

6. 스프린트 계획 회의(Sprint Planning Meeting)
이번 스프린트에서 수행할 작업을 대상으로 단기 일정 수립

7. 일일 스크럼 회의(Daily Scrum Meeting)
 모든 팀원이 매일 약속된 시간에 짧은 시간동안 진행 상황을 점검하는 회의

8. 스프린트 검토 회의(Sprint Review)
부분 또는 완성 제품이 요구사항에 잘 부합되는지 사용자가 포함된 참석자 앞에서 테스트를 수행

9. 스프린트 회고(Sprint Retrospective) 
스프린트가 끝나고 정해놓은 규칙을 잘 준수했는지, 개선할 점은 없는지 등을 점검하고 수행

XP(eXtreme Programming)
수시로 발생하는 고객의 요구사항에 유연하게 대응하기 위해 고객의 참여와 개발 과정의 반복을 극대화하여 개발 생산성을 향상시키는 기법
- 짧고 반복적인 개발주기, 단순한 설계, 고객의 적극적인 참여를 통해 빠르게 개발하는 것이 목적
- XP의 5가지 핵심 가치 : 의사소통, 단순성, 용기, 존중, 피드백

a. 사용자 스토리
고객의 요구사항을 간단한 시나리오로 표현한 것

b. 릴리즈 계획 수립(release)
몇 개의 스토리가 적용되어 부분적으로 기능이 완료된 제품을 제공하는 것에 대한 계획 수립

c. 스파이크
요구사항의 신뢰성을 높이고 기술 문제에 대한 위험을 감소시키기 위해 별도로 만드는 프로그램

d. 이터레이션(Iteration)
하나의 릴리즈를 더 세분화 한 단위

e. 승인 검사
하나의 이터레이션 안에서 계획된 릴리즈 단위의 부분 완료 제품이 구현되면 수행하는 테스트

f. 소규모 릴리즈
고객의 반응을 기능별로 확인하고 고객의 요구사항에 유연하게 대응하는 것
- 진행된 이터레이션이 모두 완료되면 고객에 의한 최종 테스트 수행 후 최종 결과물을 고객에게 전달함

XP의 주요 실천 방법
a. Pair Programming 
다른 사람과 함께 프로그래밍 수행

b. Test-Driven Development 
실제 코드 작성 전 테스트 케이스를 먼저 작성하여 무엇을 해야할지 파악 후 개발

c. Whole Team 
개발에 참여하는 모든 구성원은 각기 역할이 있어 책임을 다해야 함

d. Continuous integration
모듈 단위로 나눠 개발한 코드는 하나의 작업이 마무리되면 지속적으로 통합

e. Design Improvement / Refactoring 
프로그램 기능의 변경 없이 시스템을 재구성

f. Small Release 
릴리즈 기간을 짧게 하여 고객의 요구 변화에 신속하게 대응

현행 시스템 파악 절차

ㄱ. 1단계 (시스템 파악)
- 시스템 구성 파악 : 조직의 업무를 담당하는 기간 업무와 이를 지원하는 업무로 구분하여 나타낸 구성을 파악
- 시스템 기능 파악 : 현재 제공하는 기능들을 주요, 하부, 세부 기능으로 구분하여 계층형으로 표시
- 시스템 인터페이스 파악 : 주고받는 데이터의 종류, 형식, 프로토콜, 연계 유형, 주기 등을 명시

ㄴ. 2단계
- 아키텍쳐 구성 파악 : 어떠한 기술 요소들이 사용되는지 최상위 수준에서 계층별로 표현한 구성 파악
- 소프트웨어 구성 파악 : 업무 처리를 위해 설치되어 있는 소프트웨어의 제품명, 용도, 라이선스 적용 방식 등을 명시

ㄷ. 3단계
- 하드웨어 구성 파악 : 단위 업무 시스템들이 운용되는 서버의 주요 사양과 수량 및 이중화 적용 여부 명시
- 네트워크 구성 파악 : 서버의 위치, 서버 간의 네트워크 연결 방식을 네트워크 구성도로 작성
```

```
개발 기술 환경 파악

개발 기술 환경
개발하고자 하는 소프트웨어와 관련된 O/S, DBMS, Middle Ware 등을 선정할 때 고려해야 할 사항을 기술하고 오픈 소스 사용 시 주의해야 할 내용을 제시

운영체제(Operating System)
컴퓨터 시스템 자원을 효율적으로 관리하여 사용자가 컴퓨터를 편리하게 사용할 수 있도록 환경을 제공하는 소프트웨어
(Window, Unix, Linux 등이 있음)

데이터베이스 관리 시스템(DBMS) 
사용자와 데이터베이스 사이에서 사용자의 요구에 따라 정보를 생성해주고 관리해주는 소프트웨어

웹 애플리케이션 서버(WAS)
사용자의 요구에 따라 변하는 동적인 컨텐츠를 처리하기 위해 사용되는 미들웨어

미들웨어 : 컴퓨터 제작 회사가 사용자의 요구대로 만들어 제공하는 프로그램으로, 운영 체제와 응용 소프트웨어의 중간에서 조정과 중개의 역할을 수행하는 소프트웨어)

오픈 소스(Open Source)
누구나 제한 없이 사용할 수 있도록 소스 코드를 공개한 것

요구사항 정의

요구사항
소프트웨어가 어떤 문제를 해결하기 위해 제공하는 서비스에 대한 설명과 정상적으로 운영되는데 필요한 제약조건 등

요구사항의 유형 
ㄱ. 기술하는 내용에 따른 분류
- 기능 요구사항 : 시스템이 무엇을 하고 어떤 기능을 하는지
- 비 기능 요구사항 : 품질이나 제약사항에 대한 사항

ㄴ. 기술 관점과 대상의 범위에 따른 분류
- 사용자 요구사항 : 사용자의 관점에서 본 시스템이 제공해
야 할 사항
- 시스템 요구사항 : 개발자의 관점에서 본 시스템 전체가 사
용자와 다른 시스템에 제공해야 할 사항

요구사항 개발 프로세스
도출 -> 분석 -> 명세 -> 확인

ㄱ. 요구사항 도출 
요구사항이 어디에 있고 어떻게 수집할지 식별하고 이해하는 과정으로 인터뷰, 설문, 브레인스토밍, 워크샵, 프로토타이핑, 유스케이스 등이 있음
- 브레인스토밍 : 3인 이상이 자유롭게 아이디어를 산출해 내는 방법
- 워크샵 : 소집단 정도의 인원으로 특정 문제나 과제에 대한 
새로운 지식, 기술, 아이디어, 방법들을 서로 교환하고 검토하는 연구회 및 세미나
- 프로토타이핑 : 초기 도출된 요구사항을 토대로 프로토타입을 만든 후 개발이 진행되는 동안 도출되는 요구사항을 반
영하면서 지속적으로 프로토타입을 재작성하는 과정
- 유스케이스 : 사용자 측면에서의 요구사항으로 사용자가 원
하는 목표를 달성하기 위해 사용자 요구사항을 기능 단위로 
정리한 시나리오

ㄴ. 요구사항 분석
개발 대상에 대한 사용자의 요구사항 중 명확하지 않거나 모호하여 이해되지 않는 부분을 발견하고 걸러내는 과정

ㄷ. 요구사항 명세
요구사항을 분석한 후 승인될 수 있도록 문서화하는 과정

ㄹ. 요구사항 확인
개발 자원을 요구사항에 할당하기 전에 요구사항 명세서가 정확하게 작성되었는지 검토하는 과정

요구사항의 분석 기법

요구사항 분류
요구사항을 명확히 확인할 수 있도록 정해진 기준으로 분류
- 기능/비기능 요구사항 분류
- 제품/과정으로 분류
- 우선순위로 분류

개념 모델링
요구사항의 현실 세계의 상황을 단순화하여 개념적으로 표현하는 과정

요구사항 할당
요구사항을 만족시키기 위한 구성 요소를 식별

요구사항 협상
요구사항이 서로 충돌될 경우 해결하는 과정

정형 분석
구문과 의미를 갖는 정형화된 언어를 이용하여 요구사항을 수학적 기호로 표현 한 후 이를 분석하는 과정

요구사항의 확인 기법

요구사항 검토
문서화된 요구사항을 훑어보면서 확인하는 과정

프로토타이핑
: 초기 도출된 요구사항을 토대로 프로토타입을 만든 후 개발이 진행되는 동안 도출되는 요구사항을 반영하면서 지속적으로 프로토타입을 재작성하는 과정
ㄱ. 장점
- 빠르고 반복되는 제작을 할 수 있어 발전된 결과물을 얻을 수 있음
- 최종 시스템을 완성하기 전에 추가 또는 변경된 요구사항에 
대한 피드백 가능
ㄴ. 단점
- 사용자의 관심이 핵심에서 벗어나 프로토타입 제작에만 집
중될 수 있음
- 지속적이고 반복적인 개선에 대한 비용이 부담될 수 있음

모델 검증
요구사항 분석 단계에서 개발된 모델이 요구사항을 충족하
는지 검증하는 과정

인수 테스트
사용자가 실제로 사용될 환경에서 요구사항이 모두 충족되
는지 사용자 입장에서 확인하는 과정

UML(Unified Modeling Language)
UML이란?
시스템 개발 과정에서 시스템 개발자와 고객 또는 개발자 상호 간의 의사소통이 원활하게 이루어지도록 표준화한 객체지향 모델링 언어

- 구성 요소 : 사물, 관계, 다이어그램
ㄱ. 사물
모델을 구성하는 가장 중요한 기본 요소
ㄴ. 관계 
사물과 사물 사이의 연관성 표현
a. 연관 관계(실선, 화살표)
2개 이상의 사물이 서로 관련되어 있음을 표현
b. 집합 관계(빈 마름모)
하나의 사물이 다른 사물에 포함되어 있는 관계
c. 포함 관계(채워진 마름모)
집합 관계의 특수한 형태로 포함하는 사물의 변화가 포함되
는 사물에게 영향을 미치는 관계
d. 의존 관계(점선 화살표)
사물 사이에 연관은 있으나 필요에 의해서 서로에게 영향을 주는 짧은 시간 동안만 연관을 유지하는 관계
e. 일반화 관계(속이 빈 화살표)
하나의 사물이 다른 사물에 비해 일반적인지 구체적인지 표현
f. 실체화 관계 (빈 점선 화살표)
사물이 할 수 있거나 해야 하는 기능으로 서로를 그룹화 할 수 있는 관계(일반화 관계와는 다르게 사물이 할 수 있는 기능에 초점)

다이어그램
다이어그램
사물과의 관계를 도형으로 표현
- 정적 모델링에서는 주로 구조적 다이어그램을 사용하고 동적 모델링에서는 주로 행위 다이어그램 사용

ㄱ. 구조적 다이어그램
a. 클래스 다이어그램 : 클래스, 클래스가 가지는 속성, 클래스 사이 관계 표현
b. 객체 다이어그램 : 인스턴스를 특정 시점의 객체와 객체 사이의 관계로 표현
c. 컴포넌트 다이어그램 : 구현 단계에서 사용되며 컴포넌트 간의 관계나 인터페이스를 표현
d. 배치 다이어그램 : 구현단계에서 사용되며 결과물, 프로세스, 컴포넌트 등 물리적 요소들의 위치 표현
e. 복합체 구조 다이어그램 : 복잡한 구조를 가지는 클래스 혹은 컴포넌트의 내부 구조 표현
f. 패키지 다이어그램 : 유스케이스, 클래스 등의 모델 요소들을 그룹화한 패키지들의 관계 표현

ㄴ. 행위 다이어그램
- 유스케이스 다이어그램 : 사용자의 요구를 분석하여 기능 모델링 작업에 사용됨
- 시퀀스 다이어그램 : 상호 작용하는 시스템이나 객체들이 주고받는 메시지 표현
- 커뮤니케이션 다이어그램 : 객체들이 주고받는 메시지를 표현할 뿐 아니라 객체들 간의 연관까지 표현
- 상태 다이어그램 : 하나의 객체가 자신이 속한 클래스의 상태 변화 혹은 다른 객체와의 상호 작용에 따라 어떻게 변화하는지 표현
- 활동 다이어그램 : 객체의 처리 로직이나 조건에 따른 처리의 흐름을 순서에 따라 표현
- 상호작용 개요 다이어그램 : 상호작용 다이어그램 간의 제어 흐름 표현
- 타이밍 다이어그램 : 객체 상태 변화와 시간 제약을 명시적으로 표현

사용자 인터페이스(User Interface)

사용자 인터페이스 
사용자와 시스템 간의 상호작용을 원활하게 도와주는 장치나 소프트웨어

사용자 인터페이스의 3가지 분야
- 정보 제공과 전달을 위한 물리적 제어에 관한 분야
- 콘텐츠의 상세적인 표현과 전체적인 구성에 관한 분야
- 모든 사용자가 편리하고 간편하게 사용하도록 하는 기능에 관한 분야

사용자 인터페이스의 구분 
ㄱ. CLI(Command Line Interface) : 명령과 출력이 텍스트 형태로 이루어지는 인터페이스 
ㄴ. GUI(Graphic User Interface) : 아이콘이나 메뉴를 마우스로 선택하여 작업을 수행하는 인터페이스
ㄷ. NUI(Natural User Interface) : 말이나 행동으로 조작하는 인터페이스

사용자 인터페이스의 기본 원칙
ㄱ. 직관성 : 사용자가 큰 노력 없이 쉽게 이해하고 사용할 수 있게 제작해야 함 
ㄴ. 유효성 : 사용자의 목표가 쉽게 달성될 수 있도록 제작 되어야 함
ㄷ. 학습성 : 초보자가 쉽게 배우고 사용할 수 있게 제작되어야 함
ㄹ. 유연성 : 사용자의 인터랙션을 최대한 포용하고 실수를 방지할 수 있게 제작 되어야 함 

UI표준 및 지침

UI 표준 및 지침의 개요
UI 표준과 지침을 토대로 기술의 중립성(표준), 보편적 표현 보장성(접근성), 기능의 호환성이 고려되었는지 확인

한국형 웹 콘텐츠 접근성 지침(KWCAG)
(KWCAG-Korean Web Content Accessibility Guidelines)
장애인과 비장애인이 동등하게 접근할 수 있는 웹 콘텐츠 

전자정보 웹 표준 준수 지침
정부기관의 홈페이지 구축시 반영해야 할 최소한의 규약

UI설계 도구

UI 설계 도구
사용자의 요구사항에 맞게 UI를 설계할 때 사용하는 도구

ㄱ. 와이어프레임
기획 초기 단계에서 제작하는 것으로 페이지에 대한 대략적인 레이아웃이나 UI 요소 등에 대한 뼈대를 설계
ㄴ. 목업
와이어프레임보다 좀 더 실제 화면과 유사하게 만드는 정적인 형태의 모형
ㄷ. 스토리보드
와이어프레임에 콘텐츠에 대한 설명이나 페이지 간 이동 흐름 등을 추가한 문서

프로토타입
와이어프레임이나 스토리보드 등에 인터랙션을 적용해 실제 구현된 것처럼 테스트가 가능한 동적인 형태의 모형

유스케이스
사용자 측면에서의 요구사항으로 사용자가 원하는 목표를 달성하기 위해 수행할 내용 기술

UI요구사항 확인

UI 요구사항 확인의 개요
새로 개발할 시스템에 적용할 UI 관련 요구사항을 조사해서 작성하는 단계

ㄱ. 목표 정의
사용자들을 대상으로 인터뷰를 하고 사용자들의 의견이 수
렴된 비즈니스 요구사항을 정의
ㄴ. 활동 사항 정의
조사한 요구사항을 토대로 앞으로 해야 할 활동 사항을 정의
ㄷ. UI 요구사항 작성
여러 경로로 수집된 사용자의 요구사항을 검토하고 분석하여 UI 개발 목적에 맞게 작성해야 함
a. 요구사항 요소 확인
파악된 요구사항 요소의 종류와 각각의 표현 방식 등을 검토
b. 정황 시나리오 작성
사용자의 요구사항을 도출하기 위해 작성
c. 요구사항 작성
정황 시나리오를 토대로 작성

소프트웨어 아키텍처

소프트웨어 아키텍처의 설계
소프트웨어 아키텍처
: 소프트웨어의 골격이 되는 기본 구조

모듈화
소프트웨어의 성능을 향상하거나 시스템의 수정 및 재사용, 유지 관리 등이 용이하도록 시스템의 기능들을 모듈 단위로 나누는 것

추상화
문제의 전체를 설계 후 세분화하여 구체화하는 과정

추상화 유형
- 과정 추상화 : 전반적인 흐름만 파악
- 데이터 추상화 : 데이터의 세부사항은 정의하지 않고 구조
를 대표할 수 있는 표현으로 대체
- 제어 추상화 : 이벤트의 발생의 세부사항은 정의하지 않고 
구조를 대표할 수 있는 표현으로 대체

단계적 분해
문제를 상위 중요 개념으로부터 하위의 개념으로 구체화하는 분할 기법

정보 은닉
한 모듈 내부에 포함된 정보들을 감추어 다른 모듈이 접근하거나 변경하지 못하도록 하는 기법

소프트웨어 아키텍처의 품질 속성
소프트웨어 아키텍처가 이해 관계자들이 요구하는 수준의 품질을 유지하고 보장할 수 있게 설계되었는지를 확인하기 위해 품질 요소들을 구체화시켜 놓은 것

아키텍처 패턴

아키텍처 패턴 
아키텍처를 설계할 때 참조할 수 있는 전형적인 해결 방식 또는 예제

아키텍처 패턴의 장점
- 개발 시간을 단축시킴
- 고품질의 소프트웨어 생산 가능
- 검증된 구조로 작업을 하여 안정적인 개발 가능
- 시스템 구조를 이해하기 쉬워 개발에 참여하지 않아도 유지보수가 쉬움

레이어 패턴
시스템을 계층으로 구분하여 구성

클라이언트-서버 패턴
하나의 서버와 다수의 클라이언트로 구성

파이프-필터 패턴
데이터 스트림 절차의 각 단계를 필터 컴포넌트로 캡슐화하여 파이프를 통해 데이터를 전송

모델-뷰-컨트롤러 패턴(MVC패턴)
시스템을 아래의 3개의 부분으로 구조화
- 모델(Model) : 서브시스템의 핵심 기능과 데이터 보관
- 뷰(View) : 사용자에게 보여주는 화면단
- 컨트롤러(Controller) : 사용자로부터 받은 입력 처리

기타 패턴
ㄱ. 마스터-슬레이브 패턴 : 마스터 컴포넌트에서 슬레이브 컴포넌트로 작업을 분할한 후 슬레이브 컴포넌트에서 처리된 결과물을 다시 돌려받는 방식
ㄴ. 브로커 패턴 : 사용자가 원하는 서비스와 특성을 브로커 컴포넌트에 요청하면 브로커 컴포넌트가 요청에 맞는 컴포넌트를 연결
ㄷ. 피어-투-피어 패턴 : 피어를 하나의 컴포넌트로 간주하여 각 피어는 클라이언트 또는 서버가 될 수도 있음
ㄹ. 이벤트-버스 패턴 : 소스가 특정 채널에 이벤트 메시지를 발행하면 해당 채널을 구독한 리스너들이 메시지를 받아 이벤트를 처리하는 방식
ㅁ. 블랙보드 패턴 : 모든 컴포넌트들이 공유 데이터 저장소와 블랙보드 컴포넌트에 접근이 가능하여 검색을 통해 블랙보드에서 원하는 데이터를 찾을 수 있음
ㅂ. 인터프리터 패턴 : 프로그램 코드의 각 라인을 수행하는 방법을 지정하고 기호마다 클래스를 갖도록 구성

 객체지향

객체지향
현실 세계의 개체를 기계의 부품처럼 하나의 객체(Object)로 만들어 소프트웨어를 개발할 때 객체를 조립하여 작성할 수 있는 기법

- 구성 요소 : 객체, 클래스, 캡슐화, 상속, 다형성
객체
물리적으로 존재하거나 추상적으로 생각할 수 있는 것 중 
자신의 속성을 가지고 있고 다른 것과 식별 가능한 것

데이터
객체가 가지고 있는 정보

함수
하나의 특정한 목적의 작업을 수행하기 위해 독립적으로 설계된 코드의 집합

클래스
객체 지향 프로그래밍에서 특정 객체를 생성하기 위해 변수와 메소드를 정의하는 일종의 틀이다
- 인스턴스 : 클래스에 속한 각각의 객체
- 인스턴스화 : 클래스로부터 새로운 객체를 생성하는 것
- 슈퍼 클래스 : 특정 클래스의 부모(상위) 클래스
- 서브 클래스 : 특정 클래스의 자식(하위) 클래스

캡슐화
객체의 속성과 행위를 하나로 묶고, 실제 구현 내용 일부를 외부에 감추어 은닉하는 방법

상속
이미 정의된 상위 클래스의 모든 속성과 연산을 하위 클래스가 물려받는 것

다형성
하나의 객체가 여러 가지 타입을 가질 수 있는 것

 시스템 인터페이스 요구사항 분석

시스템 인터페이스
시스템 인터페이스는 독립적으로 떨어져 있는 시스템들끼리 서로 연동하여 상호작용하기 위한 접속 방법이나 규칙을 말함

시스템 인터페이스 요구사항 분석
요구사항 명세서에서 요구사항을 기능적 요구사항과 비 기능적 요구사항으로 분류하고 조직화하여 요구사항 명세를 구체화하고 이를 이해관계자에게 전달하는 일련의 과정
ㄱ. 기능적 요구사항 
시스템이 무엇을 하고 어떤 기능을 하는 가
ㄴ. 비 기능적 요구사항 : 시스템이나 프로젝트 개발 과정 등에서 지켜야 할 제약 사항

인터페이스 요구사항 검증

요구사항 검증
인터페이스의 설계 및 구현 전 사용자들의 요구사항이 요구사항 명세서에 정확하고 완전하게 기술되었는지 검토하고 개발 범위의 기준인 베이스라인을 설정하는 것

인터페이스 요구사항 검토 및 오류 수정
체크리스트의 항목에 따라 인터페이스 요구사항 명세서 검토

요구사항 검증 방법

요구사항 검토 
요구사항 명세서의 결함 여부를 검토 담당자들이 수작업으로 분석하는 방법

ㄱ. 동료검토 : 명세서 작성자가 직접 설명하는걸 동료들이 들으면서 결함을 발견하는 방법
ㄴ. 워크스루 : 검토 회의 전 미리 명세서를 배포하여 사전 검토 후 짧은 회의를 통해 결함을 발견하는 방법
ㄷ. 인스펙션 : 명세서 작성자를 제외한 다른 검토 전문가들이 명세서를 확인하면서 결함을 발견하는 방법
ㄹ. 프로토타이핑 : 요구사항을 파악하기 위해 실제 개발될 소프트웨어에 대한 견본품을 만들어서 최종 결과물을 예측
ㅁ. 테스트 설계 : 테스트 케이스를 생성하여 이후에 요구사항이 현실적으로 테스트 가능한지 검토
ㅂ. CASE(Computer Aided Software Engineering)도구 활용: 일관성 분석을 통해 요구사항 변경사항의 추적, 분석, 관리하고 표준 준수 여부를 확인

인터페이스 요구사항 검증의 주요 항목
- 완전성 : 모든 요구사항이 누락되지 않고 반영 되었는가
- 일관성 : 요구사항이 모순되거나 충돌되는 점 없이 일관성을 유지 하는가
- 명확성 : 모든 참여자가 요구사항을 명확하게 이해할 수 있는가
- 기능성 : 요구사항이 ‘어떻게’보다 ‘무엇을’에 중점을 두고 있는가
- 검증 가능성 : 요구사항이 사용자의 요구를 모두 만족하고 개발된 소프트웨어가 사용자의 요구 내용과 일치하는지를 검증할 수 있는가
- 추적 가능성 : 요구사항 명세서와 설계서를 추적할 수 있는가
- 변경 용이성 : 요구사항 명세서의 변경이 쉽도록 작성 되었는가

인터페이스 시스템 식별(?)
송수신 데이터 식별(?)

인터페이스 방법 명세화

인터페이스 방법 명세화의 개념
내, 외부 시스템이 연계하여 작동할 때 인터페이스별 송수신 방법, 송수신 데이터, 오류 식별 및 처리 방안에 대한 내용을 문서화해놓은 것

시스템 연계 기술
개발할 시스템과 내, 외부 시스템을 연계될 때 사용하는 기술
ㄱ. DB Link : DB에서 제공하는 DB Link 객체 이용
ㄴ. API/Open API : 송신 시스템의 DB에서 데이터를 읽어 와 제공하는 Application Programming Interface 프로그램
ㄷ. 연계 솔루션 : EAI(Enterprise Application Integration) 서버와 송수신 시스템에 설치되는 클라이언트 이용
ㄹ. EAI(Enterprise Application Integration) : 기업 응용 프로그램 통합, 기업용 응용 프로그램의 구조적 통합 방안
ㅁ. Socket : 서버에서 소켓을 생성하여 클라이언트의 통신 요청 시 클라이언트와 연결하여 통신하는 네트워크 기술
ㅂ. Web Service : 웹 서비스에서 WSDL, UDDI, SOAP 프로토콜을 이용하여 연계하는 서비스
- WSDL( Web Service Description  Language )
웹 서비스 기술언어 또는 기술된 정의 파일의 총칭으로 XML로 기술된다. 웹 서비스의 구체적 내용이 기술되어 있어 서비스 제공 장소, 서비스 메시지 포맷, 프로토콜 등이 기술된다. 
- UDDI( Universal Description, Discovery Integration )
웹 서비스 관련 정보의 공개와 탐색을 위한 표준이다. 서비스 제공자는 서비스 소비자에게 이미 알려진 온라인 저장소에 그들이 제공하는 서비스 목록들을 저장하게 되고, 서비스 소비자들은 그 저장소에 접근함으로써 원하는 서비스들의 목록을 찾을 수 있게 된다. 
SOAP ( Simple Object Access Protocol )
일반적으로 널리 알려진 HTTP, HTTPS, SMTP 등을 통해 XML 기반의 메시지를 컴퓨터 네트워크 상에서 교환하는 프로토콜이다. SOAP은 웹 서비스에서 기본적인 메시지를 전달하는 기반이 된다

인터페이스 통신 유형
데이터를 송수신 하는 형태
ㄱ. 단방향 : 시스템에서 거래 요청 후 응답 없음
ㄴ. 동기 : 시스템에서 거래 요청 후 응답이 올 때까지 대기
ㄷ. 비동기 : 시스템에서 거래를 요청 후 응답이 올 때까지 다
른 작업을 하면서 대기

인터페이스 처리 유형  
송수신 데이터를 어떤 형태로 처리할 것인지에 대한 방식
- 실시간 방식, 지연 처리 방식, 배치 방식(대량 데이터 처리)

인터페이스 발생 주기
송수신 데이터가 전송되어 인터페이스가 사용되는 주기

송수신 방법 명세화
각각의 인터페이스에 대해 연계 방식, 통신 유형, 처리 유형, 발생 주기 등 송수신 방법을 정의하고 명세

송수신 데이터 명세화
인터페이스 시 필요한 송수신 데이터에 대한 명세 작성

오류 식별 및 처리 방안 명세화
인터페이스 시 발생할 수 있는 오류를 식별하고 오류 처리 방안에 대한 명세 작성

시스템 인터페이스 설계서 작성

시스템 인터페이스 설계서
시스템의 인터페이스 현황을 확인하기 위해 시스템이 갖는 인터페이스 목록과 상세 데이터 명세를 정의한 문서

시스템 인터페이스 목록 작성
업무 시스템과 내, 외부 시스템 간 데이터를 주고받는 경우에 사용하는 인터페이스에 대해 기술

시스템 인터페이스 정의서 작성
인터페이스별로 시스템 간의 연계를 위해 필요한 데이터 항목 및 구현 요건 등을 기술

미들웨어 솔루션 명세

미들웨어의 개념 및 종류
운영체제와 응용 프로그램 사이에서 운영체제가 제공하는 서비스 이외에 추가적인 서비스를 제공하는 소프트웨어

미들웨어 솔루션 식별
개발 및 운용 환경에 사용될 미들웨어 솔루션을 확인하고 목록을 작성

미들웨어 솔루션 명세서 작성
미들웨어 솔루션 목록의 미들웨어 솔루션별로 관련 정보들을 상세하게 기술
```