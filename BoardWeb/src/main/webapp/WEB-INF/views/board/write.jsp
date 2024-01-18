<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WRITE</title>
</head>
<body>
	<h2>Write</h2>
	<div>
		<form action="/board/write" method="POST">
			<p><input type="text" name="btitle" placeholder="title"></p>
			<p><input type="text" name="bwriter" placeholder="writer"></p>
			<p><textarea cols="50" rows="6" name="bcontent" placeholder="content"></textarea></p>
			<p><input type="submit" value="confirm"> <input type="reset" value="reset"></p>
		</form>
	</div>
</body>
</html>