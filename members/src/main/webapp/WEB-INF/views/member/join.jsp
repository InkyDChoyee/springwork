<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Join...</title>
</head>
<style>
	.content {margin-left: 30px;}
</style>
<body>
	<div class="content">
		<h2>Join</h2>
		<form action="/member/join" method="post">
			<p><input type="text" name="email" placeholder="Email"></p>
			<p><input type="password" name="password" placeholder="Password"></p>
			<p><input type="text" name="name" placeholder="Name"></p>
			<p><input type="text" name="age" placeholder="Age"></p>
			<p>
				<input type="submit" value="MemberJoin">
				<input type="reset" value="Cancel">
			</p>
		</form>
	</div>
</body>
</html>