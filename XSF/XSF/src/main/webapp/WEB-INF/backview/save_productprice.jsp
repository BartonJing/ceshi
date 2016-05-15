<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="/XSF/back/css/mystyle.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="/XSF/back/js/upload.js"></script>
<title>产品价格管理</title>
</head>
<body>
	<form action="/XSF/product/saveprice" method="post" enctype="multipart/form-data">
	<div class="form_main">
		<h1 style="text-align: center;color:#336699;margin-top: 70px;">商品售价管理</h1>
		<div class="myform">
			
			<div class="myform">
				<label class="mylabel">售卖价格：</label><input type="text" name="p_price2" class="myinput" value="${product.p_price2 }">
			</div>
			<div class="myform">
				<label class="mylabel">租借价格：</label><input type="text" name="p_price3" class="myinput" value="${product.p_price3 }">
			</div>
		</div>
		<div class="myform">
			<input type="submit" value="提交" class="button">
		</div>
	</div>
	</form>
</body>
</html>