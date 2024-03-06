<p align="middle" >
  <img width="200px;" src="https://github.com/hyeokson/Shoe-We-Walk/assets/127181634/4c30b48e-30af-466a-b159-f118c89930b8"/>
</p>

<h1 align="middle">Shoe We Walk</h1>
<h3 align="middle">걷기 운동 서비스 App</h3>
<br/>

## 🙋‍♂️ Developer  
|                                          Frontend                                           |                                         Frontend                                          |                                         Backend                                          |             
| :----------------------------------------------------------------------------------------: | :--------------------------------------------------------------------------------------: | :--------------------------------------------------------------------------------------
|  |  |  | 
|                            [심준보](https://github.com/Vecto-Konkuk)                            |                           [박지원](https://github.com/parkji1on)                           |                          [손찬혁](https://github.com/hyeokson)                          |

개발 기간: 2023.03 ~ 2023.06

## 📝 프로젝트 소개

Shoe We Walk(이하 SWW)는 걷기운동으로 재화획득을 획득하여 신발 꾸미기로 사용자의 걷기운동 참여를 독려하는 애플리케이션입니다.   
기존의 걷기운동을 통해 재화를 획득하는 애플리케이션의 경우에는 캐시워크와 같은 애플리케이션이 이미 존재하지만 캐시워크에서는 실제 현금처럼 사용할 수 있는 재화를 사용자에게 주고, 광고를 통한 수익을 목적으로 하고 있습니다.  
그래서 사용자에게 운동에 대한 많은 기능을 제공해주지 않으며, 수익성도 낮기 때문에 지속적인 걷기운동을 독려하기 힘들다는 단점이 존재합니다.  
이러한 문제점을 해결하고 사용자의 걷기 운동을 독려하기 위해 SWW에서는 가상의 재화와 가상의 신발, 신발 장식을 통해 사용자의 지속적인 참여를 독려하고자 합니다.

</br>

**<기대 효과>**  
1) 꾸준한 걷기 운동 독려  
나만의 신발을 꾸밀 수 있는 장식 아이템을 구매하려면 걷기 운동을 열심히 해야 하므로 꾸준한 걷기 운동을 장려할 수 있습니다.
또한, 단순히 기기의 흔들림을 감지하여 운동 여부를 측정하는 것뿐만 아니라 GPS를 통해서 실제 운동 거리도 측정합니다.  
따라서 걷기 운동을 하지 않고서는 재화를 획득할 수 없습니다.  

3) 사용자에게 정확한 운동정보를 제공  
GPS를 통해 유저의 운동경로를 지도상에 표시하여 운동 경로를 확인할 수 있고, 이를 통해 사용자가 이동한 거리와 걸음수를 계산하여 보다 정확한 운동정보를 제공할 수 있습니다.  

<br/>



## 🔧 Stack

**Deploy**  

<img src="https://img.shields.io/badge/Amazon EC2-FF9900?style=for-the-badge&logo=Amazon EC2&logoColor=white"/> <img src="https://img.shields.io/badge/Amazon rds-527FFF?style=for-the-badge&logo=Amazon rds&logoColor=white"/>

**Frontend(Web)**
- **Language**
  
  <img src="https://img.shields.io/badge/Kotlin-7F52FF?style=for-the-badge&logo=Kotlin&logoColor=white"/>
  
- **Library & Framework**

  <img src="https://img.shields.io/badge/android studio-3DDC84?style=for-the-badge&logo=android studio&logoColor=white"/>
  
<br />

**Backend**
- **Language**

  <img src="https://img.shields.io/badge/java-FF4C46?style=for-the-badge&logo=java&logoColor=white"/>
  
- **Library & Framework**

  <img src="https://img.shields.io/badge/spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white"/>
  
- **Database**

  <img src="https://img.shields.io/badge/mysql-4479A1?style=for-the-badge&logo=mysql&logoColor=white"/> 

<br/>

## 🔨 프로젝트 구조도

<img width="600px;" src="https://github.com/hyeokson/Shoe-We-Walk/assets/127181634/69bb6587-004e-4f47-8c65-7ead65bd05ca"/>  


<br/>

## ⭐ UI 및 주요 기능

- **메인 화면**
  
  메인 화면인 탐색 화면에서 검색어를 통해 원하는 장소나 키워드에 해당하는 게시글을 확인 할 수 있습니다.
  
  <img width="600px;" src="https://github.com/Vecto-Konkuk/spring-backend/assets/127181634/26156908-e82a-4a84-82e4-bc3bcdc5eea8"/>

