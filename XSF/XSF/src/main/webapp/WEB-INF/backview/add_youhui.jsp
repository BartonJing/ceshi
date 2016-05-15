<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="/XSF/back/css/mystyle.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="/XSF/back/js/upload.js"></script>
<title>优惠券创建</title>
</head>
<body>
	<form action="/XSF/youhui/add" method="post" enctype="multipart/form-data">
	<div class="form_main">
		<h1 style="text-align: center;color:#336699;margin-top: 3px;">优惠券创建</h1>
		<div class="myform">
			
			<div class="myform_1">
				<label class="mylabel">名称：</label><input type="text" name="y_name" class="myinput" placeholder="输入优惠券的名称！">
			</div>
			<div class="myform_1">
				<label class="mylabel">价格：</label><input type="text" name="y_price" class="myinput" placeholder="输入优惠券的价值！(数字类型)">
			</div>
			<div class="myform_1">
				<label class="mylabel">数量：</label><input type="text" name="y_number1" class="myinput" placeholder="输入优惠券的数量！(数字类型)">
			</div>
			<div class="myform_1">
				<label class="mylabel">有效期：</label>
				<input type="date" name="y_starttime" class="mydate"><label class="mylabel_1">00:00-</label>
				<input type="date" name="y_endtime" class="mydate"><label class="mylabel_1">00:00</label>
			</div>
			<div class="myform_1">
				<label class="mylabel">描述：</label>
				<textarea rows="4" cols="10" style="width:400px;" name="y_discript"></textarea>
			</div>
			<div class="myform_1">
				<label class="mylabel">照片：</label>
				<input type="file" name="imageY" onchange="previewImage(this,'a_img')">
				<img id="a_img" width="120px" height="150px">
			</div>
		</div>
		<div class="myform">
			<input type="submit" value="提交" class="button">
		</div>
	</div>
	</form>
</body>
</html>