<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="user_no" value="${sessionScope.user_no}" />
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${path}/resources/css/fix/mnb.css" >
    <script src="https://code.jquery.com/jquery-3.4.1.js"></script>
    <title>Document</title>
</head>
<body>

	
	<nav class="mnb">
		<ul>
			<li><a href="<c:url value="/mypage/mydiary?user=${sessionScope.user_nicknm }" />">기록</a></li>
			<li><a href="<c:url value="/mypage/wishlist?user=${sessionScope.user_nicknm}" />">찜목록</a></li>
			<li><a href="<c:url value="/mypage/watched?user=${sessionScope.user_nicknm}" />">봤어요</a></li>
			<li>
				<a href="<c:url value="/mypage/alarm" />" id="notificationLink">
                    <c:choose>
                        <c:when test="${empty notiList || notiList.isEmpty()}">
                            <!-- notiList가 비어있을 때의 내용 -->
                            알림함
                        </c:when>
                        <c:otherwise>
                            <!-- notiList가 비어있지 않을 때의 내용 -->
                            <c:set var="hasFalse" value="false" />
                            <c:forEach items="${notiList}" var="notificationDTO">
                                <c:if test="${notificationDTO.noti_check == false}">
                                    <c:set var="hasFalse" value="true" />
                                </c:if>
                            </c:forEach>
                            <c:choose>
                                <c:when test="${hasFalse == true}">
                                    <span style="color: #33ff33;">●</span>알림함
                                </c:when>
                                <c:otherwise>
                                    알림함
                                </c:otherwise>
                            </c:choose>
                        </c:otherwise>
                    </c:choose>
                    
                    
                    
<%--                     <c:choose> --%>
<%--                         <c:when test="${notiCheckCnt == null || notiCheckCnt == 0}"> --%>
<!--                             notiCheckCnt가 없을 때의 내용 -->
<!--                             알림함 -->
<%--                         </c:when> --%>
<%--                         <c:otherwise> --%>
<!--                         	notiCheckCnt가 있을 때의 내용 -->
<!-- 							<span style="color: #33ff33;">●</span>알림함 -->
<%--                         </c:otherwise> --%>
<%--                     </c:choose> --%>
				</a>
			</li>
			<li><a href="<c:url value="/mypage/message" />">쪽지함</a></li>
		</ul>
	</nav>
	
	
</body>
</html>