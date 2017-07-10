<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE>
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
.row {
	margin:0 auto;
	width: 960px;
}
body{
	width: 100%;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="row">
		<c:forEach var="item" items="${list }">
			<div class="col-md-4">
				<div class="thumbnail">
					<input type="hidden" name="vo" value="${item }">
					<a href="gameDetailPage?gno=${item.gNo }"> <img src="displayFile?filename=${item.titleImg }">
						<div class="caption">
							<p>
								<b>제목:</b>${item.title}<br>가격:${item.salePrice }<br>기종:${item.platform}
							</p>
						</div>
					</a>
				</div>
			</div>
		</c:forEach>
	</div>

	<div class="box-footer">
		<div class="text-center">
			<ul class="pagination">
				<c:if test="${pageMaker.prev }">
					<li><a
						href="gameListPage?page=${pageMaker.startPage -1}">&laquo;</a>
				</c:if>
				<c:forEach begin="${pageMaker.startPage }"
					end="${pageMaker.endPage }" var="idx">
					<li ${pageMaker.criteria.page==idx? 'class =active' :'' }><a
						href="gameListPage?page=${idx }">${idx }</a></li>
				</c:forEach>
				<c:if test="${pageMaker.next }">
					<li><a
						href="gameListPage?page=${pageMaker.endPage+1 }">&raquo;</a>
				</c:if>
			</ul>
		</div>
	</div>
</body>
</html>