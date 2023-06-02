<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>  
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>공지사항</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-aFq/bzH65dt+w6FI2ooMVUpc+21e0SRygnTpmBvdBgSdnuTN7QbdgL+OapgHtvPp" crossorigin="anonymous">
    <link rel="stylesheet" href="${path}/resources/css/community/notice/notice.css" >
    <script type="text/javascript" src="${path}/resources/js/community/main.js"></script>
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

        <div id="line-1" >
          <nav class="nav">
          <a class="nav-link1" href="<c:url value='/community' />">자유게시판</a>
          <a class="nav-link1" href="<c:url value='/community/endmovie/tving' />">종료예정작</a>
          <a class="nav-link1" href="<c:url value='/community/priceInfoTving' />">가격정보</a>
          <a class="nav-link1" href="<c:url value='/community/QnA' />">Q&A</a>
          <a class="nav-link1" href="<c:url value='/community/notice' />" style="color: #33ff33;">공지사항</a>
        </nav>
        </div>



        <!--글작성 관련 시작-->
      <div class="qa-main">
        <!-- 검색 배너-->
        <div class="search-var">
          <span>제목+내용</span>
          <input  type="text" class="search-input"/>
          <button type="button" class="btn btn-outline-success">검색</button>
        </div>
    
        <!-- 글목록 배너-->
        <div class="title-region">
          <div class="title-mainline">
            <span style="position: absolute; left: 120px;">번호</span>
            <span style="position: absolute; left: 450px;">제목</span>
            <span style="position: absolute; left: 900px;">날짜</span>
          </div>

          <div class="title-line">
            <span style="position: absolute; left: 140px;">1</span>
            <span style="position: absolute; left: 300px;"><a href="../QnA, notice/noticeboard.html">공지사항 제목</a></span>
            <span style="position: absolute; left: 875px;">2023-04-04</span>
          </div>
          <div class="title-line">
            <span style="position: absolute; left: 140px;">2</span>
            <span style="position: absolute; left: 300px;"><a href="../QnA, notice/noticeboard.html">공지사항 제목</a></span>
            <span style="position: absolute; left: 875px;">2023-04-04</span>
          </div>
          <div class="title-line">
            <span style="position: absolute; left: 140px;">3</span>
            <span style="position: absolute; left: 300px;"><a href="../QnA, notice/noticeboard.html">공지사항 제목</a></span>
            <span style="position: absolute; left: 875px;">2023-04-04</span>
          </div>
          <div class="title-line">
            <span style="position: absolute; left: 140px;">4</span>
            <span style="position: absolute; left: 300px;"><a href="../QnA, notice/noticeboard.html">공지사항 제목</a></span>
            <span style="position: absolute; left: 875px;">2023-04-04</span>
          </div>
          <div class="title-line">
            <span style="position: absolute; left: 140px;">5</span>
            <span style="position: absolute; left: 300px;"><a href="../QnA, notice/noticeboard.html">공지사항 제목</a></span>
            <span style="position: absolute; left: 875px;">2023-04-04</span>
          </div>
          <div class="title-line">
            <span style="position: absolute; left: 140px;">6</span>
            <span style="position: absolute; left: 300px;"><a href="../QnA, notice/noticeboard.html">공지사항 제목</a></span>
            <span style="position: absolute; left: 875px;">2023-04-04</span>
          </div>
        </div>
    
        <!-- 페이지 번호 배너-->
        <div class="page-num">
          <nav aria-label="Page navigation example" class="d-flex flex-row justify-content-center">
            <ul class="pagination">
              <li class="page-item">
                <a class="page-link" href="#" aria-label="Previous">
                  <span aria-hidden="true">&laquo;</span>
                </a>
              </li>
              <li class="page-item"><a class="page-link" href="#">1</a></li>
              <li class="page-item"><a class="page-link" href="#">2</a></li>
              <li class="page-item"><a class="page-link" href="#">3</a></li>
              <li class="page-item">
                <a class="page-link" href="#" aria-label="Next">
                  <span aria-hidden="true">&raquo;</span>
                </a>
              </li>
            </ul>
          </nav>
        </div>
      </div>
    </div>
  </body>
</html>