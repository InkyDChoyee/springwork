<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원수정</title>
</head>
<body>
	<jsp:include page="../layout/header.jsp" />
	<div id="container">
		<section id="memberview">
			<h2>정보 수정</h2>
			<form action="/user/update" method="post">
				<input type="hidden" name="id" value="${userdetail.id}">
				<table class="tbl_update">
					<tr>
						<td><label>아이디</label></td>
						<td><input type="text" name="userId"
							value="${userdetail.userId}" readonly></td>
					</tr>
					<tr>
						<td><label>비밀번호</label></td>
						<td><input type="password" name="userPasswd"
							value="${userdetail.userPasswd}"></td>
					</tr>
					<tr>
						<td><label>이름</label></td>
						<td><input type="text" name="userName"
							value="${userdetail.userName}"></td>
					</tr>
					<tr>
						<td><label>나이</label></td>
						<td><input type="text" name="userAge"
							value="${userdetail.userAge}"></td>
					</tr>
					<tr>
						<td colspan="2">
							<button onclick="list()">목록</button>
							<button type="submit">수정</button>
							<button type="reset">취소</button>
						</td>
					</tr>
				</table>
			</form>
		</section>
	</div>

	<script>
		let list = function() {
			location.href = "/user/";
		}
	</script>
	<jsp:include page="../layout/footer.jsp" />
</body>
</html>