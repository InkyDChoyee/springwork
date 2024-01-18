<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>UPDATE</title>
</head>
<body>
	<h2>Update</h2>
	<div>
		<form action="/board/update" method="post">
			<p><input type="text" name="id" value="${board.id}" readonly></p>
			<p><input type="text" name="btitle" value="${board.btitle}"></p>
			<p><input type="text" name="bwriter" value="${board.bwriter}" readonly></p>
			<p><textarea cols="50" rows="6" name="bcontent" >${board.bcontent}</textarea></p>
			<p><input type="text" name="created_date" value="${board.created_date}" readonly></p>
			<p><input type="submit" value="Update">
				<a href="/board/list"><button type="button">List</button></a>
				<input type="reset" value="Reset"></p>
		</form>
	</div>
</body>
</html>