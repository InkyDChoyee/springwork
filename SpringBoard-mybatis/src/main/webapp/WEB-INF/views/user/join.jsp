<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<jsp:include page="../layout/header.jsp" />
	<div id="container">
		<section id="join">
			<h2>회원 가입</h2>
			<form action="/user/join" method="post" name="userform">
				<table class="tbl_join">
					<tr>
						<td><label>아이디</label></td>
						<td><input type="text" id="userId" name="userId"
							placeholder="아이디" onblur="checkId()">
							<p id="check-result"></p></td>
					</tr>
					<tr>
						<td><label>비밀번호</label></td>
						<td><input type="password" id="userPasswd" name="userPasswd"
							placeholder="비밀번호" required></td>
					</tr>
					<tr>
						<td><label>이름</label></td>
						<td><input type="text" id="userName" name="userName"
							placeholder="이름" required></td>
					</tr>
					<tr>
						<td><label>나이</label></td>
						<td><input type="text" id="userAge" name="userAge"
							placeholder="나이"></td>
					</tr>
					<tr>
						<td colspan="2"><input type="button" value="등록"
							onclick="checkUser()"> <input type="reset" value="취소">
						</td>
					</tr>
				</table>
			</form>
		</section>
	</div>
	<jsp:include page="../layout/footer.jsp" />
	<script src="../resources/js/validation.js" ></script>

</body>
</html>