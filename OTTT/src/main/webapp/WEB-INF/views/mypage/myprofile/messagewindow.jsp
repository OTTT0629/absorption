<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>쪽지창</title>
    
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-aFq/bzH65dt+w6FI2ooMVUpc+21e0SRygnTpmBvdBgSdnuTN7QbdgL+OapgHtvPp" crossorigin="anonymous">
    <link rel="stylesheet" href="${path}/resources/css/mypage/messagewindow.css" >
    <script type="text/javascript" src="js/main.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/js/bootstrap.bundle.min.js" integrity="sha384-qKXV1j0HvMUeCBQ+QVp7JcfGl760yU08IQ+GpUo5hlbpg51QRiuqHAJz8+BrxE/N" crossorigin="anonymous"></script>
    
</head>
<body>
	<div class="wrap">
        <header>
            <div class="sec01">
                <a href="#">
                    <div class="proimg">
                        <img src="">
                    </div>
                </a>
                <div class="nickname">피카츄 님</div>
            </div>
        </header>

        <form action="#" method="post">
        <middle>
            <div class="sec02">
                <div class="write">
                    <textarea id="content" placeholder="내용을 입력하세요."></textarea>
                </div>
            </div>
        </middle>

        <bottom>
            <div class="sec03">
                <input type="submit" id="input1" value="답장">
            </div>
        </bottom>
        </form>
    </div>	
    
</body>
</html>