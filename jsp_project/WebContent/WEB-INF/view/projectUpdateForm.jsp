<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
	<form action="update.do" method="post" name="f1">
		<fieldset>
			<input type="hidden" name="no" value="${project.pNo }">
			<p>
				<label>프로젝트 이름:</label> <input type="text" name="name" width="200"
					value="${project.pName }"> <span class="error">이름을 입력하세요</span>
			</p>
			<p>
			<label>프로젝트내용:</label> <textarea rows="20" cols="100" name="content">${project.pContent }</textarea>
			    <span class="error">내용을 입력하세요</span>
			</p>
			<p>
				<label>시작날짜:</label> <input type="text" name="startday" value=<fmt:formatDate value="${project.startDay}" pattern="yyyy-MM-dd"/> class="Datepicker" > 
				<span class="error">시작날짜를 입력하세요</span>
			</p>
			<p>
				<label>종료날짜:</label> <input type="text"  name="endday" value=<fmt:formatDate value="${project.endDay}" pattern="yyyy-MM-dd"/> class="Datepicker"> 
				<span class="error">종료날짜를 입력하세요</span>
			</p>
			
			<p>
			
			<select name="select">
				<option <c:if test="${project.progress eq '준비' }">selected</c:if>>준비</option>
				<option <c:if test="${project.progress eq '진행중' }">selected</c:if>>진행중</option>
				<option <c:if test="${project.progress eq '종료' }">selected</c:if>>종료</option>
				<option <c:if test="${project.progress eq '보류' }">selected</c:if>>보류</option>
			</select>
			</p>
			<p>
				<input type="submit" value="저장"><input type="reset" value="취소" onClick="history.back()" >
			</p>
		</fieldset>
	</form>
</section>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>