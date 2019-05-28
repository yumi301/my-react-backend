<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录页面</title>
<link rel="stylesheet" href="/css/index.css" type="text/css" />

</head>
<body>
	<center>
		<form action="/login/check" method="POST">
			<h2>
				登录页面
			</h2>
			<p>
			  用户名:<input id="username" name="username" type="text" value="Jack"/>
			</p>
			<p>
			 密&nbsp;&nbsp; 码:<input id="password"  name="password" type="password" value="jack-password"/>
			</p>
			<p>
                <input id="btn" type="button" value="登录" onclick="return _onclick_login();"/>
            </p>
		<script src="/js/login.js"></script>
		</form>
	</center>
	
</body>
</html>