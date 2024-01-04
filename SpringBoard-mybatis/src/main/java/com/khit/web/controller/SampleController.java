package com.khit.web.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

import com.khit.web.dto.SampleDTO;

@Controller   // jsp���� ��ȯ
// RestController ��� �͵� �����Ѵ� = ����(json������ ��) ��ȯ
public class SampleController {

	@GetMapping("/exam01")
	// �����͸� ������ �� = Model ���
	public String exam01(Model model) {
		Date date = new Date();
		model.addAttribute("serverTime", date);
		return "/sample/exam01";   // exam01.jsp
	}
	
	// /exam02?name=�̼���&age=30
	@GetMapping("/exam02")
	public String exam02(@ModelAttribute SampleDTO sampleDTO) {
		return "/sample/exam02";   // exam02.jsp
	}
	
	@GetMapping("/exam03")
	public @ResponseBody SampleDTO exam03() {
		SampleDTO dto = new SampleDTO();
		dto.setName("ȫ�浿");
		dto.setAge(30);
		// key:value �������� ���� ��
		return dto;  
	}
	
}