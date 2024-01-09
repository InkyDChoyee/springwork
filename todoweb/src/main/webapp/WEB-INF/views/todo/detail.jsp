<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Todo 상세보기</title>
</head>
<body>
	<div class="container-fluid">
		<jsp:include page="../layout/header.jsp" />

		<!-- 본문 영역 -->
		<div class="row content">
			<div class="col">
				<div class="card">
					<div class="card-body">
						<div class="input-group mb-3">
							<label class="input-group-text">Tno</label> <input
								class="form-control" type="text" name="tno" value="${todo.tno}"
								readonly>
						</div>
						<div class="input-group mb-3">
							<label class="input-group-text">To do</label> <input
								class="form-control" type="text" name="title"
								value="${todo.title}" readonly>
						</div>
						<div class="input-group mb-3">
							<label class="input-group-text">Writer</label> <input
								class="form-control" type="text" name="writer"
								value="${todo.writer}" readonly>
						</div>
						<div class="input-group mb-3">
							<label class="input-group-text">createDate</label> <input
								type="text" name="createDate" class="form-control"
								value="<fmt:formatDate
								value="${todo.createDate}" pattern="yyy-MM-dd" />"
								readonly>
						</div>
						<div class="my-4">
							<div class="float-end">
								<button class="btn btn-primary" type="button">Update</button>
								<button class="btn btn-secondary" type="button">List</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- 본문 영역 닫기 -->

		<jsp:include page="../layout/footer.jsp" />
	</div>
	<!-- 자바스크립트 영역 -->
	<script>
		// 목록버튼
		const listBtn = document.querySelector(".btn-secondary");
		let page = "${pageRequestDTO.page}"
		listBtn.addEventListener("click", function(e) {
			location.href = "/todo/paging?page=" + page;
		});
		
		// 수정버튼
		const modifyBtn = document.querySelector(".btn-primary");
		const tno = '${todo.tno}';
		modifyBtn.addEventListener("click", function(e) {
			location.href = "/todo/update?tno=" + tno;
		});
	</script>
</body>
</html>