![image](https://github.com/hyeokson/Shoe-We-Walk/assets/127181634/6d89eddc-f3bb-495d-9baf-1cc1e647abc8)<p align="middle" >
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
  
  메인 화면인 탐색 화면에서 유저의 신발 및 신발 장식, 운동 시작 버튼을 확인할 수 있습니다.
  
  <img width="600px;" src="https://github.com/hyeokson/Shoe-We-Walk/assets/127181634/f52de668-4696-401c-b107-1ea212edc7b1"/>


- **로그인 및 회원가입 화면**

  카카오 로그인 버튼을 누르면 카카오 계정과 연동하여 로그인이 완료됩니다.
  회원가입을 하지 않았다면 회원가입 화면으로 이동하고 기본 정보를 입력하여 회원가입을 진행합니다.
  
  <img width="600px;" src="https://github.com/hyeokson/Shoe-We-Walk/assets/127181634/53799c56-10f7-4307-a269-d9ba5b18be51"/>
  <img width="600px;" src="https://github.com/hyeokson/Shoe-We-Walk/assets/127181634/3783abea-b62a-4c4f-b79e-f061ff4cf800"/>


- **신발 꾸미기 화면**

  사용 가능한 신발 장식과 이미 신발에 부착된 신발 장식 정보를 확인할 수 있습니다.
  신발 장식을 터치하면 원하는 위치에 장식을 부착하거나 해체할 수 있습니다. 
  
  <img width="600px;" src="https://github.com/hyeokson/Shoe-We-Walk/assets/127181634/5060798b-0c87-4400-9fd6-aa66c9f323a2"/>  
  <img width="600px;" src="https://github.com/hyeokson/Shoe-We-Walk/assets/127181634/fb875f80-cb51-4520-8f43-7f5f5f961dfb"/>  
  <img width="600px;" src="https://github.com/hyeokson/Shoe-We-Walk/assets/127181634/9b97468e-3454-4907-a027-d12d7d951435"/>  
 


- **권한 설정 화면**

  바텀 네비게이션의 위치 수집항목 아이콘 선택을 통해 권한 설정 화면으로 이동할 수 있습니다.  
  사용자 권한 설정이 처음이라면 가이드 화면을 따라가면서 권한 설정을 할 수 있습니다.  

  <img width="600px;" src="https://github.com/Vecto-Konkuk/spring-backend/assets/127181634/9496cf29-3d61-4df1-aff2-aac5377f3083"/>

- **경로 수집 화면**

  권한 설정이 모두 완료되면 GPS를 통해 유저의 이동 경로 및 방문지 정보를 수집할 수 있습니다.

  <img width="600px;" src="https://github.com/Vecto-Konkuk/spring-backend/assets/127181634/651d3647-e1b3-4939-a4e4-b1f0dcc77979"/>

- **상점 화면**

  상점에서 구매 가능한 신발 장식을 확인할 수 있고, 신상품 및 모든 상품 카테고리로 나누어져 있습니다.

  <img width="600px;" src="https://github.com/hyeokson/Shoe-We-Walk/assets/127181634/d5e55e61-3f36-40e0-bcae-d5a70acea632"/>  
  <img width="600px;" src="https://github.com/hyeokson/Shoe-We-Walk/assets/127181634/2ea7e572-b204-466b-9a35-a17863278c84"/>  


- **프로필 화면**

  프로필 화면에서는 사용자의 기본 정보와 누적 운동 그래프를 확인할 수 있습니다.
  
  <img width="600px;" src="https://github.com/hyeokson/Shoe-We-Walk/assets/127181634/56e75dc4-163d-44ab-899f-ba07740a2ddf"/>  


- **운동 측정 화면**

  메인 화면에서 "START" 버튼을 누르면 GPS와 지도를 통해 운동을 측정합니다.
  유저는 지도를 통해 사용자의 실시간 위치 정보와 걸음수, 이동 경로를 확인할 수 있습니다.
  운동 종료 버튼을 누르면 운동 시간, 운동 거리, 소모된 칼로리, 획득한 재화 정보를 확인할 수 있고 저장 버튼을 누르면 운동 기록이 저장됩니다.

  <img width="600px;" src="https://github.com/hyeokson/Shoe-We-Walk/assets/127181634/9fd73d62-ccee-42f0-9738-1e77070fd56b"/>  
  <img width="600px;" src="https://github.com/hyeokson/Shoe-We-Walk/assets/127181634/d7a004e8-a874-4ba1-90f4-c652068e7816"/>


</br>

## 💻 Server
  
- **로그인 및 회원가입**  
  애플리케이션을 위한 Restful API 서버를 개발해야하기 때문에 세션, 쿠키가 필요없는 JWT 인증방식을 사용했습니다.  
  그리고 인증 방식을 쉽고 안전하게 구현하기 위해서 Spring Security를 사용하여 인증체계를 구축했습니다.  
  Username and Password Authentication Mechanism 을 사용하지 않으므로 JwtAuthenticationFilter를 따로 만들어서 JWT를 인증할 수 있도록 개발했습니다.  
  로그인을 하게 되면 프론트에 JWT를 반환하고 그 후의 request에서 header에 JWT를 넣으면 서버의 여러 기능들을 사용할 수 있습니다.  

- **유저 정보 기능**  
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

- **유저 정보, 신발 장식, 운동 기록 테이블 ERD**
  
<img width="600px;" src="https://github.com/hyeokson/Shoe-We-Walk/assets/127181634/02e38aaa-d190-4ef3-b960-2105a53cac2c"/>  

유저 테이블(user_table)에는 이름, 성별, 나이, 키, 몸무게, 소유한 총 신발 장식 개수, 잔고 데이터가 있습니다.  
운동 기록 테이블(work_table)에는 운동을 시작한 날짜, 총 걸음 수, 총 이동 거리, 소모한 칼로리 데이터가 있습니다.  
신발 장식 테이블(item_table)에는 신발 장식 Id, 소유한 신발 장식 수, 가격 데이터가 있습니다.  

유저 테이블과 나머지 두 테이블은 각각 1:N 관계에 있고, 운동을 한 적이 없다면 work_table에 데이터가 없을 수 있습니다.



- **신발 장식 위치 ERD**

  <img width="600px;" src="https://github.com/hyeokson/Shoe-We-Walk/assets/127181634/fc71934b-c58e-410e-bdf5-06d59cc1f456"/>

  신발 장식 위치 테이블(itemloc_table)은 유저가 소유한 신발의 10개의 구멍에 어떤 신발 장식이 들어가 있는지를 관리합니다.
  각각의 구멍에 해당하는 신발 장식의 item_id를 저장합니다.

  각 유저마다 신발을 소유하고 있으므로 두 테이블은 1:1 관계에 있습니다. 
