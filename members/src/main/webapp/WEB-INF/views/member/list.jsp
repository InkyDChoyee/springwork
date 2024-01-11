<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MemberList...</title>
</head>
<style>
	.content {margin-left: 30px;}
	table {border-collapse:collapse;}
	table th, td {border: 1px solid #ccc; padding: 8px;}
</style>
<body>
	<div class="content">
		<h2>MemberList</h2>
		<div>
			<table>
				<thead>
					<tr>
						<th>No</th>
						<th>Email</th>
						<th>Password</th>
						<th>Name</th>
						<th>Age</th>
						<th>Check</th>
						<th>Delete</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${memberList}" var="member">
						<tr>
							<td>${member.id}</td>
							<td>${member.email}</td>
							<td>${member.password}</td>
							<td>${member.name}</td>
							<td>${member.age}</td>
							<td><button type="button" onclick="detail('${member.id}')">check</button></td>
							<td><button type="button" onclick="del('${member.id}')">delete</button></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>		
		</div>
	</div>
<script>
	const detail = function(mid){
		location.href= "/member?id=" + mid;
	}
	const del = function(mid){
		if(confirm("정말로 삭제하시겠습니까?")){
			location.href= "/member/delete?id=" + mid;
		}
	}
</script>
</body>
</html>