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
<title>产品详情</title>
</head>
<body>
	<div class="showmessage">
	<h1 style="text-align: center;color:#336699;margin-top:100px;">产品详情</h1>
		<table>
			<tr>
				<td class="td_label">产品编号:</td>
				<td class="td_body">${product.p_code}</td>
				<td class="td_label">产品名称:</td>
				<td class="td_body">${product.p_name}</td>
			</tr>
				<tr>
					<td class="td_label">购入价格:</td>
					<td class="td_body">${product.p_price1}</td>
					<td class="td_label">产品售价:</td>
					<td class="td_body">${product.p_price2}</td>
				</tr>
				<tr>
					<td class="td_label">租借价格:</td>
					<td class="td_body">${product.p_price3}</td>
					<td class="td_label">累计货量:</td>
					<td class="td_body">${product.p_number1}</td>
				</tr>
				<tr>
					<td class="td_label">当前库存:</td>
					<td class="td_body">${product.p_number2}</td>
					<td class="td_label">产品类型:</td>
					<td class="td_body">${porductType}</td>
				</tr>
				<tr>
					<td class="td_label">产品状态:</td>
					<td class="td_body">${product.p_state}</td>
					<td class="td_label">产品描述:</td>
					<td class="td_body">${product.p_discript}</td>
				</tr>
				<tr>
					<td class="td_label">入库时间:</td>
					<td class="td_body">${product.p_time1}</td>
					<td class="td_label">最近操作:</td>
					<td class="td_body">${product.p_time2}</td>
				</tr>
		</table>
	</div>

</body>
</html>