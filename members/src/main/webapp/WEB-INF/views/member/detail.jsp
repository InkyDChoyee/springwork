<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Detail...</title>
</head>
<style>
	.content {margin-left: 30px;}
</style>
<body>
	<div class="content">
		<h2>Detail</h2>
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
					<input type="text" name="password" value="${member.password}" readonly>
				</label>
			</p>
			<p>
				<label>Name
					<input type="text" name="name" value="${member.name}" autocomplete="username" readonly>
				</label>
			</p>
			<p>
				<label>Age
					<input type="text" name="age" value="${member.age}" readonly>
				</label>
			</p>
			<p>
				<button type="button" onclick="list()">List</button>
				<button type="button" onclick="updateFn()">Update</button>
				<button type="button" onclick="del(${member.id})">Delete</button>
				<%-- <button><a href="/member/delete?id= + ${member.id}">Delete</a></button> --%>
			</p>
	</div>
<script>
	const list = function() {
		location.href="/member/";
	}
	
	let updateFn = function(){
		location.href="/member/update";
	}
	
	const del = function(mid){
		if(confirm("정말로 삭제하시겠습니까?")){
			location.href= "/member/delete?id=" + mid;
		}
	}
</script>
</body>
</html>