# :blue_book: book review 프로젝트
책 검색과 소개, 독자들의 리뷰 등을 제공하는 book review 웹 애플리케이션 구현 프로젝트

<br/>

### :pushpin: 프로젝트의 최종 목표
___
* 밑바닥부터 기능을 추가해나가며, 최종적으로는 대규모 트래픽을 처리할 수 있도록 설계 및 구현하기

<br/>

### :pushpin: 프로젝트에서 중점이 되는 요소
___
* 기능 구현에 초점을 맞추자 !
  * 여러 기술 스택을 사용해 보고 각 기술이 동작하는 원리를 습득하여 전반적인 아키텍처를 설계
  * 비즈니스 로직들은 실제로 제공되는 서비스들과 최대한 유사하게 구현

<br/>

### :paperclip: 사용한 주요 기술 스택
___
#### Front-end
* Vue 2.6.14
#### Back-end
* Spring Boot 2.7.2
* MySQL
* Spring Data JPA 2.7.2
* Spring Security 5.7.2
* Redis

<br/>

### :bookmark: 현재까지의 진행 과정
___
#### 0. 공통
* Unit Test 작성
#### 1. Spring Boot
* 각 controller를 RESTful한 API로 매핑
    * Front-End와 Back-End 서버를 분리하여 구현
#### 2. Spring Data JPA
* DB 테이블 구조가 1:1, 1:N, N:M의 연관관계를 모두 포함하도록 설계 (ERD 작성)
* 네이버 책 검색 API를 사용하여 책 정보를 받아오고, 받아온 정보는 DB에 저장하는 방식으로 구현 (책의 카테고리 값은 네이버 API에서 제공하지 않아 크롤링 하는 것으로 대체)
* JPA 성능 개선을 위해, fetch join을 통한 조회 및 default_batch_fetch_size 설정
#### 3. Spring Security
* AuthenticationFilter, AuthenticationProvider 등을 custom 하여 인증 로직 구현
* JWT 기반 사용자 인증 구현
#### 4. Redis
* Access Token이 갱신될 때, 해당 Refresh Token 또한 갱신되도록 구현

<br/>

### 기타
___
#### 개인적으로 궁금하거나 진행하면서 요구되는 개념들은 블로그에 작성하였습니다.
https://velog.io/@platinouss