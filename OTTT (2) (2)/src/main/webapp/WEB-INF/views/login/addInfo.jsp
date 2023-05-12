<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import= "java.net.URLDecoder"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<c:set var="loginout" value="${sessionScope.id == null ? 'logout' : 'login'}" />
<c:set var="loginoutlink" value="${sessionScope.id==null ? '/login' : '/mypage'}" />
<!doctype html>
<html lang="ko">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-aFq/bzH65dt+w6FI2ooMVUpc+21e0SRygnTpmBvdBgSdnuTN7QbdgL+OapgHtvPp" crossorigin="anonymous">
    <link rel="stylesheet" href="${path}/resources/css/login/addinfo.css" >
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/js/bootstrap.bundle.min.js" integrity="sha384-qKXV1j0HvMUeCBQ+QVp7JcfGl760yU08IQ+GpUo5hlbpg51QRiuqHAJz8+BrxE/N" crossorigin="anonymous"></script>
    <style>
    	.ott-logo-img:hover,
		.ott-logo-img.active {
			outline: 3px solid #33ff33;
		}
    </style>
    <title>추가 정보 입력</title>
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
		
		<form:form modelAttribute="UserOTTDTO" method="post" id="membership">
			<div class="main">
				<h1 style="font-size: 21px; display: inline-block;">추가 정보 입력</h1>
				<div class="OTTcheck" style="border: 1px; padding: 3px;">OTT 선택</div>
				<div class="Genrecheck" style="border: 1px; padding: 3px;">장르 선택</div>
				
				<section class="sec00">
					<div class="ott-logo-box">
						
						<a href="#">
							<img class="ott-logo-img" src="${path}/resources/images/icon/티빙.png"  onclick="sendData(1);"  />
						</a>
						
						<a href="#">
							<img class="ott-logo-img" src="${path}/resources/images/icon/netplix.png"  onclick="sendData(2);"	/>
						</a>
						
						<a href="#" onclick="sendData(3);">
							<img class="ott-logo-img" src="${path}/resources/images/icon/웨이브.png" />
						</a>
						
						<a href="#" onclick="sendData(4);">
							<img class="ott-logo-img" src="${path}/resources/images/icon/쿠팡플레이.png" />
						</a>
						
						<a href="#" onclick="sendData(5);">
							<img class="ott-logo-img" src="${path}/resources/images/icon/왓챠.png" />
						</a>
						
						<a href="#" onclick="sendData(6);">
							<img class="ott-logo-img" src="${path}/resources/images/icon/디즈니플러스.png" />
						</a>
					</div>
					
					
					<script>
					function sendData(ott_no) {
						var ott_no_val = ott_no; // ott_no 값을 변수에 저장
						$.ajax({
						    type: "POST",
						    url: "/ottt/signin/addInfo",
						    data: { "ott_no": ott_no }, // 데이터는 객체로 전달
						    contentType: "application/x-www-form-urlencoded; charset=UTF-8", // Content-Type 변경
						    success: function (response) {
						        console.log("success");
						    },
						    error: function (e) {
						        console.log("error");
						    }
						});
					}
					</script>
					
					<ul class="ott-logo-text" >
						<li>
					    	<input id="movie" type="checkbox" value="movie" name="1">&nbsp;&nbsp;
					    	<a href="#"><label for="movie">액션</label></a>
					  	</li>
					  	<li>
					    	<input id="movie1" type="checkbox" value="movie" name="2">&nbsp;&nbsp;
					    	<a href="#"><label for="movie1">어드벤쳐</label></a>
					  	</li>
					  	<li>
						    <input id="movie2" type="checkbox" value="movie" name="3">&nbsp;&nbsp;
						    <a href="#"><label for="movie2">SF</label></a>
					  	</li>
					  	<li>
					    	<input id="movie3" type="checkbox" value="movie" name="4">&nbsp;&nbsp;
					    	<a href="#"><label for="movie3">판타지</label></a>
					  	</li>
				  		<li>
				    		<input id="movie4" type="checkbox" value="movie" name="5">&nbsp;&nbsp;
					    	<a href="#"><label for="movie4">드라마</label></a>
					  	</li>
					  	<li>
					    	<input id="movie5" type="checkbox" value="movie" name="6">&nbsp;&nbsp;
					    	<a href="#"><label for="movie5">코미디</label></a>
					  	<li>
						    <input id="movie6" type="checkbox" value="movie" name="7">&nbsp;&nbsp;
					    	<a href="#"><label for="movie6">시대극</label></a>
					  	</li>
					  	<li>
					    	<input id="movie7" type="checkbox" value="movie" name="8">&nbsp;&nbsp;
					    	<a href="#"><label for="movie7">로맨스/멜로</label></a>
					  	</li>
					  	<li>
						    <input id="movie8" type="checkbox" value="movie" name="9">&nbsp;&nbsp;
					    	<a href="#"><label for="movie8">공포/스릴러</label></a>
					  	</li>
					  	<li>
						    <input id="movie9" type="checkbox" value="movie" name="10">&nbsp;&nbsp;
					    	<a href="#"><label for="movie9">미스터리</label></a>
					  	</li>
					  	<li>
						    <input id="movie10" type="checkbox" value="movie" name="11">&nbsp;&nbsp;
					    	<a href="#"><label for="movie10">범죄</label></a>
					  	</li>
					  	<li>
						    <input id="movie11" type="checkbox" value="movie" name="12">&nbsp;&nbsp;
					    	<a href="#"><label for="movie11">음악/뮤지컬</label></a>
					  	</li>
					  	<li>
						    <input id="movie12" type="checkbox" value="movie" name="13">&nbsp;&nbsp;
					    	<a href="#"><label for="movie12">스포츠</label></a>
					  	</li>
					  	<li>
						    <input id="movie13" type="checkbox" value="movie" name="14">&nbsp;&nbsp;
					    	<a href="#"><label for="movie13">다큐멘터리</label></a>
					  	</li>
					  	<li>
						    <input id="movie14" type="checkbox" value="movie" name="15">&nbsp;&nbsp;
					    	<a href="#"><label for="movie14">가족</label></a>
					  	</li>
					  	<li>
						    <input id="movie15" type="checkbox" value="movie" name="16">&nbsp;&nbsp;
					    	<a href="#"><label for="movie15">역사</label></a>
					  	</li>
				  	</ul>
		  		</section>
		  	
			  	<div class="back" style="display: inline-block; pointer-events: none;">
					<a href="<c:url value="/" />" style="pointer-events: none;">
						<input type="button" value="건너뛰기" style="pointer-events: auto;">
		  			</a>
				</div>
				
				<div class="complate">
					<input type="submit" value="완료"  onclick="sendData(ott_no)" >
				</div>
				
				<script>
					const logos = document.querySelectorAll('.ott-logo-img');
					logos.forEach(function(logo) {
						logo.addEventListener('click', function() {
							logo.classList.toggle('active');
						});
					});
				</script>
			</div>
		</form:form>
	</div>
		
		
		
	
</body>
</html>
