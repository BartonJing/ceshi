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
			window.location.href = "/XSF/user/query.action?currentPage="
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
			window.location.href = "/XSF/user/query.action?currentPage="
					+ currentPage;
		}
	}
	/* 上一页 */
	function prePage(str) {
		if (currentPage > 1) {
			currentPage--;
			window.location.href = "/XSF/user/query.action?currentPage="
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
			window.location.href = "/XSF/user/query.action?currentPage="
					+ currentPage;
		}
	}
	
	/*全选*/
	function Acheck(){
		var objs=document.getElementsByName("item");
		
		for(var i=0;i<objs.length;i++){
			var obj=objs[i];
			obj.checked=true;
		}
	}
	/*反选*/
	function Ucheck(){
		var objs=document.getElementsByName("item");
		
		for(var i=0;i<objs.length;i++){
			var obj=objs[i];
			obj.checked=!obj.checked;
		}
	}
	function control(){
		var obj=document.getElementById("control");
		var obj1=document.getElementById("cl");
		
		if(obj.checked){
			Acheck();
			obj1.innerHTML="全选";
		}else{
			Ucheck();
			obj1.innerHTML="反选";
		}
		
	}
</script>

<title>产品列表</title>
</head>
<body>
	<div class="myquery">
	<h1 style="text-align: center;color:#336699;margin-top: 3px;">用户列表</h1>
	<select style="text-align: center;color:#336699;">
		<option></option>
	</select>
	<button>发放优惠券</button>
		<table>
			<tr>
				<td class="thead"><input type="checkbox" id="control" onchange="control()"><label id="cl">全选</label></td>
				<td class="thead">用户名</td>
				<td class="thead">密码</td>
				<td class="thead">电话</td>
				<td class="thead">注册时间</td>
				<td class="thead">地址</td>
				<td class="thead">优惠券</td>
			</tr>
			<s:iterator value="#request.pageModel.getData()">
				<tr>
					<td class="thead"><input type="checkbox" name="item"></td>
					<td class="tbody">${u_code}</td>
					<td class="tbody">${u_password}</td>
					<td class="tbody">${u_tele}</td>
					<td class="tbody">${u_time}</td>
					<td class="tbody">
						<select style="height:30px;font-size:16px;color:#777;">
							<c:forEach var="i" items="${userAddresss}">
								<option>${i.a_address}</option>
							</c:forEach>
						</select>
					</td>
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