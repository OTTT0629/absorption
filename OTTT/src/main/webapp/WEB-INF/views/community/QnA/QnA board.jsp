<%@page import="org.springframework.web.context.annotation.SessionScope"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>  
<c:set var="loginout" value="${sessionScope.id == null ? 'logout' : 'login'}" />
<c:set var="loginoutlink" value="${sessionScope.id==null ? '/login' : '/mypage'}" /> 
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>QnA</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-aFq/bzH65dt+w6FI2ooMVUpc+21e0SRygnTpmBvdBgSdnuTN7QbdgL+OapgHtvPp" crossorigin="anonymous">
    <link rel="stylesheet" href="${path}/resources/css/community/QnA/QnA board.css" >
    <script type="text/javascript" src="${path}/resources/js/community/main.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/js/bootstrap.bundle.min.js" integrity="sha384-qKXV1j0HvMUeCBQ+QVp7JcfGl760yU08IQ+GpUo5hlbpg51QRiuqHAJz8+BrxE/N" crossorigin="anonymous"></script>
    <style type="text/css">
    	input{
    		border: none;
    		outline: none;
    		background-color: #202020;
    		color: #fff;
    		width: 100%;
    		height: 100%;
    	}
    	
    	input[name='article_title']{
    		font-size: 26px;
    	}
    	
    	

/* 모달 */
.modal-content{
    background-color: #202020;
}

.modal-body{
    font-size: 26px;
    text-align: center;
    border: 1px solid #fff;
}

.modal-header{
    border: 1px solid #fff;
}

.modal-footer{
    border: 1px solid #fff;
    display: flex;
    justify-content: flex-end;
}
 
.modi-del{
	display: flex;
    justify-content: flex-end;
}


.qa-main p{
    display: flex;
    justify-content: flex-end;
    font-weight: bold;
}

.btn{
    color: #fff;
    background-color: transparent;
    border-style: none;
    border-color: #fff; 
    font-size: 23px; 
    text-decoration: none;
}


.btn:hover{
    border-color: #33FF33;
    background-color: transparent;
    border-style: solid;
    color: #33FF33; 
}

/* 글목록 배너 */
.title-region{
    position: relative;
    margin: 20px 0;
}

.title-mainline{
    width: 1100px;
    height: 50px;
    border-bottom: 2.5px solid #fff;
    margin: 0 auto;
}

.title-mainline span{
    font-size: 23px;
    padding: 10px;
}

.title-line{
    width: 1100px;
    height: 500px;
    font-size: 20px;
    padding: 10px 0;
    border-bottom: 1.5px solid #fff;
    margin: 0 auto;
}

.qa-main{
    width: 1200px;
    height: 100%;
    margin: 0 auto;
    /* border: 1px solid red; */
}
    </style>
  </head>

