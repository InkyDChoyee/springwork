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
	// �α��� ���� �� main�������� ����
	public String main() {
		return "main";
	}
	
	// "/"��ο��� 404 ���� �߻�
	@GetMapping("favicon.ico")
	@ResponseBody // - json ���� ������
	public void returnNoFavicon() {
		
	}
}
