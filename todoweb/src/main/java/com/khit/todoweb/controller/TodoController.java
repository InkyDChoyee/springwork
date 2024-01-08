package com.khit.todoweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.khit.todoweb.dto.TodoDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/todo")
@Controller
public class TodoController {
	
	@GetMapping("/register")
	public String registerForm() {
		return "/todo/register";
	}
	
	@PostMapping("/register")
	public String register(@ModelAttribute TodoDTO todoDTO) {
		log.info("todoDTO : " + todoDTO);
		return "index";
	}
}
