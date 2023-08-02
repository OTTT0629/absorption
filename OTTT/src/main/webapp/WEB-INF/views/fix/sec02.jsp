<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${path}/resources/css/fix/sec02.css" >
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <title>Document</title>
</head>
<body>
	<section class="sec01">      
        <div class="mypage-info">
        <input name="userno" type="hidden" value="${userDTO.user_no }" />
          <div class="porfile">
            <img  src="${userDTO.image }" >
          </div>
        <div class="user">
            <ul>
              <li class="user-name">
                <span><a href="<c:url value="/profile?user=${userDTO.user_nicknm }" />">${userDTO.user_nicknm }</a></span>
              </li>
              <li class="user-follow">
                <span class="follower" onclick="location.href='<c:url value="/profile/follower?user=${userDTO.user_nicknm }" />'">팔로워 ${followerCnt}</span>
                &nbsp;|&nbsp;
                <span class="following" onclick="location.href='<c:url value="/profile/following?user=${userDTO.user_nicknm }" />'">팔로잉 ${followingCnt}</span>
              </li>
            </ul>
        </div>
        <div class="btn_more_div" >
            <button type="button" style="background-color:transparent;" class="btn_more" data-bs-toggle="dropdown" aria-expanded="false">
                <img src="${path}/resources/images/img/more.png" style="width: 40px;" alt="more">
            </button>
            <ul class="dropdown-menu">
              <li class="dropdown-item" id="item-msg" style="cursor: pointer;">쪽지 보내기</li>
              <li class="dropdown-item disabled" style="color: black;">신고하기</li>
                <ul>
                  <li class="report"><button class="report">욕설/비방</button></li>
                  <li class="report"><button class="report">광고/도배</button></li>
                  <li class="report"><button class="report">악의적인 스포</button></li>
                  <li class="report"><button class="report">선정성</button></li>
                </ul>
              <li><a class="dropdown-item" href="#">차단</a></li>
            </ul>
        </div>
	    <c:if test="${sessionScope.id ne null && sessionScope.id ne '' }">
	        <div class="btn_check_div" style="margin-top: 20px;">
	          <input type="checkbox" class="btn-check" id="btnFollow" >
	          <label class="btn btn-outline-primary" for="btnFollow">팔로우</label><br>
	        </div>
	    </c:if>
        </div>
      </section>
      
      <script type="text/javascript">
		let MY = '${sessionScope.user_no}'
		let USER = '${userDTO.user_no}'

		$(document).ready(function() {
				
			getFollowStatus({"my_no" : MY, "user_no" : USER})
			
			// 팔로잉
			$(document).on('click', '#btnFollow', function() {
				$.post(
					"/startFollow"
					, {
						my_no : MY
						, user_no : USER
					}
					, function() {
						$('#btnFollow').prop('checked', true);
						$('#btnFollow').html('팔로잉');
						$('.btn-outline-primary').html('팔로잉');
						$('.btn-outline-primary').attr('for', 'btnCxlFollow');
						$('#btnFollow').attr('id','btnCxlFollow');
					}
				)
			})
			
			// 팔로우 해제
			$(document).on('click', '#btnCxlFollow', function() {
				$.post(
					"/stopFollow"
					, {
						my_no : MY
						, user_no : USER
					}
					, function() {
						$('#btnCxlFollow').prop('checked', false)
						$('#btnCxlFollow').html('팔로우')
						$('.btn-outline-primary').html('팔로우');
						$('.btn-outline-primary').attr('for', 'btnFollow');
						$('#btnCxlFollow').attr('id','btnFollow')
					}
				)
			})
			
			// 팔로우 상태 확인
			function getFollowStatus(param) {
				console.log('param')
				console.log(param)
				
				$.post(
						"/getFollowStatus"
						, param
						, function(response) {
							if(response) {
								$('#btnFollow').prop('checked', true)
								$('#btnFollow').html('팔로잉')
								$('.btn-outline-primary').html('팔로잉');
								$('.btn-outline-primary').attr('for', 'btnCxlFollow');
								$('#btnFollow').attr('id','btnCxlFollow')
							}
							console.log('결과')
							console.log(response)
						}
						
					)

				}
			
		})	
	
	</script>
		
</body>
</html>