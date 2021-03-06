# Information System Construction Management
#Data Processing Engineer/Information System Construction Management

---

```
소프트웨어 개발 방법론

소프트웨어 개발 방법론
: 소프트웨어 개발, 유지보수에 필요한 수행 방법과 효율적으로 수행하려는 과정에서 필요한 기법 및 도구를 정리하여 표준화

구조적 방법론
정형화된 분석 절차에 따라 사용자 요구사항을 파악하여 문서화하는 처리 중심의 방법론
- Divide and Conquer 원리 적용

정보공학 방법론
: 정보 시스템 개발을 위해 계획, 분석, 설계, 구축에 정형화된 기법들을 상호 연관성 있게 통합 및 적용하는 자료 중심의 
방법론
- 대규모 정보시스템 구축에 적합

객체지향 방법론
- 기계의 부품을 조립하듯이 객체들을 조립하여 소프트웨어를 구현하는 방법론
- 구조적 기법의 해결책으로 채택

컴포넌트 기반(CBD) 방법론
- 컴포넌트를 조합하여 새로운 애플리케이션을 만드는 방법론
- 컴포넌트의 재사용이 가능하여 시간, 노력, 비용을 절감하고 품질을 높임

애자일 방법론
- 고객의 요구사항 변화에 빠르고 유연하게 대응하도록 일정한 주기를 반복하면서 개발 과정을 진행하는 방법론
순서

제품 계열 방법론
- 특정 제품에 적용하고 싶은 공통된 기능을 정의하여 개발하는 방법론
- 임베디드 소프트웨어 개발에 적합

비용 산정 기법
소프트웨어 비용 산정
소프트웨어의 개발 규모를 소요되는 인원, 자원, 기간 등으로 확인하여 실행 가능한 계획을 수립하기 위해 필요한 비용
을 산정하는 것

소프트웨어 비용 결정 요소
ㄱ. 프로젝트 요소 : 제품 복잡도, 시스템 크기, 요구되는 신뢰도
ㄴ. 자원 요소 : 인적 자원, 하드웨어 자원, 소프트웨어 자원
ㄷ. 생산성 요소 : 개발자 능력, 개발 기간

하향식 산정 기법
과거의 유사한 경험을 바탕으로 전문 지식이 많은 개발자들이 참여한 회의를 통해 비용을 산정
ㄱ. 전문가 감정 기법
- 조직 내 경험이 많은 두 명 이상의 전문가에게 비용 산정을 의뢰
- 진행했던 유사한 프로젝트와 진행할 새로운 프로젝트 간 새로운 요소가 있을 수 있고 경험이 없을 수 있음
ㄴ. 델파이 기법
- 많은 전문가의 여러 의견을 종합하여 산정
- 한 명의 조정자와 여러 전문가로 구성되어 객관적임

상향식 산정 기법
: 프로젝트의 세부적인 작업 단위별로 비용을 산정 후 집계하여 전체 비용을 산정

ㄱ. LOC(source Line Of Code) 기법
: 소프트웨어의 각 기능의 원시 코드 라인 수로 예측치를 구하고 비용을 산정하는 기법
- 노력(인월) = 개발 기간 x 투입 인원 = LOC / 1인당 월평균 생산 코드 라인 수
- 개발 비용 = 노력(인월) x 단위 비용(1인당 월평균 인건비)
- 개발 기간 = 노력(인월) / 투입 인원
- 생산성 = LOC / 노력(인월)
ㄴ. 개발 단계별 인월수 기법
각 기능을 구현시키는 데 필요한 노력을 생명 주기의 각 단계별로 산정

수학적 산정 기법

수학적 산정 기법
- 상향식 산정 기법
- 개발 비용 산정의 자동화를 목표로 함
- 경험적 / 실험적 추정 모형이라고도 함
- 과거 유사한 프로젝트를 기반으로 공식을 유도

COCOMO 모형
: 보헴이 제안하였으며 LOC에 의한 비용 산정 기법

개발 유형 
: 소프트웨어의 복잡도 또는 원시 프로그램의 규모에 따라 분류
ㄱ. 조직형(Organinc Mode) : 기관 내부에서 개발된 중·소규모의 소프트웨어로 5만 라인 이하의 소프트웨어를 개발하는 
유형
ㄴ. 반분리형(Semi-Detached Mode) : 트랜잭션 처리 시스템이나 운영체제, 데이터베이스 관리 시스템 등 30만 라인 이하의 소프트웨어를 개발하는 유형
ㄷ. 내장형(Embedded Mode) : 최대형 규모의 트랜잭션 처리 시스템이나 운영체제 등 30만 라인 이상의 소프트웨어를 개발하는 유형

모형의 종류
: 비용 산정 단계 및 적용 변수의 구체화 정도로 구분
ㄱ. 기본형(Basic) : 소프트웨어의 크기와 개발 유형만을 이용하여 비용을 산정

ㄴ. 중간형(Intermediate) : 기본형의 공식을 사용하거나 4가지 특성의 15가지 요인에 의해 비용을 산정
a. 제품의 특성 : 요구되는 신뢰도, 데이터베이스 크기, 제품의 복잡도
b. 컴퓨터의 특성 : 수행 시간의 제한, 기억 장소의 제한, 가상 기계의 안정성, 반환 시간
c. 개발 요원의 특성 : 분석가의 능력, 개발 분야의 경험, 가상 기계의 경험, 프로그래머의 능력, 프로그래밍 언어의 경험
d. 프로젝트 특성 : 소프트웨어 도구의 이용, 프로젝트 개발 일정, 최신 프로그래밍 기법의 이용

ㄷ. 발전형(Detailed) : 개발 공정별로 보다 자세하고 정확하게 노력을 산출하여 비용을 산정

Putnam 모형
소프트웨어 생명 주기의 전 과정 동안에 사용될 노력의 분포를 가정해주는 모형
- 생명 주기 예측 모형이라고도 함
- 시간에 따라 함수로 표현되는 Rayleigh-Norden 곡선의 노력 분포도를 기초로 함
- 대형 프로젝트 노력 분포 산정에 이용
- SLIM : Rayleigh-Norder 곡선과 Putnam 예측 모델을 기초로 하여 개발된 자동화 측정 도구

기능 점수(FP) 모형
: 소프트웨어 기능을 증대시키는 요인별로 가중치를 부여하고 합산하여 총 기능 점수를 산출하며 총 기능 점수와 영향도를 이용하여 기능 점수를 구한 후 이를 이용해서 비용을 산정
- 알브레히트가 제안

소프트웨어 개발 방법론 결정

소프트웨어 개발 방법론
프로젝트 관리와 재사용 현황을 개발 방법론에 반영하고 확정된 소프트웨어 생명 주기와 개발 방법론에 맞춰 개발 단계, 활동, 작업, 절차 등을 정의

프로젝트 관리 유형
ㄱ. 일정 관리 : 작업 순서 / 기간 설정, 일정 개발 / 통제
ㄴ. 비용 관리 : 비용 산정 / 예산 편성 / 통제
ㄷ, 인력 관리 : 프로젝트 팀 편성 / 관리 / 개발, 프로젝트 조직 정의, 자원 산정 / 통제
ㄹ. 위험 관리 : 위험 식별 / 평가 / 대처 / 통제
ㅁ. 품질 관리 : 품질 계획 / 보증 수행 / 통제 수행

소프트웨어 개발 표준
소프트웨어 개발 표준
- 소프트웨어 개발 단계에서 수행하는 품질 관리에 사용되는 국제 표준

ISO/IEC 12207
- ISO에서 만든 표준 소프트웨어 생명 주기 프로세스

 CMMI(Capability Maturity Model Integration, 능력 성숙도 통합 모델)
: 소프트웨어 개발 조직의 업무 능력 및 조직의 성숙도를 평가

SPICE(Software Process Improvement and Capability Etermination, 소프트웨어 처리 개선 및 능력 평가 기준)
: 소프트웨어의 품질 및 생산성 향상을 위해 소프트웨어 프로세스를 평가 및 개선하는 국제 표준

프로세스
- 고객-공급자 프로세스 : 소프트웨어를 개발하여 고객에게 전달하는 것을 지원하며 소프트웨어의 정확한 운용 및 사용을 위한 프로세스로 구성
- 공학 프로세스 : 시스템과 소프트웨어 제품의 명세화, 구현, 유지보수를 하는데 필요한 프로세스로 구성
- 지원 프로세스 : 소프트웨어 생명 주기에서 다른 프로세스에 의해 이용되는 프로세스로 구성
- 관리 프로세스 : 소프트웨어 생명 주기에서 프로젝트 관리자에 의해 사용되는 프로세스로 구성
- 조직 프로세스 : 조직의 업무 목적 수립과 조직의 업무 목표 달성을 위한 프로세스로 구성

프로세스 수행 능력 단계
- 불완전 : 구현되지 않거나 목적을 달성하지 못함
- 수행 : 수행되고 목적이 달성됨
- 관리 : 정의된 자원 한도 내에서 작업 산출물을 인도
- 확립 : 소프트웨어 공학 원칙에 기반하여 정의된 프로세스가 수행
- 예측 : 목적 달성을 위해 통제되고 양적인 측정을 통해 일관되게 수행
- 최적화 : 수행을 최적화하고 지속적인 개선을 통해 업무 목적을 만족시킴

소프트웨어 개발 방법론 테일러링
- 프로젝트 상황 및 특성에 맞도록 정의된 소프트웨어 개발 방법론의 절차, 사용 기법 등을 수정 및 보완하는 작업


소프트웨어 개발 프레임워크
소프트웨어 개발에 공통적으로 사용하는 구성 요소와 아키텍처를 일반화하여 손쉽게 구현할 수 있도록 여러 가지 기능
들을 제공해주는 반제품 형태의 소프트웨어 시스템
ㄱ. 스프링 프레임워크 : 자바 플랫폼과 동적인 웹 사이트의 개발을 위한 프레임워크
ㄴ. 전자정부 프레임워크 : 우리나라의 공공부문 정보화 사업 시 효율적인 정보 시스템의 구축을 지원하기 위해 필요한 기능 및 아키텍처를 제공
ㄷ. 닷넷 프레임워크 : Windows 프로그램의 개발 및 실행 환경을 제공하는 프레임워크로 Microsoft에서 통합 인터넷 전략을 위해 개발됨

신기술 관련 용어

네트워크 관련 신기술 용어
1. IoT(Internet of Things, 사물인터넷) : 정보 통신 기술을 기반으로 실세계와 가상 세계의 다양한 사물과 사람을 인터넷
으로 소로 연결하여 진보된 서비스를 제공하기 위한 서비스 기반 기술

2. M2M(Machine to Machine, 사물 통신) : 무선 통신을 이용한 기계와 기계 사이의 통신

3. 모바일 컴퓨팅 : 휴대형 기기로 이동하면서 자유롭게 네트워크에 접속하여 업무를 처리할 수 있는 환경

4. 클라우딩 컴퓨팅 : 각종 컴퓨터 자원을 중앙 컴퓨터에 두고 인터넷 기능을 갖는 단말기로 언제 어디서나 인터넷을 통
해 컴퓨터 작업을 수행할 수 있는 환경

5. 모바일 클라우딩 컴퓨팅 : 모바일 컴퓨팅과 클라우딩 컴퓨팅을 혼합하여 클라우드 서비스를 이용하여 모바일 기기로 클라우딩 컴퓨팅 인프라를 구성하여 여러 가지 정보와 자원을 공유하는 ICT 기술

6. 인터클라우드 컴퓨팅 : 각기 다른 클라우드 서비스를 연동하거나 컴퓨팅 자원의 동적 할당이 가능하도록 여러 클라우드 서비스 제공자들이 제공하는 클라우드 서비스나 자원을 연결하는 기술

7. 매시 네트워크 : 차세대 이통통신, 홈네트워킹, 공공 안전 등 특수 목적을 위한 새로운 방식의 네트워크 기술로 대규모 
디바이스의 네트워크 생성에 최적화

8. 와이선 : 장거리 무선 통신을 필요로 하는 사물인터넷 서비스를 위한 저전력 장거리 통신 기술

9. NDN(Named Data Networking) : 콘텐츠 자체의 정보와 라우터 기능만으로 데이터 전송을 수행하는 기술

10. NGN(Next Generation Network, 차세대 통신망) : 유선망 기반의 차세대 통신망으로 유선망뿐만 아니라 이동 사용자를 목표로 하며 이동 통신에서 제공하는 완전한 이동성 제공을 목표로 개발

11. SDN(Software Defined Networking) : 네트워크를 컴퓨터처럼 모델링하여 여러 사용자가 각각의 소프트웨어들로 네트워킹을 가상화하여 제어하고 관리하는 네트워크

12. NFC(Near Field Communication) : 고주파를 이용한 근거리 무선 통신 기술

13. UWB(Ultra WideBand) : 짧은 거리에서 많은 양의 디지털 데이터를 낮은 전력으로 전송하기 위한 무선 기술로 무선 
디지털 펄스라고도 함

14. 피코넷 : 여러 개의 독립된 통신 장치가 블루투스 기술이나 UWB 통신 기술을 사용하여 통신망을 형성하는 무선 네트워크 기술

15. WBAN(Wireless Body Area Network) : 웨어러블 또는 몸에 심는 형태의 센서나 기기를 무선으로 연결하는 개인 영역 네트워킹 기술

16. GIS(Geographic Information System) : 지리적인 자료를 수집, 저장, 분석, 출력할 수 있는 컴퓨터 응용 시스템으로 위성을 이용해 모든 사물의 위치 정보를 제공해줌

17. USN(Ubiquitous Sensor Network) : 각종 센서로 수집한 정보를 무선으로 수집할 수 있도록 구성하는 네트워크

18. SON(Self Organizing Network) : 주변 상황에 맞추어 스스로 망을 구성하는 네트워크

19. 애드 혹 네트워크 : 재난 현장과 같이 별도의 고정된 유선망을 구축할 수 없는 장소에서 모바일 호스트만을 이용하여 구성한 네트워크

20. 네트워크 슬라이싱 : 여러 글로벌 이동통신 표준화 단체가 선정한 5G의 핵심기술 중 하나로 네트워크에서 하나의 물
리적인 코어 네트워크 인프라를 독립된 다수의 가상 네트워크로 분리하여 각각의 네트워크를 통해 다양한 고객 맞춤형 서비스를 제공하는 것을 목적으로 하는 네트워크 기술

21. 저전력 블루투스 기술 : 일반 블루투스와 동일한 주파수 대역을 사용하지만 연결되지 않은 상태에서는 절전 모드를 유지하는 기술

22. 지능형 초연결망 : 스마트 시티, 스마트 스테이션 등 4차 산업혁명 시대를 맞아 새로운 변화에 따라 급격하게 증가하는 데이터 트래픽을 효과적으로 수용하기 위해 시행되는 정부 주관 사업

SW 관련 신기술 용어
1. 인공지능 : 인간의 두뇌와 같이 컴퓨터 스스로 추론, 학습, 판단 등 인간 지능적인 작업을 수행하는 시스템

2. 뉴럴링크 : 테슬라의 CEO 일론 머스크가 사람의 뇌와 컴퓨터와 결합하는 기술을 개발하기 위해 설립한 회사

3. 딥 러닝 : 인간의 두뇌를 모델로 만들어진 인공 신경망을 기반으로 하는 기계 학습 기술

4. 전문가 시스템 : 특정 분야의 전문가가 수행하는 고도의 업무를 지원하기 위한 컴퓨터 응용 프로그램

5. 증강현실 : 실제 촬영한 화면에 가상의 정보를 부가하여 보여주는 기술

6. 블록체인 : P2P 네트워크를 이용하여 온라인 금융 거래 정보를 온라인 네트워크 참여자의 디지털 장비에 분산 저장하는 기술

7. 분산 원장 기술 : 중앙 관리자나 중앙 데이터 저장소가 존재하지 않고 P2P 망내의 참여자들에게 모든 거래 목록이 분
산 저장되어 거래가 발생할 때마다 지속적으로 갱신되는 디지털 원장

8. 해시 : 임의의 길이의 입력 데이터나 메시지를 고정된 길이의 값이나 키로 변환

9. 양자 암호키 분배 : 양자 통신을 위해 비밀키를 분배하여 관리하는 기술

10. 프라이버시 강화 기술 : 개인 정보 위험 관리 기술

11. 공통 평가 기준 : ISO 15408 표준으로 채택된 정보 보호 제품 평가 기준

12. 개인정보 영향평가 제도 : 개인정보를 활용하는 새로운 정보 시스템의 도입 및 기존 정보시스템의 중요한 변경 시 시스템의 구축, 운영이 기업의 고객은 물론 국민의 사생활에 미칠 영향에 대해 미리 조사, 분석, 평가하는 제도

13. 그레이웨어 : 소프트웨어를 제공하는 입장에서는 악의적이지 않은 유용한 소프트웨어 일지라도 사용자 입장에서는 유용할 수도 있고 악의적일 수도 있는 악성 코드나 공유 웨어

14. 매시업 : 웹에서 제공하는 정보 및 서비스를 이용하여 새로운 소프트웨어나 서비스 데이터베이스 등을 만드는 기술

15. 리치 인터넷 애플리케이션 : 플래스 애니메이션 기술과 웹 서버 애플리케이션 기술을 통합하여 기존 HTML보다 역동
적인 웹페이지를 제공하는 플래시 웹페이지 제작 기술

16. 시맨틱 웹 : 컴퓨터가 사람을 대신하여 정보를 읽고 이해하고 가공하여 새로운 정보를 만들어 낼 수 있도록 이해하기 쉬운 의미를 가진 차세대 지능형 웹

17. 증발품 : 판매 계획 또는 배포 계획은 발표되었으나 실제로 고객에게는 판매되거나 배포하지 않고 있는 소프트웨어

18. 오픈 그리드 서비스 아키텍처 : 애플리케이션 공유를 위한 웹 서비스를 그리드 상에서 제공하기 위해 만든 개방형 표준

19. 서비스 지향 아키텍처 : 기업의 소프트웨어 인프라인 정보시스템을 공유와 재사용이 가능한 서비스 단위나 컴포넌트 
중심으로 구축하는 정보기술 아키텍처

20. 서비스형 소프트웨어(SaaS) : 소프트웨어의 여러 기능 중에서 사용자가 필요로 하는 서비스만 이용할 수 있도록 한 소프트웨어

21. 소프트웨어 에스크로 : 소프트웨어 개발자의 지적재산권을 보호하고 사용자는 저렴한 비용으로 소프트웨어를 안정적으로 사용 및 유지보수받을 수 있도록 소스 프로그램과 기술 정보 등을 제3의 기관에 보관하는 것

22. 복잡 이벤트 처리 : 실시간으로 발생하는 많은 사건들 중 
의미가 있는 것만을 추출할 수 있도록 사건 발생 조건을 정의
하는 데이터 처리 방법

23. 디지털 트윈 : 현실속의 사물을 소프트웨어로 가상화한 모델

HW 관련 신기술 용어

1. 고가용성 : 긴 시간동안 안정적인 서비스 운영을 위해 장애 즉시 다른 시스템으로 대체 가능한 환경을 구축하는 메커니즘

2. 3D 프린팅 : 평면에 출력하는 것이 아닌 얇은 두께로 한층 한층 적재시켜 하나의 형태를 만들어내는 기술

3. 4D 프린팅 : 특정 시간이나 환경 조건이 갖추어지면 스스로 형태를 변화시키거나 제조되는 자가 조립 기술이 적용된 
제품을 3D 프린팅 하는 기술

4. RAID : 여러 개의 하드디스크로 디스크 배열을 구성하여 파일을 구성하여 파일을 구성하고 있는 데이터 블록들을 서로 다른 디스크들에 분산 저장하는 기술

5. 앤 스크린 : N개의 서로 다른 단말기에서 동일한 콘텐츠를 자유롭게 이용할 수 있는 서비스

6. 컴패니언 스크린 : TV 방송 시청 시 방송 내용을 공유하며 추가적인 기능을 수행할 수 있는 디바이스

7. 씬(Thin) 클라이언트 PC : 하드디스크나 주변 장치 없이 기본적인 메모리만 갖추고 서버와 네트워크로 운용되는 개인
용 컴퓨터

8. 멤스 : 초정밀 반도체 기술을 바탕으로 센서나 액추에이터 등 기계 구조를 다양한 기술로 미세 가공하여 전기기계적 동작을 할 수 있도록 한 초미세 장치

9. 패블릿 : 태블릿 기능을 포함한 5인치 이상의 대화면 스마트폰

10. 트러스트존 기술 : ARM에서 개발한 하나의 프로세서 내에 일반 애플리케이션을 처리하는 일반 구역과 보안이 필요한 애플리케이션을 처리하는 보안 구역으로 분할하여 관리하는 하드웨어 기반의 보안 기술

11. 엠디스크 : 한 번의 기록만으로도 자료를 영구 보관할 수 있는 광 저장 장치

12. 멤리스터 : 메모리와 레지스터의 합성어로 전류의 방향과 양 등 기존의 경험을 모두 기억하는 소자

DB 관련 신기술 용어
1. 빅데이터 : 기존의 관리 방법이나 분석 체계로는 처리하기 어려운 막대한 양의 정형 / 비정형 데이터 집합

2. 브로드 데이터 : 다양한 채널에서 소비자와 상호 작용을 통해 생산 되었거나 기업 마케팅에 있어 효율적이고 다양한 
데이터, 이전에 사용하지 않거나 몰랐던 새로운 데이터나 기존 데이터에 새로운 가치가 더해진 데이터

3. 메타 데이터 : 일련의 데이터를 정의하고 설명해주는 데이터

4. 디지털 아카이빙 : 디지털 정보 자원을 장기적으로 보존하기 위한 작업

5. 하둡 : 오픈 소스를 기반으로 한 분산 컴퓨팅 플랫폼

6. 타조 : 우리나라가 주도적으로 개발 중인 하둡 기반의 분산 데이터 웨어하우스 프로젝트

7. 데이터 다이어트 : 데이터를 삭제하는 것이 아닌 압축하고 중복된 정보를 배제하고 새로운 기분에 따라 나누어 저장하는 작업

네트워크 구축

네트워크 설치 구조 
정보를 전달하기 위해 통신 규약에 의해 연결한 통신 설비의 집합

ㄱ. 성형(중앙 집중형) - 중앙 컴퓨터에 단말 장치들이 연결되는 구조
- Point-to-Point 방식으로 연결
- 중앙 집중식이므로 교환 노드의 수가 가장 적음
- 단말장치가 고장이나도 전체에 영향을 주지 않지만 중앙 장치가 고장이 나면 전체에 영향을 줌

ㄴ. 링형(루프형) - 컴퓨터와 단말장치들을 서로 이웃하는 것끼리 Point-to-Point 방식으로 연결
- 데이터는 단방향 또는 양방향으로 전송 가능
- 하나의 단말장치라도 고장이나면 전체에 영향을 줌

ㄷ. 버스형
- 한 개의 통신 회선에 여러 대의 단말 장치가 연결되어 있는 형태
- 단말장치가 고장이 나도 전체에 영향을 주지 않음

ㄹ. 계층형(분산형) - 중앙 컴퓨터와 일정 지역의 단말 장치까지는 하나의 회선으로 연결시키고 이웃하는 단말장치는 일정 지역 내 설치된 중
간 단말장치로부터 다시 연결
- 분산처리 시스템을 구성하는 방식

ㅁ. 망형(메쉬형) - 모든 지점의 컴퓨터와 단말장치를 서로 연결시킨 상태
- 많은 양의 통신을 필요로 하는 경우 사용
- 필요한 포트의 수 = 노드 수 - 1 - 필요한 회선의 수 = 노드 수(노드 수 -1) / 2

네트워크 분류
ㄱ. 근거리 통신망(LAN) - 비교적 가까운 거리에 있는 노드들을 연결하여 구성
- 주로 버스형이나 링형 구조 사용

ㄴ. 광대역 통신망(WAN)
- 국가와 국가, 대륙과 대륙 등 멀리 떨어진 사이트들을 연결하여 구성
- 일정 지역은 LAN으로 연결하고 각 LAN을 연결하는 방식을 사용

스위치

스위치
: LAN과 LAN을 연결하여 훨씬 더 큰 LAN을 만드는 장치

스위치의 분류
ㄱ. L2 스위치
- OSI 2계층에 속함
- 일반적으로 부르는 스위치를 말함
- MAC주소를 기반으로 프레임 전송
- 동일 네트워크 간 연결만 가능
ㄴ. L3 스위치
- OSI 3계층에 속함
- L2 스위치에 라우터 기능이 추가
- IP 주소를 기반으로 패킷 전송
- 서로 다른 네트워크 연결 가능
ㄷ. L4 스위치
- OSI 4계층에 속함
- L3 스위치에 로드밸런서(트래픽 분산 장치) 추가
- IP 주소 및 TCP/UDP를 기반으로 사용자들의 요구를 서버의 부하가 적은 곳에 배분하는 로드밸런싱 기능 제공
ㄹ. L7 스위치
- OSI 7계층에 속함
- IP 주소, TCP/UDP 포트 정보에 패킷 내용까지 참조하여 세밀하게 로드밸런싱함

스위칭 방식
- 스위치가 프레임을 전달하는 방식에 따라 나뉨
- Store and Forwarding : 데이터를 모두 받은 후 스위칭
- Cut-through : 데이터의 목적지 주소만 확인 후 바로 스위칭
- Fragment Free : 위의 두 방식의 장점만을 결합한 방식

백본 스위치
- 여러 네트워크들을 연결할 때 중추적 역할을 하는 네트워크인 백본에서 스위칭하는 장비
- 모든 패킷이 지나가는 네트워크 중심에 배치
- 주로 L3 스위치가 백본 스위치 역할을 함
```

