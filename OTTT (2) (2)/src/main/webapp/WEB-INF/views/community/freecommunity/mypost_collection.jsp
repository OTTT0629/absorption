<%@page import="com.ottt.ottt.dto.UserDTO"%>
<%@page import="com.ottt.ottt.dto.ArticleDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="loginout" value="${sessionScope.id == null ? 'logout' : 'login'}" />
<c:set var="loginoutlink" value="${sessionScope.id==null ? '/login' : '/mypage'}" />
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!doctype html>
<html lang="ko">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>mypost_collection</title>
    
    <style type="text/css">
    	.notcollection{
    		font-size: 27px;
    		text-align: center;
    	}
    </style>

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

      <!--meun bar Start-->  
        <div id="line-1" >
          <nav class="nav">
          <a class="nav-link1" href="<c:url value='/community' />">자유게시판</a>
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
              <input class="searchicon" type="image" src="${path}/resources/images/icon/search02.png" alt="돋보기">
            </form>
            <ul class="movepage">
              <li style="display: flex;">
                <div class="list-group">
                    <a href="<c:url value='/mycommynity/postcommu' />" class="list-group-item list-group-item-action" style="color: #33ff33;">
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
                      <a href="<c:url value='/mycommynity/comment' />" class="list-group-item list-group-item-action" >
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
<!---------------------------ㅡmain------------------------------------------>
          <div class="Rcontent" >
            <div>
  			   <input type="hidden" name="user_no" value="${articleDTO.user_no}"> 
  				<form:form modelAttribute="ArticleDTO" method="get">
  					<c:if test="${articleList.size() == null || articleList.size() == 0 }">
              			<div class="notcollection">게시물이 없습니다</div>  
              		</c:if>
              		<c:if test="${articleList.size() != null || articleList.size() == 0 }">
		              <c:forEach var="articleDTO" items="${articleList }">
			             <ul class="post" >
			                <div class="post_info">
			                  <div style="display: flex;">
			                  	<a href="#"><img class="usur_img" src="${path}/resources/images/icon/user01.png" alt="profile"></a>
			                  	<a href="#"><span class="nickname">${articleDTO.user_nicknm }</span></a>
			                  	<span id="current_date" ><fmt:formatDate value="${articleDTO.article_create_dt}" pattern="yyyy-MM-dd" type="date"/></span>
			                  </div>
			                    <div>
			                      <div class="modi-del">
			                        <!-- Button trigger modal -->
			                      <button type="button" class="btn btn-secondary" data-bs-toggle="modal" data-bs-target="#exampleModal">
			                        수정
			                      </button>
			                        <!-- Modal -->
			                      <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
			                        <div class="modal-dialog modal-dialog-centered">
			                          <div class="modal-content">
			                            <div class="modal-header">
			                              <h1 class="modal-title fs-5" id="exampleModalLabel">알림</h1>
			                              <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
			                            </div>
			                            <div class="modal-body">
			                              수정하시겠습니까?
			                            </div>
			                            <div class="modal-footer">
			                              <button type="button" class="btn btn-primary">Yes</button>
			                              <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">No</button>
			                            </div>
			                          </div>
			                        </div>
			                      </div>
			                      <!-- Button trigger modal -->
			                      <button type="button" class="btn btn-secondary" data-bs-toggle="modal" data-bs-target="#exampleModa2">
			                        삭제
			                      </button>
			                      <!-- Modal -->
			                      <div class="modal fade" id="exampleModa2" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
			                        <div class="modal-dialog modal-dialog-centered">
			                          <div class="modal-content">
			                            <div class="modal-header">
			                              <h1 class="modal-title fs-5" id="exampleModalLabe2">알림</h1>
			                              <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
			                            </div>
			                            <div class="modal-body">
			                              삭제하시겠습니까?
			                            </div>
			                            <div class="modal-footer">
			                              <button type="button" class="btn btn-primary">Yes</button>
			                              <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">No</button>
			                            </div>
			                          </div>
			                        </div>
			                      </div>
			                    </div>
			                    </div> 
			                </div>                
			                <li style="width: 900px;">
			                  <a href="#" class="main_article">${articleDTO.article_content}</a>
			                </li>
			                <li>
			                <div>
			                  <input class="heart_img" type="image" src="${path}/resources/images/img/free-icon-heart-6063477 2.png" alt="heart">
			                  <span>5</span> 
			                  <input class="re_comment_img" type="image" src="${path}/resources/images/img/comment.png" alt="comment">
			                  <span>10</span>                  
			                </div>
			                </li>
			              </ul>
		              </c:forEach>
		            </c:if>
  				</form:form>
  			</div>
          </div>
        </div>
    </div>
  </body>
</html>