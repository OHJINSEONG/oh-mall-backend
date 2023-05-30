# OhMall-backend

## 프로젝트 소개
OhMall은 개인 프랜차이징 쇼핑몰 프로젝트 입니다.

### 배포 URL

- [https://oh-mall.shop:8000](https://oh-mall.shop:8000)

<br>

## 기술 스택
### Backend
<img width="50px" src="https://img.shields.io/badge/java-007396?style=for-the-badge&logo=java&logoColor=white"></a>
<img src="https://img.shields.io/badge/spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white">

### Database
<img src="https://img.shields.io/badge/PostgreSQL-4169E1?style=for-the-badge&logo=postgreSQL&logoColor=white"/>
<br>

## 백엔드 프로젝트 문제 해결

<br>

### Jmeter와 로컬 캐싱을 사용한 조회 성능 개선

구현 이슈

- 변경이 자주 발생되지 않는 리소스의 조회 요청 성능을 개선하기 위해 로컬 캐시 적용

해결

- Jmeter를 이용해 부하테스트 작성 → 상품리소스에 대한 **10만번의 http GET요청**을 발생시키는 부하 발생
- EhCache를 이용해 **로컬캐시를 적용**하여 수업 조회 평균 속도 **4000% 향상(555ms → 14ms)**

<img style="width:400px" src="https://github.com/OHJINSEONG/oh-mall-backend/assets/107606892/86cbe8c6-b7b3-4f89-a215-2269356845ab">

캐시 적용전

<img style="width:400px" src="https://github.com/OHJINSEONG/oh-mall-backend/assets/107606892/eedbd25d-5de3-42ec-adcb-1fc55afca2fc">

캐시 적용후

<br>

### 도메인 레이어 TDD 적용

- JUnit과 Mockito를 이용한 독립적인 테스트 코드로 비즈니스 로직의 무결성 검증
- 테스트 코드를 먼저 작성해 사용자 관점에서 코드를 작성할 수 있어 간결한 인터페이스를 갖게 됨.

구현 이슈

- 프로젝트 초기 애플리케이션 레이어에서 테스트 작성에서 모킹하는데 비용이 너무 많이 생김

해결

- 애플리케이션 레이어에서 비즈니스 로직이 흩어진채로 존재하는 것을 확인
- 애플리케이션 레이어의 **비즈니스 로직을 도메인 객체 내부로 전달**

<br>



### 값객체를 이용한 예외처리

- 엔티티내의 필드중에서 연관된 것을 찾아 값객체로 분리.
- 값객체 내부에서 스스로 상태에 대한 비즈니스 로직을 관리함.

구현 이슈

- 프로젝트 초기 엔티티에서 각각의 필드의 예외처리를 책임지게 되어 엔티티의 역할이 비대해짐.

해결

- 필드 내에서 값객체를 발견 → 별도의 클래스로 분리
- **값객체 내부**에서 예외처리 로직을 작성하고 테스트하여 **책임을 분리**

<br>



### Backdoor API를 이용한 데이터 시딩작업 자동화

- jdbcTemplate을 이용하여 인수테스트의 명세에 적힌 데이터 세팅 자동화

구현 이슈

- 인수테스트의 유저스토리 별로 필요한 데이터가 상충함.
- 기존의 수작업으로 POST요청을 보내 데이터 세팅시 시간이 너무 오래걸림

해결

- JdbcTemplate을 이용해 유저스토리별로 필요한 데이터 시딩 모듈화
- 데이터 시딩 작업 효율 2000% 증가 (기존 20분 → 1분)

<br>



## DevOps

### 목적에 맞는 호스팅 서버 사용

- 단일 서버 프로젝트를 호스팅하는데 적합하고 Docker를 이용하여 직접 구축할수 있는 AWS EC2 사용

<br>



### Https 적용

- Http프로토콜을 이용한 데이터 전달은 보안에 취약하다는 단점이 있기 때문에 lets'encrypt에서 ssl 인증서와 개인키를 발급받아 Https 적용

<br>



### CI/CD 파이프라인 구현

- 작은 기능 단위 커밋을 지향하고 있기 때문에 테스트 비용을 줄이기 위하여 테스트 자동화 파이프라인을 구축

