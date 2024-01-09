<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Todo 수정</title>
</head>
<body>
	<div class="container-fluid">
		<jsp:include page="../layout/header.jsp" />

		<!-- 본문 영역 -->
		<div class="row content">
			<div class="col">
				<div class="card">
					<div class="card-body">
						<form action="/todo/update" method="post">
							<div class="input-group mb-3">
								<label class="input-group-text">Tno</label> <input
									class="form-control" type="text" name="tno" value="${todo.tno}"
									readonly>
							</div>
							<div class="input-group mb-3">
								<label class="input-group-text">To do</label> <input
									class="form-control" type="text" name="title"
									value="${todo.title}" >
							</div>
							<div class="input-group mb-3">
								<label class="input-group-text">Writer</label> <input
									class="form-control" type="text" name="writer"
									value="${todo.writer}" >
							</div>
							<div class="input-group mb-3">
								<label class="input-group-text">createDate</label> <input
									type="text" name="createDate" class="form-control"
									value="${todo.createDate}" readonly>
							</div>
							<div class="my-4">
								<div class="float-end">
									<button type="submit" class="btn btn-primary">Modify</button>
									<button class="btn btn-danger" type="button">Delete</button>
									<button class="btn btn-secondary" type="button">gotoList</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
		<!-- 본문 영역 닫기 -->

		<jsp:include page="../layout/footer.jsp" />
	</div>
<script>
	// 목록버튼
	const listBtn = document.querySelector(".btn-secondary");
	listBtn.addEventListener("click", function(e) {
		location.href = "/todo/list";
	});
	
	// 삭제버튼
	const delBtn = document.querySelector(".btn-danger");
	const tno = '${todo.tno}';
	delBtn.addEventListener("click", function(e) {
	    let checkConfirm = confirm("정말로 삭제하시겠습니까?");
	    
	    if (checkConfirm) {
	        location.href = "/todo/delete?tno=" + tno;
	    }
	});
</script>
</body>
</html>