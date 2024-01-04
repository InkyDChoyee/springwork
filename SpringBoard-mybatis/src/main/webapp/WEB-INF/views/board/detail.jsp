<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
			<table class="tbl_detail">
				<tr>
					<td><input type="text" name="boardTitle"
						value="${board.boardTitle}" readonly></td>
				</tr>
				<tr>
					<td>작성자 : ${board.userId}</td>
				</tr>
				<tr>
					<td><textarea name="boardContent"
						readonly>${board.boardContent}</textarea></td>
				</tr>
				<tr>
					<td>조회수 : ${board.hit}</td>
				</tr>
				<tr>
					<td>작성일 : <fmt:formatDate value="${board.createTime}" pattern="yyy-MM-dd HH:mm:ss"/></td>
				</tr>
				<tr>
					<c:choose>
						<c:when test="${board.userId eq sessionId}">
							<td>
								<a href="/board/update?id=${board.id}"><button>수정</button></a>
								<a href="/board/delete?id=${board.id}" onclick="return confirm('정말로 삭제하시겠습니까?')"><button>삭제</button></a> 
								<a href="/board/"><button>목록</button></a></td>
						</c:when>
						<c:otherwise>
							<td><a href="/board/"><button>목록</button></a></td>
						</c:otherwise>
					</c:choose>
				</tr>
			</table>
		</section>
	</div>
	<jsp:include page="../layout/footer.jsp" />
</body>
</html>