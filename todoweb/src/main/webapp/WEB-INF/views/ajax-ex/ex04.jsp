<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajax-study</title>
</head>
<style>
	
</style>
<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
<body>
	<div class="content">
		<h2>4. DTO(POST) 요청하기</h2>
		<p>
			<button type="button" onClick="myFunction()">전송</button>
		</p>
	</div>
	
<script>
	// Ajax는 제이쿼리 라이브러리를 포함(import)시켜야 한다
	const myFunction = function(){
		let greeting = "새해복많이받으세요";
		let number = 2024;
		//alert("text...");
		// ajax() 안에 {} 객체로 구성되어 있다는 의미 => {key: value, key: value, ,,,}형식
		$.ajax({
			// 요청 방식: GET, 요청 주소: /ex01, (함수) -> 성공, 실패
			// 객체 = 키값은 문자열로 함 (자바스크립트에서는 "" 생략 가능)
			type: "POST",
			url: "/ex04",
			data: {  // 변수를 받아서 넘겨줄 수 있음
				greet: greeting,
				num : number
			},
			success : function(res){  // res= 서버에서 보내주는 자료 => 페이지를 문자로 읽어줌
				console.log("성공", res);
			},
			error: function(){
				console.log("실패");
			}
		})
	}
</script>
</body>
</html>