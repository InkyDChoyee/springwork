<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login...</title>
</head>
<style>
	.content {margin-left: 30px;}
</style>
<body>
	<div class="content">
		<h2>Login</h2>
		<form action="/member/Login" method="post">
			<p><input type="text" name="email" placeholder="Email"></p>
			<p><input type="password" name="password" placeholder="Password"></p>
			<p>
				<input type="submit" value="MemberLogin">
				<input type="reset" value="Cancel">
			</p>
		</form>
	</div>
</body>
</html>