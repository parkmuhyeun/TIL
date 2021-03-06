# Programming Language Utilization
#Data Processing Engineer/Programming Language Utilization

```
개발 환경 구축

개발 환경 구축
응용 소프트웨어 개발을 위해 개발 프로젝트를 이해하고 S/W 및 H/W 장비를 구축하는 것
(S/W : 소프트웨어 / H/W : 하드웨어)
- 응용 소프트웨어가 운영될 환경과 유사한 구조로 구축
- 개발 프로젝트의 분석 단계의 산출물을 바탕으로 개발에 필요한 S/W와 H/W를 선정
- S/W와 H/W의 성능, 편의성, 라이선스 등 비즈니스 환경에 적합한 제품들을 최종적으로 결정하여 구축

H/W 환경
- 사용자의 인터페이스 역할을 하는 클라이언트와, 클라이언트와 통신하여 서비스하는 서버로 구성

웹 서버 
클라이언트로부터 직접 요청을 받아 처리하는 서버
- 저용량의 정적 파일(HTML, CSS 등)을 제공
- ex) Apache HTTP Server, Microsoft Internet Information Service 등

웹 애플리케이션 서버(Web Application Server)
 - 사용자에게 동적 서비스를 제공하기 위해 웹 서버로부터 요청을 받아 데이터 가공 작업을 수행
- 웹 서버와 데이터베이스 서버 또는 웹 서버와 파일 서버 사
이에서 인터페이스 역할 수행
ex) Apache Tomcat, IBM WebSphere 등

데이터베이스 서버
: 데이터베이스와 이를 관리하는 DBMS를 운영하는 서버
ex) MySQL Server, Oracle Server 등

파일 서버
데이터베이스에 저장하기에는 비효율적이거나 서비스 제공 목적으로 유지하는 파일들을 저장하는 서버
ex) AWS, S3 등

S/W 환경
- 클라이언트 서버 운영을 위한 시스템 S/W와 개발에 사용되
는 개발 S/W로 구성
ㄱ. 시스템 S/W
- O/S, 웹 서버, WAS 운용을 위한 서버 프로그램
- DBMS 
ㄴ. 개발 S/W
- 요구사항 관리 도구 : 요구사항 수집과 분석, 추적 등을 편리하게 도와주는 S/W
- 설계 모델링 도구 : UML을 지원하며 개발의 전 과정에서 설계 및 모델링을 도와주는 S/W
- 구현 도구 : 개발 언어를 통해 애플리케이션의 실제 구현을 지원하는 S/W
- 빌드 도구 : 구현 도구를 통해 작성된 소스의 빌드 및 배포, 라이브러리 관리를 지원하는 S/W
- 테스트 도구 : 모듈들이 요구사항에 적합하게 구현되었는지 테스트하는 S/W
- 형상 관리 도구 : 버전 관리를 하여 품질 향상을 지원하는 S/W

서버 개발

서버 개발
웹 애플리케이션의 로직을 구현할 서버 프로그램을 제작하여 WAS에 탑재하는 것
- 서버 프로그램을 개발할 수 있도록 지원하는 프레임워크가 있음서

개발 프레임워크
:버 프로그램 개발 시 다양한 설정을 손쉽게 할 수 있도록 클래스나 인터페이스를 제공하는 S/W
- 뷰-모델-컨트롤러(MVC) 패턴을 기반으로 개발됨
ㄱ. Spring
- Java 기반 프레임워크
- 전자정부 표준 프레임워크의 기반 기술로 사용
ㄴ. Node.js
- Javascript 기반 프레임워크
- 실시간으로 입출력이 빈번한 애플리케이션에 적합
ㄷ. Django
- Python 기반 프레임워크
- 컴포넌트 재사용 및 플러그인화를 기반으로 신속한 개발을 지원
ㄹ. Codeigniter
- PHP 기반 프레임워크
- 인터페이스가 간편하며 서버 자원을 적게 사용
ㅁ. Ruby on Rails
- Ruby 기반 프레임워크
- 테스트를 위한 웹 서버 지원
- 데이터베이스 작업을 단순화, 자동화시켜 신속한 개발 가능
- 프레임워크의 특성 : 모듈화, 재사용성, 확장성, 제어의 역 흐름

서버 프로그램 구현
- 응용 S/W와 동일하게 모듈 및 공통 모듈 개발 후 통합하는 
방식으로 구현
- 모듈 개발 시 다른 모듈과의 과도한 상호작용을 배제함으로써 특정 모듈의 수정이 다른 모듈에게 영향을 미치지 않아야 함
- 모듈의 독립성은 결합도와 응집도에 의해 측정
- 공통 모듈은 여러 프로그램에서 재사용할 수 있는 모듈

결합도
어떤 모듈이 다른 모듈에 의존하는 정도를 나타내는 것으로 독립적인 모듈이 되기 위해서는 낮을수록 좋음

결합도의 종류
자료 결합도 < 스탬프 결합도 < 제어 결합도 < 외부 결합도 < 공통 결합도 < 내용 결합도
(낮을수록 좋음)

ㄱ. 자료 결합도(Data Coupling) : 모듈간의 인터페이스 전달되는 파라미터를 통해서만 모듈간의 상호 작용이 일어나는 경우.
ㄴ. 스탬프 결합도(Stamp Coupling) : 모듈간의 인터페이스로 배열이나 오브젝트, 스트럭쳐등이 전달되는 경우.
ㄷ.제어 결합도(Control Coupling) : 단순히 처리를 해야할 대상인 값만 전달되는게 아니라 어떻게 처리를 해야 한다는 제어 요소(DCD, Flag등)이 전달되는 경우. 
ㄹ. 외부 결합도(External Coupling) : 어떤 모듈에서 반환한 값을 다른 모듈에서 참조해서 사용하는 경우
ㅁ.공통 결합도(Common Coupling) : 파라미터가 아닌 모듈 밖에 선언되어 있는 전역 변수를 참조하고 전역변수를 갱신하는 식으로 상호작용하는 경우
ㅂ. 내용 결합도(Content Coupling) : 다른 모듈 내부에 있는 변수나 기능을 다른 모듈에서 사용 하는 경우

응집도
하나의 모듈이 하나의 기능을 수행하는 요소들 간의 연관성 척도, 독립적인 모듈이 되기 위해서는 응집도가 높을수록 좋음

응집도 순서
기능적 응집도 > 순차적 응집도 > 교환적 응집도 > 절차적 응집도 > 시간적 응집도 > 논리적 응집도 > 우연적 응집도
(높을수록 좋음)

ㄱ. 기능적 응집도(Functional Cohesion) : 모듈 내 모든 요소들이 단일 기능을 수행
ㄴ. 순차적 응집도(Sequential Cohesion) : 모듈 내의 한 요소의 출력 자료가 다음 요소의 입력 자료로 사용
ㄷ. 교환적 응집도(Communication Cohesion) : 모듈 내의 요소들이 동일한 입출력 자료로 서로 다른 기능을 수행
ㄹ. 절차적 응집도(Procedural Cohesion) : 모듈 수행 요소들이 반드시 특정 순서대로 수행
ㅁ. 시간적 응집도(Temporal Cohesion) : 특정 시간에 실행되는 기능들을 모아 작성된 모듈
ㅂ. 논리적 응집도(Logical Cohesion) : 논리적으로 유사한 기능을 수행 하지만 서로의 관계는 밀접하지 않음
ㅅ. 우연적 응집도(Coincidental Cohesion) : 모듈 내 요소들이 뚜렷한 관계가 없이 존재, 어떠한 의미 있는 연관관계도 지니지 않은 기능 요소로 구성되고 서로 다른 상위 모듈에 의해 호출되어 처리상의 연관성이 없는 서로 다른 기능을 수행하는 경우

보안 및 API

S/W 개발 보안
개발 과정에서 발생할 수 있는 보안 취약점을 최소화하여 보안 위협으로부터 안전한 S/W를 개발하기 위한 보안 활동
- 데이터의 기밀성, 무결성, 가용성을 유지해야 함
- S/W 개발 보안 가이드를 참고하여 점검해야 할 보안 항목을 점검해야 함

S/W 개발 보안 점검 항목
ㄱ. 세션 통제
- 서버와 클라이언트의 연결 간 발생하는 정보를 관리
- 불충분한 세션 관리 또는 잘못된 세션에 의한 정보 노출
ㄴ. 입력 데이터 검증 및 표현
- 입력 데이터에 대한 유효성 검증 체계를 갖추고 실패 시 이를 처리할 수 있도록 코딩하는 것
- SQL 삽입, 경로 조작 및 자원 삽입, 크로스 사이트 스크립팅
ㄷ. 보안 기능
- 인증, 접근제어, 기밀성, 암호화 등의 기능
- 적절한 인증 없는 중요 기능 허용, 부적절한 인가
ㄹ. 시간 및 상태
- 병렬 처리 시스템이나 다수의 프로세스가 동작하는 환경에서 시간과 실행 상태를 관리하여 시스템이 원활히 동작되도록 하는 것
- 검사 시점과 사용 시점 경쟁 조건, 무한 루프, 재귀 함수
ㅁ. 에러 처리
- S/W 실행 중 발생할 수 있는 오류들을 사전에 정의하여 에러로 인해 발생할 수 있는 문제들을 예방
- 오류 메시지를 통한 정보 노출, 오류 상황 대응 부재
ㅂ. 코드 오류
- 형 변환, 자원의 반환 등을 고려하여 코딩하는 것
- 널 포인터 역참조, 부적절한 자원 해제
ㅅ. 캡슐화
- 데이터와 데이터를 처리하는 함수를 하나의 객체로 묶어 코딩하는 것
- 잘못된 세션에 의한 정보 노출, 제거되지 않고 남은 디버그 코드
ㅇ. API 오용
- API를 잘못사용하거나 보안의 취약한 API를 사용하지 않도록 고려하여 코딩하는 것
- DNS lookup에 의존한 보안 결정

API(Application Programming Interface)
응용 프로그램 개발 시 운영체제나 프로그래밍 언어 등에 있는 라이브러리를 이용할 수 있도록 규칙 등을 정의해 놓은 
인터페이스

배치 프로그램

배치 프로그램
사용자와의 상호 작용 없이 미리 정해진 작업을 일괄적으로 처리하는 프로그램
- 배치 프로그램의 필수 요소 : 대용량 데이터, 자동화, 견고성, 안정성, 신뢰성, 성능
- 정기 배치 : 정해진 기간에 정기적으로 수행
- 이벤트성 배치 : 설정한 특정 조건이 충족될 때 수행
- On-Demand 배치 : 사용자 요청 시 수행

배치 스케줄러
일괄 처리 작업이 설정된 주기에 맞춰 자동으로 수행되도록 지원해주는 도구
- 잡 스케줄러라고도 함
ㄱ. 스프링 배치
- Spring Source 사와 Accenture 사가 공동 개발한 오픈소스 프레임워크
- 스프링 프레임워크의 특성을 그대로 가져와 스프링의 기능을 모두 사용할 수 있음
- 데이터베이스나 파일의 데이터를 교환하는데 필요한 컴포넌트를 제공
- 로그 관리, 추적, 트랜잭션 관리, 작업 처리 통계, 작업 재시작 등의 다양한 기능 제공
- 구성요소 : Job, Job Launcher, Step, Job Repository
ㄴ. Quatz - 스프링 프레임워크로 개발되는 응용 프로그램들의 일괄 처리를 위한 다양한 기능을 제공하는 오픈소스 라이브러리
- 수행할 작업과 수행 시간을 관리하는 요소들을 분리하여 일괄 처리 작업에 유연성을 제공
- 구성요소 : Scheduler, Job, JobDetail, Trigger

패키지 소프트웨어

패키지 소프트웨어
기업에서 일반적으로 사용하는 여러 기능을 통합하여 제공하는 S/W
- 기업에서는 패키지 소프트웨어를 구입하여 기업 환경에 적합하게 커스터마이징하여 사용

패키지 소프트웨어의 특징
요구사항을 분석하여 업무 특성에 맞게 전용으로 개발되는 S/W와 비교하여 안정성, 라이선스, 생산성 등의 차이가 있음
- 전문 업체에 의해 품질이 검증되었고 국제 산업계 표준을 준수하고 있어 안정적인 이용 가능
- S/W에 대한 라이선스가 판매자에게 있어 시스템 구축 후 기능 추가 및 코드 재사용 등에 제약이 있음
- 개발 조직을 갖추어야 할 필요성이 없어 비용을 절감할 수 있음
- 이미 개발된 S/W를 사용하기 때문에 프로젝트 기간 단축

프로그래밍 언어

개발도구
- 구성 : 빌드 도구, 구현 도구, 테스트 도구, 형상관리 도구
- 빌드 도구 : Gradle, Maven, Ant
- 테스트 도구 : xUnit, PMD, Findbugs, Cppcheck, Sonar

형상관리
소프트웨어 개발을 위한 전체 과정에서 발생하는 모든 항목의 변경 사항을 관리하기 위한 활동

프레임워크
- 소프트웨어의 구체적인 부분에 해당하는 설계와 구현을 재사용이 가능하게끔 협업화된 형태로 클래스들을 제공하는 틀
- 구성요소 : 개발환경, 실행환경, 운영환경, 관리환경
- 특징 : 모듈화, 재사용성, 확장성, 제어의 역행
- 재사용성 : 인터페이스를 통해 여러 애플리케이션에서 반복적으로 사용되는 일반적 컴포넌트를 정의하여 재사용성을 높임
- 확장성 : 다형성을 통해 애플리케이션이 프레임워크의 인터페이스를 확장
- 제어의 역행 : 프레임워크 코드가 전체 애플리케이션의 처리흐름을 제어

모듈화
: 프로그램 개발 시 생산성과 최적화, 관리에 용이하게 기능단위로 분할하는 기법
- 원리 : 정보은닉, 분할과 정복, 데이터 추상화, 모듈의 독립성
- 유형 : 설계 -> 모듈화, 컴포넌트, 서비스 // 구현 -> 함수, 매크로, 인라인

배치 프로그램
사용자와의 상호작용 없이 일련의 작업들을 작업 단위로 묶어 정기적으로 반복 수행하거나 정해진 규칙에 따라 일괄 처리하는 방법
- 유형 : 이벤트 배치, 온디멘드 배치, 정기 배치
- 온디멘드 배치 : 사용자의 명시적 요구가 있을 때마다 실행하는 방법
- 정기 배치 : 정해진 시점(주로 야간)에 실행하는 배치

프로세스
CPU에 의해 처리되는 사용자 프로그램, 시스템 프로그램,  즉 실행중인 프로그램을 의미
- 상태 : 생성, 준비, 실행, 대기, 완료
- PID(Process identifier) : 프로세스 식별자
- PCB(Process Control Block) : 운영체제가 프로세스 관리를 위해 필요한 자료를 담고 있는 자료 구조로 프로세스 식별
자, 프로세스 상태, 프로그램 카운트, 레지스터 저장 영역, 프로세서 스케줄링 정보, 계정 정보, 입출력 상태 정보, 메모리 
관리 정보 등을 담고 있음

프로세스 상태 전이
하나의 작업이 컴퓨터 시스템에 입력되어 완료되기까지 프로세스의 상태가 준비, 실행 및 대기 상태 등으로 변화는 활동

프로세스 상태 전이 종류
디스패치, 타이머 런 아웃, 블록, 웨이크업, Swap-in/out 
- Swap-in : 프로세스에게 다시 기억 장치가 할당될 경우
- Swap-out : 프로세스가 기억 장치를 잃은 경우

프로토콜
: 서로 다른 시스템에 있는 두 개체 간의 데이터 교환을 원활히 하기 위한 일련의 통신 규약

IP
 송신 호스트와 수신 호스트가 패킷 교환 네트워크에서 정보를 주고받는데 사용하는 정보 위주의 규약
- OSI 3계층에서 호스트의 주소 지정과 패킷 분할 및 조립 기능을 담당하는 프로토콜

TCP(Transmission Control Protocol)
근거리 통신망이나 인트라넷, 인터넷에 연결된 컴퓨터에서 실행되는 프로그램 간에 일련의 옥텟을 안정적으로, 순서대로, 에러 없이 교환할 수 있게 하는 프로토콜

UDP (User Datagram Protocol)
같은 네트워크 내에서 컴퓨터들 간에 메시지들이 교환될 때 제한된 서비스만을 제공하는 통신 프로토콜이다

IPSEC(Internet Protocol Security)
: IP계층에서 무결성과 인증을 보장하는 인증 헤더와 기밀성을 보장하는 암호화를 이용한 IP 보안 프로토콜
- 현재 전 세계에서 사용되는 인터넷 상거래시 요구되는 개인 정보와 크레딧카드 정보의 보안 유지에 가장 많이 사용되고 있는 프로토콜

제네릭 프로그래밍
재사용 프로그래밍 기법 중 하나의 값이 여러 데이터 타입을 가질 수 있어서 재사용성을 높일 수 있는 특징이 있는 프
로그래밍 방식
- 재사용 프로그래밍 기법 : 객체지향, 제네릭, 자동, 메타 프로그래밍
- 메타 프로그래밍 : 런타임에 수행해야 할 작업의 일부를 컴파일 타임 동안 수행하는 프로그램

객체지향 프로그래밍
- 구성 요소 : 객체, 클래스, 메시지
- 원리 : 캡슐화, 추상화, 다형성, 정보은닉, 상속성

윈도우 계열 운영체제 특징
GUI사용(Graphical User Interface), 선점형 멀티태스킹 방식 사용, 자동 감지 기능(Plug &Play), OLE사용

유닉스 계열 운영체제 특징
대화식 운영체제 기능 제공, 다중 작업 기능 제공, 다중 사용자 기능 제공, 이식성 제공, 계층적 트리 구조 파일 시스템 
제공

스레싱
어떤 프로세스가 계속적으로 페이지 부재가 많이 발생하여 프로세스의 실제 처리 시간보다 페이지 교체 시간이 더 많아지는 현상

워킹세트
각 프로세스가 많이 참조하는 페이지들의 집합을 주기억장치 공간에 계속 상주하게 하여 빈번한 페이지 교체 현상을 줄이고자 하는 기법

절차적 프로그래밍 언어
ㄱ. 알골(ALGOL) : 재귀호출이 최초로 가능하게 한 절차형 언어
ㄴ. C언어 : 이식성이 높은 언어로 유닉스 운영체제에서 사용하기 위한 언어, 데니스 리치에 의해 개발
ㄷ. 베이직(BASIC) : 교육용으로 개발되어 문법이 쉬움
ㄹ. 포트란(FORTRAN) : 과학계산에서 필수적인 백터, 행렬 계산 기능 등이 내장되어 있는 과학기술 전문 언어기억장치 접근 속도, 접근 시간 빠른 순 >느린 순
- 레지스터 >캐시 기억장치 >주기억장치 >보조기억장치

구역성(Locality)
: 데닝 교수에 의해 구역성 개념이 증명됨

ㄱ. 시간 구역성(Temporal Locality)
: 프로세스가 실행되면서 하나의 페이지를 일정시간 동안 집중적으로 액세스하는 현상
- 반복(loop), 스택(stack), 부프로그램(sub routine) 
ㄴ. 공간 구역성(Spatial Locality)
: 프로세스 실행 시 일정 위치의 페이지를 집중적으로 액세스 하는 현상
- 배열, 순차코드, 순차코드의 실행

WAS(웹애플리케이션서버)의 종류
- Tomcat, Weblogic, Jeus 등

스크립트 언어
: 소스 코드를 컴파일하지 않고도 실행할 수 있는 프로그래밍 언어
- 빠르게 배우고 쉽게 작성 가능

파이썬 언어
- 다양한 플랫폼에서 쓸 수 있고, 라이브러리(모듈)가 풍부
- 유니코드 문자열을 지원하여 다양한 언어의 문자 처리가 가능
- 들여쓰기를 사용하여 블록을 구분
- 다른 언어로 쓰인 모듈들을 연결하는데 사용

리스프(LISP)
: 수학 표기법을 나타내기 위한 목적으로 생성

운영체제의 개념
운영체제
: 컴퓨터 시스템의 자원들을 효율적으로 관리하며, 사용자가 컴퓨터를 편리하고 효과적으로 사용할 수 있도록 환경을 제공하는 여러 프로그램의 모임
ex) 우리가 흔히 쓰는 윈도우, 혹은 MacOS같은 것들

운영체제의 목적
: 처리 능력 향상, 사용 가능도 향상, 신뢰도 향상, 반환 시간 단축 등

운영체제의 성능을 평가하는 기준
ㄱ. 처리능력 : 일정 시간 내에 시스템이 처리하는 일의 양
ㄴ. 반환 시간(≒응답 시간) : 시스템에 작업을 의뢰한 시간부터 처리가 완료될 때까지 걸리는 시간
ㄷ. 사용 가능도 : 시스템을 사용할 필요가 있을 때 즉시 사용 가능한 정도
ㄹ. 신뢰도 : 주어진 문제를 정확하게 해결하는 정도

운영체제의 기능
- 프로세서(처리기 / Processor / CPU), 기억장치(주기억, 보
조기억), 입 출력 장치, 파일 및 정보 등의 자원 관리
- 자원을 효율적으로 관리하기 위해 스케줄링 기능 제공
- 사용자와 시스템 간 편리한 인터페이스 제공
- 각종 하드웨어와 네트워크를 관리 제어
- 데이터 관리, 데이터 및 자원의 공유 기능 제공
- 시스템의 오류 검사 및 복구
- 자원 보호 기능 제공
- 입 출력에 대한 보조 기능 제공

운영체제의 주요 자원 관리
- 프로세스 관리 : 프로세스 스케줄링 및 동기화 관리
- 기억장치 관리 : 프로세스에게 메모리 할당 및 회수 관리
- 주변장치 관리 : 입 출력장치 스케줄링 및 전반적인 관리
- 파일 관리 : 파일의 생성과 삭제, 변경, 유지 등의 관리
운영체제의 종류
- Windows, UNIX, LINUX, MacOS, MS-DOS 등

Window

Windows
: 마이크로소프트에서 개발한 운영체제

Windows 시스템의 특징
: 그래픽 사용자 인터페이스(GUI, Graphci User Interface) : 
키보드로 명령어를 수행하지 않고 마우스로 아이콘이나 메뉴
를 선택하여 모든 작업을 수행
- 선점형 멀티태스킹 : 동시에 여러 개의 프로그램을 실행하는 멀티태스킹을 하면서 운영체제가 각 작업의 CPU 이용 시
간을 제어하여 응용 프로그램 실행 중 문제가 발생하면 해당 프로그램을 강제 종료시키고 모든 시스템 자원을 반환
- Pnp(Plug and Play) : 하드웨어를 설치할 때 해당 하드웨어를 사용하는데 필요한 시스템 환경을 운영체제가 자동으로 
구성해주는 기능
- OLE(Object Linking and Embedding) : 다른 응용 프로그램에서 작성된 문자나 그림 등의 개체를 현재 작성 중인 문서
에 자유롭게 연결하거나 삽입하여 편집할 수 있는 기능
- Single User 시스템 : 컴퓨터 한대를 한 사람이 독점 사용

UNIX / LINUX / MacOS

UNIX
: 1960년대 AT&T 벨(Bell) 연구소, MIT, General Electric이 
공동 개발한 운영체제
- 시분할 시스템을 위해 설계된 대화식 운영체제
- 소스코드가 개방형 시스템으로 구성되어 있음
- 대부분 C언어로 작성되어 이식성이 높으며 장치, 프로세스 간 호환성이 높음
- 다중 사용자(Multi-User) 및 다중 작업(Multi-Tasking)을 지원
- 트리 구조의 파일 시스템을 가짐

UNIX 시스템의 구성
ㄱ. 커널(Kernel) 
- 컴퓨터가 부팅될 때 주기억장치에 적재된 후 상주하면서 실행됨
- 하드웨어를 보호하고 프로그램과 하드웨어 간의 인터페이스 역할을 담당
- 프로세스 관리, 기억장치 관리, 파일 관리, 입출력 관리, 프로세스 간 통신, 데이터 전송 및 변환 등 여러 가지 기능 수행

ㄴ. 쉘(Shell) - 명령어를 인식하여 수행하는 명령어 해석기
- 시스템과 사용자 간의 인터페이스 담당
- DOS의 COMMAND.COM과 같은 기능 수행
- 주기억장치에 상주하지 않고 명령어가 포함된 파일 형태로 존재
- 보조기억장치에서 교체 처리 가능
- 파이프라인 기능 지원
- 파이프라인 : 둘 이상의 명령을 함께 묶어 처리한 결과를 
다른 명령의 입력으로 전환하는 기능
- 입출력 재지정을 통해 입력과 출력의 방향을 변경할 수 있음
- 공용 Shell이나 사용자가 만들 Shell을 사용할 수 있음

ㄷ. 유틸리티(Utility Program)
- 사용자가 작성한 외부 프로그램을 처리
- DOS에서의 외부 명령어에 해당
- 에디터, 컴파일러, 인터프리터, 디버거 등

LINUX
: 1991년 리누스 토발즈가 UNIX를 기반으로 개발한 운영체제
- 프로그램 소스 코드가 무료로 공개되어 있어 사용자가 원하는 기능을 추가할 수 있고 다양한 플랫폼에 설치하여 사용이 가능하여 재배포가 가능
- UNIX와 완벽하게 호환
- 대부분의 특징이 UNIX와 동일

MacOS
: 1980년대 애플사가 UNIX를 기반으로 개발한 운영체제
- 애플사에서 생산하는 제품에서만 사용 가능
- 드라이버 설치 및 install / uninstall 과정이 단순

저장장치 관리의 개요

저장장치 계층 구조
주기억장치는 각기 자신의 주소를 가지는 워드 또는 바이트들로 구성되어 주소를 이용하여 접근
- 보조기억장치에 있는 프로그램이나 데이터는 CPU가 직접 액세스 할 수 없음
- 보조기억장치에 있는 데이터는 주기억장치에 적재된 후 CPU에 의해 액세스

기억장치의 관리 전략
Fetch(반입), 배치(Placement), 재배치(Replacement) 전략

반입(Fetch) 전략
보조기억장치에 보관중인 데이터를 언제 주기억장치에 적재할 것인지를 결정하는 전략
ㄱ. 요구 반입 : 실행중인 프로그램이 특정 프로그램이나 데이터 등의 참조를 요구할 때 적재
ㄴ. 예상 반입 : 실행중인 프로그램에 의해 참조될 프로그램이나 데이터를 미리 예상하여 적재

배치(Placement) 전략
새로 반입되는 데이터를 주기억장치의 어디에 위치시킬 것인지를 결정하는 전략
ㄱ. 최초 적합(First Fit) : 배치가 가능한 크기의 빈 영역 중에서 첫 번째 분할 영역에 배치
ㄴ. 최적 적합(Best Fit) : 배치가 가능한 크기의 빈 영역 중에서 단편화를 가장 적게 남기는 분할 영역에 배치
ㄷ. 최악 적합(Worst Fit) : 배치가 가능한 크기의 빈 영역중에서 단편화를 가장 많이 남기는 분할 영역에 배치

단편화
ㄱ. 내부 단편화 : 배치 후 남은 공간
ㄴ. 외부 단편화 : 배치를 못해 빈 공간으로 남아있는 공간

재배치(Replacement) 전략
주기억장치의 모든 영역이 이미 사용 중인 상태에서 새로운 프로그램이나 데이터가 배치하려고 할 때, 이미 사용 중인 영역에서 어느 영역을 교체할 것인지를 결정하는 전략
- FIFO, OPT, LRU, LFU, NUR, SCR 등
```

