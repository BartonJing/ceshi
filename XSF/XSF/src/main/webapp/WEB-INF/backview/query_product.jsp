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
<script type="text/javascript">
	var currentPage = ${pageModel.getCurrentPage()};
	var total = ${pageModel.getTotalPage()};
	/* 下一页 */
	function nextPage() {
		if (currentPage < total) {
			currentPage++;
			window.location.href = "/XSF/product/query.action?currentPage="
					+ currentPage;
		} else {
			alert("已经是尾页了！");
			return;
		}
	}
	/* 首页 */
	function firstPage(str) {
		if (currentPage == 1) {
			alert("已经是首页了！");
			return;
		} else {
			currentPage = 1;
			window.location.href = "/XSF/product/query.action?currentPage="
					+ currentPage;
		}
	}
	/* 上一页 */
	function prePage(str) {
		if (currentPage > 1) {
			currentPage--;
			window.location.href = "/XSF/product/query.action?currentPage="
					+ currentPage;
		} else {
			alert("已经是首页了！");
			return;
		}
	}

	/* 尾页 */
	function endPage(str) {
		if (currentPage == total) {
			alert("已经是尾页了！");
			return;
		} else {
			currentPage = total;
			window.location.href = "/XSF/product/query.action?currentPage="
					+ currentPage;
		}
	}
</script>

<title>产品列表</title>
</head>
<body>
	<div class="myquery">
	<h1 style="text-align: center;color:#336699;margin-top: 3px;">产品列表</h1>
		<table>
			<tr>
				<td class="thead">产品编号</td>
				<td class="thead">产品名称</td>
				<td class="thead">购进价格</td>
				<td class="thead">库存量</td>
				<td class="thead">上次入库时间</td>
				<td class="thead">操作</td>
			</tr>
			<s:iterator value="#request.pageModel.getData()">
				<tr>
					<td class="tbody">${p_code}</td>
					<td class="tbody">${p_name}</td>
					<td class="tbody">${p_price1}</td>
					<td class="tbody">${p_number2}</td>
					<td class="tbody">${p_time2}</td>
					 <td style="text-align: center;">
						<a href="/XSF/product/openold?id=${p_id}">增加库存</a> /
						<a href="/XSF/product/pricemana?id=${p_id}" >售价管理</a>/ 
						<a href="/XSF/product/push?id=${p_id}"> <c:choose>
								<c:when test="${p_state=='未推送'?true:false}">前台推送</c:when>
								<c:otherwise>撤销推送</c:otherwise>
							</c:choose></a>/ 
						<a href="/XSF/product/editor?id=${p_id}">查看详情</a>/ 
						<a href="/XSF/product/openimage?id=${p_id}" >图片添加</a>/
						<a href="/XSF/product/openimageMana?id=${p_id}" >图片管理</a>/

						</td> 
					<%-- <td style="text-align: center;">
						<select style="height:35px;font-size:18px;color:#777;" >
							<option><a href="/XSF/product/openold?id=${p_id}">增加库存</a></option>
							<option><a href="/XSF/product/pricemana?id=${p_id}" >售价管理</a></option>
							<option><a href="/XSF/product/push?id=${p_id}"> <c:choose>
								<c:when test="${p_state=='未推送'?true:false}">前台推送</c:when>
								<c:otherwise>撤销推送</c:otherwise>
							</c:choose></a></option>
							<option><a href="/XSF/product/editor?id=${p_id}">查看详情</a></option>
							<option><a href="/XSF/product/openimage?id=${p_id}" >图片添加</a></option>
							<option><a href="/XSF/product/openimageMana?id=${p_id}" >图片管理</a></option>
						</select>
					</td> --%>
				</tr>
			</s:iterator>
		</table>
		<div style="font-size: 16px; float: right">
			第${pageModel.getCurrentPage()}页/共${pageModel.getTotalPage()}页 <a
				href="javascript:void(0)" onclick="firstPage()">首页</a> <a
				href="javascript:void(0)" onclick="prePage()">上一页</a> <a
				href="javascript:void(0)" onclick="nextPage()">下一页</a> <a
				href="javascript:void(0)" onclick="endPage()">尾页</a>
		</div>
	</div>

</body>
</html>