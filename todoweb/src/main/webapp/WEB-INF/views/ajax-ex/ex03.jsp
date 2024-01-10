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
		<h2>3. DATA(GET) 요청하기</h2>
		<p>
			<button type="button" onClick="myFunction()">전송</button>
		</p>
	</div>
	
<script>
	// Ajax는 제이쿼리 라이브러리를 포함(import)시켜야 한다
	const myFunction = function(){
		//alert("text...");
		// ajax() 안에 {} 객체로 구성되어 있다는 의미 => {key: value, key: value, ,,,}형식
		$.ajax({
			// 요청 방식: GET, 요청 주소: /ex01, (함수) -> 성공, 실패
			type: "GET",
			url: "/ex03",
			data: {
				"greet": "안녕하세요",
				"num" : 10	
			},
			success : function(res){  // res= 서버에서 보내주는 자료 => 페이지를 문자로 읽어줌
				console.log("성공", res);
				if(res == "success") {
					alert("처리완료");
				}
			},
			error: function(){
				console.log("실패");
			}
		})
	}
</script>
</body>
</html>