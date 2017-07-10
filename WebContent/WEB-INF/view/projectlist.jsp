<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/common.css">
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<section>
<p id="projectinput">
<a href="projectinsert.do" >프로젝트 등록하기 </a>
</p>
<table>
		<tr>
			<th>프로젝트 이름</th>
			<th>시작날짜</th>
			<th>종료날짜</th>
			<th>상태</th>
		</tr>
	<c:forEach var="prj" items="${list }">
		<tr>
			<td><a href="read.do?no=${prj.pNo}">${prj.pName }</a></td>
			<td><fmt:formatDate value="${prj.startDay}" pattern="yyyy-MM-dd"/></td>
			<td><fmt:formatDate value="${prj.endDay}" pattern="yyyy-MM-dd"/></td>
			<td>${prj.progress }</td>
		</tr>
	</c:forEach>
</table>
</section>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>