<!--  body  --------------------->
  <body style="background-color: #202020;">
     
    <div class="wrap">
    	<%@ include file="../../fix/header.jsp" %>

        <div id="line-1" >
          <%@ include file="../../fix/nav.jsp" %>
        </div>

		<script type="text/javascript">
		$(document).ready(function() {
			let admin = '${userDTO.admin}'
			let article_no = $("input[name=article_no]").val()
						
			$("#modifyBtn").on("click", function() {
				let form = $("#form")
				let isReadonly = $("input[name=article_title]").attr('readonly')
				
				if(isReadonly=='readonly'){
					$("input[name=article_title]").attr('readonly', false)
					$("textarea").attr('readonly', false)
					$("#modi").html("등록")
					$("#del").html("취소")
					return
				}
				
				form.attr("action", "<c:url value='/community/QnA/modify${searchItem.queryString}' />")
				form.attr("method", "post")
				
				if(formCheck()){
					form.submit()
				}
			})
			
			$("#del").on("click", function() {
				if(!$("input[name=article_title]").attr('readonly')){
					let form = $("#form")
					form.attr("action", "<c:url value='/community/QnA/read${searchItem.queryString}' />")
					form.attr("method", "get")
					form.submit()
					return
				}
			})
			
			$("#removeBtn").on("click", function() {
				let form = $("#form")
				form.attr("action", "<c:url value='/community/QnA/remove${searchItem.queryString}' />")
				form.attr("method", "post")
				form.submit()
			})
			
			$("#listBtn").on("click", function() {
				location.href="<c:url value='/community/QnA${searchItem.queryString}' />"
			})
			
			$("#writeBtn").on("click", function() {
				let form = $("#form")
				form.attr("action", "<c:url value='/community/QnA/write' />")
				form.attr("method", "post")
				if(formCheck()){form.submit()}
			})
			
			$("#sendBtn").click(function() {
				let cmt_no = $(this).attr("data-cmt_no")
				let cmt_content = $("textarea[name=cmt_content]").val()
				
				if(cmt_content.trim()==''){
					$(".body").html("댓글을 입력해 주세요.")
		   	    	$('#Modal').modal('show');
					$("textarea[name=cmt_content]").focus()
					return
				}
				
				$.ajax({
					type: 'post',
					url: '/community/QnA/QnAcomments?article_no='+article_no,
					headers: {"content-type":"application/json"},
					data: JSON.stringify({article_no:article_no, cmt_content:cmt_content}),
					success: function(result){
						$(".body").html("댓글이 등록되었습니다.")
			   	    	$('#Modal').modal('show');
						$("textarea[name=cmt_content]").val('')
						showList(article_no)
					},
					error: function() {
						$(".body").html("댓글등록에 실패했습니다. 다시 시도해주세요.")
			   	    	$('#Modal').modal('show');
					}
				})
			})			
			
			let formCheck = function() {
				let form = document.getElementById("form")
				
				if(form.article_title.value==""){
					$(".body").html("제목을 입력해 주세요.")
		   	    	$('#Modal').modal('show');
					form.article_title.focus()
					return false
				}
				
				if(form.article_content.value==""){
					$(".body").html("내용을 입력해 주세요.")
		   	    	$('#Modal').modal('show');
					form.article_content.focus()
					return false
				}
				return true
			}
			
			let showList = function(article_no){
				$.ajax({
					type: 'GET',
					url: '/community/QnA/QnAcomments?article_no='+article_no,
					success: function(result) {
						if(result && result.length > 0){
							$("#commentList").html(toHtml(result))
						}							
						else{
							let tmp = '<div style="margin-bottom: 100px;"><div style="margin-left: 55px; margin-bottom: 10px; font-size:20px;">댓글</div>';
					          tmp += "<div style='margin-left: 55px; margin-bottom: 10px; font-size:16px;'>작성된 댓글이 없습니다.</div>";
					        $("#commentList").html(tmp+'</div>');
						}
							
					},
					error: function() {alter("error")}
				})
			}
			
			let toHtml = function(comments) {
				let tmp = '<div style="margin-bottom: 100px;"><div style="margin-left: 55px; margin-bottom: 10px; font-size:20px;">댓글</div>'
					comments.forEach(function(comment) {
					    tmp += "<div class='comment_show'>";
					    tmp += '<div class="pro-dan">';
					    tmp += '<div class="cmt" style="display: flex;" data-cmt_no=' + comment.cmt_no;
					    tmp += ' data-article_no=' + comment.article_no + '>';
					    tmp += '<img class="profile" src="${path}/resources/images/icon/user01.png" alt="profile" >';
					    tmp += '<div class="nickname commenter">관리자</div>';
					    tmp += '</div>';
					    tmp += '<div class="btn_warning_div">';
					    if (admin == 'Y' && admin != null) {
					      tmp += '<button class="btn modBtn" style="text-align: center; width: 56px; height: 35px; font-size: 16px;">수정</button>';
					      tmp += '<button class="btn delBtn" style="text-align: center; width: 56px; height: 35px; font-size: 16px;">삭제</button>';
					    } else {
					      tmp += '<button class="btn modBtn" style="text-align: center; width: 56px; height: 35px; font-size: 16px; display: none;">수정</button>';
					      tmp += '<button class="btn delBtn" style="text-align: center; width: 56px; height: 35px; font-size: 16px; display: none;">삭제</button>';
					    }
					    tmp += '</div>';
					    tmp += '</div>';
					    tmp += '<div class="comment comment_write_box" name="cmt_content" ><textarea name="content-area" readonly = "readonly" style="background-color: #202020; width: 100%; height: 100%; color: #fff; border: none; outline: none; resize:none;">'+comment.cmt_content+'</textarea></div>';
					    tmp += '</div>';
					  });
					  return tmp + '</div>';
			}
			showList(article_no)
			
			
			
			
			$("#commentList").on("click", ".delBtn",function(){
				//alert("삭제버튼 클릭")
				let cmt_no = $(this).closest('.comment_show').find('.cmt').attr('data-cmt_no')
				let article_no = $(this).closest('.comment_show').find('.cmt').attr('data-article_no')
				
				if($(this).closest('.comment_show').find("textarea[name=content-area]").attr('readonly') != 'readonly'){
					showList(article_no)
					return
				}
				$.ajax({
					type: 'DELETE',							//요청메서드
					url: '/community/QnA/QnAcomments/' + cmt_no + '?article_no=' + article_no,	//요청URI
					success: function(result) {				//서버로부터 응답이 도착하면 호출될 함수
						$('#Modal').modal('show')	
						$(".body").html("삭제되었습니다.");//result는 서버가 전송한 데이터
						showList(article_no)
					},
					error: function() {
						$('#Modal').modal('show')	
						$(".body").html("삭제되지 않았습니다. 다시 시도해주세요.") 
						}	//에러가 발생했을 때 호출될 함수
				})
			})
			
			$("#commentList").on("click", ".modBtn", function() {
				let cmt_no = $(this).closest('.comment_show').find('.cmt').attr('data-cmt_no')
				let cmt_content = $(this).closest('.comment_show').find("textarea[name=content-area]").val()

				if($(this).closest('.comment_show').find("textarea[name=content-area]").attr('readonly') == 'readonly'){
					$(this).closest('.comment_show').find("textarea[name=content-area]").attr('readonly', false)
					$(this).closest(".modBtn").html("등록")
					$(this).closest('.comment_show').find(".delBtn").html("취소")
					return
				}
				
				if(cmt_content.trim()==''){
					$(".body").html("내용을 입력해 주세요.")
		   	    	$('#Modal').modal('show');
					$("div[name=cmt_content]").focus()
					return
				}
				
				$.ajax({
					type: 'PATCH',
					url: '/community/QnA/QnAcomments/'+cmt_no,
					headers: {"content-type":"application/json"},
					data: JSON.stringify({cmt_no:cmt_no, cmt_content:cmt_content}),
					success: function(result) {
						$(".body").html("수정되었습니다.")
			   	    	$('#Modal').modal('show')
						showList(article_no)
					},
					error: function() {
						$(".body").html("댓글수정에 실패했습니다. 다시 시도해주세요.")
			   	    	$('#Modal').modal('show');
					}
				})
			})
		})
	</script>
	
	
   	<script type="text/javascript">
	   	$(document).ready(function() {
	   	    let msg = "${msg}";
	   	    if(msg == 'MOD_OK') {
	   	        $(".body").html("수정이 완료되었습니다.");
	   	    	$('#Modal').modal('show');
	   	    } 
	   	    if(msg == 'MOD_ERR') {
	   	        $(".body").html("수정 실패했습니다. 다시 시도해주세요.");
	   	     	$('#Modal').modal('show');
	   	    }
	   	 	if(msg == 'WRT_ERR') {
	   	        $(".body").html("글이 등록되지 않았습니다. 다시 시도해주세요.");
	   	     	$('#Modal').modal('show');
	   	    }
	   	});
   	</script>


        <!--글작성 관련 시작-->
      <div class="qa-main">

        <form action="" id="form" class="frm" method="post">
        <div class="modi-del">
			<c:if test="${mode != 'new'}">
			<!-- Button trigger modal -->
	        <button type="button" class="btn btn-secondary" id="modi" data-bs-toggle="modal" data-bs-target="#exampleModal">
	          수정
	        </button>
	 
	        <!-- Modal -->
	        <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
	          <div class="modal-dialog modal-dialog-centered">
	            <div class="modal-content">
	              <div class="modal-header">
	                <h1 class="modal-title fs-5" id="exampleModalLabel">알림</h1>
	                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
	              </div>
	              <div class="modal-body" id="modal-bady1">
	                수정하시겠습니까?
	              </div>
	              <div class="modal-footer">
	                <button type="button" class="btn" data-bs-dismiss="modal" id="modifyBtn">Yes</button>
	                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">No</button>
	              </div>
	            </div>
	          </div>
	        </div>
	
	        <!-- Button trigger modal -->
	        <button type="button" class="btn btn-secondary" id="del" data-bs-toggle="modal" data-bs-target="#exampleModa2">
	          삭제
	        </button>
	
	        <!-- Modal -->
	        <div class="modal fade" id="exampleModa2" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
	          <div class="modal-dialog modal-dialog-centered">
	            <div class="modal-content">
	              <div class="modal-header">
	                <h1 class="modal-title fs-5" id="exampleModalLabe2">알림</h1>
	                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
	              </div>
	              <div class="modal-body">
	                삭제하시겠습니까?
	              </div>
	              <div class="modal-footer">
	                <button type="button" class="btn btn-primary"  data-toggle="modal" id="removeBtn">Yes</button>
	                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">No</button>
	              </div>
	            </div>
	          </div>
	        </div> 
			</c:if>
          
       <c:if test="${mode == 'new'}">
	          <!-- Button trigger modal -->
	        <button type="button" class="btn btn-secondary" id="modi" data-bs-toggle="modal" data-bs-target="#exampleModal">
	          등록
	        </button>
	 
	        <!-- Modal -->
	        <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
	          <div class="modal-dialog modal-dialog-centered">
	            <div class="modal-content">
	              <div class="modal-header">
	                <h1 class="modal-title fs-5" id="exampleModalLabel">알림</h1>
	                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
	              </div>
	              <div class="modal-body" id="modal-bady1">
	                등록하시겠습니까?
	              </div>
	              <div class="modal-footer">
	                <button type="button" class="btn" data-bs-dismiss="modal" id="writeBtn">Yes</button>
	                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">No</button>
	              </div>
	            </div>
	          </div>
	        </div>
       	</c:if>
      
      	<div>
	       <button type="button" class="btn btn-outline-success" id="listBtn"><i class="fa-solid fa-list" style="background-color: #202020; margin: 3px;"></i>목록</button> 
	    </div>
	    </div>
        <!-- 글목록 배너-->
        <div class="title-region">
          <div class="title-mainline">
            <input type="hidden" name="article_no" value="${articleDTO.article_no}"/>
            <div style="display: flex; justify-content: space-between;">
            	<div><input type="text" placeholder="제목을 입력해주세요." name="article_title" value="${articleDTO.article_title}" ${mode=="new" ? "" : "readonly='readonly'" } /></div>
            	<div style="font-size: 20px;"><fmt:formatDate value="${articleDTO.article_create_dt}" pattern="yyyy-MM-dd" type="date"/></div>
            </div>
            
          </div>
		 
          <div class="title-line">
            <textarea name="article_content" ${mode=="new" ? "" : "readonly='readonly'" } onkeydown="resize(this)" onkeyup="resize(this)" style="background-color: #202020; width: 100%; height: 100%; color: #fff; border: none; outline: none;" placeholder="내용을 입력해주세요.">${articleDTO.article_content}</textarea>
          </div>
          
        </div>
        </form>  
	    
	    <!--댓글-->  
		<c:if test="${sessionScope.id != null && userDTO.admin.toString() == 'Y'}">	
	    	<div class="comment_write_box" style="margin-top: 50px;">
	    	<div style="display: flex; justify-content: space-between; width: 1100px;">
		    	<div>
		    		<img class="profile" src="${path}/resources/images/icon/user01.png" alt="profile" >
	                <div class="nickname">관리자</div>
		    	</div>
	            <div>
	            	<button type="button" id="sendBtn" class="btn" style="font-size: 16px; position: relative; left: -20px;">댓글 작성</button>
	            </div>
	    	</div>
               <div>
                <textarea class="writeHere" name="cmt_content" placeholder="댓글을 입력해주세요." onkeydown="resize(this)" onkeyup="resize(this)" ></textarea>              
               </div>
            </div>	    	
		</c:if>
              	
        <div id="commentList" style="background-color: #202020;"></div>
        	       	
        

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
    </div>
  </body>
</html>