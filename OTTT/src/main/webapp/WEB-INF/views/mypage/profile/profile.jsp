<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!doctype html>
<html lang="ko">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>프로필</title>
    <script src="https://code.jquery.com/jquery-1.11.3.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-aFq/bzH65dt+w6FI2ooMVUpc+21e0SRygnTpmBvdBgSdnuTN7QbdgL+OapgHtvPp" crossorigin="anonymous">
    <link rel="stylesheet" href="${path}/resources/css/mypage/mypageshow.css" >
    <script src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/js/bootstrap.bundle.min.js" integrity="sha384-qKXV1j0HvMUeCBQ+QVp7JcfGl760yU08IQ+GpUo5hlbpg51QRiuqHAJz8+BrxE/N" crossorigin="anonymous"></script>
  </head>
  <body style="background-color: #202020;">
  <script type="text/javascript">
  	$(document).ready(function() {
		$("#item-msg").click(function() {			
			var userno = $("input[name='userno']").val()
		    var url = "/ottt/messagewindow/open?user_no=" + encodeURIComponent(userno)
		    window.open(url, 'SEND-MSG', 'width=520, height=750, scrollbars=no')
		})
	})
  
  </script>
     
    <div class="wrap">
    	<%@ include file="../../fix/header.jsp" %>

      <section class="sec01">      
        <div class="mypage-info">
        <input name="userno" type="hidden" value="${userDTO.user_no }" />
          <div class="porfile">
            <img  src="${userDTO.image }" >
          </div>
        <div class="user">
            <ul>
              <li class="user-name">
                <span>${userDTO.user_nicknm }</span>
              </li>
              <li class="user-follow">
                <span onclick="location.href='<c:url value="/mypage/follower" />'">팔로워</span>
                <span>|</span>
                <span onclick="location.href='<c:url value="/mypage/following" />'">팔로잉</span>
              </li>
            </ul>
        </div>
        <div class="btn_more_div" >
            <button type="button" style="background-color:transparent;" class="btn_more" data-bs-toggle="dropdown" aria-expanded="false">
                <img src="${path}/resources/images/img/more.png" style="width: 40px;" alt="more">
            </button>
            <ul class="dropdown-menu">
              <li class="dropdown-item" id="item-msg">쪽지 보내기</li>
              <li class="dropdown-item">신고하기</li>
                <ul>
                  <li class="report"><button class="report">욕설/비방</button></li>
                  <li class="report"><button class="report">광고/도배</button></li>
                  <li class="report"><button class="report">악의적인 스포</button></li>
                  <li class="report"><button class="report">선정성</button></li>
                </ul>
              <li><a class="dropdown-item" href="#">차단</a></li>
            </ul>
        </div>
        <div class="btn_check_div" style="margin-top: 20px;">
          <input type="checkbox" class="btn-check" id="btn-check-outlined" autocomplete="off" checked>
          <label class="btn btn-outline-primary" for="btn-check-outlined">팔로우 취소</label><br>
        </div>
        </div>
      </section>
          
      <nav class="mnb2">
        <ul>
          <li><a style="color: #33ff33" href="<c:url value="/mypage/myreview" />">기록</a></li>
          <li><a href="<c:url value="/mypage/wishlist" />">찜목록</a></li>
          <li><a href=<c:url value="/mypage/watched" />">봤어요</a></li>
        </ul>
      </nav>



      <section class="sec02">
        <div class="mymenu">
          <div class="mycontent">
            <ul>
              <li class="mydiary">
                <img class="mimg" src="${path}/resources/images/img/free-icon-diary-6393039.png" alt="다이어리">
               <a href="<c:url value="/mypage/mydiary" />">나만의 다이어리</a>
              </li>
              <li class="myrivew">
                <img class="mimg" src="${path}/resources/images/img/free-icon-review-3501894.png" alt="리뷰">
                <a href="<c:url value="/mypage/myreview" />">나의 리뷰</a>
              </li>
            </ul>
          </div>
        
          <div class="mypost">
            <ul>
              <li class="mywrite">
                <img class="mimg" src="${path}/resources/images/img/KakaoTalk_20230411_161709664.png" alt="게시글">
                <a href="<c:url value="/mycommynity/postcommu" />">내가 쓴 게시글</a>
                </li>
              <li class="mylike">
                <img class="mimg" src="${path}/resources/images/img/heart_on.png" alt="좋아요">
                <a href="<c:url value="/mycommynity/likecommunity" />">좋아요 누른 게시글</a>  
              </li>
              <li class="mycomment">
                <img class="mimg" src="${path}/resources/images/img/댓글.png" alt="댓글">
                <a href="<c:url value="/mycommynity/comment" />">나의 댓글</a>
              </li>
            </ul>
          </div>
        </div>    
      </section>

	</div>
  </body>
</html>