<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="/XSF/back/css/mystyle.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="/XSF/back/js/upload.js"></script>
<title>产品图片管理</title>
<script type="text/javascript">
	var currentPage = ${pageModel.getCurrentPage()};
	var total = ${pageModel.getTotalPage()};
	/* 下一页 */
	function nextPage() {
		if (currentPage < total) {
			currentPage++;
			window.location.href = "/XSF/mainimage/query.action?currentPage="
					+ currentPage;
		} else {
			alert("已经是最后一张了！");
			return;
		}
	}
	/* 上一页 */
	function prePage(str) {
		if (currentPage > 1) {
			currentPage--;
			window.location.href = "/XSF/mainimage/query.action?currentPage="
					+ currentPage;
		} else {
			alert("已经是第一张了！");
			return;
		}
	}
	
</script>
</head>
<body>
<s:iterator value="#request.pageModel.getData()">
	<form action="/XSF/mainimage/save?i_id=${i_id}" method="post" enctype="multipart/form-data">
	<div class="form_main">
		
		<div class="myform">
			<h1 style="text-align: center;color:#336699;">图片管理</h1>
			
			<img id="a_img" width="450px" height="330px" src="/XSF_img/${i_image}"><br><br>
			<input type="file" name="imageM" onchange="previewImage(this,'a_img')">
			<button><a href="/XSF/mainimage/delete?i_id=${i_id}">删除</a></button>
			<input type="submit" value="保存">
			 
		
		</div>
		
		<div style="font-size: 16px; float: right">
			第${pageModel.getCurrentPage()}张/共${pageModel.getTotalPage()}张
			 
			 <a	href="javascript:void(0)" onclick="prePage()">上一张</a> 
			 <a	href="javascript:void(0)" onclick="nextPage()">下一张</a>
			 
				
		</div>
		
	</div>
	</form>
	</s:iterator>
</body>
</html>