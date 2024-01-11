<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Join...</title>
</head>
<style>
	.content {margin-left: 30px;}
</style>
<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
<body>
	<div class="content">
		<h2>Join</h2>
		<form action="/member/join" method="post">
			<p><input id="email" type="text" name="email" placeholder="Email" onblur="checkEmail()"></p>
			<p id="check-result"></p>
			<p><input type="password" name="password" placeholder="Password"></p>
			<p><input type="text" name="name" placeholder="Name"></p>
			<p><input type="text" name="age" placeholder="Age"></p>
			<p>
				<input type="submit" value="MemberJoin">
				<input type="reset" value="Cancel">
			</p>
		</form>
	</div>
<script>
	// email 입력값을 가져오고
	// ajax() -> 입력값을 서버(controller)로 전송
	// 이메일이 체크된 후 사용 가능 여부를 입력상자  아래에 표시
	const checkEmail = function(){
		let inputEmail = document.getElementById("email").value;
		let checkResult = document.getElementById("check-result");
		console.log("이메일: ", email);
		
		$.ajax({
			// 요청방식, url, data, 함수(성공, 실패)
			type: "POST",
			url: "/member/checkemail",
			data: {
				email: inputEmail,				
			},
			success: function(res){
				console.log("성공: ", res);
				if(res == "OK"){
					checkResult.innerHTML = "사용가능한 email입니다";
					checkResult.style.color="green";
				}else {  // res = "NO"
					checkResult.innerHTML = "이미 가입된 email입니다";
					checkResult.style.color="red";
				}
			},
			error: function(err){
				console.log("실패: ", err)
			}
		});
	}
</script>
</body>
</html>