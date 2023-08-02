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
    <title>아이디 확인</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-aFq/bzH65dt+w6FI2ooMVUpc+21e0SRygnTpmBvdBgSdnuTN7QbdgL+OapgHtvPp" crossorigin="anonymous">
    <link rel="stylesheet" href="${path}/resources/css/login/idverify.css" >
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/js/bootstrap.bundle.min.js" integrity="sha384-qKXV1j0HvMUeCBQ+QVp7JcfGl760yU08IQ+GpUo5hlbpg51QRiuqHAJz8+BrxE/N" crossorigin="anonymous"></script>
</head>
<body style="background-color: #202020;">
	<div class="wrap">
		<%@ include file="../fix/header.jsp" %>
		
		<section class="sec00">
			<form method="get" action="<c:url value="/login" />" id="membership">
				<h1 style="font-size: 21px; display: inline-block;">아이디 확인</h1>
				<div class="Idcheck" >회원님의 아이디는 ${userDTO.user_id}입니다.</div>
					<div class="back" style="display: inline-block; pointer-events: none;">
						<a href="<c:url value='/login/findPwd' />" style="pointer-events: none;">
							<input type="button" value="비밀번호 찾기" style="pointer-events: auto;">
						</a>
					</div>
					
					<div class="complate">
						<input type="submit" value="완료" >
					</div>
			 </form>
		 </section>
	 </div>
	 
</body>
</html>
