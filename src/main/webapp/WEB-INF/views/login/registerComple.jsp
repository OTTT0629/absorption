<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import= "java.net.URLDecoder"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!doctype html>
<html lang="ko">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-aFq/bzH65dt+w6FI2ooMVUpc+21e0SRygnTpmBvdBgSdnuTN7QbdgL+OapgHtvPp" crossorigin="anonymous">
    <link rel="stylesheet" href="${path}/resources/css/login/registercomple.css" >
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/js/bootstrap.bundle.min.js" integrity="sha384-qKXV1j0HvMUeCBQ+QVp7JcfGl760yU08IQ+GpUo5hlbpg51QRiuqHAJz8+BrxE/N" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css">
    <style>
    	.ott-logo-img:hover,
		.ott-logo-img.active {
			outline: 3px solid #33ff33;
		}
		
		#msg{
			text-align: center;
		}
    </style>
    <title>회원가입 완료</title>
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
              <a href="<c:url value='/mypage' />">
                <!-- <img src="./images/icon/user01.png" alt="내 정보"> -->
              </a>
            </li>
          </ul>
        	</div>
		</header>
      
        <div class = "Login">
        	<img src = "${path}/resources/images/logo/OTTT.png" width="420" height="120">
        	<div style="font-size: 30px; font-weight: bold; text-align: center; margin: 10px 0;">환영합니다!</div>
        	
        	
        	
        	<form method="post" action="<c:url value='/signin/complete' />" onsubmit="return frmCheck(this)">
        			<div id="msg">		        		
						<c:if test= "${not empty param.msg}" >
						<i class="fa fa-exclamation-circle">${URLDecoder.decode(param.msg)}</i>
						</c:if>
					</div>
						<input type="text" style="border:0 solid black" name="user_id" placeholder="아이디">
		            	<input type="password" style="border:0 solid black" name="user_pwd" style="border:0 solid black" placeholder="비밀번호">
		            	<input type="submit" value="로그인">
           	</form>
       	</div>
   	</div>
   	
   	<script type="text/javascript">
			function frmCheck(frm) {
				let msg = ''
				
				if (frm.user_id.value.length == 0){
					setMessage("id를 입력해주세요", frm.user_id)
					return false;
				}
				
				if (frm.user_pwd.value.length == 0){
					setMessage("비밀번호를 입력해주세요", frm.user_pwd)
					return false;
				}
				
				return true;
				
			}
			
			function setMessage(msg, element) {
				document.getElementById("msg").innerHTML
						= `<i class="fa fa-exclamation-circle">${'${msg}'}</i>`
				if(element) {
					element.select()	//값이 잘못 입력되었을 때 다시 입력 
				}
			}
	
	</script>
         
</body>
</html>
