<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Todo 등록</title>
</head>
<body>
	<div class="container-fluid">
		<jsp:include page="../layout/header.jsp" />

		<!-- 본문 영역 -->
		<div class="row content">
			<div class="col">
				<div class="card">
					<div class="card-body">
							<h2>Todo 목록</h2>
							<h4>${todoList}</h4>
						<table>
						</table>
					</div>
				</div>
			</div>
		</div>
		<!-- 본문 영역 닫기 -->

		<jsp:include page="../layout/footer.jsp" />
	</div>
</body>
</html>