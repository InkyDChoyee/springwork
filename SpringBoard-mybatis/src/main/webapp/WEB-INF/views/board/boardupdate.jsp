<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 상세보기</title>
</head>
<body>
	<jsp:include page="../layout/header.jsp" />
	<div id="container">
		<section id="detail">
			<h2>글 상세보기</h2>
			<form action="/board/update" method="post">
				<input type="hidden" name="id" value="${board.id}">
				<table class="tbl_detail">
					<tr>
						<td><input type="text" name="boardTitle"
							value="${board.boardTitle}"></td>
					</tr>
					<tr>
						<td>작성자 : ${board.userId}</td>
					</tr>
					<tr>
						<td><textarea name="boardContent">${board.boardContent}</textarea></td>
					</tr>
					<tr>
						<td>조회수 : ${board.hit}</td>
					</tr>
					<c:choose>
						<c:when test="${empty board.updateTime}">
							<tr>
								<td>작성일 : <fmt:formatDate value="${board.createTime}"
										pattern="yyy-MM-dd HH:mm:ss" /></td>
							</tr>
						</c:when>
						<c:otherwise>
							<tr>
								<td>작성일 : <fmt:formatDate value="${board.createTime}"
										pattern="yyy-MM-dd HH:mm:ss" /></td>
							</tr>
							<tr>
								<td>수정일 : <fmt:formatDate value="${board.updateTime}"
										pattern="yyy-MM-dd HH:mm:ss" /></td>
							</tr>

						</c:otherwise>
					</c:choose>
					<tr>
						<td>
							<button type="submit">수정 완료</button>
							<button type="reset">수정 취소</button> <a href="/board/"><button>목록</button></a>
						</td>
					</tr>
				</table>
			</form>
		</section>
	</div>
	<jsp:include page="../layout/footer.jsp" />
</body>
</html>