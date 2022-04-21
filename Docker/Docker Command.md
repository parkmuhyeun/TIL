# Docker Command
#Docker/Docker Command

---
## 컨테이너 보기
docker ps

## 실행
docker run container_id = docker create + docker start container_id

## 중지 
- docker stop container_id: 하던 것 까진 다하게해주고 중지
- docker kill container_id: 그냥 바로 중지

## 삭제
docker rm container_id (중지하고 삭제해야됨)

## 모든 컨테이너를 삭제하고 싶다면 ?
docker rm `docker ps -a -q`

## 이미지를 삭제하고 싶다면?
docker rmi image_id

## 한번에 컨테이너, 이미지, 네트워크 모두 삭제하고 싶다면?
docker system prune
- 하지만 이것도 실행중인 컨테이너에는 영향을 주지 않음

## 이미 실행중인 컨테이너에 명령어를 전달하고 싶다면?
- docker exec image_id
- ex) docker exec image_id ls
- docker exec -it 컨테이너 아이디 명령어
- it를 붙여줘야 명령어를 실행하고 계속사용가능

## 컨테이너를 쉘 환경으로 접근해보기
- docker exec(run) -it 컨테이너 아이디 sh
- 터미널 환경에서 나올려면 ctrl + d

## 도커 이미지 직접 생성
Dockerfile 작성 -> 도커 클라이언트 -> 도커 서버 -> 이미지 생성

*Dockerfile: Docker Image를 만들기 위한 설정 파일, 컨테이너가 어떻게 행동해야 하는지에 대한 설정들을 정의해줌

## 도커 파일 만드는 순서(도커 이미지가 필요한 것이 무엇인지 생각)
1. 베이스 이미지 명시
2. 추가적으로 필요한 파일을 다운 받기 위한 명령어를 명시
3. 컨테이너 시작시 실행 될 명령어를 명시해준다.

```Dockerfile
# 베이스 이미지를 명시
FROM baseImage

# 추가적으로 필요한 파일들을 다운로드
RUN commnad

# 컨테이너 시작 시 실행 될 명령어를 명시
CMD ["executable"]
```
- FROM: 이미지 생성시 기반이 되는 이미지 레이어
    - <이미지 이름>:<태그> 형식으로 작성
    - 태그를 안붙이면 자동적으로 가장 최신것으로 다운
    - ex) ubuntu:14.04
- RUN: 도커이미지가 생성되기 전에 수행할 쉘 명령어
- CMD: 컨테이너가 시작되었을 때 실행할 실행 파일 또는 쉘 스크립트, 해당 명령어는 DockerFile내 1회만 사용 가능

## 이미지 생성 
- docker build ./ 
- docker build .
- Build 명령어는
    - 해당 디렉토리 내에서 dockerfile이라는 파일을 찾아서 도커 클라이언트에 전달시켜준다
    - docker build 뒤 ./ 와 .는 현재 디렉토리를 가르킨다

## build 과정
이미지 -> 임시 컨테이너(새로운 명령어, 새로운 파일 스냅샷 추가) -> 새로운 이미지

## 도커 이미지에 이름 주는 방법
- 원래 build docker build ./ 
- 이름 주는 build docker build -t 이름 .
    - (이름: 나의 도커 아이디/저장소, 프로젝트 이름 : 버전)
    - ex) pjhg410/hello:latest

## 생성한 이미지로 어플리케이션 실행 시 접근이 안되는 이유
- 포트 매핑을 시켜줘야됨
- docker run -p localhost port : container port 이미지 이름
- ex) docker run -p 8080:8080 이미지 이름

## working 디렉토리 생성 이유
1. 원래 이미지에 있던 파일과 copy하는 파일중 같은 이름이 있으면 덮여쓰여짐.
2. 깔금하게 정리 


## 재빌드 효율적으로 하기 
```docker
COPY ./ ./

RUN npm install
```
소스만 변경했을 때 -> 재빌드를 효율적으로 하기위해 개선(캐시 사용)
```docker
COPY package.json ./

RUN npm install

COPY ./ ./
```

## Docker Volume
로컬에 있는걸 계속 참조
- docker run -p 5050:8080 -v /usr/src/app/node_modules -v $(pwd):/usr/src/app 이미지 아이디
- 맥: $(pwd)
- 윈도우: %cd%

또는 docker compose에서 volume 작성
```docker-compose
version: "3"
services:
  react:
    build:
      context: .
      dockerfile: Dockerfile.dev
    ports:
      - "3000:3000"
    volumes:
      - /usr/src/app/node_modules
      - ./:/usr/src/app
    stdin_open: true
```

## 임의의 이름을 가진 도커파일 빌드
docker build -f Dockerfile.dev ./

## 도커를 이용한 리액트 앱 테스트 하기
docker run -it pjhg410/docker-react-app npm run test

---
## Docker Compsose
```docker compose
version: '3'            # 도커 컴포즈의 버전
services:               # 이곳에 실행하려는 컨테이너들
  redis-server:         # 컨테이너 이름
    image: "redis"      # 컨테이너에서 사용하는 이미지
  node-app:             # 컨테이너 이름
    build: .            # 현 디렉토리에 있는 Dockerfile
    ports:              # 포트맵핑 로컬포트 : 컨테이너 포트
     - "5000:8080" 
```
- compose 실행: docker-compose up (백그라운드 실행 docker-compose up -d)
- docker-compose up 이미지가 없을 때 이미지를 빌드하고 컨테이너 시작
- docker-compose up --build 이미지가 있든 없든 이미지를 빌드하고 컨테이너 시작
- docker compose 로 컨테이너 멈추기: docker compose down

---
## Nginx로 운영환경 도커 이미지 생성
1. 빌드 단계
2. 실행 단계

```dockerfile
# 1. build
FROM node:alpine as builder
WORKDIR /usr/src/app
COPY package.json ./
RUN npm install
COPY ./ ./
CMD ["npm", "run", "build"]

# 2. run
FROM nginx
COPY --from=builder /usr/src/app/build /usr/share/nginx/html
```

- docker run -p 8080:80 이미지 이름 (Nginx의 기본 사용포트는 8080)


---
## travis.yml (테스트) (CI/CD)

```js
sudo: required // 관리자 권한갖기

language: generic //언어(플랫폼)을 선택

services:
  - docker  // 도커 환경 구성

before_install:   //스크립트를 실행할 수 있는 환경 구성
  - echo "start Creating an image with dockerfile"
  - docker build -t dockerimage_name -f Dockerfile.dev .

script:   // 실행할 스크립트(테스트 실행)
  - docker run -e CI=true dockerimage_name npm run test -- --coverage

after_succes:  // 테스트 성공 후 할일
  - echo "Test Success"
```