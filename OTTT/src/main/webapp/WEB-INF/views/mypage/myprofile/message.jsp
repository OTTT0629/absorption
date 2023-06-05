<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!doctype html>
<html lang="ko">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>쪽지알림</title>
    <script src="https://code.jquery.com/jquery-1.11.3.js"></script>
    <script src="${path}/resources/js/mypage/message.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-aFq/bzH65dt+w6FI2ooMVUpc+21e0SRygnTpmBvdBgSdnuTN7QbdgL+OapgHtvPp" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/js/bootstrap.bundle.min.js" integrity="sha384-qKXV1j0HvMUeCBQ+QVp7JcfGl760yU08IQ+GpUo5hlbpg51QRiuqHAJz8+BrxE/N" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="${path}/resources/css/mypage/message.css" >
    
  </head>

  <body>
     
    <div class="warp">
	<%@ include file="../../fix/header.jsp" %>

      <nav class="mnb">
        <ul>
          <li><a href="<c:url value="/mypage/myreview" />" class="mreview">기록</a></li>
          <li><a href="<c:url value="/mypage/wishlist" />">찜목록</a></li>
          <li><a href="<c:url value="/mypage/watched" />">봤어요</a></li>
          <li><a href="<c:url value="/mypage/alarm" />">알림함</a></li>
          <li><a href="<c:url value="/mypage/message" />" style="color: #33ff33">쪽지함</a></li>
        </ul>
      </nav>
        
      <div class="sec00">

        <button type="button" id="btn-recv">받은 쪽지</button>
        <button type="button" id="btn-send">보낸 쪽지</button>

      </div>

      <div class="sec01">
        
        <div class="sec-left">
        	
        	<div class="left-top">
	            <table>
	                <tr>
	                    <th class="msg-img">프로필</th>
	                    <th class="msg-name" style="width: 188px; padding-right: 20px;">이름</th>
	                    <th class="msg-content">내용</th>
	                    <th class="msg-time">시간</th>
	                    <th class="msg-del">삭제</th>
	                </tr>
	            </table>
            </div>
            <div class="left-bottom">
	            <table>
					<c:if test="${totalCnt == null || totalCnt == 0}">
						<div style="display: flex; margin-top: 20px; justify-content: center; color: #8f8f8f;">보관된 쪽지가 없습니다.</div>
					</c:if>
		            <c:forEach var="messageDTO" items="${list }">
		              <tr class="title-line" style="font-weight: 200">
  		              	<td class="msg-no" style="display: none; ">${messageDTO.message_no}</td>
		                <td class="msg-img">픞</td>
		                <td class="msg-nicknm">${messageDTO.user_nicknm }</td>
		                <!-- c:if문 추가 보낸/받은 구분 -->
		                <td class="msg-name" style="display: none; ">${messageDTO.send_user_no }</td>
		                
		                <td class="msg-content" style="cursor: pointer;">${messageDTO.content }</td>
		                <td class="msg-time"><fmt:formatDate value="${messageDTO.send_date}" pattern="yyyy-MM-dd HH:mm" type="date" /></td>
		                <td class="msg-del"><button class="delBtn" style="border: none; color: red;"><i class="fas fa-times"></i></button></td>
		              </tr>
		            </c:forEach>
				</table>
		    </div>
			<br />
			<div class="paging-container">
				<div class="paging">
						<c:if test="${totalCnt != null || totalCnt != 0 }">
							<c:if test="${mpr.showPrev }">
								<a class="page" href="<c:url value="${mpr.msc.getQueryString(mpr.beginPage-1) }" />">&lt;</a>
							</c:if>
							<c:forEach var="i" begin="${mpr.beginPage }" end="${mpr.endPage }">
								<a class="page" href="<c:url value="${mpr.msc.getQueryString(i) }" />">${i }</a>
							</c:forEach>
							<c:if test="${mpr.showNext }">
								<a class="page" href="<c:url value="${mpr.msc.getQueryString(mpr.endPage+1) }" />">&gt;</a>
							</c:if>
						</c:if>
				</div>
			</div>

        </div>

        <div class="sec-right">
        	<input name="msgno" type="hidden" value="" />
        	<input name="sendno" type="hidden" value="" />
            <div class="msg-nick" id="msgNick">${messageDTO.user_nicknm }</div>
	        <div class="msg-view-content">${messageDTO.content }</div>
	        <button type="button" id="msg-write" class="msg-write-btn" >답장</button>
        </div>

      </div>
	  
    </div>
  </body>
</html>