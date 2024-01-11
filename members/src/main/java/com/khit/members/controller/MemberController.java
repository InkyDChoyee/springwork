package com.khit.members.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	// 회원 목록
	@GetMapping("/")
	public String getMemberList(Model model) {
		List<MemberDTO> memberDTOList = memberService.findAll();
		model.addAttribute("memberList", memberDTOList);
		return "/member/list";
	}
	
	// 회원 상세
	@GetMapping
	public String getMember(@RequestParam("id") Long id, Model model) {
		MemberDTO memberDTO = memberService.findById(id);
		model.addAttribute("member", memberDTO);
		return "/member/detail";
	}
	
	// 회원 삭제
	@GetMapping("/delete")
	public String delete(@RequestParam("id") Long id) {
		memberService.delete(id);
		return "redirect:/member";
	}

	// 회원 수정
	@GetMapping("/update")
	public String updateForm(HttpSession session,
			Model model) {
		String email = (String)session.getAttribute("sessionEmail");
		MemberDTO memberDTO = memberService.findByEmail(email);
		model.addAttribute("member", memberDTO);
		return "/member/update";  // update.jsp
	}
	
	// 회원 수정 처리
	@PostMapping("/update")
	public String update(@ModelAttribute MemberDTO memberDTO){
		memberService.update(memberDTO);
		return "redirect:/member?id=" + memberDTO.getId();
	}
	
}
