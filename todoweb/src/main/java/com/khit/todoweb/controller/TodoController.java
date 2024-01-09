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
	
	// ����ϱ�
	@GetMapping("/register")
	public String registerForm() {
		return "/todo/register";
	}
	
	// ����ϱ�
	@PostMapping("/register")
	public String register(@ModelAttribute TodoDTO todoDTO ) {
		log.info("todoDTO:" + todoDTO);
		todoService.insert(todoDTO);
		return "redirect:/todo/paging";
	}
	
	// ��Ϻ���
	@GetMapping("/list")
	public String todoList(Model model) {
		List<TodoDTO> todoDTOList = todoService.findAll();
		model.addAttribute("todoList", todoDTOList);
		return "/todo/list";
	}
	
	// �������� ��Ϻ���
	@GetMapping("/paging")
	public String todoPagingList(Model model,
								@ModelAttribute PageRequestDTO pageRequestDTO) {
		PageResponseDTO<TodoDTO> pageResponseDTO = todoService.pagingList(pageRequestDTO);  // class �� ��Ƽ� ����
		model.addAttribute("responseDTO", pageResponseDTO);
		return "/todo/pagelist";
	}
	
	// 1�� �󼼺���
	@GetMapping // �������X => /todo?tno=1
	public String getTodo(Model model, 
			@RequestParam("tno") Long tno,
			PageRequestDTO pageRequestDTO) {
		TodoDTO todoDTO = todoService.findById(tno);
		model.addAttribute("todo", todoDTO);
		return "/todo/detail";
	}
	
	// ���� ������ ��û
	@GetMapping("/update")
	public String updateFrom(Model model, @RequestParam("tno") Long tno) {
		// �ش� ���� ��������
		TodoDTO todoDTO = todoService.findById(tno);	
		model.addAttribute("todo", todoDTO);
		return "/todo/update";
	}
	
	@PostMapping("/update")
	public String update(@ModelAttribute TodoDTO todoDTO) {
		todoService.update(todoDTO);
		return "redirect:/todo/update?tno=" + todoDTO.getTno();
	}

	// �����ϱ�
	@GetMapping("/delete")
	public String delete(@RequestParam("tno") Long tno) {
		todoService.delete(tno);
		return "redirect:/todo/paging";
	}
	
}
