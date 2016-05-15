<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>登录(Login)</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<!-- CSS -->
<link rel="stylesheet" href="/XSF/back/assets/css/reset.css">
<link rel="stylesheet" href="/XSF/back/assets/css/supersized.css">
<link rel="stylesheet" href="/XSF/back/assets/css/style.css">
<script>
	var ll = "" + '${message}';
	alert(ll);
	if (ll != "") {
		alert(ll);
	}
</script>

</head>

<body>

	<div class="page-container">
		<h1>登录(Login)</h1>
		<form action="/XSF/admin/login" method="get">
			<input type="text" name="a_code" class="username"
				placeholder="请输入您的用户名！"> <input type="password" name="a_psw"
				class="password" placeholder="请输入您的用户密码！">
			<!-- <input type="Captcha" class="Captcha" name="Captcha" placeholder="请输入验证码！"> -->
			<button type="submit" class="submit_button">登录</button>
			<div class="error">
				<span>+</span>
			</div>
		</form>
	</div>

	<!-- Javascript -->
	<script src="/XSF/back/assets/js/jquery-1.8.2.min.js"></script>
	<script src="/XSF/back/assets/js/supersized.3.2.7.min.js"></script>
	<script src="/XSF/back/assets/js/supersized-init.js"></script>
	<script src="/XSF/back/assets/js/scripts.js"></script>
</body>
</html>

