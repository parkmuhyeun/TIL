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