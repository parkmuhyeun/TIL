# Design
#소프트웨어 공학/Design

---
### What is SW "Design"?
- A process to transform user requirements into some suitable form
- Software design is the first step, which moves the concentration from problem domain to solution domain. It tries to specify how to fulfill the requirements mentioned in SRS

### Why is Design Important?
Design is the place where quality is fostered

좋은 설계의 조건
- 요구 분석 명세서의 내용을 설계서에 모두 포함해야 한다
- 유지보수가 용이하도록 추적이 가능해야 한다
- 변화에 쉽게 적응할 수 있어야 한다
- 시스템 변경으로 인한 영향이 최소화되도록 국지적이어야 한다
- 설계서는 읽기 쉽고, 이해하기 쉽게 작성

## 설계의 종류

![](./img/D_1.PNG)

상위 설계
- 아키텍처 설계: 시스템의 전체적인 구조
- 데이터 설계: 시스템에 필요한 정보를 자료구조와 DB설계에 반영
- 시스템 분할: 전체 시스템을 여러 개의 서브시스템으로 나눈다
- UI 설계: 사용자가 익숙하고 편리하게 사용할 수 있도록 사용자 인터페이스 설계

하위 설계
- 각 모듈의 실제적인 내부를 알고리즘 형태로 표현
- 인터페이스에 대한 설명, 자료구조 ,변수 등에 대한 상세한 정보를 작성

## Design Concepts

### Abstraction(추상화)
- 주어진 문제에서 필수 정보만 추출하여 강조

객체지향 설계에서의 추상화
![](./img/D_2.PNG)

### Stepwise refinement(단계적 분해)
- 하향식 설계에서 사용
- 기능을 점점 작은 단위로 나누어 점차적으로 구체화하는 방법

![](./img/D_3.PNG)

### Modularizaiton
Modularization is a technique to divide a software system into multiple discrete and independent module, which are expected to be capable of carrying out task independently.

모듈의 특징
- 다른 것들과 구별될 수 있는 독립적인 기능을 갖는 단위
- 유일한 이름을 가짐
- 독립적으로 컴파일 가능
- 모듈에서 또 다른 모듈을 호출 가능
- 다른 프로그램에서도 모듈을 호출 가능

### Encapsulation vs Information Hiding
- Encapsulation means drawing a boundary around something
- Information hiding is the idea that a design decision should be hidden from the rest of the system to prevent unintended coupling

![](./img/D_4.PNG)

## Software Architecture
개발할 소프트웨어 대한 전체적인 구조
- 소포트웨어를 이루고 있는 여러 구성 요소(서브시스템)을 다룬다.
- 구성 요소들이 인터페이스를 통해서 어떻게 상호작용하는지를 정의해야 한다.
- 세부 내용보다는 중요한 부분만을 다룬다.

Architecture model

![](./img/D_5.PNG)

### 데이터 중심형 모델
- 특징: 주요 데이터가 repository에서 중앙 관리
- 구성: repository와 여기에 접근하는 서브시스템
    - repository: 공동으로 활용하는 데이터 보관
    - 서브시스템: repository에 접근하여 정보를 저장, 검색, 변경하는 역활

![](./img/D_6.PNG)

### 클라이언트-서버 모델
- 네트워크를 이용하는 분산 시스템 형태
- 데이터와 처리 기능을 클라이언트와 서버에 분할하여 사용
- 분산 아키텍처에 유용
    - 서버: 클라이언트에 서비스 제공
    - 클라이언트: 서버가 제공하는 서비스를 요청(호출)하는 서브시스템
    
![](./img/D_7.PNG)

### 계층 모델
- 기능을 몇 개의 계층으로 나누어 배치
- 구성: 하위 계층은 서버, 상위 계층은 클라이언트 역활

![](./img/D_8.PNG)

### Model/View/Controller 모델 (MVC model)
- 중앙 데이터 구조
- 같은 모델의 서브시스템에 대하여 여러 view 서브시스템을 필요로 하는 시스템에 적합
- M-V-C로 분리하는 이유: 변경에 대한 영향을 덜 미치도록 하기 위해

![](./img/D_9.PNG)

Model 서브시스템
- 뷰/제어 서브시스템과 독립되어 모든 데이터와 로직을 처리
- 특정 입출력 방식에 영향을 받지 않고, 무언가의 호출에 응답만 함

View 서브시스템
- 데이터를 사용자에게 보여주는 역활

