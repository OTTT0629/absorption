$(document).ready(function() {
	//글자수제한
	$(".write textarea").keyup(function(){
	  var content = $(this).val()
	  $(".write .count span").html(content.length)
	  if (content.length > 1000){
		alert("최대 1000자까지 입력 가능합니다.")
	    $(this).val(content.substring(0, 1000))
	    $(".write .count span").html(1000)
	  }
	});
	
	//이름 넘기기
	var sendUserNo = getParameterByName("user_nicknm") + " 님"
	$(".nickname").text(sendUserNo)
	
	//쪽지 전송하기
	$("#writeBtn").on("click", function() {	//글작성 버튼 눌렀을 때 일어나는 기능 함수
		let form = $("#form")
		form.attr("action", "<c:url value='/messagewindow/open' />")
		form.attr("method", "post")
		
	//제목 또는 내용이 채워졌는지 확인해야함
		if(formCheck()) {
			form.submit()
		}
	})
	let formCheck = function() {
		let form = document.getElementById("form")
		
		if(form.content.value == "") {
			alert("내용을 입력하세요")
			form.content.focus()
			return false
		}
		return true
	}
});

//이름 가져오기
function getParameterByName(name) {
  name = name.replace(/[\[\]]/g, "\\$&")
  var regex = new RegExp("[?&]" + name + "(=([^&#]*)|&|#|$)")
  var results = regex.exec(window.location.href)
  if (!results) return null
  if (!results[2]) return ''
  return decodeURIComponent(results[2].replace(/\+/g, " "))
}