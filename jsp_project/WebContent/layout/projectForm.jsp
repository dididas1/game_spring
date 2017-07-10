<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/Css.css">
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<style type="text/css">
	label{
		width : 150px;
		text-align: right;
		float: left;
		margin-right: 20px;
	}
	.a1{
		padding-left: 850px;
	}
</style>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
  $( function() {
    $( "#startDate" ).datepicker({
    	dateFormat: "yy-mm-dd"    
    });
    $( "#endDate" ).datepicker({
    	dateFormat: "yy-mm-dd"    
    });  
  });
  </script>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
	<section>
		<form action="insert.do" method="post">
		<p>
			<label>프로젝트 이름 </label><input type="text" name ="name"><br><br>
		</p>
		<p>
			<label>프로젝트 내용 </label><textarea rows="20" cols="100" name= "content"></textarea><br>
		</p>
		<p>
			<label>시작 날짜</label><input type="text" name="startdate" width="200px;" id="startDate"><br>
		</p>
		<p>
			<label>종료 날짜</label><input type="text" name="enddate" width="200px;" id="endDate"><br>
		</p>
		<p>
			<label>상태</label>
			<select name="projecting">
				<option selected="selected">준비</option>
				<option>진행 중</option>
				<option>종료</option>
				<option>보류</option>
			</select><br>
		</p>
		<p class="a1">
			<input type="submit" value="저장">
			<input type="reset" value="취소">
		</p>
		
		</form>
	</section>
	<jsp:include page="footer.jsp"></jsp:include>
	
</body>
</html>