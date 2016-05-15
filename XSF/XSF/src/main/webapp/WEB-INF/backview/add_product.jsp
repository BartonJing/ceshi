<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="/XSF/back/css/mystyle.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="/XSF/back/js/upload.js"></script>
<title>产品添加</title>
</head>
<body>
	<form action="/XSF/product/add" method="post">
	<div class="form_main">
		<div class="myform">
			<label class="mylabel">产品名称：</label><input type="text" name="p_name" class="myinput" placeholder="请输入产品名称！">
		</div>
		<div class="myform">
			<label class="mylabel">产品类别：</label>
			<select class="myinput" name="p_type">
			<s:iterator value="#request.porductTypes">
			    <option value="${t_id}">${t_type}</option>
			</s:iterator>
			</select>
		</div>
		<div class="myform">
			<label class="mylabel">产品数量：</label><input type="text" name="p_number1" class="myinput" placeholder="请输入产品数量（数字类型）">
		</div>
		<div class="myform">
			<label class="mylabel">购入价格：</label><input type="text" name="p_price1" class="myinput" placeholder="请输入产品价格（数字类型）">
		</div>
		<div class="myform">
			<label class="mylabel">产品描述：</label><textarea class="mytextarea" rows="8" cols="55" name="p_discript"></textarea>
		</div>
		<div class="myform">
			<input type="submit" value="提交" class="button">
		</div>
	</div>
		

	</form>
</body>
</html>