Controller 서브시스템
- 뷰를 통한 사용자의 요청을 적절한 모델 쪽으로 넘겨주고, 모델로부터 받은 응답을 다시 뷰를 통해 사용자에게 돌려주는 역활

장점
- 관심의 분리
- 데이터를 화면에 표현(뷰)하는 디자인과 로직(모델)을 분리함으로써 느슨한 결합 가능
- 구조 변경 요청 시 수정 용이

단점
- 기본 기능 설계로 인한 클래스 수의 증가로 복잡도 증가
- 속도가 중요한 프로젝트에 부적합

MVC 모델이 많이 사용되는 이유
- Interface designer는 Model 부분을 신경쓰지 않고 View 부분만 집중하여 개발가능
- Programmer는 View부분을 신경쓰지 않고 Model부분만 집중하여 개발가능

### Pipe and filter 구조
- Filter: data stream을 한 개 이상 입력 받아 처리한 후 data stream 하나를 출력
- Pipe: filter를 거쳐 생성된 data stream 하나를 다른 filter의 입력에 연결

![](./img/D_10.PNG)


SW architecture model에 대한 고려 필요
- 소프트웨어 특성, 전체 구조, 개발 방법을 알 수 있다.

Architecture model을 사용한 설계의 장점
- 개발 기간 단축, 고품질의 소프트웨어 생산
- 수월한 의사소통
- 용이한 유지보수
- 검증된 아키텍처
- 구축전 시스템 특성에 대한 시뮬레이션 가능
- 기존 시스템에 대한 빠른 이해

## Software Design Quality
Good design --> Maintainable
- Cohesion: Functional relatedness
- Coupling: Strength of interconnectedness

(High cohesion, low coupling)

## Cohesion
모듈 내부에 존재하는 구성하는 요소들 사이의 밀접한 정도

### Coincidental cohesion(우연적 응집)
- 구성 요소들이 말 그대로 우연히 모여 구성

### Logical cohesion(논리적 응집)
- 요소들 간에 공통점이 있거나 관련된 임무가 존재하거나 기능이 비슷하다는 이유로 하나의 모듈로 구성

### Temporal cohesion(시간적 응집)
- 구성 요소들이 같은 시간대에 함께 실행된다는 이유로 하나의 모듈로 구성

### Procedural cohesion(절차적 응집)
- 순서가 정해진 몇개의 구성요소를 하나의 모듈로 구성

### Communicational cohesion(교환적 응집)
- 같은 입력을 사용하는 구성 요소들을 하나의 모듈로 구성
- 구성 요소들의 동일한 출력을 만들어낼 때도 교환적 응집

### Sequential cohesion(순차적 응집)
- A요소의 출력을 B요소의 입력으로 사용하므로 두 요소가 하나릐 모듈을 구성한 경우

### Functional cohesion(기능적 응집)
- 응집도가 가장 높은 경우이며 단일 기능의 요소로 하나의 모듈을 구성
- 하나의 모듈이 정확히 하나의 활동 or 하나의 단일 목적을 달성하기 위해 동작

## Coupling(결합도)
The measure of the interdependence of one module to another

### Contents coupling(내용 결합)
- 모듈 간에 인터페이스를 사용하지 않고 직접 왔다 갔다 하는 경우의 관계
- 상대 모듈의 데이터를 직접 변경할 수 있어 서로 간섭을 가장 많이 하는 관계
- 모듈들이 서로 종속되어 독립적으로 설계하거나 변경할 수 없어 유지보수가 매우 어려움

### Common coupling(공통 결합)
- 모듈들이 공통 변수(전역변수)를 같이 사용하여 발생하는 관계
- 문제점: 변수 값이 변하면 모든 모듈이 함께 영향을 받는다는 것

### Control coupling(제어 결합)
- 제어 플래그(flag)를 매개변수로 사용하여 간섭하는 관계
- 호출하는 모듈이 호출되는 모듈의 내부 구조를 잘 알고 논리적 흐름을 변경하는 관계

### Stamp coupling(스탬프 결합)
- 두 모듈 사이에서 정보를 교환할 때 필요한 데이터만 주고받을 수 없고 스탬프처럼 필요 없는 데이터까지 전체를 주고받아야 하는 경우(ex) 구조체 )

### Data coupling(데이터 결합)
- 가장 좋은 모듈 간 결합
- 모듈들이 매개변수를 통해 데이터만 주고받음으로써 서로 간섭을 최소화하는 관계
- 모듈 간의 독립성 보장