- **게시글 상세 화면**

  게시글을 선택하면 게시글 상세 페이지로 이동할 수 있습니다.  
  데이트 코스와 이미지 및 상세정보를 확인할 수 있고, 좋아요와 댓글을 통해 소통할 수 있습니다.
  
  <img width="600px;" src="https://github.com/Vecto-Konkuk/spring-backend/assets/127181634/9e8aedcd-735d-416f-a873-a54789e6b8e1"/>
  <img width="600px;" src="https://github.com/Vecto-Konkuk/spring-backend/assets/127181634/15e8f2c8-08ac-43e9-8739-df305777fde5"/>

- **게시글 작성 화면**

  바텀 네비게이션의 글쓰기 아이콘 선택을 통해 게시글 작성 화면으로 이동할 수 있습니다.  
  데이트 경로, 사진, 제목, 글을 작성하여 등록하면 게시글 작성이 완료됩니다.  
  
  <img width="600px;" src="https://github.com/Vecto-Konkuk/spring-backend/assets/127181634/ffbcf421-3092-4bc5-ae18-35dd96405ffc"/>

- **권한 설정 화면**

  바텀 네비게이션의 위치 수집항목 아이콘 선택을 통해 권한 설정 화면으로 이동할 수 있습니다.  
  사용자 권한 설정이 처음이라면 가이드 화면을 따라가면서 권한 설정을 할 수 있습니다.  

  <img width="600px;" src="https://github.com/Vecto-Konkuk/spring-backend/assets/127181634/9496cf29-3d61-4df1-aff2-aac5377f3083"/>

- **경로 수집 화면**

  권한 설정이 모두 완료되면 GPS를 통해 유저의 이동 경로 및 방문지 정보를 수집할 수 있습니다.

  <img width="600px;" src="https://github.com/Vecto-Konkuk/spring-backend/assets/127181634/651d3647-e1b3-4939-a4e4-b1f0dcc77979"/>

- **경로 수정 화면**

  바텀 네비게이션의 경로 수정 아이콘 선택을 통해 경로 수정 화면으로 이동할 수 있습니다.  
  처음에 나오는 달력을 통해 방문지가 저장된 날짜를 확인할 수 있고, 해당 날짜를 선택하여 이동경로 및 방문지를 수정할 수 있습니다.  
  방문지를 선택하면 방문지 이름 수정, 방문지 삭제, 주변 방문지 검색 기능을 사용할 수 있습니다.  
  이동 경로를 선택하면 화면 하단에서 방문지들을 순서대로 확인할 수 있고, 추천 경로 설정 기능을 통해 이동 경로를 바꿀 수 있습니다.  

  <img width="600px;" src="https://github.com/Vecto-Konkuk/spring-backend/assets/127181634/f4cb2759-1f8b-4eec-a246-fbaa6c5d3a14"/>  
  <img width="600px;" src="https://github.com/Vecto-Konkuk/spring-backend/assets/127181634/67bea202-bfaf-4f2c-bb58-82353389f27a"/>  
  <img width="600px;" src="https://github.com/Vecto-Konkuk/spring-backend/assets/127181634/aa1ca2c5-1441-4833-af1a-b3467294bda6"/>  

- **마이페이지 화면**

  바텀 네비게이션의 마이페이지 아이콘 선택을 통해 마이페이지로 이동할 수 있습니다.  
  
  <img width="600px;" src="https://github.com/Vecto-Konkuk/spring-backend/assets/127181634/eeabf54b-025e-45a4-af5e-03174c42df9c"/>

- **로그인 및 회원가입 화면**

  VECTO 전용 계정 또는 카카오 계정으로 로그인할 수 있습니다.  
  VECTO 전용 계정으로 로그인하려면 회원가입을 진행해야 합니다.

  <img width="600px;" src="https://github.com/Vecto-Konkuk/spring-backend/assets/127181634/04d217da-31ef-4cea-96bb-ccba186715ae"/>  
  <img width="600px;" src="https://github.com/Vecto-Konkuk/spring-backend/assets/127181634/56d6647a-da92-4258-b93c-080fc3bc83cf"/>

- **알림 화면**

  다른 유저가 자신의 게시글에 댓글을 달거나 팔로우를 할 경우, 알림을 확인할 수 있습니다.

  <img width="600px;" src="https://github.com/Vecto-Konkuk/spring-backend/assets/127181634/4845b861-2278-4c8e-a7a6-6fc14beb1964"/>

