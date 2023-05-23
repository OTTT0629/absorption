<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!doctype html>
<html lang="ko">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>community_main</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-aFq/bzH65dt+w6FI2ooMVUpc+21e0SRygnTpmBvdBgSdnuTN7QbdgL+OapgHtvPp" crossorigin="anonymous">
    <link rel="stylesheet" href="${path}/resources/css/community/freecommunity/community_main.css" >
    <script type="text/javascript" src="${path}/resources/js/community/main.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/js/bootstrap.bundle.min.js" integrity="sha384-qKXV1j0HvMUeCBQ+QVp7JcfGl760yU08IQ+GpUo5hlbpg51QRiuqHAJz8+BrxE/N" crossorigin="anonymous"></script>
  </head>
  <body style="background-color: #202020;">
    <div class="wrap">
      <header>
        <div class="logo">
          <a href="<c:url value="/" />">
            <img src="${path}/resources/images/logo/OTTT.png" alt="로고">
          </a>
        </div>
        <nav class="gnb">
          <ul>
            <li>
              <a href="<c:url value="/genre/movie" />">영화</a>
            </li>
            <li>
              <a href="<c:url value="/genre/drama" />">드라마</a>
            </li>
            <li>
              <a href="<c:url value="/genre/interest" />">예능</a>
            </li>
            <li>
              <a href="<c:url value="/genre/animation" />">애니</a>
            </li>
            <li>
              <a href="<c:url value="/community" />" style="color: #33ff33;">게시판</a>
            </li>
          </ul>
        </nav>
        <div class="h-icon">
          <ul>
            <li>
              <a href="<c:url value='/search' />">
                <!-- <img src="./images/icon/search02.png" alt="검색"> -->
              </a>
            </li>
            <li>
              <a href="<c:url value='/mypage' />">
                <!-- <img src="./images/icon/user01.png" alt="내 정보"> -->
              </a>
            </li>
          </ul>
        </div>
      </header>

      <!--meun bar Start-->  
        <div id="line-1" >
          <nav class="nav">
          <a class="nav-link1" href="<c:url value='/community' />" style="color: #33ff33;">자유게시판</a>
          <a class="nav-link1" href="<c:url value='/community/endmovie/tving' />">종료예정작</a>
          <a class="nav-link1" href="<c:url value='/community/priceInfoTving' />">가격정보</a>
          <a class="nav-link1" href="<c:url value='/community/QnA' />">Q&A</a>
          <a class="nav-link1" href="<c:url value='/community/notice' />">공지사항</a>
        </nav>
        </div>
        <div id="line-2">
          <div class="Lcontent">
            <form name="post_search" action="" method="get">
              <input class="search" type="search" placeholder=" &nbsp;Search">
              <input class="searchicon" type="image" src="${path}/resources/images/icon/search.png" alt="돋보기">
            </form>
            <ul class="movepage">
              <li style="display: flex;">
                <div class="list-group">
                    <a href="<c:url value='/mycommynity/postcommu' />" class="list-group-item list-group-item-action">
                      <img class="side_img" src="${path}/resources/images/img/KakaoTalk_20230411_161709664.png" alt="post">내가 쓴 게시글
                    </a>
                </div>
              </li>
              <li style="display: flex;">
                  <div class="list-group">
                      <a href="<c:url value='/mycommynity/likecommunity' />" class="list-group-item list-group-item-action">
                        <img class="side_img" src="${path}/resources/images/img/free-icon-heart-6063477 2.png" alt="heart">좋아요 누른 게시글
                      </a>
                  </div>
              </li>
              <li style="display: flex;">
                  <div class="list-group">
                      <a href="<c:url value='/mycommynity/comment' />" class="list-group-item list-group-item-action">
                        <img class="side_img" src="${path}/resources/images/img/comment.png" >댓글 작성 게시물
                      </a>
                  </div>
              </li>
              <li style="display: flex;">
                  <div class="list-group">
                      <a href="#" class="list-group-item list-group-item-action" style="margin-top: 2vw; height: 35vh;">광고</a>
                    </div>
              </li>
          </div>

