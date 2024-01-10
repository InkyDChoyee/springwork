package com.khit.members.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.khit.members.dto.MemberDTO;
import com.khit.members.service.MemberService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor  // 생성자 주입 어너테이션
@Slf4j
@RequestMapping("/member")
@Controller
public class MemberController {
	
	private MemberService memberService;
	
	@GetMapping("/join")
	public String joinForm() {
		return "/member/join";
	}
	
	@PostMapping("/join")
	public String join(@ModelAttribute MemberDTO memberDTO) {
		log.info("MemberDTO = " + memberDTO);
		memberService.insert(memberDTO);
		return "/member/login";
	}
	
	@GetMapping("/login")
	public String loginForm() {
		return "/member/login";
	}

	@PostMapping("/login")
	public String login(@ModelAttribute MemberDTO memberDTO,
			HttpSession session) {
		MemberDTO loginMember = memberService.login(memberDTO);
		if(loginMember !=null) {
			session.setAttribute("sessionEmail", memberDTO.getEmail());
			return "/main";
		}else {
			return "/member/login";
		}
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();   // 모든 세션 삭제
		return "redirect:/";   // 강제 이동 = redirect
	}
	
}
