const checkUser = function(){
	//alert("가입");
	// 아이디는 4자 이상 15자 이하 까지 입력해주세요
	// 비밀번호는 영문자, 숫자, 특수문자 포함 8자 이상 입력해주세요
	// 이름은 한글로 입력해주세요
	// 나이는 숫자를 입력해주세요
	let form = document.userform//document.getElementById("userform");
	let id = document.getElementById("userId").value;
	let pw = document.getElementById("userPasswd").value;
	let name = document.getElementById("userName").value;
	let age = document.getElementById("userAge").value;
	
	// 정규 표현식
	let regName = /^[가-힣]+$/;   // 한글만
	let regPw1 = /[0-9]+/;  // 숫자
	let regPw2 = /[a-zA-Z]+/; // 영문자
	let regPw3 = /[~!@#$%^&*()\-=]+/; // 특수문자

	if(id == "" || id.length < 4 || id.length > 15) {
		alert("아이디는 4자 이상 15자 이하 까지 입력해주세요");
		document.getElementById("userId").select();
		return false;
	}else if(pw == "" || pw.length < 8 || !regPw1.test(pw) || !regPw2.test(pw) || !regPw3.test(pw)) {
		alert("비밀번호는 영문자, 숫자, 특수문자 포함 8자 이상 입력해주세요")
		document.getElementById("userPasswd").select();
		return false;
	}else if(name == "" || !regName.test(name)) {// 한글 정규식에 일치하지 않으면
		alert("이름은 한글로 입력해주세요")
		document.getElementById("userName").select();
		return false;
	}else if(age == "" || isNaN(age)) {
		alert("나이는 숫자를 입력해주세요")
		document.getElementById("userAge").select();
		return false;
	}
	else {
		form.submit();   // 유효하면 폼 전송
	}
} // checkUser 닫기

// ID 중복검사 순서
/*
	1. 아이디의 입력 값 가져오기
	2. 입력 값을 서버(controller)에 전송하고 중복된 아이디가 있는지 확인
*/
const checkId = function(){
	//alert("중복검사");
	let userId = document.getElementById("userId").value;
	let checkResult = document.getElementById("check-result");
	console.log(userId);
    if (userId === "") {
        checkResult.innerHTML = "아이디를 입력해주세요";
        checkResult.style.color = "black"; // 원하는 스타일로 변경하세요
        return;
    }
	$.ajax({
		// 요청방식:post, url:/user/checkuserid, data:userId
		type: "post",
		url: "/user/checkuserid",
		data: {"userId": userId},
		// 서버 응답 : 성공 / 실패
		success: function(response){
			console.log(response);
			if(response == "usable"){
				checkResult.innerHTML = "사용가능한 아이디입니다";
				checkResult.style.color = "blue";
			}else if (userId == "") {
				checkResult.innerHTML = "아이디를 입력해주세요";
			}
			
			else {
				checkResult.innerHTML = "이미 사용중인 아이디입니다";
				checkResult.style.color = "red";						
			}
		},
		error: function(error){
			console.log("에러발생", error);
		}
	});
}