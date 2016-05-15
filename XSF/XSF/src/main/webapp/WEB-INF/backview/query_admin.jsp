<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="/XSF/back/css/mystyle.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="/XSF/back/js/upload.js"></script>
<script type="text/javascript">
var currentPage=${pageModel.getCurrentPage()};
var total=${pageModel.getTotalPage()};
/* 下一页 */
function nextPage(){
	if(currentPage<total){
		currentPage++;
		window.location.href="/XSF/admin/query.action?currentPage="+currentPage;
	}else{
		alert("已经是尾页了！");
		return;
	}
}
/* 首页 */
function firstPage(str){
	if(currentPage==1){
		alert("已经是首页了！");
		return;
	}else{
		currentPage=1;
		window.location.href="/XSF/admin/query.action?currentPage="+currentPage;
	}
}
/* 上一页 */
function prePage(str){
	if(currentPage>1){
		currentPage--;
		window.location.href="/XSF/admin/query.action?currentPage="+currentPage;
	}else{
		alert("已经是首页了！");
		return;
	}
}

/* 尾页 */
function endPage(str){
	if(currentPage==total){
		alert("已经是尾页了！");
		return;
	}else{
		currentPage=total;
		window.location.href="/XSF/admin/query.action?currentPage="+currentPage;
	}
}
</script>

<title>管理员列表</title>
</head>
<body>
	<div class="myquery">
<h1 style="text-align: center;color:#336699;margin-top: 3px;">管理员列表</h1>
		<table>
			<tr>
				<td class="thead">姓名</td>
				<td class="thead">昵称</td>
				<td class="thead">电话</td>
				<td class="thead">权限</td>
				<td class="thead">操作</td>
			</tr>
			<s:iterator value="#request.pageModel.getData()"> 
			<tr>
			   <td class="tbody">${a_name}</td>
			   <td class="tbody">${a_code}</td>
			   <td class="tbody">${a_tele}</td>
			   <td class="tbody">${a_power}</td>
			   <td style="text-align: center;"><a href="" >删除</a> /<a href="/XSF/admin/editor?id=${a_id}" >修改</a></td>
			</tr>
			</s:iterator>
		</table>
		<div style="font-size:16px;float:right">
     	第${pageModel.getCurrentPage()}页/共${pageModel.getTotalPage()}页
     	<a href="javascript:void(0)" onclick="firstPage()">首页</a>
		<a href="javascript:void(0)" onclick="prePage()">上一页</a>
		<a href="javascript:void(0)" onclick="nextPage()">下一页</a>
		<a href="javascript:void(0)" onclick="endPage()">尾页</a> 
     </div>
	</div>

</body>
</html>