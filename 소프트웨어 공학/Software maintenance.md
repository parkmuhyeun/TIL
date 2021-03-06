# Software maintenance
#소프트웨어공학/Software maintenance

---
## Software maintenancew (유지보수)
Type of maintenance
- Corrective: 20% (시스템을 운영하면서 발견한 오류 수정 활동)
- Adaptive: 20% (환경변화(HW, OS등)를 반영하기 위한 활동)
- Perfective: 60% (새로운 기능 추가, 성능 개선을 위한 확장 활동)
- Preventive (미래의 유지보수를 용이하게 하기 위한 변경 활동)
- Maintenance라고 하면 주로 defect fix를 생각
- 그러나 Corrective는 고작 20% 정도

Lehman의 원리
- SW는 계속 변경됨
- SW 복잡도도 계속 증가됨
- 대규모 SW 유지보수에는 일정한 방향이 있음
- 대규모 SW는 안정화 상태인 경우가 많음
- 유지보수 수행시 기존 SW에 대한 친근성을 유지하려고 함

### 유지보수에 영향을 주는 요소
- 사용자
    - 불편, 오류의 개선을 위한 변경 요청
- 환경
    - 운용환경, 조직환경의 변화
- 유지보수 프로세스
    - 변경요청, 이해, 변경 효과 분석
- 소프트웨어 제품
    - 지속적인 사용과 변경
- 유지보수 인력
    - 관련된 사람

### 유지보수 작업의 문제점과 한계
- SW에 대한 변경이 수시로 일어남
    - 문서에 반영하지 않는 경우 이를 추적하는 것은 거의 불가능
- 다른 사람이 작성한 프로그램을 이해하는 일은 쉽지 않음
    - 문서화되어 있지 않거나 주석도 달지 않았다면 문제는 매우 심각
- 변경을 가정하여 설계되는 경우가 드물다
- 관리적인 측면에서 유지보수를 담당하는 프로그래머에게 동기부여를 하지못함
- Alien Code의 발생
    - 아주 오래되거나 참고 문서 또는 개발자가 없어 유지보수 작업이 어려운 프로그램

### 유지보수 작업 도구
- 시스템을 운영하고 지원하는 단계에 도움을 제공하는 자동화 도구
- 성능 모니터링 도구
- 프로그램 분석
- 디버깅 분석
- 자동 문서화 도구

## SW 형상 관리 (SCM: Software Configuration Management)
SW 변경의 요인
- 업무 환경의 변화
    - 새로운 기능의 추가와 같이 고객의 요구의 변경
    - 시장 여건의 변경
    - 예산과 일정 계획 등에서의 변경
- 기술 환경의 변화
    - 하드웨어의 사양 및 운영체제의 변경

버전 관리
- SW에서의 버전: 개발 단계 또는 순서를 번호로 표시한 것

버전 관리의 필요성
- 각 버전의 정보를 데이터베이스화하여 언제라도 과거의 파일을 가지고 작업할 수 있도록 관리 

![](./img/Sm_1.PNG)

형상관리
- 개발 중 발생하는 모든 산출물들이 변경됨으로써 점차 변해가는 소프트웨어형상을 체계적으로 관리하고 유지하는 기법
- 언제라도 특정 시간대에 가장 안정적인 버전의 소프트웨어를 유지할 수 있도록, 소프트웨어 제품이 변경되어가는 상태에 대한 가시성을 확보해준다.
- 누가 변경했는지, 변경된 것은 무엇인지, 언제 변경되었는지, 왜 변경했는지와 같은 질문에 대답해준다.
- 궁극적으로 프로젝트를 개발하는 동안 생산성과 안전성을 높여 좋은 품질의 소프트웨어를 생산하고 유지보수도 용이하게 해주는 데 목적이 있다.

형상 관리 요소
- 분석서
- 설계서
- 프로그램
- 사용자 지침서

형상관리의 주 역활
- 변경되는 부분이 SW전체에 어떤 영향을 미치는지 확인
- 개발자가 해야할 일의 방향을 알려주는 것

형상관리가 제 역활을 하기 위해서는 프로젝트의 특성을 고려하여 관리하고자하는 형상 항목과 시점을 명확하고 효율적으로 계획
- 형상항목을 너무 많이 설정했을 경우
    - 형상 관리에 많은 시간이 소요
    - 사소한 항목까지 형상 통제 대상
- 너무 적게 설정
    - 필요한 형상 항목이 제외
- 형상 관리 시간인 베이스라인을 너무 빨리 설정했을 경우
    - 형상 관리에 많은 시간이 소요
- 너무 늦게 설정했을 경우
    - 필요한 형상 항목이 제외

