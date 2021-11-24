# Software testing
#소프트웨어 공학/Software testing

---
## Error, Fault, Failure
Error
- Differnce between the actual output and the correct output

Fault = Bug
- A condition(potential) that causes the software to fail

Failure
- The inability of a system to perform a required function

## Verification & Validation
Verification
- The process of evaluating products of a development phase to find out whether they meet the specified requirements
- Do we build the system right? (시스템을 올바르게 만들고 있는가?)
- 소프트웨어가 정확한 요구사항에 부합하여 구현되었음을 보장하는 활동
- '요구사항 명세서에 맞게 올바른 방법으로 제품을 만들고 있음'을 보장
- 요구사항 명세서대로 제품이 만들어지고 있나?
- 개발 중간중간 이루어짐
- 개발자 측면

Validation
- The process of evaluating software at the end of the development process to determine whether software meets the customer expectations and requirements
- Do we build the right system? (올바른 시스템을 만들고 있는가?)
- 소프트웨어가 고객이 의도한 요구사항에 따라 구현되었음을 보장하는 활동
- '고객이 의도한 환경이나 사용목적에 맞게 올바른 제품을 만들고 있음'을 보장
- 제품이 고객들이 원한 것이 맞나?
- 원래 의도한 사용에 부합하는가?
- 주로 개발 처음이나 끝에 이루어짐
- 고객/사용자 측면

### Static vs Dynamic
Most of the V & V activities can be classified as dynamic ofr static
- Dynamic
    - testing(so called dynamic testing)
- Static
    - reviews
    - program proving
    - code reading

Classification of V&V Activities
- Static
    - Do not observe system behavior
- Dynamic(Testing)
    - System behavior is observed

## What is Testing?
- How: Exercising a system or component
    - with define inputs
    - capturing monitored outputs
    - comparing outputs with specified or intended requirements
- For What: purposes
    - to identify discrepancies between actual results and correct or expected behavior
    - to provide high assurance of reliability, correctness
- What is NOT software testing?
    - Debugging

![](./img/ST_1.PNG)

-|Testing|Debugging
---|---|---|
목적|알려지지 않은 결함의 발견|이미 알고 있는 결함의 수정
수행|시스템 내부 관련자, 테스팅 팀등 외부의 제 3자|시스템 내부 관련자
주요작업|숨겨진 결함 발견|결함의 정확한 위치 파악, 결함의 타입 식별, 결함의 수정

### Fundamental Testing Questions
- What cases should we test?
    - What test data should we use?
    - What aspect of the software should we test?
- Are we there yet? When can we stop testing?
    - Did we find a sufficient number of failures?
- How well do we do?
    - Did we provide high assurance?
- Infinite possibilities with limited resources?
    - Working overnight? Agile? Call experts?

## Realisitc Goal of Testing
- 테스트의 목적
    - 프로그램이 사용할만한것인지 확인하기 위하여 결함을 발견할 목적으로 프로그램을 실행하는 작업
- 완벽한 테스트는 불가능
- 결함이 없음을 보이려는 것이 아님
- 현실적인 테스트의 목적
    - 주어진 시간과 인력으로 오류를 발견할 확률이 높은, 가장 효율적인 테스트 케이스를 찾아내고 실행하는 일

### State of the Testing in Practice
- 개발에 비하여 적은 관심
    - 무계획
    - 개인의 경험에 의존
    - 개발이 비해 쉽다고 생각
- 품질의 중요성에 비하여 적은 노력
    - 테스트 엔지니어 교육
    - 테스트기법에 대한 교육
    - 테스트 도구 교육

### Testing Steps
- Select what is to be measured by the test
- Decide how to test
- Develop test case
- Execute the test case
- Determine the expected result of the test
- Compare the actual result and the expected result 

## Test Cases
- Two kinds of problems to be discovered by testing:
    - INVALID: The program DOES NOT do something it is supposed to do
    - UNEXPECTED: The program DOES something it is NOT supposed to do
- INVALID and UNEXPECTED Cases
    - Test cases must be written for INVALID and UNEXPECTED, as well as valid and expected, input conditions

Test case: 특정한 요구사항이 제대로 구현되었는지를 검증하기 위하여 테스트 조건, 입력값, 예상출력값, 그리고 실제 수행한 결과를 기록하는것

![](./img/ST_2.PNG)

- OBJECTED
    - to uncover errors(에러를 찾아내는 것)
- CRITERIA
    -  in a complete mannner (완벽히 에러를 찾아내는 것)
- CONSTRAINT
    - with a minimum of effort and time (가능한 최소의 시간과 노력으로 찾아내는 것)

좋은 test case는 아직 발견되지 않은 오류를 발견 할 확률이 높은 test case이다

### Test Every Input Conditions?
It is generally impossible, even for trivial examples, to test a program using EVERY POSSIBLE INPUT CONDITION

## Types of testing: Black box vs White box
- Black box testing (Functional testing)
    - Test cases derived from examining the requirements, specifications or user documents

![](./img/ST_3.PNG)

- White box testing (Structural testing)
    - Test cases derived from examining the actual code (software structure/implementation)

![](./img/ST_4.PNG)

### Black box testing
(1) Equivalence partitioning
- input space partitioning
- Divde the input space into equivalence class so that items in each equivalence class are treated the same
- Both valid and invalid equivalence classes are considered

(2) Boundary -Value Analysis
- Rather than selecting any element in an equivalence class, boundary-value analysis focuses on those elements near the boundary of the equivalence class

(3) Error guessing
- Based on intuition and experience

![](./img/ST_5.PNG)

### White box testing
Goal
- Our goal is to ensure that all statements and conditions have been executed at least once

(1) Statement coverage
- Simplest form of logic coverage
- Every statement in the program must be executed at least once

(2) Branch coverage
- Each branch and each entry point must be taken at least once

(3) Condition coverage
- Each condition must be true at least once and false at least once

(4) Multiple-Condition
- At each branch statement, all feasible combinations of condition outcomes must be covered at least once

### Limitations of White Box Testing
- Missing paths undetected
- Coincidental correctness
- Finding data to exercise an arbitrary path is difficult

### Testing loop
Exercise loops 0, 1, 2, t, (max-1), max, max+1 times

### Black box vs White box

Criteria|Black Box Testing|White Box Testing
---|---|---
Definition|Design/ implementation is NOT known to the tester| Design/ implementation is  known to the tester
Implementation Knowledge|Not Required|Required
Levels Mainly applicable to|Acceptance Testing, System Testing|Unit Testing, Integration Testing
Basis for Test Cases|Requirement Spec|Code
Responsibility|Generally, Independent Testers|Generally, developers


## TMMI(Testing Maturity Model Integration)
소프트웨어 테스팅 프로세스 성숙도 수준 측정 모델

![](./img/ST_6.PNG)