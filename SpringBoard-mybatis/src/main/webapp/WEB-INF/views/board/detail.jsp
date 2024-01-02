<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 상세보기</title>
</head>
<body>
	<jsp:include page="../layout/header.jsp" />
	<div id="container">
		<h2>글 상세보기</h2>
		<table class="tbl_detail">
			<tr>
				<td><label>글제목</label></td>
				<td>
					${board.boardTitle}
				</td>
			</tr>
			<tr>
				<td><label>작성자</label></td>
				<td>
					${board.userId}
				</td>
			</tr>
			<tr>
				<td><label>글내용</label></td>
				<td>
					${board.boardContent}
				</td>
			</tr>
			<tr>
				<td><label>조회수</label></td>
				<td>
					${board.hit}
				</td>
			</tr>
			<tr>
				<td><label>작성일</label></td>
				<td>
					${board.createTime}
				</td>
			</tr>
			<tr>
				<td>
					<a href="/board/"><button>목록으로</button></a>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>