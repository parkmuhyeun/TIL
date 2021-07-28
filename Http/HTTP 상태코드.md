# HTTP 상태코드
#TIL/HTTP

---
## 상태코드
클라이언트가 보낸 요청의 처리상태를 응답에서 알려주는 기능

- 1xx (Informational): 요청이 수신되어 처리중
- 2xx (Succeful): 요청 정상 처리
- 3xx (Redirection): 요청을 완료하려면 추가 행동이 필요
- 4xx (Client Error): 클라이언트 오류
- 5xx (Server Error): 서버 오류

### 2xx (Succesful)
클라이언트의 요청을 성공적으로 처리
- 200 OK ( 요청 성공)
- 201 Created ( 요청 성공해서 새로운 리소스가 생성됨)
- 202 Accepted (요청이 접수 되었으나 처리가 완료되지 않았음)
- 204 No Content ( 서버가 요청을 성공적으로 수행했지만, 보낼 데이터가 없음)

### 3xx (Redirection)
요청을 완료하기 위해 추가 조치 필요

- 300 Multiple Choices
- 301 Moved Permanently
- 302 Found
- 303 See other
- 304 Not Modified
- 307 Temporary Redirect
- 308 Permanent Redirect

#### 리다이렉션의 이해

웹 브라우저는 3xx 응답의 결과에 Location 헤더가 있으면 Location 위치로 자동 이동

영구 다이렉션( 301, 308 )

- 리소스의 URI가 영구적으로 이동
- 301 Moved Permanently
    - 리다이렉트시 요청 메서드가 GET으로 변하고, 본문이 제거될 수 있음(MAY)
- 308 Permanent Redirect
    - 리다이렉트시 요청 메서드와 본문 유지(처음 POST를 보내면 리다이렉트도 POST 유지)

일시적 리다이렉션( 302, 307, 303)
- 리소스의 URI가 일시적으로 변경
- 302 FOUND
    - 리다이렉트시 요청 메서드가 GET으로 변하고, 본문이 제거될 수 있음(MAY)
- 307 Temporary Redirect
    - 리다이렉트시 요청 메서드와 본문 유지(MUST NOT)
- 303 See Other
    - 리다이렉트시 요청 메서드가 GET으로 변경

304 Not Modified

캐시를 목적으로 사용( 캐시 리다이렉트)

### 4xx(Client Error)
클라이언트 오류

- 오류의 원인이 클라이언트에 있음
- 재시도 해도 실패

400 BadRequest
- 요청 구문, 메시지 등등 오류

401 Unauthorized
- 인증 되지 않음

403 Forbidden
- 인증 자격 증명은 있지만, 접근 권한이 불충분한 경우

404 Not Found
- 요청 리소스가 서버에 없음

### 5xx(Server Error)
서버 오류

- 서버 문제로 오류 발생
- 재시도 하면 성공 할수도 있음(복구되거나 등등)

500 Internal Server Error
- 서버 내부 문제로 오류
- 애매하면 500 오류

503 Service Unavailable
- 서비스 이용 불가
- 얼마뒤에 복구되는지 보낼 수도 있음