<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Join Form</title>
<link rel="stylesheet" type="text/css" href="css/common.css">
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="js/common.js"></script>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" type="text/css" />  
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>  
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>  

<script type="text/javascript">
$(function () {
	$("form[name='f1']").submit(function() {
		$(".error").css("display","none");
		$(".error2").css("display","none");
		
		if(checkInputEmpty($("input[name]"))==false){
			return false; //서버로 가지 못하게 리턴
		}
	});
})

$(function() {
    $( "#testDatepicker" ).datepicker({
    	   changeMonth: true, 
           changeYear: true,
           nextText: '다음 달',
           prevText: '이전 달' ,
           dateFormat: "yy-mm-dd"

    });
});
</script>

</head>
<body>

	<form action="join.do" method="post" name="f1">
		<fieldset>
			<p>
				<label>프로젝트 이름:</label> <input type="text" name="name" width="200"
					value=""> <span class="error">이름을 입력하세요</span>
			</p>
			<p>
				<label>프로젝트내용:</label> <textarea rows="50" cols="70" name="content"></textarea>
					 <span class="error">암호를 입력하세요</span>
			</p>
			<p>
				<label>시작날짜:</label> <input type=text name="startday" id="testDatepicker"> 
				<span class="error">시작날짜를 입력하세요</span>
			</p>
			<p>
				<label>종료날짜:</label> <input type=text name="endday" id="testDatepicker"> 
				<span class="error">종료날짜를 입력하세요</span>
			</p>
			<p>
				<input type="submit" value="저장"><input type="reset" value="취소">
			</p>
		</fieldset>
	</form>
		<p class="error2"></p>
	<c:if test="${duplicateId ==true }">
		<p class="error2">이미 사용중인 아이디입니다.</p>
	</c:if>
	<c:if test="${duplicatepass ==true }">
		<p class="error2">아이디를 확인해주세요.</p>
	</c:if>

</body>
</html>