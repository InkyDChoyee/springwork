package com.khit.members.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("main")
	// 로그인 됐을 때 main페이지가 열림
	public String main() {
		return "main";
	}
	
	// "/"경로에서 404 에러 발생
	@GetMapping("favicon.ico")
	@ResponseBody // - json 문자 데이터
	public void returnNoFavicon() {
		
	}
}
