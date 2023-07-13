<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!doctype html>
<html lang="ko">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>팔로우</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-aFq/bzH65dt+w6FI2ooMVUpc+21e0SRygnTpmBvdBgSdnuTN7QbdgL+OapgHtvPp" crossorigin="anonymous">
    <link rel="stylesheet" href="${path}/resources/css/mypage/followlist.css" >
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/js/bootstrap.bundle.min.js" integrity="sha384-qKXV1j0HvMUeCBQ+QVp7JcfGl760yU08IQ+GpUo5hlbpg51QRiuqHAJz8+BrxE/N" crossorigin="anonymous"></script>
  </head>
  <body style="background-color: #202020;">
  	<div class="wrap">
  		<%@ include file="../../fix/header.jsp" %>
  		
  		<c:choose>
  			<c:when test="${stat eq 'my' }">
  				<%@ include file="../../fix/sec01.jsp" %>
  			</c:when>
  			
  			<c:otherwise>
  				<%@ include file="../../fix/sec02.jsp" %>
  			</c:otherwise>  		
  		</c:choose>
  		
  			
	    
	    <section class="sec02">
	    	<c:choose>
	    		<c:when test="${empty follow && mode eq 'follower' }">
	    			<div class="nofollow">팔로워가 없습니다</div>
	    		</c:when>
	    		<c:when test="${empty follow && mode eq 'following' }">
	    			<div class="nofollow">팔로잉이 없습니다</div>
	    		</c:when>
	    	</c:choose>
	    	
	    	<c:forEach var="Follow" items="${follow }">

				<div class="follow">
					<a href="<c:url value="/profile?user=${Follow.user_nicknm }" />">
		            	<img class="fol-pro" src="${Follow.image }" alt="profile" /></a>
	            	<div class="follow-nm"><a href="<c:url value="/profile?user=${Follow.user_nicknm }" />">
	            		${Follow.user_nicknm }</a></div>
	            		
	            	<c:if test="${sessionScope.user_no == userDTO.user_no && mode ne 'follower' }">
			          	<input type="checkbox" class="checkfollow" id="Follow" data-user="${Follow.user_no} " checked>
			        	<label class="labelfollow" for="Follow">팔로잉</label><br>
		        	</c:if>
				</div>
			</c:forEach>
		</section>
	</div>
	
	<script type="text/javascript">
		let MY = '${sessionScope.user_no}'
		let USER = '${userDTO.user_no}'
	
		$(document).ready(function() {
			
			getFollow()
			
			//팔로우 해제
			$(document).on('click', '.labelfollow', function() {
				let USER = $(this).prev().data('user');
				
				console.log('$(this)')
				console.log($(this))
				
				console.log("USER")
				console.log(USER)
				
				$(this).attr('class', 'labelCxlfollow')
				$(this).html('팔로우')
				
				$.post(
						"/ottt/stopFollow"
						, {
							my_no : MY
							, user_no : USER
						}
					)
			})
			
			//팔로잉
			$(document).on('click', '.labelCxlfollow', function() {
				let USER = $(this).prev().data('user');
				
				console.log('$(this)')
				console.log($(this))
				
				console.log("USER")
				console.log(USER)
				
				$(this).attr('class', 'labelfollow')
				$(this).html('팔로잉')
				
				$.post(
						"/ottt/startFollow"
						, {
							my_no : MY
							, user_no : USER
						}
					)
			})
			
			function getFollow() {
				if('${mode}' == 'follower')
					document.querySelector('.follower').style.color = '#33ff33';
				
				if('${mode}' == 'following')
					document.querySelector('.following').style.color = '#33ff33';
				
				}
			
		})
	
	</script>

  </body>
</html>