<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update...</title>
</head>
<style>
	.content {margin-left: 30px;}
</style>
<body>
	<div class="content">
		<h2>Update</h2>
		<form action="/member/update" method="post" name="updateform">
			<p>
				<label>No
					<input type="text" name="id" value="${member.id}" readonly>
				</label>
			</p>
			<p>
				<label>Email
					<input type="text" name="email" value="${member.email}" autocomplete="email" readonly>
				</label>
			</p>
			<p>
				<label>Password
					<input type="text" name="password" value="${member.password}">
				</label>
			</p>
			<p>
				<label>Name
					<input type="text" name="name" value="${member.name}" autocomplete="username">
				</label>
			</p>
			<p>
				<label>Age
					<input type="text" name="age" value="${member.age}">
				</label>
			</p>
			<p>
				<button type="button" onclick="updateFn()">Update</button>
				<button type="button" onclick="list()">Cancel</button>
			</p>
		</form>
	</div>
<script>
	// 수정처리
	const updateFn = function() {
		document.updateform.submit();
		/* location.href="/member/update"; */
	}

	const list = function() {
		location.href="/member/";
	}

</script>
</body>
</html>