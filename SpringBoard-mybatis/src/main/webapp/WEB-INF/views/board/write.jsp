<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
</head>
<body>
	<div id="content">
		<h2>글쓰기</h2>
		<form action="/board/write" method="post">
		<table class="tbl_write">
			<tr>
				<td>
					<input type="text" name="boardTitle" placeholder="글제목" required>
				</td>
			</tr>
			<tr>
				<td>
					<input type="text" name="userId" value="${sessionId}" readonly>
				</td>
			</tr>
			<tr>
				<td>
					<textarea rows="5" cols="50" name="boardContent" placeholder="글 내용" style="resize:none" required></textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="등록">
					<input type="reset" value="취소">
				</td>
			</tr>
		</table>
		</form>
	</div>
</body>
</html>