<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Todo 등록</title>
</head>
<body>
	<h1>Todo 등록</h1>
	<form action="/todo/register" method="post">
		<p>
			<label>Title</label>
			<input type="text" name="title">
		</p>
		<p>
			<label>Writer</label>
			<input type="text" name="writer">
		</p>
		<p>
			<input type="submit" value="등록">
			<input type="reset" value="취소">
		</p>
	</form>
</body>
</html>