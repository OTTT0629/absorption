<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!doctype html>
<html lang="ko">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>쪽지알림</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-aFq/bzH65dt+w6FI2ooMVUpc+21e0SRygnTpmBvdBgSdnuTN7QbdgL+OapgHtvPp" crossorigin="anonymous">
    <link rel="stylesheet" href="${path}/resources/css/mypage/message.css" >
    <script src="${path}/resources/js/mypage/script.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/js/bootstrap.bundle.min.js" integrity="sha384-qKXV1j0HvMUeCBQ+QVp7JcfGl760yU08IQ+GpUo5hlbpg51QRiuqHAJz8+BrxE/N" crossorigin="anonymous"></script>
  </head>

  <body style="background-color: #202020;">
     
    <div class="wrap">
      <header >
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
              <a href="<c:url value="/community" />">게시판</a>
            </li>
          </ul>
        </nav>
        <div class="h-icon">
          <ul>
            <li>
              <a href="<c:url value='/search' />">
              </a>
            </li>
            <li>
              <a href="<c:url value='/mypage' />">
              </a>
            </li>
          </ul>
        </div>
      </header>

      <nav class="mnb">
        <ul>
          <li><a href="<c:url value="/mypage/myreview" />" class="mreview">기록</a></li>
          <li><a href="<c:url value="/mypage/wishlist" />">찜목록</a></li>
          <li><a href="<c:url value="/mypage/watched" />">봤어요</a></li>
          <li><a href="<c:url value="/mypage/alarm" />">알림함</a></li>
          <li><a href="<c:url value="/mypage/message" />" style="color: #33ff33">쪽지함</a></li>
        </ul>
      </nav>

      <section class="sec01">      
        <div class="mypage-info">
          <div class="set">
            <a href="<c:url value="/mypage/messagesetting" />"><img class="set-img" src="${path}/resources/images/img/톱니.png" alt="img-set"></a>
          </div>
        </div>
      </section>

      <section class="sec02">
        <span class="alarm-1-1"><img class="profile" src="${path}/resources/images/img/이브이.png" alt="profile" /></span>
        <div class="push-alarm">

        <div class="modi-del">
          <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#content01">
            이브이 님이 메세지를 보냈습니다.
          </button>
          <div class="modal fade" id="content01" tabindex="-1" aria-labelledby="content01Label" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered">
              <div class="modal-content">
                <div class="modal-header">
                  <h1 class="modal-title fs-5" id="content01Label"><img src="${path}/resources/images/img/이브이.png">이브이</h1>
                  <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                  안녕하세요? 저는 이브이 입니다.<br /> 
                  쪽지 드려봐요.<br />
                  앞으로 잘 부탁드려요.<br />
                  안녕하세요? 저는 파이리또가스 입니다. 쪽지 드려봐요. 앞으로 잘 부탁드려요.
                </div>
                <div class="modal-footer">
                  <button type="button" class="btn btn-primary">삭제</button>
                  <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">답장</button>
                </div>
              </div>
            </div>
          </div>
        </div>
        </div>
        <div class="send-msg">
        
        <input type="button" onclick="open()">
        
            <img src="${path}/resources/images/img/send.png" alt="send">
        </div>
        <button type="button" class="btn-delete">
       		<img src="${path}/resources/images/img/delete-normal.png" alt="delete">
        </button>
      </section>

      

      </div>
  </body>
</html>