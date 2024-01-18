<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LIST</title>
</head>
<body>
	<h2>List</h2>
	<div>
		<table>
			<thead>
				<tr>
					<th>ID</th>
					<th>TITLE</th>
					<th>WRITER</th>
					<th>DATE</th>
					<th>DETAIL / DELETE</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${boardList}" var="board">
					<tr>
						<td>${board.id}</td>
						<td>${board.btitle}</td>
						<td>${board.bwriter}</td>
						<td><fmt:formatDate value="${board.created_date}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
						<td><a href="/board?id=${board.id}"><button type="button">Detail</button></a> / 
							<a href="/board/delete?id=${board.id}"><button onclick="return confirm('정말로 삭제하시겠습니까?')" type="button">Delete</button></a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<p><a href="/board/write"><button type="button">Write</button></a>
		<a href="/"><button type="button">Home</button></a></p>
	</div>
</body>
</html>