<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form role="form" action="gameCreate" method="post" enctype="multipart/form-data">
		<div class="box-body">
			<div class="form-group">
				<label>TITLE</label> <input type="text" name="title"
					class="form-control" placeholder="Enter Title">
			</div>
			<div class="form-group">
				<label>Content</label>
				<textarea rows="5" cols="" name="gContent" class="form-control"
					placeholder="Enter Content"></textarea>
			</div>
			<div class="form-group">
				<label>Company</label> <input type="text" name="gComp"
					class="form-control" placeholder="Enter Writer">
			</div>
				<div class="form-group">
				<label>Category</label> <input type="text" name="category"
					class="form-control" placeholder="Enter Title">
			</div>
			<div class="form-group">
				<label>saleyear</label> <input type="text" name="saleYear"
					class="form-control" placeholder="Enter Title">
			</div>
			<div class="form-group">
				<label>saleprice</label> <input type="text" name="salePrice"
					class="form-control" placeholder="Enter Writer">
			</div>
				<div class="form-group">
				<label>discount</label> <input type="text" name="discount"
					class="form-control" placeholder="Enter Title">
			</div>
			</div>
				<div class="form-group">
				<label>platform</label> <input type="text" name="platform"
					class="form-control" placeholder="Enter Title">
			</div>
				<div class="form-group">
				<label>startDay</label> <input type="text" name="start"
					class="form-control" placeholder="Enter Title">
			</div>
			<div class="form-group">
				<label>Files</label> <input type="file" name="titlefile"
					class="form-control">
			</div>
			<div class="form-group">
				<label>Files</label> <input type="file" name="imgFiles"
					class="form-control" multiple="multiple">
			</div>
				<button type="submit">Submit</button>
		</form>
</body>
</html>