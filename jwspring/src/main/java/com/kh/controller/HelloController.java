package com.kh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller  //클래스를 사용할 객체를(bean) 생성 - new 한것과 같음
public class HelloController {
	
	@RequestMapping("/hello")
	public String hello() {
		return "hello";  //hello.jsp
	}
}
