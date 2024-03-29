package com.khit.todoweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.khit.todoweb.dto.AjaxDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class AjaxController {  // Ajax요청 처리 컨트롤러
	@GetMapping("/ex01")
	public String ex01() {
		log.info("GET 요청 처리");
		return "/ajax-ex/main";     // main.jsp
		// http://localhost:8080/ajax/ex01 경로는 유지 = 비동기 방식
	}
	
	// @ResponseBody
	@PostMapping("/ex02")
	public @ResponseBody String ex02() {
		log.info("POST 요청 처리");
		return "/ajax-ex/main";     // 문자열로 /ajax-ex/main 반환
		// http://localhost:8080/ajax/ex02 경로는 유지 = 비동기 방식
	}
	
	@GetMapping("/ex03")
	public @ResponseBody String ex03(
			@RequestParam("greet") String greet,
			@RequestParam("num") int num) {
		log.info("greet: " + greet);
		log.info("num: " + num);
		return "success";
	}
	
	// ajaxDTO - object(객체)이므로 json(자바스크립트 데이터)으로 변환을 위해
	// jackson-databind를 주입해줘야 함
	@PostMapping("/ex04")
	public @ResponseBody AjaxDTO ex04(
			@ModelAttribute AjaxDTO ajaxDTO) {
		log.info("ajaxDTO= " + ajaxDTO);
		return ajaxDTO;
	}
}