```
경로 트래픽 제어

경로 제어
: 전송 경로 중 어느 한 경로에 데이터의 양이 집중되는 것을 피하면서 최저의 비용으로 최단 시간에 송신할 수 있는 경로인 최적 패킷 교환 경로를 결정
- 경로 제어표를 참조해서 라우터에 의해 수행
- 경로 제어 요소 : 성능 기준, 경로의 결정 시간 / 장소, 정보 발생지, 경로 정보의 갱신 시간

경로 제어 프로토콜
효율적인 경로 제어를 위해 네트워크를 제어하는 프로토콜
ㄱ. IGP(내부 게이트웨이 프로토콜)
 - 하나의 자율 시스템(AS) 내의 라우팅에 사용
- RIP : 현재 가장 널리 사용되며 소규모 네트워크에서 효율적인 방법
- OSPF : 대규모 네트워크에서 많이 사용되는 프로토콜
ㄴ. EGP(외부 게이트웨이 프로토콜) - 자율 시스템 / 게이트웨이 간 라우팅에 사용되는 프로토콜
ㄷ. BGP
- 자율 시스템 간의 라우팅 프로토콜
- EGP의 단점을 보완하기 위해 만들어짐
- 초기 연결 시 라우팅 테이블을 교환하고 이후에는 변화된 정보만을 교환

트래픽 제어
네트워크의 보호, 성능 유지, 자원의 효율적인 이용을 위해 전송되는 패킷의 흐름, 양을 조절하는 기능

흐름 제어
: 네트워크 내의 원활한 흐름을 위해 송수신 사이 전송되는 패킷의 양이나 속도를 규제
- 송수신간 처리 속도 또는 버퍼 크기의 차이에 의해 생길 수 있는 버퍼 오버플로우를 방지
- 정지-대기 : 수신 측에서 확인 신호를 받아야 다음 패킷을 전송

슬라이딩 윈도우
- 확인 신호를 이용하여 송신 데이터의 양을 조절
- 수신 측의 확인 신호를 받지 않아도 정해진 패킷 수만큼 연속적으로 전송하는 방식
- 한 번에 여러 개의 패킷을 전송할 수 있음

혼잡 제어
- 네트워크 내의 패킷 수를 조절하여 네트워크의 오버플로우를 방지

교착상태 방지
- 교환기 내에 패킷들을 축적하는 기억 공간이 꽉 차있을 때 
다음 패킷들을 이 기억 공간에 들어가기 위해 무한정 기다리
는 현상을 방지

소프트웨어 개발 보안
소프트웨어 개발 과정에서 발생할 수 있는 보안 취약점을 최소화하여 보안 위협으로부터 안전한 소프트웨어를 개발하기 위한 보안 활동
- 데이터의 기밀성, 무결성, 가용성을 유지하는 것이 목표

소프트웨어 개발 직무별 보안 활동(?)

Secure OS
기존 운영체제에 내재된 보안 취약점을 해소하기 위해 보안 기능을 갖춘 커널을 이식한 운영체제

회복/병행제어
회복
- 트랜잭션을 수행하는 도중 장애가 발생하여 데이터베이스가 손상되었을 때 복구하는 작업
- 장애의 유형 : 트랜잭션 장애, 시스템 장애, 미디어 장애
- 회복 관리기 : 트랜잭션이 실행이 완료되지 못하면 트랜잭션이 데이터베이스에 생성했던 모든 변화를 취소(Undo)시키고 이전의 원래 상태로 복구하는 역할을 담당

병행 제어
동시에 여러 개의 트랜잭션을 수행할 때 데이터베이스의 일관성을 유지할 수 있도록 트랜잭션 간 상호작용을 제어

병행 제어의 목적
- 데이터베이스의 공유 및 시스템의 활용도 최대화
- 데이터베이스 일관성 유지
- 응답 시간 최소화

병행 수행의 문제점
ㄱ. 갱신 분실 : 두 개 이상의 트랜잭션이 같은 자료를 공유하여 갱신할 때 갱신 결과의 일부가 없어짐
ㄴ. 비 완료 의존성 : 하나의 트랜잭션이 실패한 후 회복되기 전에 다른 트랜잭션이 실패한 갱신 결과를 참조
ㄷ. 모순성 : 병행 수행될 때 원치 않는 자료를 이용하여 문제가 발생
ㄹ. 연쇄 복귀 : 트랜잭션 중 하나에 문제가 생겨 ROLLBACK 하는 경우 다른 트랜잭션도 같이 ROLLBACK 됨

데이터 표준화
: 시스템을 구성하는 데이터 요소의 명칭, 정의, 형식, 규칙에 대한 원칙을 수립하고 정의

Secure SDLC(Software Development Life Cycle)
: 보안상 안전한 소프트웨어를 개발하기 위해 SDLC(소프트웨어 개발 생명주기)에 보안 강화를 위한 프로세스를 포함한 것

세션 통제

세션 통제
서버와 클라이언트의 연결인 세션 간의 연결로 인해 발생하는 정보를 관리
- 요구사항 분석 및 설계 단계에서 진단해야 하는 보안 점검 내용

불충분한 세션 관리
- 일정한 규칙이 존재하는 세션ID가 발급되거나 타임아웃이 너무 길게 설정되어 있는 경우 발생
- 세션 하이재킹(세션 정보를 가로채는 공격)을 통해 획득한 세션 ID로 접근할 수 있음

잘못된 세션에 의한 정보 노출
- 다중 스레드 환경에서 멤버 변수에 정보를 저장할 때 발생
- 변수의 범위를 제한하는 방법으로 방지 가능
- 싱글톤 패턴에서 발생하는 레이스컨디션으로 인해 동기화 오류가 발생하거나 멤버 변수의 정보가 노출될 수 있음
- 레이스컨디션 : 두 개 이상의 프로세스가 공용 자원을 획득하기 위해 경쟁하고 있는 상태

세션 설계 시 고려사항
- 로그아웃 요청 시 할당된 세션이 완전히 제거되도록 함
- 이전 세션이 종료되지 않으면 새로운 세션이 생성되지 못하도록 함

입력 데이터 검증 및 표현
: 입력 데이터로 인해 발생하는 문제들을 예방하기 위해 구현 단계에서 검증해야 하는 보안 점검 항목

해결방법
SQL 삽입 -  입력데이터에 특수 문자 입력되지 않게 필터링
경로 조작 및 자원 삽입 - 경로 순회 공격을 막는 필터
크로스사이트 필터링 - HTML 태그 사용을 제한
운영체제 명령어 삽입 - 웹 인터페이스를 통해 시스템 명령어 전달 방지
위험한 형식 파일 업로드 - 업로드 되는 파일의 확장자 제한, 웹사이트와 파일 서버의 경로 분리, 실행 속성 제거
신뢰되지 않는 URL 주소로 연결 - 연결되는 외부 사이트의 주소를 화이트 리스트로 관리

에러 처리
소프트웨어 실행 중 발생할 수 있는 오류들을 사전에 정의하여 오류로 인해 발생할 수 있는 문제들을 예방하기 위한 보안 점검 항목

코드 오류
소프트웨어 구현 단계에서 코딩 중 실수하기 쉬운 형 변환, 자원 반환 등 오류를 예방하기 위한 보안 점검 항목

캡슐화
: 정보 은닉이 필요한 중요한 데이터와 기능을 불충분하게 캡슐화하거나 잘못 사용함으로써 발생할 수 있는 문제를 예방하기 위한 보안 점검 항목

API 오용
- 소프트웨어 구현 단계에서 API를 잘못 사용하거나 보안에 취약한 API를 사용하지 않도록 하는 보안 검증 항목

 암호 알고리즘

암호 알고리즘
중요정보를 보호하기 위한 평문을 암호화된 문장으로 만드는 방법

단방향 - 해시
양방향 - 공개키, 개인키(stream 방식, block 방식)

개인키 암호화 기법
- 동일한 키로 데이터를 암호화하고 복호화함
- 대칭 암호 기법, 단일키 암호화 기법이라고도 함
- Stream 기법 : 평문과 동일한 길이의 스트림을 생성하여 비트 단위로 암호화
- Block 기법 : 한 번에 하나의 데이터 블록을 암호화

공개키 암호화 기법
- 데이터를 암호화하는 공개키는 데이터베이스 사용자에게 공개하고 복호화하는 비밀키는 관리자에게만 공개
- 비대칭 암호화 기법이라고도 함
- RSA기법 : 공개키와 비밀키는 메시지를 열고 잠그는 상수를 의미

양방향 암호화 알고리즘 종류
- SEED : 블록 크기는 128비트, 키의 길이에 따라 128, 256로 분류
- ARIA : 블록 크기는 128비트, 키의 길이에 따라 128, 192, 256로 분류
- DES : 블록 크기는 64비트, 키의 길이 56비트
- AES : 블록 크기는 128비트, 키의 길이에 따라 128, 192, 256로 분류

해시(Hash) - 임의의 길이의 입력 데이터나 메시지를 고정된 길이의 값이나 키로 변환
- SHA 시리즈, MD5, N-NASH, SNEFRU 등

서비스 공격 유형

서비스 거부 공격
: 표적이 되는 서버의 자원을 고갈시킬 목적으로 다수의 공격자 또는 시스템에서 대량의 데이터를 한 곳의 서버에 집중적으로 전송함으로써 표적이 되는 서버의 정상적인 기능을 방해

Ping of Death
Ping 명령 전송 시 패킷의 크기를 인터넷 프로토콜 허용 범위 이상으로 공격하여 공격 대상의 네트워크를 마비시키는 서비스 거부 방법

SMURFING
IP나 ICMP의 특성을 악용하여 엄청난 양의 데이터를 한 사이트에 집중적으로 보냄으로써 네트워크를 불능 상태로 만드
는 공격 방법

SYN Flooding
: 공격자가 가상의 클라이언트로 위장하여 3-way-handshake 과정을 의도적으로 중단시킴으로써 공격 대상지인 서버가 대기 상태에 놓여 정상적인 서비스를 수행하지 못하게 하는 공격 방법

TearDrop
: 데이터의 송수신 단계에서 전송되는 Fragment Offset 값을 변경시켜 패킷을 재조립할 때 오류로 인한 과부하를 발생시킴으로 시스템이 다운되도록 하는 공격 방법

Land
패킷 전송 시 송수신 IP 주소를 모두 공격 대상의 IP주소로 하여 공격 대상에게 전송하여 무한히 자신에게 응답을 수행하게 되는 공격 방법

DDos(Distributed Denial of Service, 분산 서비스 거부) 공격
: 여러 곳에 분산된 공격 지점에서 한 곳의 서버에 대해 공격을 수행
- 네트워크에서 취약점이 있는 호스트들을 탐색한 후 호스트들에게 분산 서비스 공격 툴을 설치하여 에이전트로 만든 후 공격에 이용

네트워크 침해 공격 관련 용어
ㄱ. 스미싱 : 문자 메시지를 이용해 사용자의 개인 신용 정보를 빼내는 수법
ㄴ. 스피어 피싱 : 일반적인 이메일로 위장한 메일을 지속적으로 발송하여 메일의 링크나 첨부된 파일을 클릭하게 유도하여 개인 정보를 탈취
ㄷ. APT(지능형 지속 위협) : 조직적으로 특정 기업이나 조직 네트워크에 침투해 활동 거점을 마련한 뒤 때를 기다리면서 보안을 무력화시키고 정보를 수집한 다음 외부로 빼돌리는 형태의 공격
ㄹ. 무작위 대입 공격 : 암호화된 문서의 암호키를 찾기 위해 무작위로 값을 대입하여 공격하는 방식
ㅁ. 큐싱 : QR코드를 통해 악성 앱을 다운받게 하여 개인 정보를 탈취하는 공격 방식
ㅂ. SQL 삽입 공격 : 웹사이트를 무차별적으로 공격하는 과정에서 취약한 사이트 발견 시 데이터를 조작하는 일련의 공격 방식
ㅅ. 크로스 사이트 스크립 : 웹 페이지의 내용을 사용자 브라우저에 표현하기 위해 사용되는 스크립트의 취약점을 악용한 해킹 기법

정보 보안 침해 공격 관련 용어
ㄱ. 좀비 PC : 악성코드에 감염되어 다른 프로그램이나 컴퓨터를 조종하도록 만들어진 컴퓨터
ㄴ. C&C 서버 : 해커가 원격지에서 감염된 좀비 PC에 명령을 내리고 악성코드를 제어하기 위한 용도로 사용하는 서버
ㄷ. 봇넷 : 악성 프로그램에 감염된 컴퓨터들이 네트워크로 연결된 형태
ㄹ. 웜 : 네트워크를 통해 연속적으로 자신을 복사하여 시스템의 부하를 높여 시스템을 다운시키는 바이러스의 일종
ㅁ. 제로 데이 공격 : 보안 취약점이 발견됐을 때 공표되기도 전에 해당 취약점을 통해 신속하게 이루어지는 보안 공격
ㅂ. 키로거 공격 : 사용자의 키보드 움직임을 탐지하여 개인 정보를 몰래 빼가는 공격
ㅅ. 랜섬웨어 : 사용자의 컴퓨터에 잡입해 파일을 암호화하여 사용자가 열지 못하게 하는 프로그램
ㅇ. 백도어 : 액세스 편의를 위해 시스템 보안을 제거하여 만들어 놓은 비밀 통로를 통해 범죄에 악용되는 형태
ㅈ. 트로이 목마 : 정상적인 기능을 하는 프로그램인 척 프로그램에 숨어 있다가 해당 프로그램이 동작될 때 활성화되어  부작용을 일으키는 형태

서버인증

보안 서버
: 인터넷을 통해 개인정보를 암호화하여 송수신할 수 있는 기능을 갖춘 서버
- 서버에 SSL(Secure Socket Layer) 인증서를 설치하여 전송 정보를 암호화하여 송수신

인증의 개념 
다중 사용자 컴퓨터 / 네트워크 시스템에서 로그인을 요청한 사용자의 정보를 확인하고 접근 권한을 검증하는 보안 절차

ㄱ. 지식 기반 인증
- 사용자가 기억하고 있는 정보를 기반으로 인증을 수행
- 고정된 패스워드, 패스 프레이즈, 아이핀
ㄴ. 소유 기반 인증
- 사용자가 소유하고 있는 것을 기반으로 인증을 수행
- 신분증, 메모리 카드, 스마트 카드, OTP
ㄷ. 생체 기반 인증
- 사용자의 고유한 생체 정보를 기반으로 인증을 수행
- 지문, 홍채/망막, 얼굴, 음성, 정맥
ㄹ. 기타 인증 방법
- 행위 기반 인증 : 사용자의 행동 정보를 이용해 인증 수행
- 위치 기반 인증 : 인증을 시도하는 위치나 적절성 확인

로그
- 시스템 사용에 대한 모든 내역을 기록하여 시스템 침해 사고 발생 시 해킹 흔적이나 공격 기법을 파악할 수 있음

보안 솔루션
: 접근 통제, 침입 차단 등을 수행하여 외부로부터 불법적인 침입을 막는 기술 및 시스템
```