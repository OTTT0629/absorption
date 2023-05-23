<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">
<head>
  	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>게시판</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-aFq/bzH65dt+w6FI2ooMVUpc+21e0SRygnTpmBvdBgSdnuTN7QbdgL+OapgHtvPp" crossorigin="anonymous">
    <link rel="stylesheet" href="${path}/resources/css/mypage/myprofile.css" >
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/js/bootstrap.bundle.min.js" integrity="sha384-qKXV1j0HvMUeCBQ+QVp7JcfGl760yU08IQ+GpUo5hlbpg51QRiuqHAJz8+BrxE/N" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
</head>
<body>
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
		
		<script type="text/javascript">
			$(document).ready(function() {
				$(".done").on("click", function() {
 					if (!confirm("정말 바꾸시겠습니까?")) return;
					
					let form = $("#form")
					form.attr("action", "<c:url value='/mypage/setting/myprofile ' />")
					form.attr("method", "post")
					form.submit()
					
					/*$(".body").html("수정이 완료되었습니다.");
			        $('#Modal').modal('show'); */
					
				})
				
				$(".cancleBtn").on("click", function() {
					location.href = "<c:url value ='/mypage/setting' />"
				})
				
				$(".byebye").on("click", function() {
					if (!confirm("정말 탈퇴할거야??")) return;
					
					let form = $("#form")
					form.attr("action", "<c:url value='/mypage/setting/goodbye ' />")
					form.attr("method", "post")
					form.submit()
				})				
				
			})
		</script>
		
		<script type="text/javascript">
			let msg = "${msg}"
			if(msg == "MOD_OK") alert("닉네임 변경에 성공했습니다.")
    		if(msg == "MOD_ERR") alert("닉네임 변경에 실패했습니다. 다시 시도해 주세요")
    	</script>
		
		<section class="sec01">
			<form action="" id="form" class="info-main">
			<div class="profile-a">
				<img src="${path}/resources/images/img/라플.jpg" class ="profile-img" alt="프로필">
				<div class="cancle">
					<button class="cancleBtn" type="button">취소</button>
				</div>				
			</div>
			
			<div class="profile-b">
				<div class="nick">
					<input type="text" name = "user_nicknm" id="nickname" class="input-field" placeholder="${userDTO.user_nicknm }"/>
				</div>
				
	            <div class="user_img">
	            	<label class="input-file-button" for="input-file">프로필 이미지</label>
					<input type="file" name=user_img id="input-file" style= "display:none" />	            	
	            </div>
	            
	            <div class="skin">
	            	<a href="#">스킨 변경</a>
	            </div>
	
	            <button class="done" type="button">확인</button>
			</div>
			</form>
		</section>
		
		<!-- Modal -->
           <div class="modal fade" id="Modal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
             <div class="modal-dialog modal-dialog-centered">
               <div class="modal-content">
                 <div class="modal-header">
                   <h1 class="modal-title fs-5" id="exampleModalLabel">알림</h1>
                   <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                 </div>
                 <div class="modal-body body">
                 </div>
                 <div class="modal-footer">
                   <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">확인</button>
                 </div>
               </div>
             </div>
           </div>
		

    	
	</div>


	</body>
</html>