- **댓글 화면**

  게시글에 댓글을 작성할 수 있고, 댓글에 좋아요를 누를 수 있습니다.

  <img width="600px;" src="https://github.com/Vecto-Konkuk/spring-backend/assets/127181634/a8dfb449-1f87-4aa7-8b7c-9815a45d152f"/>

- **유저 프로필 화면**  

  해당 화면에서 유저를 팔로우할 수 있고 유저의 상세 정보들을 확인할 수 있습니다.
  유저의 부적절한 행동을 발견할 경우, 해당 유저를 신고할 수도 있습니다.

  <img width="600px;" src="https://github.com/Vecto-Konkuk/spring-backend/assets/127181634/ca9eb3a9-c9e3-4888-8e88-ff0349605198"/>  
  <img width="600px;" src="https://github.com/Vecto-Konkuk/spring-backend/assets/127181634/3b84173f-f85c-4146-ae17-9e93d57eab74"/>  

</br>

## 💻 Server
- **[Server API(Swagger)](https://vec-to.net/swagger-ui/index.html)**
  
- **로그인 및 인증 기능**  
  애플리케이션을 위한 Restful API 서버를 개발해야하기 때문에 세션, 쿠키가 필요없는 JWT 인증방식을 사용했습니다.  
  그리고 인증 방식을 쉽고 안전하게 구현하기 위해서 Spring Security를 사용하여 인증체계를 구축했습니다.  
  Username and Password Authentication Mechanism 을 사용하지 않으므로 JwtAuthenticationFilter를 따로 만들어서 JWT를 인증할 수 있도록 개발했습니다.  
  로그인을 하게 되면 프론트에 JWT를 반환하고 그 후의 request에서 header에 JWT를 넣으면 서버의 여러 기능들을 사용할 수 있습니다.  

- **게시글 및 댓글 기능**  
  FeedController를 통해서 게시글과 댓글의 CRUD 기능을 구현했습니다.  
  애플리케이션의 게시글 탐색 화면에서 게시글을 조회할 때는 Paging을 사용하여 DB에서 정보를 가져왔고, 로그인 상태와 비로그인 상태를 구별해서 게시글 정보를 반환하도록 구현했습니다.  
  로그인 상태에서는 팔로우를 한 유저의 게시글을 조회하고 나서 팔로우를 하지 않은 유저의 게시글을 조회할 수 있습니다.  
  비로그인 상태에서는 처음부터 팔로우 여부와 관계없이 시간 순서대로 게시글을 조회할 수 있습니다.  

- **팔로우 및 좋아요 기능**  
  각각 FollowController, LikesController, CommentLikesController가 CRUD를 담당합니다.  
  팔로우 및 게시글 좋아요 기능을 사용하게 되면 해당 유저에게 푸쉬알림이 가도록 구현했습니다.  
  푸쉬알림은 Firebase의 Cloud Messaging 기능을 사용해서 팔로우 및 좋아요 기능을 사용한 직후에 바로 유저의 앱에 알림이 뜨게 됩니다.  

- **이미지 저장 기능**  
  ImageController에서 게시글 사진과 프로필 사진 저장 및 조회 기능을 담당합니다.  
  이미지 파일은 용량이 크기 때문에 Amazon S3를 활용하여 이미지를 저장하고, 해당 이미지 URL을 프론트에 보내주게 됩니다.  
  
</br>

## 💾 ERD  

- **유저 정보 테이블을 중심으로 한 ERD**
  
<img width="600px;" src="https://github.com/hyeokson/spring-backend/assets/127181634/4d5c36f3-19c6-4526-874c-941c3b704ea7"/>

- **팔로우 테이블 ERD**

  <img width="600px;" src="https://github.com/hyeokson/spring-backend/assets/127181634/5ff787c2-880e-484d-ad5a-625b969c105a"/>

- **게시글 테이블을 중심으로 한 ERD**
  
  <img width="600px;" src="https://github.com/hyeokson/spring-backend/assets/127181634/0364f80c-299f-4d84-ae3a-cd1c455693b9"/>
  <img width="600px;" src="https://github.com/hyeokson/spring-backend/assets/127181634/c4dafeb5-9a3b-4ffc-866a-1ad79ed9eb5b"/>
  <img width="600px;" src="https://github.com/hyeokson/spring-backend/assets/127181634/537b1476-81d6-4e19-89b5-b6da0df35544"/>
  <img width="400px;" src="https://github.com/hyeokson/spring-backend/assets/127181634/826bc286-0ca6-4ec3-b1e1-ed15b4ef9ff3"/>
