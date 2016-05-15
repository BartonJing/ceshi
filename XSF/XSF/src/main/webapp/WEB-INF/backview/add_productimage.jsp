<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="/XSF/back/css/mystyle.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="/XSF/back/js/upload.js"></script>
<title>产品图片添加</title>
</head>
<body>
	<form action="/XSF/product/addimage" method="post" enctype="multipart/form-data">
	<div class="form_main">
		
		<div class="myform">
			<h1 style="text-align: center;color:#336699;">图片添加</h1>
			<img id="a_img" width="450px" height="330px"><br><br>
			<input type="file" name="imageP" onchange="previewImage(this,'a_img')">
		</div>
		<div class="myform">
			<input type="submit" value="提交" class="button">
		</div>
	</div>
	</form>
</body>
</html>