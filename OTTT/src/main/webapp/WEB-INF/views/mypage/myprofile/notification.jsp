<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!doctype html>
<html lang="ko">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title> 댓글 외 알림</title>
    <script src="https://code.jquery.com/jquery-1.11.3.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-aFq/bzH65dt+w6FI2ooMVUpc+21e0SRygnTpmBvdBgSdnuTN7QbdgL+OapgHtvPp" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css" />
    <link rel="stylesheet" href="${path}/resources/css/mypage/message_alarm.css" >
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/js/bootstrap.bundle.min.js" integrity="sha384-qKXV1j0HvMUeCBQ+QVp7JcfGl760yU08IQ+GpUo5hlbpg51QRiuqHAJz8+BrxE/N" crossorigin="anonymous"></script>
  </head>

	<body style="background-color: #202020;">
    <script type="text/javascript">
    $(document).ready(function() {
    	  $('.noti-box').on('click', '.delBtn', function() {
    	    var notiNo = $(this).attr('notiNo');
    	    var notiBox = $(this).closest('.noti-box'); // $(this)를 변수에 저장
    	    
    	    console.log('notiNo')
    	    console.log(notiNo)
    	    
    	    console.log('notiBox')
    	    console.log(notiBox)
    	    
    	    $.ajax({
    	      url: '/mypage/deleteNotification',
    	      method: 'POST',
    	      data: { notiNo: notiNo },
    	      success: function(response) {
    	        if (response.success) {
    	          notiBox.remove(); // 변수 사용
    	          console.log('알림이 삭제되었습니다.');
    	        } else {
    	          console.log('알림 삭제에 실패했습니다.');
    	        }
    	      },
    	      error: function() {
    	        console.log('알림 삭제 중 오류가 발생했습니다.');
    	      }
    	    });
    	  });
    	});
    </script>
	
	<div class="wrap">
	
		<%@ include file="../../fix/header.jsp" %>
	
		<%@ include file="../../fix/mnb.jsp" %>
		<input type="hidden" value="${notiCnt }"/>
		<c:if test="${notiCnt == null || notiCnt == 0}">
			<div style="display: flex; margin-top: 30px; justify-content: center; color: #8f8f8f; font-size: 30px;">알림이 없습니다.</div>
		</c:if>
		
		<c:forEach var="notificationDTO" items="${list}">
			<div class="noti-box" id="noti-box" notiNo="${notificationDTO.noti_no}">
				<section class="sec01">
					<img class="profile" src="${notificationDTO.image }" alt="profile" />
						<a href="${notificationDTO.noti_url }">
							<div class="noti">${notificationDTO.user_nicknm } ${notificationDTO.noti_message }</div>
						</a>
					<button class="delBtn" name="deleteBtn" id="del" alt="delete" notiNo="${notificationDTO.noti_no}"><i class="fas fa-times"></i></button>
				</section>
			</div>
		</c:forEach>

	</div>
  </body>
</html>