<!--ㅡmain------------------------------------------>
          <div class="Rcontent" >
            <div>
              <form name="post_write" action="community_main.html" method="get">
                <ul class="post_write">
                  <li>
                    <img src="${path}/resources/images/icon/user01.png" alt="프로필사진">
                  </li>
                  <li>
                      <textarea class="writeHere" placeholder="Write Here" onkeydown="resize(this)" onkeyup="resize(this)" ></textarea>
                  </li>
                  <li class="btn_s">
                      <label for="btn_file" ><img src="${path}/resources/images/img/writeImg.png" class="img_file"></label>
                      <input id="btn_file" type="file" accept="image/gif, image/jpeg, image/png" multiple/>                      
                      <input class="btn_commit" type="image" src="${path}/resources/images/img/commit.png" alt="commit">
                  </li>
                </ul>
              </form>
            </div>
            <div class="post_list">
              <ul class="post" >
                <div class="post_info">
                  <div style="display: flex;">
                  	<a href="#"><img class="usur_img" src="${path}/resources/images/icon/user01.png" alt="profile"></a>
                  	<a href="#"><span class="nickname">Nickname</span></a>
                  	<span id="current_date" >작성한 날짜</span>
                  </div>            
                  <div>
                   <div>
                    <button type="button" class="btn_warning" data-bs-toggle="dropdown" >
                      신고
                    </button>
                    <ul class="dropdown-menu" >
                      <li><a class="dropdown-item" href="#">욕설/비방</a></li>
                      <li><a class="dropdown-item" href="#">광고/도배</a></li>
                      <li><a class="dropdown-item" href="#">악의적인 스포</a></li>
                      <li><a class="dropdown-item" href="#">선정성</a></li>
                    </ul>                   
                   </div>
                  </div>  
                </div>                
                <div style="width: 900px;">
                  <a href="<c:url value='/community/post' />" class="main_article">내가 작성한 댓글이 올라감</a>
                </div>
                <div>
                <div>
                  <input class="heart_img" type="image" src="${path}/resources/images/img/free-icon-heart-6063477 2.png" alt="heart">
                  <span>5</span> 
                  <input class="re_comment_img" type="image" src="${path}/resources/images/img/comment.png" alt="comment">
                  <span>10</span>                  
                </div>
                </div>
              </ul>            
              <ul class="post" >
                <div class="post_info">
                  <div style="display: flex;">
                  	<a href="#"><img class="usur_img" src="${path}/resources/images/icon/user01.png" alt="profile"></a>
                  	<a href="#"><span class="nickname">Nickname</span></a>
                  	<span id="current_date" >작성한 날짜</span>
                  </div>            
                  <div>
                   <div>
                    <button type="button" class="btn_warning" data-bs-toggle="dropdown" >
                      신고
                    </button>
                    <ul class="dropdown-menu" >
                      <li><a class="dropdown-item" href="#">욕설/비방</a></li>
                      <li><a class="dropdown-item" href="#">광고/도배</a></li>
                      <li><a class="dropdown-item" href="#">악의적인 스포</a></li>
                      <li><a class="dropdown-item" href="#">선정성</a></li>
                    </ul>                   
                   </div>
                  </div>  
                </div>                
                <div style="width: 900px;">
                  <a href="#" class="main_article">내가 작성한 댓글이 올라감</a>
                </div>
                <div>
                <div>
                  <input class="heart_img" type="image" src="${path}/resources/images/img/free-icon-heart-6063477 2.png" alt="heart">
                  <span>5</span> 
                  <input class="re_comment_img" type="image" src="${path}/resources/images/img/comment.png" alt="comment">
                  <span>10</span>                  
                </div>
                </div>
              </ul>
              <ul class="post" >
                <div class="post_info">
                  <div style="display: flex;">
                  	<a href="#"><img class="usur_img" src="${path}/resources/images/icon/user01.png" alt="profile"></a>
                  	<a href="#"><span class="nickname">Nickname</span></a>
                  	<span id="current_date" >작성한 날짜</span>
                  </div>            
                  <div>
                   <div>
                    <button type="button" class="btn_warning" data-bs-toggle="dropdown" >
                      신고
                    </button>
                    <ul class="dropdown-menu" >
                      <li><a class="dropdown-item" href="#">욕설/비방</a></li>
                      <li><a class="dropdown-item" href="#">광고/도배</a></li>
                      <li><a class="dropdown-item" href="#">악의적인 스포</a></li>
                      <li><a class="dropdown-item" href="#">선정성</a></li>
                    </ul>                   
                   </div>
                  </div>  
                </div>                
                <div style="width: 900px;">
                  <a href="#" class="main_article">내가 작성한 댓글이 올라감</a>
                </div>
                <div>
                <div>
                  <input class="heart_img" type="image" src="${path}/resources/images/img/free-icon-heart-6063477 2.png" alt="heart">
                  <span>5</span> 
                  <input class="re_comment_img" type="image" src="${path}/resources/images/img/comment.png" alt="comment">
                  <span>10</span>                  
                </div>
                </div>
              </ul>
            </div>
          </div>
        </div>
    </div>
  </body>
</html>