# 고급 SQL
#데이터 베이스/고급 SQL

---
##  Large-Object Types
사진이나 동영상 등의 대용량 데이터를 저장
- CLOB(Character Large-Object)
    - Single-byte나 multibyte의 문자 데이터를 저장
- BLOB(Binary Large-Object)
    - Unstructured binary large object를 저장

Oracle의 LOB 구현 정책
- LOB column을 생성할 때 "enable storage in row" option을 선택하면 최대 4000byte 까지는 다른 필드와 함께 저장
    - 4000byte 이상의 값들은 항상 외부에 저장
- Select 문을 이용하여 LOB column을 액세스할 경우, LOB locator가 return

## 무결성 조건(Integrity Constraints)

### 개체 무결성
기본 키에는 Null이나 중복된 값이 저장될 수 없다.

### 도메인 무결성
- 릴레이션의 애트리뷰트가 가질수 있는 값을 제한
- SQL에서 CHECK 문에 의해 표현

![](./img/고S_1.png)

### Enable/Disable Constraint
기존에 선언된 제약 조건을 활성화/비활성화
- Alter Table Student Disable Constraint ST_Sname
- Alter Table Student Enable Constraint ST_Sname

### 참조 무결성
- 릴레이션 S에 대한 릴레이션 R의 외래키 K
- K는 S에서 반드시 존재하며, 하나의 값만 존재

```sql
CREATE TABLE STUDENT (
SID Number(4) NOT NULL PRIMARY_KEY,
DeptNo Number(2) REFERENCES Department(DeptNo)
ON DELETE CASCADE,      /*department 삭제시 student도 삭제*/
Advisor Number(3) REFERENCES Professor(PID)
CONSTRAINT Emp_Advisor
);

/*REFERENCES Department(DeptNo)
ON DELETE SET NULL 도가능 -> Department삭제시 student set null*/
```

## Embedded SQL
- C, C++, JAVA 등의 언어로 작성한 프로그램에 포함된 SQL
- SQL을 포함하고 있는 프로그래밍 언어: Host language

### Oracle Pro*C를 이용한 Embedded SQL의 예

변수 선언
```c
/*선언절(DECLARE SECTION)*/
EXEC SQL BEGIN DECLARE SECTION
int st_id; /* student id */
char name[11]; /* student name */
int dno; /* department number */
EXEC SQL END DECLARE SECTION
````

CURSOR를 이용한 Query
```c
EXEC SQL DECLARE C1 CURSOR FOR
select sid, sname
from student
where deptno = :dno;
EXEC SQL OPEN C1;
EXEC SQL WHENEVER NOT FOUND STOP;
for (; ;) {
EXEC SQL FETCH C1 INTO :st_id, :name;
printf("%d \t %s \n", st_id, name)
}
EXEC SQL CLOSE C1;
```

Data Manipulation
```c
scanf("%d", &st_id);
gets(name);

EXEC SQL UPDATE student
SET sname = :name
WHERE sid = :st_id;

printf("Student %d updated. \n", st_id); /* sqlca.sqlcode */

EXEC SQL COMMIT WORK RELEASE;
```

## Dynamic SQL
- Run-time에 SQL을 구성하고 질의를 요청하는 API로 구성
    - Embedded SQL: SQL 질의가 컴파일 시점에 완성
        - SQL이 수정되면 전체 프로그램을 다시 컴파일
    - Dynamic SQL: Run-time에 SQL 질의를 생성 가능

- Dynamic SQL을 이용하는 응용 프로그램의 구성
    - DB server에 연결
    - DB server에 SQL command 전송
    - DB server와의 연결 종료

- 대표적인 두가지
    - ODBC(Open Database Connectivity)
        - C, C++, C# 등
    - JDBC(Java Database Connectivity)

## JDBC
DBMS와의 통신을 위한 Java API

### JDBC 연결
- 1단계: JDBC 드라이버 로딩
```java
Class.forName("oracle.jdbc.driver.OracleDriver");
```

- 2단계: 데이터베이스 연결
```java
Connection conn = DriverManager.getConnection
("jdbc:oracle:thin:@dbserver.yu.ac.kr:1521:XE", "scott", "tiger");
```

### JDBC에서 Statement 생성
- Statement stmt = conn.createStatement();
    - 두가지 method:
        - executeQuery() : SELECT문을 수행할 때 사용한다.(ResultSet을 반환)
        - executeUpdate(): DML 문을 수행할 때 사용한다.(처리된 데이터의 수를 반환)
- PreparedStatement query = conn.prepareStatement("select sid, sname, deptno from student where deptno = ?");
    - SQL에 필요한 변수 데이터를 "?"로 표시하고 메서드를 통해 설정하는 방식