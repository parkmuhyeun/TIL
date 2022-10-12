# Interface
#etc/Data Processing Engineer/practical test/Interface

---

```
5장
인터페이스 구현

요구사항 검토
- 동료 검토(Peer Review)
- 워크스루(Walk Through)
- 인스펙션 (Insepctiopn)
프로토타이핑
테스트 설계
CASE 도구 활용

인터페이스 요구사항 
완전성
일관성
명확성
기능성
검증 가능성
추적 가능성
변경 용이성

미들웨어 솔루션
운영체제와 응용 프로그램 또는 서버와 클라이언트 사이에서 서비스를 제공하는 소프트웨어

DB
클라이언트에서 원격의 데이터베이스와 연결하는 미들웨어

RFC(원격 프로시저 호출)
원격 프로시저를 로컬 프로시저처럼 호출하는 미들웨어

MOM(메시지 지향 미들웨어)
비동기형 메시지를 전달하는 미들웨어

TP-Monitor(트랜잭션 처리 모니터)
트랜잭션을 처리 및 감시하는 미들웨어

ORB(객체 요청 브로커)
코바 표준 스펙을 구현한 객체 지향 미들웨어

WAS(웹 애플리케이션 서버)
동적 콘텐츠 처리하기 위한 미들웨어

모둘 연계
내부 모듈과 외부 모듈 또는 내부 모듈간 데이터 교환을 위해 관계를 설정

모듈 연계 방법
EAI(Enterprisae Application Integration)
기업 내 각종 애플리케이션 및 플랫폼 간의 상호 연동이 가능하게 해주는 솔루션
EAI 구축 유형
Point-to-Point
Hub & Spoke
Message Bus
Hybrid

ESB
애플리케이션 간 표준 기반 인터페이스 제공

웹 서비스
네트워크 정보를 표준화된 서비스 형태로 만들어 공유하는 기술

웹 서비스 구성
SOAP
UDDI
WSDL

JSON(Javascript Objecnt Notation)
데이터 객체를 속성 값의 쌍 형태로 표현하는 개방형 표준 포맷

AJAX(Asynchronous JavaScript and XML)
클라이언트와 서버 간에 XML 데이터를 주고 받는 비동기 통신 기술

인터페이스 보안
인터페이스의 보안 취약점을 분석한 후 적절한 보안 기능을 적용하는 것

인터페이스 보안 기능 적용
네트워크 영역, IPsec, SSL, S-HTTP
애플리케이션 영역
데이터베이스 영역

데이터 무결성 검사 도구
Tirpwire, AIDE, Samhain, Claymore, Slipwire, Fcheck

인터페이스 구현 검증
인터페이스가 정상적으로 문제없이 작동하는지 확인

인터페이스 구현 검증 도구
xUnit
STAF
FitNesse
NTAF
Selenium
watir

인터페이스 구현 감시 도구
인터페이스 동작 상태는 APM을 통해 감시 가능
대표적인 APM
스카우터
제니퍼

APM(Application Performance Management)
애플리케이션 성능 관리를 위해 다양한 모니터링 도구를 제공하는 도구

리소스 방식 Nagios, Zabbix, Cacti
엔드투엔드 방식 VisualVM, 제니퍼, 스카우터
```