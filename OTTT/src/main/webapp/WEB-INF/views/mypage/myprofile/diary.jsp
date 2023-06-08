<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>나의 다이어리</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-aFq/bzH65dt+w6FI2ooMVUpc+21e0SRygnTpmBvdBgSdnuTN7QbdgL+OapgHtvPp" crossorigin="anonymous">
    <link rel="stylesheet" href="${path}/resources/css/mypage/diary.css" >
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/js/bootstrap.bundle.min.js" integrity="sha384-qKXV1j0HvMUeCBQ+QVp7JcfGl760yU08IQ+GpUo5hlbpg51QRiuqHAJz8+BrxE/N" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
</head>
<body>
	<div class="wrap">
		<%@ include file="../../fix/header.jsp" %>

		<section class="sec01">
			<nav class="mnb">
				<ul>
					<li>
						<a href="<c:url value="/mypage/myreview" />" class="mreview">기록</a>
					</li>
					<li>
					    <a href="<c:url value="/mypage/wishlist" />">찜목록</a>
					</li>
					<li>
					    <a href="<c:url value="/mypage/watched" />">봤어요</a>
					</li>
					<li>
					  	<a href="<c:url value="/mypage/alarm" />">알림함</a>
					</li>
					<li>
					  	<a href="<c:url value="/mypage/message" />">쪽지함</a>
					</li>
				</ul>
            </nav>
		</section>

		<section class="sec02">
			<div class="main">
				<div class="blank"></div>
				<form action="" id="diary-main">
					<input type="hidden" name="content_no" value="${myDiaryDTO.content_no }"/>
					<input type="hidden" name="user_no" value="${myDiaryDTO.user_no }"/>
					<div class="l-main">
						<img class="poster" src="${myDiaryDTO.thumbnail }" >
						<input type="hidden" name="thumbnail" value="${myDiaryDTO.thumbnail }"/>
					</div>
					
					<div class="c-main">
						<div class="c-title">
							<input class="diary-title" readonly="readonly" name="content_nm" type="text"
								value="${myDiaryDTO.content_nm }" />
						</div>
						<div class="diary">
							<label for="story"></label>
							<textarea id="story" name="mydiary_content"
								${mode=="new" ? "" : "readonly='readonly'" }
							 spellcheck="false">${myDiaryDTO.mydiary_content }</textarea>
						</div>
					</div>
					
					<div class="r-main">
						<div class="rTop">
							<fieldset class="pnp-button">
								<input type="radio" id="pub"
								 name="public_yn_cd" value="1"
								 ${myDiaryDTO.public_yn_cd.toString()=='1' ? "checked" : "" }>
								<label for="pub">전체 공개</label><br>
								
			                    <input type="radio" id="Npub"
			                    name="public_yn_cd" value="0"
			                    ${myDiaryDTO.public_yn_cd.toString()=='0' ? "checked" : "" }>
			                    <label for="Npub">비공개</label><br>
	
			                    <input type="radio" id="Fpub"
			                    name="public_yn_cd" value="2"
			                    ${myDiaryDTO.public_yn_cd.toString()=='2' ? "checked" : "" }>
			                    <label for="Fpub">팔로워</label><br>
	                		</fieldset>
						</div>
						
						<div class="rBot">
							<c:if test="${sessionScope.user_no eq myDiaryDTO.user_no}">
								<button id="writeBtn" class="btn-write" type="button" >수정</button>
								&nbsp;/&nbsp;
								<button id="removeBtn" class="btn-write" type="button" >삭제</button>
							</c:if>
						</div>
					</div>
				</form>
			</div>
		</section>
	</div>
	 
	<script type="text/javascript">
	 	$(document).ready(function() {

	 		$('#writeBtn').on('click', function() {
	 			let form = $('#diary-main')
	 			
	 			let isReadonly = $("textarea[name=mydiary_content]").attr('readonly')
	 			
	 			//수정상태 변환
	 			if(isReadonly == 'readonly') {
	 				$("textarea[name=mydiary_content]").attr('readonly', false)
	 				$("#writeBtn").html('등록')
	 				$("#removeBtn").html('취소')
	 				return;
	 			}
	 			
	 			form.attr("action", "<c:url value='/mypage/mydiary/modify${searchItem.string}' />")
	 			form.attr("method", "post")
	 			
	 			
	 			if(formchk()) {
	 				form.submit()
	 			}	 			
				
			})
			
			$('#removeBtn').on('click', function() {
				
				let form = $('#diary-main')	 			
	 			let isReadonly = $("textarea[name=mydiary_content]").attr('readonly')
	 			
	 			if(isReadonly != 'readonly') {
	 				form.attr("action", "<c:url value='/mypage/mydiary/diary${searchItem.string}' />")
		 			form.attr("method", "post")
		 			form.submit()
		 			
		 			return false;
	 			}			
				
			})
			
			
			let formchk = function() {
	 			let form = document.getElementById('diary-main')
	 			
	 			if(form.story.value == '') {
	 				alert("내용을 입력해주세요")
	 				form.story.focus();
	 				return false;
	 			}
	 			
	 			return true;				
			}
	 		
			
		})	 
	</script>
	 
	<script type="text/javascript">
    	let msg = "${msg}"
    	if(msg == "WRT_ERR") alert("다이어리 등록에 실패했습니다. 다시 시도해 주세요")
    	if(msg == "MOD_ERR") alert("다이어리 수정에 실패했습니다. 다시 시도해 주세요")
    </script>
	 

</body>
</html>