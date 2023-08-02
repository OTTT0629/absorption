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
	<link rel="stylesheet" href="${path}/resources/css/admin/admin_review.css" >
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
					리뷰 관리
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
				<h3 class="mainTitle">리뷰신고 목록</h3>
				<div class="mainView">
					<div>
						<ul class="reviewCategory">
							<li>리뷰번호</li>
							<li>아이디</li>
							<li>닉네임</li>
							<li class="content">내용</li>
							<li class="count">누적신고수</li>
						</ul>
					</div>
					<div>
					<c:forEach var="ReviewDTO" items="${reviewList}" varStatus="status">
					    <div class="reviewInfo">
					        <div class="review_no">${ReviewDTO.review_no}</div>
					        <div class="user_id">
					            <a href='<c:url value="/profile?user=${ReviewDTO.user_nicknm}" />'>
					                ${ReviewDTO.user_id}
					            </a>
					        </div>
					        <div class="user_nicknm">
					            <a href='<c:url value="/profile?user=${ReviewDTO.user_nicknm}" />'>
					                ${ReviewDTO.user_nicknm}
					            </a>
					        </div>
					        <div class="review_content">
					            <button class="review-button" data-target="#review-popup-${status.index}">
					                ${ReviewDTO.review_content}
					            </button>
					        </div>
					        <div class="report_count">${ReviewDTO.report_count}</div>
					        <form class="reviewdelForm">
					            <input type="hidden" name="review_no" value="${ReviewDTO.review_no}">
					        </form>
					        <button class="delete">삭제</button>
					    </div>
					    <div class="review-back">1</div>
					    <div id="review-popup-${status.index}" class="popup11">
					        <label for="review-text" style="background-color: #202020;">리뷰 내용</label>
					        <textarea id="review-text" name="review_content">${ReviewDTO.review_content}</textarea>
					        <button type="button" id="cancel-review" class="cancel-review">
					            <ul>
					                <li></li>
					                <li></li>
					            </ul>
					        </button>
					    </div>
					</c:forEach>
						<c:if test="${totalCnt != null || totalCnt != 0}">
						<!-- 페이지 번호 배너-->
				        <div class="page-num" style="margin-top: 20px;">
				          <nav aria-label="Page navigation example" class="d-flex flex-row justify-content-center">
				            <ul class="pagination">
				            <c:if test="${pr.showPrev}">
					            <li class="page-item">
					                <a class="page-link" href='<c:url value="/admin/review${pr.sc.getQueryString(pr.beginPage-1)}" />' aria-label="Previous">
					                  <span aria-hidden="true">&laquo;</span>
					                </a>
					              </li>
				            </c:if>
				            <c:forEach var="i" begin="${pr.beginPage }" end="${pr.endPage }">
				            	<li class="page-item"><a class="page-link" href='<c:url value="/admin/review${pr.sc.getQueryString(i)}" />'>${i}</a></li>
				            </c:forEach>
				              <c:if test="${pr.showNext}">
					              <li class="page-item">
					                <a class="page-link" href='<c:url value="/admin/review${pr.sc.getQueryString(pr.endPage-1)}" />' aria-label="Next">
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
			var review_no = $(this).closest('.reviewInfo').find('.reviewdelForm input[name="review_no"]').val();
		    let modalBody = $(".body");
		    modalBody.html("리뷰를 삭제하시겠습니까?");
		    $('#Modal').modal('show');

		    // 확인 버튼 클릭 시 리뷰 삭제 실행
		    $('.btn-secondary').on('click', function() {		      
		      $.ajax({
		        url: "<c:url value='/admin/review/reviewDelete' />",
		        type: "POST",
		        data: { review_no: review_no },
		        success: function(response) {
		          location.reload();	
		          if (response === "DEL_OK") {
		            $(".body").html("삭제가 완료되었습니다.");
		            $('#Modal').modal('show');
		          } else if (response === "DEL_ERR") {
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
	
	<!-- 리뷰 내용 팝업 -->
	<script type="text/javascript">
	$(document).ready(function() {
		  $(".review-button").on("click", function() {
		    var target = $(this).data("target");
		    $(target).show(); // 해당하는 팝업창 열기
		  });

		  $(".cancel-review").on("click", function() {
		    $(this).closest(".popup11").hide(); // 팝업창 닫기
		  });
		});
    </script>
</body>
</html>