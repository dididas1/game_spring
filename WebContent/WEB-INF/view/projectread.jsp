<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script type="text/javascript">
   $(function(){
      $("#del").click(function(e) {
         e.preventDefault(); //링크막기
         
         var number = ${project.pNo };   //브라우저에서는 서버언어 사용 못함
         var result = confirm("정말 삭제하시겠습니까?");
         if(result == true){
            location.href = "delete.do?no="+number;
         }
      });
   });
</script>
<link rel="stylesheet" type="text/css" href="css/common.css">
<meta charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<section>

<table id="readtable" border="1">
	<tr>
		<th>프로젝트 이름</th>
		<td>${project.pName }</td>
	</tr>
	<tr>
		<th>프로젝트 내용</th>
		<td>${project.pContent }</td>
	</tr>
	<tr>
		<th>시작날짜</th>
		<td><fmt:formatDate value="${project.startDay}" pattern="yyyy-MM-dd"/></td>
	</tr>
	<tr>
		<th>종료날짜</th>
		<td><fmt:formatDate value="${project.endDay}" pattern="yyyy-MM-dd"/></td>
	</tr>
	<tr>
		<th>상태</th>
		<td>${project.progress }</td>
	</tr>
</table>
<a href="update.do?no=${project.pNo }">[수정]</a> <a href="delete.do" id="del">[삭제]</a> <a href="projectlist.do">[돌아가기]</a> 
</section>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>