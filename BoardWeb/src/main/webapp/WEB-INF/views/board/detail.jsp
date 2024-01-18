<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DETAIL</title>
</head>
<body>
	<h2>Detail</h2>
	<div>
		<p><input type="text" name="id" value="${board.id}" readonly></p>
		<p><input type="text" name="btitle" value="${board.btitle}" readonly></p>
		<p><input type="text" name="bwriter" value="${board.bwriter}" readonly></p>
		<p><textarea cols="50" rows="6" name="bcontent" readonly>${board.bcontent}</textarea></p>
		<p><input type="text" name="created_date" value="${board.created_date}" readonly></p>
		<p><a href="/board/update?id=${board.id}"><button type="button">Update</button></a>
		<a href="/board/list"><button type="button">List</button></a>
		<a href="/board/delete?id=${board.id}"><button onclick="return confirm('정말로 삭제하시겠습니까?')" type="button">Delete</button></a></p>
	</div>
</body>
</html>