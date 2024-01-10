package com.khit.todoweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class AjaxController {  // Ajax��û ó�� ��Ʈ�ѷ�
	@GetMapping("/ex01")
	public String ex01() {
		log.info("GET ��û ó��");
		return "/ajax-ex/main";     // main.jsp
		// http://localhost:8080/ajax/ex01 ��δ� ���� = �񵿱� ���
	}
	
	// @ResponseBody
	@PostMapping("/ex02")
	public @ResponseBody String ex02() {
		log.info("POST ��û ó��");
		return "/ajax-ex/main";     // ���ڿ��� /ajax-ex/main ��ȯ
		// http://localhost:8080/ajax/ex02 ��δ� ���� = �񵿱� ���
	}
	
	@GetMapping("/ex03")
	public @ResponseBody String ex03(
			@RequestParam("greet") String greet,
			@RequestParam("num") int num) {
		log.info("greet: " + greet);
		log.info("num: " + num);
		return "success";
	}
}