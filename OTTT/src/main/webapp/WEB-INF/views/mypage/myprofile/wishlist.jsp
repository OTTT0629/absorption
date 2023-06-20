<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>찜목록</title>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous"/>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.1/font/bootstrap-icons.css">
    <link rel="stylesheet" href="${path}/resources/css/mypage/wishlist.css" >

</head>
<body>
	<div class="wrap">
		<%@ include file="../../fix/header.jsp" %>
	
		<section class="sec01">
			<nav class="mnb">
				<ul>
					<li><a href="<c:url value="/mypage/myreview" />" class="mreview">기록</a></li>
					<li><a href="<c:url value="/mypage/wishlist" />" style="color: #33ff33">찜목록</a></li>
					<li><a href="<c:url value="/mypage/watched" />">봤어요</a></li>
					<li><a href="<c:url value="/mypage/alarm" />">알림함</a></li>
					<li><a href="<c:url value="/mypage/message" />">쪽지함</a>
				</ul>
			</nav>
		</section>
		
		<section class="sec02">
			<div class="Lcontent">
				<div class="Lmenu">
					<ul>
						<li>
							<img class="mimg" src="${path}/resources/images/img/movie.png" alt="영화">
							<a href="./watched-1movie.html">영화</a>
						</li>
						<li>
							<img class="mimg" src="${path}/resources/images/img/drama.png" alt="드라마">
							<a href="./watched-1drama.html">드라마</a>
	                	</li>
	                	<li>
	                  		<img class="mimg" src="${path}/resources/images/img/vrt.png" alt="예능">
	                  		<a href="./watched-1vrt.html">예능</a>
	               		</li>
		                <li>
		                	<img class="mimg" src="${path}/resources/images/img/free-icon-anime-2314736.png" alt="애니">
	                		<a href="./watched-1ani.html">애니</a>
	               		</li>
	           		</ul>
	      		</div>
	   		</div>
	
	        <div class="main">
	        	<section class="sec_2">
	        		<div class="btn_more_div" style="text-align: right; margin-top: 20px; ">
	        			<button type="button" class="btn_more" data-bs-toggle="dropdown" aria-expanded="false" style="background-color: black; color: #fff; width: 50px;">
	        			정렬
	        			</button>
		       			<ul class="dropdown-menu dropdown-menu-dark">
		       				<li><a class="dropdown-item" href="#">최신순</a></li>
		       				<li><a class="dropdown-item" href="#">별점순</a></li>
		   				</ul>
	 				</div>
				</section>
				
				<div class="main-work">				
		            	
	           		<div class="work-info">
	           			<a href="<c:url value="/detailPage" />">
	           				<img src="${path}/resources/images/poster/subu.jpg" class="poster"/>
	                       </a>
	                       <div style="text-align: right; border: #fff;">
	                       	<input type="checkbox" class="btn-check" id="btncheck1" autocomplete="off" checked>
	                           <label class="btn btn-outline-primary" for="btncheck1"><i class="bi bi-bookmark-fill"></i></label>
	                           <div class="title" style="text-align: center; font-size: 13px;"> 서부 전선 이상 없다</div>
	                           <div class="review"><img src="${path}/resources/images/img/별1.PNG" class="review-star" alt="star"> 5.0</div>
						</div>
					</div>
					

				</div>
				
				<div class=paging-container>
		    		<div class="paging">
		    			<c:if test="${myDiaryCnt == null || myDiaryCnt == 0 }">		    			
		    				<div class="title-line" style="text-align: center;">
		    					내가 쓴 다이어리가 없습니다.
		    				</div>
		    			</c:if>
		    			
		    			<c:if test="${myDiaryCnt != null || myDiaryCnt != 0 }">
			    			<!-- 페이지 번호 배너-->
					        <div class="page-num" style="margin-top: 10px;">
					        	<nav aria-label="Page navigation example" class="d-flex flex-row justify-content-center">
					          	<ul class="pagination">				          		
						            <c:if test="${pr.showPrev}">
							            <li class="page-item">
							            	<a class="page-link" href="<c:url value="/mypage/mydiary${pr.sc.getList(pr.beginPage-1) }" />">&lt;</a>
						            	</li>
						            </c:if>
						            <c:forEach var="i" begin="${pr.beginPage }" end="${pr.endPage }">
						            	<li class="page-item">
						            		<a class="page-link" href="<c:url value="/mypage/mydiary${pr.sc.getList(i) }" />">${i }</a>
					            		</li>
					            	</c:forEach>
				            		<c:if test="${pr.showNext}">
				            			<li class="page-item">
				            				<a class="page-link" href="<c:url value="/mypage/mydiary${pr.sc.getList(pr.endPage+1) }" />" >&gt;</a>
			            				</li>
	            					</c:if>
	       						</ul>
	   							</nav>
							</div>
						</c:if>		    			
		    		</div>	    	
	    		</div>
				
	        </div>
	        
	        </section>
		</div>
	
	<script type="text/javascript">
		
	
	
	</script>		
		
		
	<script
    src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
    crossorigin="anonymous"></script>
</body>
</html>