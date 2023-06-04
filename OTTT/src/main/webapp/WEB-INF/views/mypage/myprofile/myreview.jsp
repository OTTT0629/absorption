<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">
<head>
  	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>나의 리뷰</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-aFq/bzH65dt+w6FI2ooMVUpc+21e0SRygnTpmBvdBgSdnuTN7QbdgL+OapgHtvPp" crossorigin="anonymous">
    <link rel="stylesheet" href="${path}/resources/css/mypage/myreview.css" >
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/js/bootstrap.bundle.min.js" integrity="sha384-qKXV1j0HvMUeCBQ+QVp7JcfGl760yU08IQ+GpUo5hlbpg51QRiuqHAJz8+BrxE/N" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
</head>
<body>
	<div class="wrap">
		<%@ include file="../../fix/header.jsp" %>

		<section class="sec01">
			<nav class="mnb">
				<ul>
					<li>
						<a href="<c:url value="/mypage/myreview" />" class="mreview">기록</a>
					</li>
					<li>
					    <a href="<c:url value="/mypage/wishlist" />">찜목록</a>
					</li>
					<li>
					    <a href="<c:url value="/mypage/watched" />">봤어요</a>
					</li>
					<li>
					  	<a href="<c:url value="/mypage/alarm" />">알림함</a>
					</li>
					<li>
					  	<a href="<c:url value="/mypage/message" />">쪽지함</a>
					</li>
				</ul>
			</nav>
		</section>

		<section class="sec02">
			<div class="Lcontent">
				<div class="Lmenu">
					<ul>
      					<li id="Ldiary">
      						<img class="mimg" src="${path}/resources/images/img/free-icon-diary-6393039.png" alt="다이어리">
      						<a href="<c:url value="/mypage/mydiary" />">나만의 다이어리</a>
   						</li>
   						<li id="Lreview">
		                	<img class="mimg" src="${path}/resources/images/img/free-icon-review-3501894.png" alt="리뷰">
		                	<a href="<c:url value="/mypage/myreview" />">나의 리뷰</a>
		              	</li>
		              	<li id="Lwrite">
		                	<img class="mimg" src="${path}/resources/images/img/KakaoTalk_20230411_161709664.png" alt="게시글">
		                	<a href="<c:url value="/mycommynity/postcommu" />">내가 쓴 게시글</a>
		              	</li>
		              	<li id="Llike">
			                <img class="mimg" src="${path}/resources/images/img/free-icon-heart-6063477 2.png" alt="좋아요">
			                <a href="<c:url value="/mycommynity/likecommunity" />">좋아요 누른 게시글</a>
			            </li>
		    	        <li id="Lcomments">
		                	<img class="mimg" src="${path}/resources/images/img/comment.png" alt="댓글">
		                	<a href="<c:url value="/mycommynity/comment" />">나의 댓글</a>
		              	</li>
	              	</ul>
				</div>
			</div>
		
			<div class="main">
				<div class="blank"></div>
				
				<c:forEach var="ReviewDTO" items="${list }" >
				
					<a href="<c:url value="/mypage/myreview${pr.sc.queryString}&review_no=${ReviewDTO.review_no }"/>" class="review">
						<div class="post">					  	
						    <div class="Lside">
						      	<img class="poster" src="${ReviewDTO.thumbnail}">
						    </div>
						    <div class="Rside">
						    	<div class="rv-head">
						    		<span class="title">${ReviewDTO.content_nm}</span>
						    		<div class="starating">
						    			<img class="star" src="./images/icon/point.png">
						        		<span>${ReviewDTO.rating}</span>						    		
						    		</div>
						      	</div>
						
								<div class="rv-main">
								  <span>${ReviewDTO.review_content}</span>
								</div>
						    </div>
					  	</div>
				  	</a>			  	
			  	</c:forEach>
			  	
			  	<div class=paging-container>
		    		<div class="paging">
		    			<c:if test="${myReviewCnt == null || myReviewCnt == 0 }">
		    				<div>게시글이 없습니다.</div>
		    			</c:if>
		    			
		    			<c:if test="${myReviewCnt != null || myReviewCnt != 0 }">
		    				<c:if test="${pr.showPrev }">
		    					<a class="page" href="<c:url value="/mypage/myreview${pr.sc.getMyReviewString(pr.beginPage-1) }" />">&lt;</a>
		    				</c:if>
		    				<c:forEach var="i" begin="${pr.beginPage }" end="${pr.endPage }">
		    					<a class="page" href="<c:url value="/mypage/myreview${pr.sc.getMyReviewString(i) }" />">${i }</a>
		    				</c:forEach>
		    				<c:if test="${pr.showNext }">
		    					<a class="page" href="<c:url value="/mypage/myreview${pr.sc.getMyReviewString(pr.endPage+1) }" />" >&gt;</a>
		    				</c:if>	    				
		    			</c:if>
		    		</div>	    	
	    		</div>	    	
			
			</div>
		</section>
	</div>

</body>
</html>