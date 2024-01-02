<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글목록</title>
</head>
<body>
	<div id="content">
		<h2>글목록</h2>
		<table class="tbl_list">
			<thead>
				<tr>
					<td>글번호</td>
					<td>글제목</td>
					<td>글쓴이</td>
					<td>조회수</td>
					<td>작성일</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${boardList}" var="board">
					<tr>
						<td>${board.id}</td>
						<td><a href="/board?id=${board.id}">${board.boardTitle}</a></td>
						<td>${board.userId}</td>
						<td>${board.hit}</td>
						<td>${board.createTime}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="/"><button>Home</button></a>
	</div>
</body>
</html>