<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src='resources/calender/js/jquery.min.js'></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<head>
<style type="text/css">
	#imgTitle{
		width: 300px;
	}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div class="row">
		<div class="col-sm-2"></div>
		<div class="col-sm-2" >
			<img src="displayTitleFile?filename=${gameVo.titleImg }" id="imgTitle"> 
		</div>
		<div class="col-sm-4">
			제목:${gameVo.title }<br> 가격:${gameVo.salePrice }<br>
			할인율:${gameVo.discount }<br> 기종:${gameVo.platform }<br>
			발매일:${gameVo.start }<br> 제작사:${gameVo.gComp }<br>
			장르:${gameVo.category }<br> 제한연령:${gameVo.saleYear }<br>
			내용:${gameVo.gContent }<br> 다운로드횟수:${gameVo.downcnt }
			
			
		</div>
		<div class="col-sm-2" ></div>
	</div>
</body>
</html>