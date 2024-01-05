<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글목록</title>
</head>
<body>
	<jsp:include page="../layout/header.jsp" />
	<div id="container">
		<section id="boardlist">
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
							<td><a href="/board?id=${board.id}&page=${paging.page}">${board.boardTitle}</a></td>
							<td>${board.userId}</td>
							<td>${board.hit}</td>
							<td>
								<c:choose>
									<c:when test="${empty board.updateTime}">
										<fmt:formatDate value="${board.createTime}"
											pattern="yyy-MM-dd HH:mm:ss" />(작성일)
									</c:when>
									<c:otherwise>
										<fmt:formatDate value="${board.updateTime}"
											pattern="yyy-MM-dd HH:mm:ss" />(수정일)
									</c:otherwise>
								</c:choose>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<!-- page 처리 영역 -->
			<div class="pagination">
				<!-- 이전 페이지 -->
				<c:if test="${paging.page > 1}">
					<a href="/board/paging?page= 1 "><<</a>
					<a href="/board/paging?page=${paging.page-1}"><</a>
				</c:if>
				<!-- 현재 페이지 -->
				<c:forEach var = "i" begin="${paging.startPage}" end="${paging.endPage}">
					<a href="/board/paging?page=${i}">${i}</a>
				</c:forEach>
				<!-- 다음 페이지 -->
				<c:if test="${paging.page < paging.maxPage}">
					<a href="/board/paging?page=${paging.page+1}">></a>
					<a href="/board/paging?page=${paging.maxPage}">>></a>
				</c:if>
				
			</div>
			
			<!-- 버튼 영역 -->
			<div class="boardlist_button">
				<a href="/"><button>Home</button></a> <a href="/board/write"><button>글쓰기</button></a>
			</div>
		</section>
	</div>
	<jsp:include page="../layout/footer.jsp" />
</body>
</html>