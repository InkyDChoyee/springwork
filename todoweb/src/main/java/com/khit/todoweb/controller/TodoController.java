package com.khit.todoweb.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.khit.todoweb.dto.PageRequestDTO;
import com.khit.todoweb.dto.PageResponseDTO;
import com.khit.todoweb.dto.TodoDTO;
import com.khit.todoweb.service.TodoService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Slf4j
@RequestMapping("/todo")
@Controller
public class TodoController {
	
	private TodoService todoService;
	
	// 등록하기
	@GetMapping("/register")
	public String registerForm() {
		return "/todo/register";
	}
	
	// 등록하기
	@PostMapping("/register")
	public String register(@ModelAttribute TodoDTO todoDTO ) {
		log.info("todoDTO:" + todoDTO);
		todoService.insert(todoDTO);
		return "redirect:/todo/paging";
	}
	
	// 목록보기
	@GetMapping("/list")
	public String todoList(Model model) {
		List<TodoDTO> todoDTOList = todoService.findAll();
		model.addAttribute("todoList", todoDTOList);
		return "/todo/list";
	}
	
	// 페이지로 목록보기
	@GetMapping("/paging")
	public String todoPagingList(Model model,
								@ModelAttribute PageRequestDTO pageRequestDTO) {
		PageResponseDTO<TodoDTO> pageResponseDTO = todoService.pagingList(pageRequestDTO);  // class 를 담아서 보냄
		model.addAttribute("responseDTO", pageResponseDTO);
		return "/todo/pagelist";
	}
	
	// 1건 상세보기
	@GetMapping // 경로지정X => /todo?tno=1
	public String getTodo(Model model, 
			@RequestParam("tno") Long tno,
			PageRequestDTO pageRequestDTO) {
		TodoDTO todoDTO = todoService.findById(tno);
		model.addAttribute("todo", todoDTO);
		return "/todo/detail";
	}
	
	// 수정 페이지 요청
	@GetMapping("/update")
	public String updateFrom(Model model, @RequestParam("tno") Long tno) {
		// 해당 할일 가져오기
		TodoDTO todoDTO = todoService.findById(tno);	
		model.addAttribute("todo", todoDTO);
		return "/todo/update";
	}
	
	@PostMapping("/update")
	public String update(@ModelAttribute TodoDTO todoDTO) {
		todoService.update(todoDTO);
		return "redirect:/todo/update?tno=" + todoDTO.getTno();
	}

	// 삭제하기
	@GetMapping("/delete")
	public String delete(@RequestParam("tno") Long tno) {
		todoService.delete(tno);
		return "redirect:/todo/paging";
	}
	
}
