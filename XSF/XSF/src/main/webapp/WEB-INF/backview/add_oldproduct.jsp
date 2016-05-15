<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib uri="/struts-tags" prefix="s"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="/XSF/back/css/mystyle.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="/XSF/back/js/upload.js"></script>
<title>已有库存添加</title>
</head>
<body>
	<form action="/XSF/product/addold?id=${product.p_id}" method="post">
	<div class="form_main">
		<div class="myform">
			<label class="mylabel">产品名称：</label>
			<input type="text" name="p_name" class="myinput" disabled value="${product.p_name}">
		</div>
		<div class="myform">
			<label class="mylabel">产品类别：</label>
			<select class="myinput" name="p_type">
			<s:iterator value="#request.porductTypes">
			    <option value="${t_id}" <c:out value="${p_type==t_id ? 'selected':''}"/>>${t_type}</option>
			</s:iterator>
			</select>
		</div>
		<div class="myform">
			<label class="mylabel">已有数量：</label>
			<input type="text" name="p_number2" class="myinput" disabled value="${product.p_number2}">
		</div>
		<div class="myform">
			<label class="mylabel">新增数量：</label>
			<input type="text" name="p_number1" class="myinput" placeholder="请输入本次增加的产品数量（数字类型）">
		</div>
		<div class="myform">
			<label class="mylabel">购入价格：</label><input type="text" name="p_price1" class="myinput" value="${product.p_price1}">
		</div>
		<div class="myform">
			<label class="mylabel">产品描述：</label><textarea class="mytextarea" rows="6" cols="55" name="p_discript">${product.p_discript}</textarea>
		</div>
		<div class="myform">
			<input type="submit" value="提交" class="button">
		</div>
	</div>
		

	</form>
</body>
</html>