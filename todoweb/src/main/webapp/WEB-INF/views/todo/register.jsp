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
						<form action="/todo/register" method="post">
							<div class="input-group mb-3">
								<label class="input-group-text">To do</label> 
								<input class="form-control" type="text" name="title" placeholder="Title">
							</div>
							<div class="input-group mb-3">
								<label class="input-group-text">Writer</label> 
								<input class="form-control" type="text" name="writer" placeholder="Name">
							</div>
							<p>
								<input class="btn btn-success" type="submit" value="등록"> 
								<input class="btn btn-secondary" type="reset" value="취소">
							</p>
						</form>
					</div>
				</div>
			</div>
		</div>
		<!-- 본문 영역 닫기 -->

		<jsp:include page="../layout/footer.jsp" />
	</div>
</body>
</html>