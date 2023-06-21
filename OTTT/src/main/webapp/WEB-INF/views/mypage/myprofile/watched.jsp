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
    <title>봤어요-애니</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-aFq/bzH65dt+w6FI2ooMVUpc+21e0SRygnTpmBvdBgSdnuTN7QbdgL+OapgHtvPp" crossorigin="anonymous">
    <link rel="stylesheet" href="${path}/resources/css/mypage/watched.css" >
    <script type="text/javascript" src="js/main.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/js/bootstrap.bundle.min.js" integrity="sha384-qKXV1j0HvMUeCBQ+QVp7JcfGl760yU08IQ+GpUo5hlbpg51QRiuqHAJz8+BrxE/N" crossorigin="anonymous"></script>


</head>
<body>
	<div class="wrap">
		<%@ include file="../../fix/header.jsp" %>

      <section class="sec01">
      	
        <nav class="mnb">
          <ul>
	          <li><a href="<c:url value="/mypage/myreview" />" class="mreview">기록</a></li>
	          <li><a href="<c:url value="/mypage/wishlist" />">찜목록</a></li>
	          <li><a href="<c:url value="/mypage/watched" />" style="color: #33ff33">봤어요</a></li>
	          <li><a href="<c:url value="/mypage/alarm" />">알림함</a></li>
	          <li><a href="<c:url value="/mypage/message" />">쪽지함</a>
            </li>
          </ul>
        </nav>
      </section>

      <section class="sec02">
        <div class="Lcontent">
          <div class="Lmenu">
            <ul>
              <li>
                <img class="mimg" src="${path}/resources/images/img/movie.png" alt="영화">
                <a onclick="javascript:fnCategory(1)">영화</a>
              </li>
              <li>
                <img class="mimg" src="${path}/resources/images/img/drama.png" alt="드라마">
                <a onclick="javascript:fnCategory(2)">드라마</a>
              </li>
              <li >
                <img class="mimg" src="${path}/resources/images/img/vrt.png" alt="예능">
                <a onclick="javascript:fnCategory(3)">예능</a>
              </li>
              <li>
                <img class="mimg" src="${path}/resources/images/img/free-icon-anime-2314736.png" alt="애니">
                <a onclick="javascript:fnCategory(4)">애니</a>
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
	           	
				<div class="main-work"></div>
				
				<div class=paging-container>
					<div class="paging"></div>
				</div>
						
			</div>        
		</section>
	</div>
	
	<script type="text/javascript">
		let CATEGORY = '' 
		let USER = '${userDTO.user_nicknm}'
		let PAGE = ${pr.sc.page}
		let PAGESIZE = ${pr.sc.pageSize}
				
		$(document).ready(function() {			
			
			fnGetWatchedList({
				"user" : USER
				, "category_no" : CATEGORY
				, "page" : PAGE
				, "pageSize" : PAGESIZE
			})
			
		})
	
		function fnGetWatchedList(param) {
			
			$.post(
					"/ottt/mypage/getwatchedlist"
				    ,param
				    ,fnCreatWatchedList
				)
				
				console.log("param")
				console.log(param)
			
		}
		
		function fnCreatWatchedList(response) {
			
			console.log("ajax 통신결과");
			console.log(response);
			
			let createHtml = "";
			
			let list = response.list;
			let watchedCnt = response.watchedCnt
			let pr = response.pr
			
			list.forEach(function(v) {
				createHtml += '<div class="work-info">'
				createHtml += '<a href="<c:url value="/detailPage?content_no=' +v.content_no+ '" />">'
				createHtml += '<img src="' +v.thumbnail+ '" class="poster"/></a>'
				createHtml += '<div style="text-align: right; border: #fff;">'
				createHtml += '<input type="checkbox" class="btn-check" id="btncheck1" autocomplete="off" checked>'
				createHtml += '<div class="title" style="text-align: center; font-size: 13px;">'+v.content_nm+'</div>'
				createHtml += '<div class="review"><img src="${path}/resources/images/img/starone.png" class="review-star" alt="star">'+v.rating+'</div>'
				createHtml += '</div>'
				createHtml += '</div>'				
			})
			
			$('.main-work').append(createHtml)
			
			let createPage = "";
			
			 if (response.wishListCnt == null || response.watchedCnt === 0) {
			        createPage += '<div class="title-line" style="text-align: center;">내가 쓴 다이어리가 없습니다.</div>';
			    } else {
			        createPage += '<div class="page-num" style="margin-top: 10px;">';
			        createPage += '<nav aria-label="Page navigation example" class="d-flex flex-row justify-content-center">';
			        createPage += '<ul class="pagination">';
			        if (response.pr.showPrev) {
			            createPage += '<li class="page-item">';
			            createPage += '<a class="page-link" onclick="javascript:fnPage('+ (response.pr.beginPage-1) +','+response.pr.sc.category_no+ ')">&lt;</a></li>';
			        }
			        for (let i = response.pr.beginPage; i <= response.pr.endPage; i++) {
			            createPage += '<li class="page-item">';
			            createPage += '<a class="page-link" onclick="javascript:fnPage('+i+','+response.pr.sc.category_no+ ')">' + i + '</a></li>';
			        }
			        if (response.pr.showNext) {
			            createPage += '<li class="page-item">';
			            createPage += '<a class="page-link" onclick="javascript:fnPage('+(response.pr.endPage+1)+','+response.pr.sc.category_no+ ')">&gt;</a></li>';
			        }
			        createPage += '</ul></nav></div>';
			    }
			
			$('.paging').append(createPage)

							
		}
		
		function fnCategory(category) {
			$(".main-work").html("");
			$('.paging').html("");
			fnGetWatchedList({
				"user" : USER
				, "category_no" : category
				, "page" : PAGE
				, "pageSize" : PAGESIZE
			});
			
		}
		
		function fnPage(page, category) {
			$(".main-work").html("");
			$('.paging').html("");
			fnGetWatchedList({
				"user" : USER
				, "category_no" : category
				, "page" : page
				, "pageSize" : PAGESIZE
			});
			
		}
		
	</script>
    
    <script
    src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
    crossorigin="anonymous"></script>
</body>
</html>