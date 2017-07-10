<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Join Form</title>
<link rel="stylesheet" type="text/css" href="css/common.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="js/common.js"></script>
<script src="js/date.js"></script>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" type="text/css" />  
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>  
<script type="text/javascript">
$(function () {
	$("form[name='f1']").submit(function() {
		
		$(".error").css("display","none");
		$(".error2").css("display","none");
	
		if(checkInputEmpty($("input[name]"))==false || checkInputEmpty($("textarea"))==false){
			checkInputEmpty($("textarea"))
			return false; //서버로 가지 못하게 리턴
		}
		
		
	});
});
		
		$(function () {
			$("form[name='f1']").submit(function() {
				var error = $("#dateerror");
				if(checkDate($("input[name='startday']").val(),$("input[name='endday']").val())==false){
					error.css("display","block");
					return false; //서버로 가지 못하게 리턴
				}
		});
	});

$(function() {
    $(".Datepicker").datepicker({
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
<jsp:include page="header.jsp"></jsp:include>
<section>

	<form action="projectinsert.do" method="post" name="f1">
		<fieldset>
			<p>
				<label>프로젝트 이름:</label> <input type="text" name="name"> 
				<span class="error">이름을 입력하세요</span>
			</p>
			<p>
				<label>프로젝트내용:</label> <textarea rows="20" cols="100" name="content"></textarea>
			    <span class="error">내용을 입력하세요</span>
			</p>
			<p>
				<label>시작날짜:</label> <input type=text name="startday" class="Datepicker"> 
				<span class="error">시작날짜를 입력하세요</span>
			</p>
			<p>
				<label>종료날짜:</label> <input type=text  name="endday" class="Datepicker"> 
				<span class="error">종료날짜를 입력하세요</span>
			</p>
				<span id="dateerror">날짜가 틀렸습니다</span>
			<p>
			<select name="select">
				<option>준비</option>
				<option>진행중</option>
				<option>종료</option>
				<option>보류</option>
			</select>
			</p>
			<p>
				<input type="submit" value="안되노"><input type="reset" value="취소" onClick="history.back()">
			</p>
		</fieldset>
	</form>
	
	</section>
	
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>