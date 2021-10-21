# SQL
#데이터베이스/SQL

---
## SQL (By Oracle)

### 특정 필드만 출력
```sql
SELECT sid, sname
FROM student;
```

### 테이블의 모든 열 출력
```sql
SELECT *
FROM student;
```

### DISTINCT를 이용하여 중복 제거
```sql
SELECT distinct deptno
FROM student;
```

### 특정 필드 이름을 변경하여 출력
학생 테이블에서 deptno 를 department로 바꿔 출력
```sql
SELECT sid, sname, deptno department
FROM student;
```

### 열 결합하여 출력
학번과 이름을 합치고 열 이름을 student로 출력
```sql
SELECT sid||sname student
FROM student;
```

### 정렬출력
학과 순(내치림차순)으로 출력
```sql
SELECT sid, sname, deptno, grade
FROM student
ORDER BY deptno DESC;
```

### 논리 연산자
- AND 모든 조건이 만족
- OR 하나 이상의 조건이 만족
- NOT 주어진 조건을 부정

### 비교 연산자
```sql
SELECT sid, sname, deptno, addr
FROM student
WHERE gen = 'F';

SELECT sname, deptno, grade
FROM student
WHERE grade > 3.5;
```

### Between 연산자
```sql
SELECT sname, grade
FROM student
WHERE grade between 3.0 and 3.5;
```

### IN 연산자
지도 교수 id가 101, 201, 401 인 학생 출력
```sql
SELECT sid, sname, grade, advisor
FROM student
WHERE advisor in (101, 201, 401);
```

### LIKE 연산자
Example
- LIKE `KIM%` = 'KIM'으로 시작하는 문자열이면 참
- LIKE `%KIM%` = 'KIM'을 포함하는 문자열이면 참
- LIKE `%TH` = 'TH'로 끝나는 문자열이면 참
- LIKE `__TH%` = 앞에서 3번째와 4번째 위치에 `TH`가 포함되는 문자열이면 참
- LIKE `%TH_` = 마지막 바로 앞에 `TH`가 포함되는 문자열이면 참

### NULL이란?
- SQL Keyword
- 존재하지 않거나, 모르는 데이터의 상태를 표시
- NULL에 대한 모든 산술 연산자의 결과는 NULL
- NULL에 대한 모든 비교 연산자의 결과는 FALSE

---

## 함수
단일 행에 대한 함수들
- 문자 함수
- 숫자 함수
- 날짜 함수
- 기타 함수(전환, 조건 등)

Group 함수들
- AVG
- COUNT
- MAX
- MIN
- SUM

### 문자 함수 - LOWER, UPPER
학과 테이블에서 학과 이름은 소문자로, 단과 대학은 대문자로 출력

```sql
SELECT lower(dname), upper(college)
FROM department;
```

### 문자 함수 – LPAD
LPAD(필드, 문자 범위, '형식')에 따라 결과 출력

```sql
SELECT lpad(deptno, 10, ' '), lpad(dname, 20, '*'), 
lpad(budget, 20, '.')
FROM department;
```

![](./img/S_1.png)

### 문자 함수 – SUBSTR
Substr('문자열' 혹은 필드, pos, n) 함수는 문자열의 pos 위치부터 n개의 문자를 출력(n이 없으면 마지막까지)

```sql
SELECT dname, substr(dname, 2),
substr(dname, 3, 3)
FROM department;
```

![](./img/S_2.png)

### 문자 함수 – INSTR
- Instr(필드, '문자') - 필드에서 문자가 있는 위치를 출력
- Instr(필드, 'answk', 수1, 수2) - 수1부터 문자가 있는 위치를 검색하되, 수2번째의 위치 출력

```sql
SELECT dname, instr(dname, 'e'), instr(dname, 'ic'),
instr(dname, 'e', 2, 2)
FROM department;
```

![](./img/S_3.png)

### 문자 함수 – LENGTH
필드나 입력한 문자열의 문자 개수를 출력

