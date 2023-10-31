<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${path}/resources/css/fix/header.css" >
    <script src="https://code.jquery.com/jquery-3.4.1.js"></script>
    <title>Document</title>
</head>
<body>
	<section class="sec01">
			<div class="mypage-info">
				<div class="porfile">
		            <img  src=${userDTO.image }>
		        </div>
	         	<div class="user">
	          		<ul>
	          			<li class="user-name">
	          				<span><a href="<c:url value="/mypage?user=${userDTO.user_nicknm }" />">${userDTO.user_nicknm }</a></span>
	         				</li>
		              	<li class="user-follow">
		                	<span class="follower"><a href="<c:url value="/mypage/follower?user=${userDTO.user_nicknm }" />">팔로워 ${followerCnt}</a></span>
		                	&nbsp;|&nbsp;
		                	<span class="following"><a href="<c:url value="/mypage/following?user=${userDTO.user_nicknm }" />">팔로잉 ${followingCnt}</a></span>
		              	</li>
	              	</ul>
				</div>
			</div>
		</section>	
		
</body>
</html>