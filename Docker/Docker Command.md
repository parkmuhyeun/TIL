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
