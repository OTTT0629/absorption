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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-aFq/bzH65dt+w6FI2ooMVUpc+21e0SRygnTpmBvdBgSdnuTN7QbdgL+OapgHtvPp" crossorigin="anonymous">
    <link rel="stylesheet" href="${path}/resources/css/mypage/profile.css" >
    <script src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/js/bootstrap.bundle.min.js" integrity="sha384-qKXV1j0HvMUeCBQ+QVp7JcfGl760yU08IQ+GpUo5hlbpg51QRiuqHAJz8+BrxE/N" crossorigin="anonymous"></script>
  </head>
  <body style="background-color: #202020;">
  <script type="text/javascript">
  	$(document).ready(function() {
		$("#item-msg").click(function() {			
			var userno = $("input[name='userno']").val()
		    var url = "/messagewindow/open?user_no=" + encodeURIComponent(userno)
		    window.open(url, 'SEND-MSG', 'width=520, height=750, scrollbars=no')
		})
	})
  
  </script>
     
    <div class="wrap">
    	
    	<%@ include file="../../fix/header.jsp" %>
    	
    	<%@ include file="../../fix/sec02.jsp" %>
          
	    <%@ include file="../../fix/mnb2.jsp" %>

      <section class="sec02">
        <div class="mymenu">
          <div class="mycontent">
            <ul>
              <li class="mydiary">
                <img class="mimg" src="${path}/resources/images/img/free-icon-diary-6393039.png" alt="다이어리">
               <a href="<c:url value="/mypage/mydiary?user=${userDTO.user_nicknm }" />">나만의 다이어리</a>
              </li>
              <li class="myrivew">
                <img class="mimg" src="${path}/resources/images/img/free-icon-review-3501894.png" alt="리뷰">
                <a href="<c:url value="/mypage/myreview?user=${userDTO.user_nicknm }" />">나의 리뷰</a>
              </li>
            </ul>
          </div>
        
          <div class="mypost">
            <ul>
              <li class="mywrite">
                <img class="mimg" src="${path}/resources/images/img/KakaoTalk_20230411_161709664.png" alt="게시글">
                <a href="<c:url value="/community/freecommunity?user=${userDTO.user_nicknm }&category=myPost" />">내가 쓴 게시글</a>
                </li>
              <li class="mylike">
                <img class="mimg" src="${path}/resources/images/img/heart_on.png" alt="좋아요">
                <a href="<c:url value="/community/freecommunity?user=${userDTO.user_nicknm }&category=myLike" />">좋아요 누른 게시글</a>  
              </li>
              <li class="mycomment">
                <img class="mimg" src="https://myottt.s3.ap-northeast-2.amazonaws.com/img/%EB%8C%93%EA%B8%80.png" alt="댓글">
                <a href="<c:url value="/community/freecommunity?user=${userDTO.user_nicknm }&category=myComment" />">나의 댓글</a>
              </li>
            </ul>
          </div>
        </div>    
      </section>
	</div>
	
  </body>
</html>