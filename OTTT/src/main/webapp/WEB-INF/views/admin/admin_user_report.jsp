<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<c:set var="loginout" value="${sessionScope.id == null ? 'logout' : 'login'}" />
<c:set var="loginoutlink" value="${sessionScope.id==null ? '/login' : '/mypage'}" />
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>관리자페이지</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-aFq/bzH65dt+w6FI2ooMVUpc+21e0SRygnTpmBvdBgSdnuTN7QbdgL+OapgHtvPp" crossorigin="anonymous">
	<link rel="stylesheet" href="${path}/resources/css/admin/admin_user.css" >
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/js/bootstrap.bundle.min.js" integrity="sha384-qKXV1j0HvMUeCBQ+QVp7JcfGl760yU08IQ+GpUo5hlbpg51QRiuqHAJz8+BrxE/N" crossorigin="anonymous"></script>
	<script src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
</head>
<body>
	<div class="wrap">
	
	<%@ include file="../fix/header.jsp" %>
		<c:if test="${sessionScope.id == null}">
			<h1 class="NoAdmin">관리자 권한이 없습니다.</h1>			
		</c:if>
		<c:if test="${sessionScope.id != null}">
		<section class="sec01">
			<div class="leftBox">
				<div class="userManagement">
					회원 관리
					<ul>
						<li><a href='<c:url value="/admin"/>'>- 회원정보</a></li>
					</ul>
				</div>
				<div class="reportManagement">
					신고 관리
					<ul>
						<li><a href='<c:url value="/admin/user"/>'>- 유저 신고</a></li>
						<li><a href='<c:url value="/admin/review"/>'>- 리뷰 신고</a></li>
						<li><a href='<c:url value="/admin/article"/>'>- 게시글 신고</a></li>
						<li><a href='<c:url value="/admin/comment"/>'>- 댓글 신고</a></li>
					</ul>
				</div>
			</div>
			<div class="mainBox">
				<h3 class="mainTitle">유저신고 목록</h3>
				<div class="mainView">
					<div>
						<ul class="userCategory">
							<li>회원번호</li>
							<li>아이디</li>
							<li>닉네임</li>
							<li>리뷰수</li>
							<li>게시글수</li>
							<li>댓글수</li>
							<li>누적신고수</li>
							<li>정지유무</li>
						</ul>
					</div>
					<div>
						<c:forEach var="UserDTO" items="${userReportList}">
							<div class="userInfo">
								<div class="user_no">${UserDTO.user_no}</div>
								<div class="user_id"><a href='<c:url value="/profile?user=${UserDTO.user_nicknm}"/>'>${UserDTO.user_id}</a></div>
								<div class="user_nicknm"><a href='<c:url value="/profile?user=${UserDTO.user_nicknm}"/>'>${UserDTO.user_nicknm}</a></div>
								<div class="review_count">${UserDTO.review_count}</div>
								<div class="post_count">${UserDTO.article_count}</div>
								<div class="reply_count">${UserDTO.comment_count}</div>
								<div class="report_count">${UserDTO.report_count}</div>
								<c:if test="${UserDTO.block_yn == true}">
									<div class="block_y">Y</div>
								</c:if>
								<c:if test="${UserDTO.block_yn == false}">
									<div class="block_n">N</div>
								</c:if>
								<form class="deleteForm">
									<input type="hidden" name="user_no" value="${UserDTO.user_no}">   								
								</form>
								<button class="delete">정지</button>								
							</div>
						</c:forEach>
						<c:if test="${totalCnt != null || totalCnt != 0}">
						<!-- 페이지 번호 배너-->
				        <div class="page-num" style="margin-top: 20px;">
				          <nav aria-label="Page navigation example" class="d-flex flex-row justify-content-center">
				            <ul class="pagination">
				            <c:if test="${pr.showPrev}">
					            <li class="page-item">
					                <a class="page-link" href='<c:url value="/admin${pr.sc.getQueryString(pr.beginPage-1)}" />' aria-label="Previous">
					                  <span aria-hidden="true">&laquo;</span>
					                </a>
					              </li>
				            </c:if>
				            <c:forEach var="i" begin="${pr.beginPage }" end="${pr.endPage }">
				            	<li class="page-item"><a class="page-link" href='<c:url value="/admin${pr.sc.getQueryString(i)}" />'>${i}</a></li>
				            </c:forEach>
				              <c:if test="${pr.showNext}">
					              <li class="page-item">
					                <a class="page-link" href='<c:url value="/admin${pr.sc.getQueryString(pr.endPage-1)}" />' aria-label="Next">
					                  <span aria-hidden="true">&raquo;</span>
					                </a>
					              </li>
				              </c:if>		              
				            </ul>
				          </nav>
				        </div>
					</c:if>
					</div>
				</div>
			</div>	
		</section>
		</c:if>
	</div>
			<!-- Modal -->
           <div class="modal fade" id="Modal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true" style="z-index: 9999;">
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
	
	<script type="text/javascript">
	$(document).ready(function() {
		  $(".delete").on("click", function() {
			var user_no = $(this).closest('.userInfo').find('.deleteForm input[name="user_no"]').val();
		    let modalBody = $(".body");
		    modalBody.html("유저를 정지하시겠습니까?");
		    $('#Modal').modal('show');

		    // 확인 버튼 클릭 시 회원 정지 실행
		    $('.btn-secondary').on('click', function() {		      
		      $.ajax({
		        url: "<c:url value='/admin/user/block' />",
		        type: "POST",
		        data: { user_no: user_no },
		        success: function(response) {
		          location.reload();	
		          if (response === "Block_OK") {
		            $(".body").html("정지가 완료되었습니다.");
		            $('#Modal').modal('show');
		          } else if (response === "Block_ERR") {
		            $(".body").html("다시 시도해 주세요.");
		            $('#Modal').modal('show');
		          }
		        },
		        error: function() {
		          $(".body").html("다시 시도해 주세요.");
		          $('#Modal').modal('show');
		        }
		      });
		    });
		  });
		});
	</script>
</body>
</html>