# SQL
#etc/Data Processing Engineer/practical test/SQL

---

```
8장 SQL 응용

DDL(Data Definition Langauge)
db를 구축하거나 수정할 목적으로 사용하는 언어
create
alter
drop

cascade
제거할 요소를 참조하는 모든 개체를 함께 제거
restrict
다른 개체가 제거할 요소를 참조중일대는 제거 취소

DCL(Data Control Language)
데이터의 보안, 무결성, 회복, 병행 제어등을 정의하는데 사용하는 언어
COMMIT
ROLLBACK
GRANT
REVOKE

사용자 등급
DBA 데이베이스 관리자
RESOURCE 데이터베이스 및 테이블 생성 가능자
CONNECT 단순사용자

WITH GRANT OPTION 부여받은 권한을 다른 사람에게 다시 권한부여 가능
GRANT OPTION FOR 다른 사용자에게 권한 부여할 수 있는 권한 취소
CASCADE 권한 취소시 연쇄적 취소


TCL(Transaction Control Language)
COMMIT 트랜잭션이 수행한 내용을 데이터베이스에 반영하는 명령
ROLLBACK 변경되었으나 아직 COMMIT되지 않은 모든 내용을 취소하고 데이터베이스를 이전 상태로 되돌리는 명령어
SAVEPOINT 트랜잭션 내에 ROLLBACK할 위치인 저장점을 지정하는 명령어

DML
데이터를 조작하기 위해 사용되는 언어
select
insert
delete
update 

like 연산자: 문자 패턴과 일치하는 튜플을 검색하기 위해 사용
% 모든 문자를 대신함
_ 문자 하나를 대신함
# 숫자 하나를 대신함

JOIN
연관된 튜플을 조합해 하나의 릴레이션을 반환

프로시저
sql로 작성한 일련의 작업을 원할 때마다 저장한 작업을 수행하도록 하는 절자형SQL

DECLARE
BEGIN
CONTROL
SQL
EXCEPTION
TRANSACTION
END

프로시저 생성
CREATE PROCEDURE

프로시저 실행
EXCEUTE 프로시저명
or EXEC
or CALL 

프로시저 제거
DROP PROCEDURE 프로시저명

트리거
이벤트가 발생할 때 관련 작업이 자동으로 실행되게 하는 절차형 SQL

DECLARE
EVENT
BEGIN
CONTROL
SQL
EXCEPTION
END

트리거 생성
CREATE TRIGGER

트리거 제거
DROP TRIGGER

사용자 정의 함수 ( ex) sum, avg, dml)
프로시저와 유사하게 일련의 작업을 연속적으로 처리하지만 종료시 처리 결과로 단일값만을 반환하는 절차형 SQL

DECLARE
BEGIN
CONTROL
SQL
EXCEPTION
RETURN
END

사용자 정의 함수 생성
CREATE FUNCTION

제어문
절차형 SQL의 진행 순서를 변경하기 위해 사용되는 명령문

IF문
조건에 따라 실행할 문장을 달리하는 제어문

LOOP문
조건에 따라 실행할 문장을 반복 수행하는 제어문

커서(Cursor)
쿼리문의 처리 결과가 저장되어 있는 메모리 공간을 가르키는 포인터

묵시적 커서
내부에서 자동으로 생성되어 사용되는 커서
속성 종류
SQL%FOUND 쿼리수행의 결과로 패치된 튜플 수가 1개이상이면 TRUE
SQL%NOTFOUND 쿼리수행의 결과로 패치된 튜플 수가 0개이면 TRUE
SQL%ROWCOUNT 쿼리수행결과로 패치된 튜플 수 반환
SQL%ISOPEN 커서가 열린상태이면 open 묵시적 커서는 생성된후 자동으로 닫히기 떄문에 항상 Close

명시적 커서
사용자가 직접 정의해서 사용하는 커서

선언 형식
CURSOR 커서명(매개변수1, 매개변수2, ....)
IS

SELECT문:
열기 형식
OPEN 커서명(매개변수1, 매개변수2, ...)
패치 형식
FETCH 커서명 INTO 변수1, 변수2 ...;
닫기 형식
CLOSE 커서명

DBMS 접속
데이터를 사용하기 위해 응용시스템을 이용하여 DBMS 접근하는 것

웹응용시스템
웹 서버 + 웹애플리케이션 서버로 구성

DBMS 접속기술
DBMS에 접근하기 위해 사용되는 API를 편리하게 도와주는 프레임워크
종류
JDBC
ODBC
MYBATIS

동적 SQL
SQL구문을 동적으로 변경하여 처리할 수 있는 SQL 처리 방식

SQL 테스트
SQL이 작성 의도에 맞게 원하는 기능을 수행하는지 검증하는 과정

단문 sql 테스트
DDL, DML, DCL이 포함되어 있는 SQL, TCL을 테스트하는 것
BY DESCRIBE(=DESC)

절차형 SQL 테스트
BY SHOW ERRORS

orm(객체 관계 매핑)
객체와 관계형 데이터베이스의 데이터를 연결하는 기술

쿼리 성능 향상
데이터 입 출력 애플리케이션의 성능 향상을 위해 SQL 코드를 최적화하는 것
옵티마이저  실행 계획 검토 후 SQL 코드와 인덱스 재구성 필요

옵티마이저
작성된 SQL이 가장 효율적으로 수행되도록 최적의 경로를 찾아주는 모듈
RBO(Rule Based Optimizer): 미리 정해둔 규칙 기반
CBO(Cost Based Optimizer): 비용으로 최적의 경로를 찾는

실행 계획
옵티마이저가 수립한 SQL 코드의 실행 절차와 방법
실행계획은 EXPLAIN으로 확인 가능
```