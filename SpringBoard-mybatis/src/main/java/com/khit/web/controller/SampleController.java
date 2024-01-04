package com.khit.web.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

import com.khit.web.dto.SampleDTO;

@Controller   // jsp파일 반환
// RestController 라는 것도 존재한다 = 문자(json데이터 등) 반환
public class SampleController {

	@GetMapping("/exam01")
	// 데이터를 보내줄 때 = Model 사용
	public String exam01(Model model) {
		Date date = new Date();
		model.addAttribute("serverTime", date);
		return "/sample/exam01";   // exam01.jsp
	}
	
	// /exam02?name=이순신&age=30
	@GetMapping("/exam02")
	public String exam02(@ModelAttribute SampleDTO sampleDTO) {
		return "/sample/exam02";   // exam02.jsp
	}
	
	@GetMapping("/exam03")
	public @ResponseBody SampleDTO exam03() {
		SampleDTO dto = new SampleDTO();
		dto.setName("홍길동");
		dto.setAge(30);
		// key:value 형식으로 들어가게 됨
		return dto;  
	}
	
}
