<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="user_no" value="${sessionScope.user_no}" />
<c:set var="loginId" value="${sessionScope.id}" />
<c:set var="loginout" value="${sessionScope.id == null ? 'logout' : 'login'}" />
<c:set var="loginoutlink" value="${sessionScope.id==null ? '/login' : '/mypage'}" />

<c:set var="path" value="${pageContext.request.contextPath}"/>
<!doctype html>
<html lang="ko">
	<head>
    	<meta charset="utf-8">
    	<meta name="viewport" content="width=device-width, initial-scale=1">
    	<title>community_main</title>
    	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-aFq/bzH65dt+w6FI2ooMVUpc+21e0SRygnTpmBvdBgSdnuTN7QbdgL+OapgHtvPp" crossorigin="anonymous">
    	<link rel="stylesheet" href="${path}/resources/css/community/freecommunity/community_main.css" >
    	<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
    	<script type="text/javascript" src="${path}/resources/js/community/main.js"></script>
    	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/js/bootstrap.bundle.min.js" integrity="sha384-qKXV1j0HvMUeCBQ+QVp7JcfGl760yU08IQ+GpUo5hlbpg51QRiuqHAJz8+BrxE/N" crossorigin="anonymous"></script>
		<style type="text/css">
		    #loading {
		      display: none;
		      position: fixed;
		      z-index: 9999;
		      top: 0;
		      left: 0;
		      height: 100%;
		      width: 100%;
		      overflow: visible;
		      background: rgba(0, 0, 0, 0.75) url('${path}/resources/images/loading2.gif') no-repeat center center;
		    }
		    
			#scroll-btn {       
			       
			    width: 40px;
			    height: 40px;
			    color: #fff;
			    background-color: #ef476f;
			    position: fixed;
			    bottom: 10%;
			    right: 6%;    
			    border: 2px solid #fff;
			    border-radius: 50%; 
			    font: bold 20px monospace;       
			    transition: opacity 0.5s, transform 0.5s;
			}
			#scroll-btn.show {      
			    opacity: 1;  
			    transition: opacity 1s, transform 1s;     
			}
		</style>
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
              				<a href="<c:url value="/community/freecommunity" />" style="color: #33ff33;">게시판</a>
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
              				<a href="<c:url value='${loginoutlink}' /> " class="${loginout}">
                				<!-- <img src="./images/icon/user01.png" alt="내 정보"> -->
              				</a>
            			</li>
          			</ul>
        		</div>
      		</header>
      		<!--meun bar Start-->  
        	<div id="line-1" >
          		<nav class="nav">
          			<a class="nav-link1" href="<c:url value='/community/freecommunity' />" style="color: #33ff33;">자유게시판</a>
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
	                    		<a href="<c:url value='/mycommynity/postcommu?user_no=${sessionScope.user_no}' />" class="list-group-item list-group-item-action" >
	                      			<img class="side_img" src="${path}/resources/images/img/KakaoTalk_20230411_161709664.png" alt="post">내가 쓴 게시글
	                    		</a>
	                		</div>
	              		</li>
	              		<li style="display: flex;">
	                  		<div class="list-group">
	                      		<a href="<c:url value='/mycommynity/likecommunity?user_no=${ArticleDTO.user_no}' />" class="list-group-item list-group-item-action">
	                        		<img class="side_img" src="${path}/resources/images/img/free-icon-heart-6063477 2.png" alt="heart">좋아요 누른 게시글
	                      		</a>
	                  		</div>
	              		</li>
	              		<li style="display: flex;">
	                  		<div class="list-group">
	                     		<a href="<c:url value='/mycommynity/comment?user_no=${ArticleDTO.user_no}' />" class="list-group-item list-group-item-action">
	                       			<img class="side_img" src="${path}/resources/images/img/comment.png" >댓글 작성 게시물
		                      	</a>
	                 		</div>
	             		</li>
	              		<li style="display: flex;">
	             			<div class="list-group">
	                      		<a href="#" class="list-group-item list-group-item-action" style="margin-top: 2vw; height: 35vh;">광고</a>
	                    	</div>
	              		</li>
	              	</ul>
          		</div>
				<!--ㅡmain------------------------------------------>
				<div class="Rcontent" >
            		<div>
	       				<form id="insertForm" class="frm" method="post" action="<c:url value='/community/freecommunity'/>">  
	           				<ul class="post_write">
		                  		<li>
	                    			<img src="${path}/resources/images/icon/user01.png" alt="프로필사진">
		                  		</li>
		                  		<li>
	                      			<textarea class="writeHere" placeholder="Write Here" onkeydown="resize(this)" onkeyup="resize(this)" id="article_content" name="article_content" ></textarea>
		                  		</li>
		                  		<li class="btn_s">
		                      		<label for="btn_file" ><img src="${path}/resources/images/img/writeImg.png" class="img_file"></label>
		                      		<input id="btn_file" type="file" accept="image/gif, image/jpeg, image/png" multiple/>         
		                      		<img src="${path}/resources/images/img/commit.png" alt="commit" class="btn_commit"	id="commitBtn">             
		                  		</li>
	          				</ul>
	        			</form> 
            		</div>
            		<div class="post_list" id="post_list"></div>
    				<button id="loadMoreBtn">[더보기]</button>
         		</div>
        	</div>
        	<button id="scroll-btn">&uarr;</button>
        	<div id="loading"></div>
    	</div>
	    <script>
	    
			/********************************************************************************/
			/* 자바스크립트 전역변수 영역, 대문자로 정의												*/
			/********************************************************************************/
			let PATH = "<c:out value='${path}'/>"; 	//이미지 root 경로
			let URL = 	"<c:url value='/community/post?article_no='/>";	//상세페이지 이동 URL 설정
			let OFFSET = 0
			let TOTAL_COUNT = "<c:out value='${totalCount}'/>";

			console.log("path :"+PATH);
			console.log("url  :"+URL);
			
			/********************************************************************************/
			/* DOM Ready 영역																	*/
			/* 작성자 gahhyun																	*/
			/********************************************************************************/
			$(document).ready(function(){

				/********************************************************************************/
				/*	DOM ajaxStart 영역 ajax 호출시 로딩효과											*/
				/********************************************************************************/
	      		$(document).ajaxStart(function() {
	          		$('#loading').show();
	        	}).ajaxStop(function() {
	          		setTimeout(function() {
		            	$('#loading').hide();
		          	}, 1000); // 1초의 지연 효과를 줍니다.
	        	});
	
				/********************************************************************************/
				/*	요소 Event정의 영역																*/
				/********************************************************************************/

				//저장버튼 Click Event
				$("#commitBtn").click(function(){
					//자바스크립트 + 제이쿼리를 이용한 입력항목 유효성 체크
					let value = $("#article_content").val();
					if(value == "" || value == null){
						alert("내용을 입력해주세요.");
						return;
					}				
		     		$("#insertForm").submit();		//컨트롤러로 최종 값을 전송
				});
				
	
				//더보기버튼 Click Event
				$("#loadMoreBtn").click(function(){
					
					let ulLength = $("#post_list > ul").length;
	
					if(TOTAL_COUNT <= ulLength){
						alert("불러올 데이터가 없습니다.");
						return;
					}
					
					OFFSET += 10;

					callAjaxSelectArticleList(OFFSET);
					
				});
	
				
				//1. ajax 비통기 통신으로 아티클목록 호출
				callAjaxSelectArticleList(OFFSET);
				
			});
	
				
			/********************************************************************************/
			/* function 함수 정의 영역															*/
			/* 작성자 gahhyun																	*/
			/********************************************************************************/
			
			//목록 호출 함수
			function callAjaxSelectArticleList(_offSet){
				//ajax-post방식 축약버전 호출방식
				$.post(
					"/ottt/community/ajax/getArticleList"
				    ,{ 
						"offset": _offSet
					}
				    ,fnCreatArticleList
				)				
			}
				
			//목록 생성 함수, $.post 에서 success 함수로 사용
			function fnCreatArticleList(response){
				
				console.log("ajax 통신결과");
				console.log(response);
				
				let createHtml = "";
	
				//데이터가 있을때
				if(response){
			
					checkListSize = response.length;
					
					//화살표 함수형 foreach 반복문
					response.forEach( function(v) {
	
						createHtml += 	'<ul class="post" >';
						createHtml += 		'<div class="post_info">';
						createHtml +=			'<div style="display: flex;">';
						createHtml +=				'<a href="#"><img class="usur_img" src="'+ PATH +'/resources/images/icon/user01.png" alt="profile"></a>';
						createHtml +=				'<a href="#"><span class="nickname">'+ v.user_nicknm +'</span></a>';
						createHtml +=				'<span id="current_date" >'+ v.article_create_dt +'</span>';
						createHtml +=			'</div>';
						createHtml +=			'<div>';
						createHtml +=				'<div>';	
						createHtml +=					'<button type="button" class="btn_warning" data-bs-toggle="dropdown" >신고</button>';
						createHtml +=					'<ul class="dropdown-menu" >';
						createHtml +=						'<li><a class="dropdown-item" href="#">욕설/비방</a></li>';
						createHtml +=						'<li><a class="dropdown-item" href="#">광고/도배</a></li>';
						createHtml +=						'<li><a class="dropdown-item" href="#">악의적인 스포</a></li>';
						createHtml +=						'<li><a class="dropdown-item" href="#">선정성</a></li>';
						createHtml +=					'</ul>';                   
						createHtml +=				'</div>';
						createHtml +=			'</div>';
						createHtml +=		'</div>'                
						createHtml +=		'<div style="width: 900px;">';
						createHtml +=			'<a href="'+ URL + v.article_no +'" class="main_article" >'+ v.article_content +'</a>';
						createHtml +=		'</div>';
						createHtml +=		'<div>';
						createHtml +=			'<div>';
						createHtml +=				'<input class="heart_img" type="image" src="'+ PATH +'/resources/images/img/free-icon-heart-6063477 2.png" alt="heart">';
						createHtml +=				'<span>'+ v.article_like_count +'</span>'; 
						createHtml +=				'<input class="re_comment_img" type="image" src="'+ PATH +'/resources/images/img/comment.png" alt="comment">';
						createHtml +=				'<span>0</span>';                  
						createHtml +=			'</div>';
						createHtml +=		'</div>';
						createHtml +=	'</ul>';
					
					});
					
					//반복문으로 목록을 그리고 id가 post_list인 div 하위에 추가한다.
					$("#post_list").append(createHtml);
					
				//데이터가 없을때 처리
				}else {
	
					$("#post_list").append('<div>게시물이 없습니다. </div>');				
					$("#loadMoreBtn").hide();		//더보기 버튼 숨김
					
				}				
				
			}
			
			const scrollTop = function () {
				  const scrollBtn = document.createElement("button");
				  scrollBtn.innerHTML = "&uarr;";
				  scrollBtn.setAttribute("id", "scroll-btn");
				  document.body.appendChild(scrollBtn);
				};

				scrollTop();
				
			const scrollBtnDisplay = function () {
				  window.scrollY > window.innerHeight
				  ? scrollBtn.classList.add("show")
				  : scrollBtn.classList.remove("show");
			};

			window.addEventListener("scroll", scrollBtnDisplay);
			
			const scrollWindow = function () {  
				  if (window.scrollY != 0) {
				    setTimeout(function () {
				      window.scrollTo(0, window.scrollY - 50);
				      scrollWindow();
				    }, 10);
				  }
				};

				scrollBtn.addEventListener("click", scrollWindow);
		</script>
	</body>
</html>