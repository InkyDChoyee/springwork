package com.khit.todoweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	// "/"경로에서 404 에러 발생
	@GetMapping("favicon.ico")
	@ResponseBody // - json 문자 데이터
	public void returnNoFavicon() {
		
	}
}