```
주기억장치 할당
프로그램이나 데이터를 실행시키기 위해 주기억장치에 어떻게 할당할 것인지에 대한 내용

ㄱ. 연속 할당 기법
프로그램을 주 기억장치에 연속으로 할당하는 기법
- 단일 분할 할당 기법 : 오버레이, 스와핑
- 다중 분할 기법 : 고정 분할 할당 기법, 동적 분할 할당 기법
ㄴ. 분산 할당 기법
: 프로그램을 특정 단위의 조각으로 나누어 주기억장치 내에 분산하여 할당하는 기법
- 페이징 기법, 세그먼테이션 기법

단일 분할 할당 기법
주기억장치를 운영체제 영역과 사용자 영역으로 나누어 한순간에는 오직 한 명의 사용자만이 주기억장치의 사용자 영역을 사용하는 기법 
ㄱ. 오버레이 기법
: 주기억장치보다 큰 사용자 프로그램을 실행하기 위한 기법
- 보조기억장치에 저장된 하나의 프로그램을 여러개의 조각으로 분할한 후 필요한 조각을 차례로 주기억장치에 적재하여 프로그램을 실행
ㄴ. 스와핑 기법
하나의 프로그램 전체를 주기억장치에 할당하여 사용하다 필요에 따라 다른 프로그램과 교체하는 기법

다중 분할 할당 기법
ㄱ. 고정 분할 할당 기법 : 프로그램에 할당하기 전에 운영체제가 주기억장치의 사용자 영역을 여러 개의 고정된 크기로 
분할하고 준비상태 큐에서 준비 중인 프로그램을 각 영역에서 할당하여 수행하는 기법
ㄴ. 가변 분할 할당 기법 : 미리 주기억장치에 분할해 놓는 것이 아닌 프로그램을 주기억장치에 적재하면서 필요한 만큼의 크기로 영역을 분할

가상 기억장치 구현 기법 / 페이지 교체 알고리즘

가상 기억장치
: 보조기억장치의 일부를 주기억장치처럼 사용하는 것
- 용량이 작은 주기억장치를 마치 큰 용량을 가진 것처럼 사용할 수 있음
- 프로그램을 여러 작은 블록 단위로 나누어서 가상 기억장치에 보관해 놓고, 프로그램 실행 시 요구되는 블록만 주기억장치에 불연속적으로 할당하여 처리
- 주기억장치의 이용률과 다중 프로그래밍의 효율 상승
- 가상기억장치에 저장된 프로그램을 실행하려면 가상 기억장치의 주소를 주기억장치의 주소로 바꾸는 주소변환 (Mapping) 작업이 필요
- 연속 할당 방식에서 발생할 수 있는 단편화를 해결할 수 있음

페이징 기법
: 가상기억장치의 보관되어 있는 프로그램과 주기억장치의 영역을 동일한 크기로 나눈 후 나눠진 프로그램을 동일하게 나눠진 주기억장치의 영역에 적재시켜 실행하는 기법
- 프로그램을 일정한 크기로 나눈 크기를 페이지라 하고 페이지 크기로 일정하게 나누어진 주기억장치의 단위를 페이지 프레임이라고 함
- 외부 단편화는 발생하지 않으나 내부 단편화는 발생할 수 있음
- Mapping 작업을 위해서 페이지 맵 테이블이 필요함

세그먼트 기법
: 가상기억장치에 보관되어 있는 프로그램을 다양한 크기의 논리적인 단위로 나눈 후 주기억장치에 적재시켜 실행시키는 방법
- 프로그램을 논리적인 크기로 나눈 단위를 세그먼트라고 함
- 내부 단편화는 발생하지 않으나 외부 단편화는 발생할 수 있음
- Mapping 작업을 위해서 세그먼트 맵 테이블이 필요함
- 세그먼트가 주기억장치에 적재될 때 다른 세그먼트에게 할당된 영역을 침범할 수 없으며 이를 위해 기억장치 보호키가 필요

페이지 교체 알고리즘
페이지 부재가 발생했을 때 가상 기억장치의 필요한 페이지를 주기억장치에 적재해야 하는데 이럴 경우 주기억장치의 모든 페이지 프레임이 사용 중이면 어떤 페이지 프레임을 선택하여 교체할 것인지 결정하는 기법
종류 : OPT, FIFO, LRU,LFU 등이 있음

 가상 기억장치 기타 관리 사항

페이지 크기에 따른 특징
ㄱ. 페이지 크기가 작을 경우
- 단편화와 주기억장치로 이동하는 시간 감소
- 불필요한 내용이 적재될 확률이 낮아 워킹 셋이 효율적으로 유지
- Locality에 더욱 일치하여 기억장치에 효율 상승
- 페이지 맵 테이블 크기가 커지므로 매핑 속도가 늦어짐
- 디스크 접근 횟수가 많아져 전체적인 입출력 시간이 늘어남

ㄴ. 페이지 크기가 클 경우
- 단편화와 주기억장치로 이동하는 시간이 증가
- 프로세스 수행에 불필요한 내용까지 적재될 수 있음
- 페이지 맵 테이블 크기가 작아지므로 매핑 속도가 빨라짐
- 디스크 접근 횟수가 줄어들어 전체적인 입출력 시간이 줄어듦

Locality
프로세스가 실행되는 동안 주기억장치를 참조할 때 일부 페이지만 집중적으로 참조하는 성질이 있다는 이론

시간 구역성
 프로세스가 실행되면서 하나의 페이지를 일정 시간 동안 집중적으로 액세스 하는 현상

공간 구역성
프로세스 실행 시 일정 위치의 페이지를 집중적으로 액세스하는 현상

워킹 셋
: 프로세스가 일정 시간 동안 자주 참조하는 페이지들의 집합
- 자주 참조되는 워킹 셋을 주기억장치에 상주시켜 페이지 부재 및 페이지 교체 현상이 줄어들어 프로세스의 기억장치 사용이 안정됨
- 워킹 셋은 시간에 따라 변화

페이지 부재 빈도 방식
- 페이지 부재 빈도는 페이지 부재가 일어나는 횟수
- 페이지 부재율에 따라 주기억장치에 있는 페이지 프레임 수를 조정하여 적정 수준으로 유지하는 방식
- 운영체제는 프로세스 실행 초기에 임의의 페이지 프레임 할당 후 페이지 부재율에 따라 프레임을 할당하거나 회수

프리 페이징
: 처음의 과도한 페이지 부재를 방지하기 위해 필요할 것 같은 모든 페이지를 한꺼번에 페이지 프레임에 적재하는 기법

스래싱
: 프로세스의 처리 시간보다 페이지 교체에 소요되는 시간이 더 많아지는 현상
- 다중 프로그래밍 시스템이나 가상 기억장치를 사용하는 시스템에서 하나의 프로세스 수행 중 자주 페이지 부재가 발생하면서 나타나는 현상
- 전체 프로세스 성능이 저하됨
- 다중 프로그래밍의 정도가 높아짐에 따라 CPU의 이용률은 어느 특정 시점까지는 높아지지만 다중 프로그래밍의 정도가 더욱 커지면 스래싱이 나타나고 CPU의 이용률은 급격히 감소됨

스래싱 현상 방지 방법
- 다중 프로그래밍의 정도를 적정 수준으로 유지
- 페이지 부재 빈도를 조절하여 사용
- 워킹 셋 유지
- 부족한 자원 증설, 일부 프로세스 중단
- CPU 성능에 대한 자료의 지속적 관리 및 분석으로 임계치를 예상하여 운영

프로세스의 개요

프로세스
프로세서에 의해 처리되는 사용자 프로그램이나 시스템 프로그램을 의미
- 실행 중인 프로그램을 의미하며 작업 혹은 태스크라고도 함

프로세스의 또 다른 형태
- PCB를 가진 프로그램 - 실기억 장치에 저장된 프로그램
- 디스패치가 가능한 단위
- 프로시저(부 프로그램)가 활동 중인 것
- 비동기적 행위(다수의 프로세스가 서로 독립적으로 실행)를 일으키는 주체
- 지정된 결과를 얻기 위한 일련의 계통적 동작
- 목적 또는 결과에 따라 발생되는 사건들의 과정
- 운영체제가 관리하는 실행 단위

프로세스 상태 전이 관련 용어
- Dispatch : 준비 상태에 대기하고 있는 프로세스 중 하나가 프로세스를 할당받아 실행 상태로 전이되는 과정
- Wake up : 입출력 작업이 완료되어 프로세스가 대기 상태에서 준비 상태로 전이되는 과정
- Spooling : 입출력 장치의 공유 및 상대적으로 느린 입출력장치의 처리 속도를 보완하기 위해 입출력할 데이터를 직접 
장치에 보내지 않고 나중에 한꺼번에 입출력하기 위해 디스크에 저장하는 과정
- 교통량 제어기 : 프로세스의 상태에 대한 조사와 통보를 담당

스레드(Thread)
 - 프로세스 내에서의 작업 단위로서 시스템의 여러 자원을 할당받아 실행하는 프로세스 단위
- 프로세스의 일부 특성을 가지고 있어 경량 프로세스라고도 함
- 동일 프로세스 환경에서 독립적인 다중 수행 가능

스레드의 분류
- 사용자 수준의 스레드 : 사용자가 만든 라이브러리를 사용하여 운용하기 때문에 속도는 빠르지만 구현이 어려움
- 커널 수준의 스레드 : 운영체제의 커널에 의해 스레드를 운영하기 때문에 속도는 느리지만 구현이 쉬움

스레드 사용의 장점
- 하나의 프로세스를 여러 개의 스레드로 생성하여 병행성을 증진할 수 있음
- H/W, O/S의 성능과 응용 프로그램의 처리율을 향상시킬 수 있음
- 응용프로그램의 응답 시간을 단축시킬 수 있음
- 프로세스들 간의 통신이 향상
- 공통적으로 접근 가능한 기억장치를 통해 효율적으로 통신

스케줄링

스케줄링
프로세스가 생성되어 실행될 때 필요한 시스템의 여러 자원을 해당 프로세스에게 할당하는 작업
- 프로세스가 생성되어 완료될 때까지 여러 종류의 스케줄링 과정을 거침
- 그 종류에는 장기, 중기, 단기 스케줄링이 있음

문맥 교환
하나의 프로세스에서 다른 프로세스로 CPU가 할당되는 과정에서 발생되는 것
- 새로운 프로세스에 CPU를 할당하기 위해 현재 CPU가 할당된 프로세스의 상태 정보 저장
- 새로운 프로세스의 상태 정보를 설정한 후 CPU를 할당하여 실행하도록 하는 작업

스케줄링의 목적
- CPU나 자원을 효율적으로 사용하기 위한 정책
- 공정성 : 모든 프로세스에게 공정하게 할당
- 처리율(처리량) 증가 : 단위 시간당 프로세스를 처리하는 비율 혹은 양을 증가
- CPU 이용률 증가 : CPU의 낭비 시간을 줄이고 CPU가 순수 프로세스를 실행하는 데 사용되는 시간 비율 증가
- 우선순위 제도 : 우선순위가 높은 프로세스를 먼저 실행
- 오버헤드 최소화 : 어떤 처리하기 위해 들어가는 간접적인 처리시간이나 메모리를 최소화
- 응답 시간 최소화 : 작업을 지시하고 반응하기 시작하는 시간을 최소화
- 반환 시간 최소화 : 프로세스를 제출한 시간부터 실행이 완료될 때까지 걸리는 시간 최소화
- 대기 시간 최소화 : 프로세스가 준비상태 큐에서 대기하는 시간 최소화
- 균형 있는 자원의 사용
- 무한 연기 회피

프로세스 스케줄링의 기법

ㄱ. 비선점 스케줄링
- 강제 종료 불가능
- 이미 할당된 CPU를 다른 프로세스가 강제로 빼앗아 사용할 수 없음
- 프로세스가 CPU를 할당받으면 완료될 때 까지 사용
- 프로세스 응답 시간 예측이 용이
- 일괄 처리 방식에 적합
- 중요한(짧은) 작업이 중요하지 않은(긴) 작업을 기다리는 경우가 발생할 수 있음
ex) FCFS, SJF, 우선순위, HRN, 기한부 등의 알고리즘

ㄴ. 선점 스케줄링
- 강제 종료 가능
- 우선순위가 높은 다른 프로세스가 CPU를 강제로 빼앗아 사용할 수 있음
- 우선순위가 높은 프로세스를 빠르게 처리할 수 있음
- 빠른 응답 시간을 요구하는 대화식 시분할 시스템에 사용
- 많은 오버헤드를 초래함
- 선점이 가능하도록 일정 시간 배당에 대한 인터럽트용 타이머 클록이 필요
- Round Robin, SRT, 선점 우선순위, 다단계 큐, 다단계 피드백 큐 등의 알고리즘

환경변수

환경변수
시스템 소프트웨어의 동작에 영향을 미치는 동적인 값들의 모임

Windows 환경 변수
- Windows에서 환경 변수를 명령어나 스크립트에서 사용하기 위해서는 변수명 앞뒤에 %를 붙여야 함

UNIX / LINUX 환경 변수
- UNIX나 LINUX에서 환경 변수를 사용하기 위해서는 변수명 앞에 $를 붙여야 함

운영체제 기본 명령어
- CLI(Command Line Interface) : 키보드로 명령어를 입력하여 작업을 수행하는 인터페이스
- GUI(Graphic User Interface) : 마우스로 아이콘이나 메뉴를 선택하여 작업을 수행하는 인터페이스
Windows |  UNIX/LINUX
DIR | ls 파일 목록표시
COPY | cp 파일 복사
TYPE | cat 파일 내용 표시
REN | mv 파일 이름 변경
MOVE | mv 파일 이동
MD | mkdir 디렉토리 생성
CD | chdir 디렉토리 위치 변경
CLS | clear 화면 내용 지움
ATTRIB | chmod 파일 속성 변경
FIND | find 파일 찾기
CHKDSK | x 디스크 상태 점검
FORMAT | x 디스크 표면을 섹터로 나누어 초기화
x | chown 소유자 변경
x | exec 새로운 프로세스 수행
x | fork 새로운 프로세스 생성(Tree 구조)
x | fsck 파일 시스템 검사 보수
x | getpid 자신의 프로세스 아이디를 얻음
x | mount 파일 시스템을 마운팅

인터넷

인터넷
TCP/IP 프로토콜을 기반으로 전 세계 수많은 컴퓨터와 네트워크들이 연결된 광범위한 컴퓨터 통신망
IP주소(Internet Protocol Address)
- 인터넷에 연결된 컴퓨터를 구분하기 위한 고유한 주소
- 8비트 씩 4부분으로 구성됨(IPv4)

서브네팅 - 할당된 네트워크 주소를 다시 여러 개의 작은 네트워크로 나누어 사용
- IPv4의 주소 부족 문제를 해결하기 위한 방법
- 서브넷 마스크 : 네트워크 주소와 호스트 주소를 구분하기 위한 비트

IPv6
: 시간이 지나면서 인터넷 사용자가 많아지면서 IPv4의 주소가 부족해지게 되어 IPv4의 주소 부족 문제를 해결하기 위해 
개발됨
- 128비트의 긴 주소를 사용하여 주소 부족 문제를 해결할 수 있고, 자료 전송 속도가 빠름 인증성, 기밀성, 데이터 무결성의 지원으로 보안 문제 해결 가능
ㄱ. 인증성 : 사용자의 식별과 접근 권한 검증
ㄴ. 기밀성 : 시스템 내의 정보와 자료는 인가된 사용자에게만 접근 허용
ㄷ. 무결성 : 시스템 내의 정보는 인가된 사용자만 수정 가능

도메인 네임 
IP 주소 사람이 이해하기 쉬운 문자 형태로 표현한 것

OSI 7 Layer

OSI(Open System Interconnetion)7 Layer 참조 모델
다른 시스템 간의 원활한 통신을 위해 ISO(국제표준화기구)에서 제안한 통신 규약(프로토콜)으로 컴퓨터 네트워크 프로토콜을 기능별로 나누어 각 계층으로 설명한 것

application
presentation
session
transport
network
data link
physical

네트워크를 계층 구조로 나눈 이유
ㄱ. 데이터의 흐름이 한눈에 보인다.
ㄴ. 하나의 문제를 7개의 작은 문제로 나누기 때문에 문제 해
결이 쉽다. 
ㄷ. 각 계층마다 사용하는 장비가 다른데, 표준화를 통해 여러 회사의 네트워크 장비를 사용하더라도 이상 없이 작동할 수 있게 된다. 

OSI 모델의 계층
ㄱ. 1 물리 계층
전송에 필요한 두 장치 간의 실제 접속과 절단 등 기계적, 전기적, 기능적, 절차적 특성에 대한 규칙을 정의
- 물리적 전송 매체와 신호 방식을 정의
- RS-232C, X.21 등의 표준
- 관련 장비 : 리피터, 허브
- 데이터 단위 : 비트

ㄴ. 2 데이터 링크 계층
두 개의 인접 개방 시스템들 간의 신뢰성 있고 효율적인 정보 전송을 할 수 있도록 함
- 주요 기능 : 흐름 제어, 프레임 동기화, 오류 제어, 순서 제어
- HDLC, LAPB, LLC, MAC, LAPD, PPP 등의 표준
- 관련 장비 : 브리지
- 데이터 단위 : 프레임

ㄷ. 3 네트워크 계층
: 개방 시스템들 간의 네트워크 연결을 관리하고 데이터의 교환 및 중계 기능
- 네트워크 연결 설정, 유지, 해제
- 경로 설정, 데이터 교환 및 중계, 트래픽 제어, 패킷 정보 
전송 수행 - X.25, IP 등의 표준
- 관련 장비 : 라우터
- 데이터 단위 : 패킷

ㄹ. 4 전송 계층
: 논리적 안정과 균일한 데이터 전송 서비스를 제공
- 종단 시스템 간의 투명한 데이터 전송을 가능하게 함
- 종단 시스템 간의 전송 연결 설정, 데이터 전송, 연결 해제 기능
- 주소 설정, 다중화, 오류 제어, 흐름 제어
- TCP, UDP 등의 표준
- 관련 장비 : 게이트웨이
- 데이터 단위 : 세그먼트

ㅁ. 5 세션 계층
: 송수신 측 간의 관련성을 유지하고 대화 제어를 담당
- 동기점 : 송수신 측간의 대화 동기를 위해 전송하는 정보를 일정한 부분에 두어 정보의 수신 상태를 체크하는 포인트
- 데이터 단위 : 메시지

ㅂ. 6 표현 계층
: 데이터를 응용 계층, 세션 계층에 보내기 전에 계층에 맞게 변환
- 서로 다른 데이터 표현 형태를 갖는 시스템 간 상호 접속을 위해 필요한 계층
- 코드 변환, 데이터 암호화, 데이터 압축, 구문 검색, 정보 형식 변환, 문맥 관리 기능
- 데이터 단위 : 메시지

ㅅ. 7 애플리케이션 계층
: 사용자가 OSI 환경에 접속할 수 있도록 서비스 제공
- 프로세스 간의 정보 교환, 전자 사서함, 가상 터미널 등의 서비스 제공

네트워크 관련 장비

네트워크 인터페이스 카드(Network Interface Card)
컴퓨터를 연결하는 장치로 정보 전송 시 정보가 케이블을 통해 전송될 수 있도록 정보 형태를 변경
- 이더넷 카드 혹은 네트워크 어댑터라고도 함

허브(hub)
: 가까운 거리의 컴퓨터를 연결하는 장치
- 각 회선을 통합적으로 관리하며 신호 증폭 기능을 하는 리피터의 역할도 포함
ㄱ. 더미 허브
- 네트워크에 흐르는 모든 데이터를 단순히 연결만 함
- LAN이 보유한 대역폭을 나누어 제공
ㄴ. 스위칭 허브
- 네트워크상에 흐르는 데이터의 유무 및 흐름을 제어하여 각각의 노드가 허브의 최대 대역폭을 사용할 수 있는 지능형 허브

리피터(Repeater)
: 전송되는 신호가 원래의 형태와 다르게 왜곡되거나 약해질 경우 원래의 신호 형태로 재생하여 다시 전송하는 역할
- 근접한 네트워크 사이에 신호를 전송
- 전송 거리의 연장 또는 배선의 자유도를 높이는 용도

브리지(Bridge)
: LAN과 LAN을 연결하거나 LAN안에서 컴퓨터 그룹을 연결
- 데이터 링크 계층 중 MAC 계층에서 사용되므로 MAC 브리지라고도 함
- 현재는 스위치에 밀려 거의 사용되지 않는다

스위치(Switch)
- LAN과 LAN을 연결하여 훨씬 더 큰 LAN을 만드는 장치
- 포트마다 각기 다른 전송속도를 지원하도록 제어할 수 있음
- 수십 ~ 수백 개의 포트를 지원

라우터(Router) - LAN과 LAN의 연결 기능에 데이터 전송의 최적 경로를 선택할 수 있는 기능을 추가
- 서로 다른 LAN이나 LAN과 WAN의 연결도 수행
- 접속 가능한 경로에 대한 정보를 Routing Table에 저장하여 보관

게이트웨이(Gateway)
: 전 계층의 프로토콜 구조가 다른 네트워크의 연결을 수행
- LAN에서 다른 네트워크에 데이터를 송수신하는 출입구 역할을 함

프로토콜의 개념

프로토콜
서로 다른 기기들 간의 데이터 교환을 원활하게 수행할 수 있도록 표준화시켜 놓은 통신 규약

프로토콜의 기본 요소
- 구문 : 전송하고자 하는 데이터의 형식, 부호화, 신호 레벨 등을 규정
- 의미 : 두 기기 간의 효율적이고 정확한 정보 전송을 위한 협조 사항과 오류 관리를 위한 제어 정보를 규정
- 시간 : 두 기기 간의 통신 속도, 메시지의 순서 제어 등을 규정

프로토콜의 기능
ㄱ. 단편화와 재결합
 a. 단편화 : 송신 측에서 전송할 데이터를 전송에 알맞은 작은 크기의 블록으로 자르는 작업
 b. 재결합 : 수신 측에서 수신한 단편화된 데이터를 다시 모으는 작업
ㄴ. 캡슐화
- 단편화 된 데이터에 주소, 오류 검출 코드, 프로토콜 제어 정보를 부가하는 것
ㄷ. 흐름 제어
- 수신 측에서 송신 측의 데이터 전송 속도나 전송 량을 제어할 수 있는 기능
- 정지-대기 방식이나 슬라이딩 윈도우 방식을 이용
ㄹ. 오류 제어
- 전송 중에 발생하는 오류를 검출하고 정정하여 데이터나 제어 정보의 파손에 대비하는 기능
ㅁ. 동기화
- 송수신 측이 같은 상태를 유지하도록 타이밍을 맞추는 기능
ㅂ. 순서 제어
- 전송되는 데이터 블록에 전송 순서를 부여하여 연결 위주의 데이터 전송 방식에 사용
- 흐름 제어 및 오류 제어를 용이하게 함
ㅅ. 주소 지정
- 데이터가 목적지까지 정확하게 전송될 수 있도록 목적지 이름, 주소, 경로를 부여하는 기능
ㅇ. 다중화
- 한 개의 통신 회선을 여러 가입자들이 동시에 사용하도록 하는 기능
ㅈ. 경로 제어
- 송수신 측간의 송신 경로 중에서 최적의 패킷 교환 경로를 설정하는 기능
ㅊ. 전송 서비스
- 전송하려는 데이터가 사용하도록 하는 별도의 부가 서비스

TCP/IP

TCP/IP
인터넷에 연결된 서로 다른 기종의 컴퓨터들이 데이터를 주고받을 수 있도록 하는 표준 프로토콜

응용 계층의 주요 프로토콜
ㄱ. FTP : 원격 파일 전송 프로토콜
ㄴ. SMTP : 전자 우편 교환 서비스
ㄷ. TELNET : 원격 접속 서비스
- 가상 터미널 기능 수행
ㄹ. SNMP : TCP/IP의 관리 프로토콜
- 네트워크 기기의 네트워크 정보를 네트워크 관리 시스템에 보내는 데 사용되는 프로토콜
ㅁ. DNS : 도메인 네임을 IP주소로 매핑하는 시스템
ㅂ. HTTP : WWW에서 HTML을 송수신하기 위한 표준 프로토콜

전송 계층의 주요 프로토콜

ㄱ. TCP : 양방향 연결형 서비스 제공
- 가상 회선 연결 형태의 서비스 제공
- 순서 제어, 오류 제어, 흐름 제어 기능을 함
- 스트림 위주의 패킷 단위 전달
ㄴ. UDP : 비연결형 서비스 제공
- 실시간 전송에 유리하며, 신뢰성보다는 속도가 중요시되는 네트워크에서 사용
ㄷ. RTCP
- 패킷의 전송 품질을 제어하기 위한 제어 프로토콜
- 세션에 참여한 각 참여자들에게 주기적으로 제어 정보를 전송
- 데이터 전송을 모니터링하고 최소한의 제어와 인증 기능만을 제공
- 패킷은 항상 32비트의 경계로 끝남
```