```sql
SELECT deptno, length(deptno), dname, length(dname)
FROM department;
```

### 문자 함수 – TRANSLATE
TRANSLATE(필드, 'A', 'B')함수는 필드에서 문자 A를 찾아 B로 변환한 후 출력

```sql
SELECT dname, translate(dname, 'e', 'E'), 
translate(dname, 'ie', 'IE')
FROM department;
```

![](./img/S_4.png)

### 숫자 함수 - ROUND
ROUND(필드 혹은 입력값, 숫자)함수는 입력값을 숫자만큼 반올림

```sql
SELECT round(45.923, 1), round(45.923),
round(45.323, -1), round(grade, 1)
FROM student
WHERE deptno=30;
```

![](./img/S_5.png)

### 숫자 함수 – POWER
POWER(필드 혹은 입력값, 숫자) 함수는 입력값의 숫자만큼 제곱한 값을 출력

### 숫자 함수 - SQRT
SQRT(필드 혹은 입력값) 함수는 입력값의 제곱근을 출력

### 숫자 함수 - SIGN
SIGN(필드 혹은 입력값) 함수는 입력값 < 0 이면 -1 출력, 입력값 = 0 이면 -0출력, 입력값 > 0 이면 1 출력

## 날짜 함수
- SYSDATE: 현재 날짜 및 시간을 반환
- Date + Number -> Date
- Date - Number -> Date
- Date - Date -> Number of days

### 날짜 함수 - MONTH_BETWEEN
MONTH_BETWEEN(날짜1, 날짜2) 함수는 날짜1과 날짜2 사이의 개월수 출력

```sql
SELECT months_between(sysdate, hiredate),
months_between('84/01/01', '88/11/05')
FROM professor
WHERE months_between(sysdate, hiredate) > 200;
```

![](./img/S_6.png)

### 날짜 함수 – ADD_MONTHS
ADD_MONTH(날짜, 숫자) 함수는 날짜의 달에 숫자만큼 더한 값 출력

### 날짜 함수 - NEXT_DAY
NEXT_DAY(날짜 ,문자)함수는 입력 받은 날짜를 기준으로 문자만큼 지난 날짜를 출력

(일요일=1, 월요일=2, 화요일=3, 수요일=4, 목요일=5, 금요일=6, 토요일=7)

```sql
SELECT hiredate, next_day(hiredate,'금요일'),
next_day(hiredate,6)
FROM professor
WHERE deptno=10 or deptno = 40;
```

![](./img/S_7.png)

### 날짜 함수 - LAST_DAY
LAST_DAY(날짜) 함수는 입력 받은 날짜가 포함된 달의 마지막 날짜 출력

```sql
SELECT hiredate, next_day(hiredate,'금요일'),
next_day(hiredate,6)
FROM professor
WHERE deptno=10 or deptno = 40;
```

![](./img/S_8.png)

### 기타 함수 - TO_CHAR
TO_CHAR(날짜, '문자')함수는 입력 받은 날짜를 입력한 문자형으로 변환하여 출력

```sql
SELECT to_char(sysdate, 'DAY, DDTH MONTH YYYY')
FROM sys.dual;
```

![](./img/S_9.png)

### 기타 함수 - TO_DATE
TO_DATE(문자열, 포맷) 함수는 문자열을 포맷에 따라 해석하여 날짜를 반환

```sql
SELECT pid, pname, hiredate
FROM professor
WHERE hiredate = to_date('2002-06-11', 'yyyy-mm-dd');
```

![](./img/S_10.png)

### 기타 함수 – DECODE
DECODE(필드, 조건1, 조건1의참, 조건2, 조건2의 참, ..., 거짓) 함수는 필드에서 조건의 참, 거짓에 따라 출력

```sql
SELECT sname, deptno, decode(deptno, 10, 'CE',
20, 'ME', 'NOT Eng') DECODED_DEPT
FROM student;
```

![](./img/S_11.png)