형상 관리 수행 활동 흐름 (개요도)

![](./img/Sm_2.PNG)

형상관리 수행 절차

![](./img/Sm_3.PNG)

(1) 형상 식별(configuration identification)
- 형상 관리의 가장 밑바탕이 되는 활동
- 프로젝트 계획 시 형상 관리 계획을 근거로 형상 관리의 대상이 무엇인지 식별하는 과정

1. 형상 항목 선정
2. 형상 식별자 규칙 선정
3. 베이스라인 기준 선정

(2) 형상 통제(configuration control)
- 형상 목록의 변경 요구를 검토 및 승인하여 현재의 소프트웨어 기준선에 반영될 수 있또록 통제하는 일련의 과정

1. 변경 요청
2. 변경 심사
3. 변경 확인

CCB(Configuration Control Board)의 형상 변경 절차

![](./img/Sm_4.PNG)

(3) 형상 상태 보고(configuration status reporting)
- 베이스라인으로 설정된 형상 항목 구조와 변경 상태 기록 -> 관련된 사람들에게 보고
- 형상 상태보고 내용
    - 프로젝트에서의 변경 횟수
    - 최근 SW항목의 버전, 릴리스 식별자, 릴리스 횟수, 릴리스 간의 비교 내용
    - 베이스라인의 상태
    - 변경 제어 상태
    - 형상통제위원회 활동 내역

(4) 형상 감사(configuration audit)
- 형상 관리 계획서대로 형상 관리가 진행되고 있는지, 형상 항목의 변경이 요구사항에 맞도록 제대로 이뤄졌는지 등을 살펴보는 활동

### SW 형상관리가 SW 생산성에 미치는 영향
- 개발된 SW는 계속 변화함
- SW 변경의 부정적인 문제

원인|설명
---|---
가시성의 결핍|소프트웨어는 무형의 자산
통제의 어려움|보이지 않는 소프트웨어 개발에 대한 통제는 현실적으로 어려움
추적의 결여|소프트웨어 개발 과정에 대한 추적의 어려움
감시의 미비|지속적으로 프로젝트를 관리 또는 감시하기 어려움
부절제한 변경|사용자의 무절제한 변경이 항상 발생

=> 현실적으로 변경을 막을 수 없다면, 최소한의 사간과 비용을 들여 효율적인 대응을 할 필요가 있음. --- SW 형상관리를 통해 해결

## Refactoring
코드를 보다 쉽게 이해할 수 있고 적은 비용으로 수정할 수 있도록 겉으로 보이는 동작의 변화 없이 내부구조를 변경하는 작업

### Refactoring의 특성
- Refactoring의 목적은 Sw를 보다 이해하기 쉽고 수정하기 쉽도록 만드는 것
- Refactoring은 겉으로 보이는 Sw의 기능을 변경하지 않는다는 것

### Refactoring을 수행하는 이유
- SW Design을 개선시킨다
    - 중복된 코드, 적절하지 않은 코드 제거
    - SW Design시 의도했었던 구조와 다르게 망가질 경우 바로잡을 수 있는 기회 제공 -> 의도된 Sw Design으로 개발할 수 있도록 함
- Sw를 더 이해하기 쉽게 만든다
    - 현재 코드에 대한 개발자가 아닌 다른 개발자가 확인해도 쉽게 이해할 수 있도록 함
    - 추가적인 수정 작업도 쉽게 진행 가능
- 버그를 발견할 수 있게 돕는다
- 개발의 작업시간을 줄여준다.

-> Sw 개발속도를 어느정도 유지하기 위해서는 좋은 디자인이 필수, 이를 위해서는 refactoring이 선행되어야 함

Refactoring을 수행하는 시기
- 틈틈히 계속, 유지보수 단계에서 기능 추가, 버그 수정시, 코드 검토시 등

Refactoring을 수행할 수 없을때는?
- 현재 설계된 구조가 보안문제, 성능문제 등의 사항으로 refactoring을 기대할 수 없을때
- 코드가 처음부터 작성하는게 나을 정도로 엉망인 경우
- 현재 코드가 작동하지 않을 경우
- 마감일이 가까울 경우

### Refactoring해야 하는 Bad code가 발생하는 이유
- Copy & paste에 의해 중복코드 발생
- 잘못되거나 일관되지 않은 변수명, 함수 명 등(혼돈유발)
- 너무 긴 이름의 method, parameter
- 특정 Class내에 method가 동작을 하기위해 다른 Class에 있는 정보를 많이 필요로 하는 경우
- 잘못 작성되거나 양식에 맞지 않게 작성된 주석