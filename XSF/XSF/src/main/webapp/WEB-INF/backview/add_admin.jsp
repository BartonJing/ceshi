<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="/XSF/back/css/mystyle.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="/XSF/back/js/upload.js"></script>
<title>管理员添加</title>
</head>
<body>
	<form action="/XSF/admin/add" method="post" enctype="multipart/form-data">
	<div class="form_main">
		<div class="myform">
			<label class="mylabel">姓名：</label><input type="text" name="a_name" class="myinput" placeholder="请输入姓名！">
		</div>
		<div class="myform">
			<label class="mylabel">昵称：</label><input type="text" name="a_code" class="myinput" placeholder="请输入您的用户名！">
		</div>
		<div class="myform">
			<label class="mylabel">密码：</label><input type="password" name="a_psw" class="myinput" placeholder="请输入您的密码！">
		</div>
		<div class="myform">
			<label class="mylabel">再次输入密码：</label><input type="password" class="myinput" placeholder="请再次输入您的用户名！">
		</div>
		<div class="myform">
			<label class="mylabel">电话：</label><input type="text" name="a_tele" class="myinput" placeholder="请输入您的电话！">
		</div>
		<div class="myform">
			<label class="mylabel">权限：</label><input type="radio" name="a_power" value="1">高级
			<input type="radio" name="a_power" value="2">普通
			<input type="radio" name="a_power" value="3">一般
		</div>
		<div class="myform">
			<label class="mylabel">照片：</label>
			<input type="file" name="image" onchange="previewImage(this,'a_img')">
			<img id="a_img" width="120px" height="150px">
		</div>
		<div class="myform">
			<input type="submit" value="提交" class="button">
		</div>
	</div>
		

	</form>
</body>
</html>