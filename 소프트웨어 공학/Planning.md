# Planning
#소프트웨어공학/Planning

---
## Software Development Planning
- 비용, 기간, 자원 계획 필요

Without Planning?
- 일정 지연, 비용 초과, 품질 저하 -> 유지보수 비용 증가

### Definition of Problems
- 무엇을 개발할 것인지 명확히 정의
- 개발 범위를 정의

-> 프로젝트의 초기 타당성과 초기 계획을 작성할 수 있는 기초로 활용

Requirements for problem definition
- 개발하고자 하는 영역의 배경 지식
- 문제를 파악하기 위해 현재 운영중인 시스템 사용
- 실무 담당자와 면담하여 자료를 수집한 후 면밀히 분석

## 타당석 분석
경제적 타당석
- Manager 경영자: 투자 효율성
- Analyst 분석가: 투자 대비 효과 검토 후 경영자에게 정확한 정보 제공

-> 개발 여부 판단

기술적 타당성
- 현재의 기술로 구현할 수 있는지
- 하드웨어 성능이 개발에 지장은 없는지
- 개발자 기술력에 문제가 없는지

법적 타당성
- 개발용 소프트웨어와 도구의 사용이 법적으로 문제가 없는지

## Factors Affecting Software Development
프로그래머 자질
- 초급 프래그래머와 고급 프로그래머의 차이

소프트웨어 복잡도
- 애플리케이션 개발 < 유틸리티 개발 < 시스템 프로그램 개발

소프트웨어 크기
- 참여 인력 증가, 개발 기간 길어짐, 복잡도 커짐

가용시간
- 관리자들의 잘못된 생각: 인력/자원 증가는 개발 기간 단축
- B.Boehm: "정상적이 계획에서 최대 75%가 줄일 수 있는 한계"

요구되는 신뢰도 수준
- 높은 신뢰도의 소프트웨어: 개발 비용 증가

프로그래밍 언어 수준
- 고급 언어 사용: 저급 언어의 사용보다 5~10배의 생산성 증가

## Types of SW development cost estimation

### 하향식 산정 기법(Top-down techs)
전문가 판단 기법
- 경험이 많은 전문가가 개발 비용을 산정
- 짧은 시간에 개발비를 산정하는 경우 많이 사용
- Disadvantage: 수학적 계산 방법보다 경험에만 의존할 경우 부정확할 수 있음

-> 보완

델파이 기법

![](./img/P_1.png)

### 상향식 산정 기법(Bottom up)
상향식 산정 기법
- 세부 작업 단위별로 비용 산정한 후 전체 비용 합산
- Disadvantage: 수학적 계산 방법보다 경험에만 의존할 경우 부정확할 수 있음

원시 코드 라인 수(LOC) 기법
- 원시 코드 라인수의 비관치, 낙관치, 중관치를 측정 후 예측치를 구해 비용 산정

개발 단계별 노력 기법
- 생명주기의 각 단계별로 노력(M/M)을 산정

### 수학적 산정 기법(Mathematical estimation techniques)
COCOMO 기법
- SW 규모(LOC) 예측 한 후 SW 종류에 따라 각 비용 산정 공식에 대입하여 비용 산정

Putnam 기법
- 소프트웨어 생명주기의 전 과정에 사용될 노력의 분포를 가정해 주는 비용 산정 기법

Function Point(FP: 기능 점수) 기법
- 기능 점수를 구한 후 이를 이용해 비용 산정