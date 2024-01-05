package com.khit.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.khit.web.dto.BoardDTO;
import com.khit.web.dto.PageDTO;
import com.khit.web.dto.ReplyDTO;
import com.khit.web.service.BoardService;
import com.khit.web.service.ReplyService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor  // 생성자 주입
@Slf4j
@RequestMapping("/board")
@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	private ReplyService replyService;
	
	// 글쓰기 페이지
	@GetMapping("/write")
	public String writeForm() {
		return "/board/write";
	}
	
	// 글쓰기
	@PostMapping("/write")
	public String write(BoardDTO boardDTO) {
//		log.info("boardDTO=" + boardDTO);
		boardService.insert(boardDTO);
		return "redirect:/board/";  // boardlist.jsp로 이동
	}
	
	// 글목록
	// /board/
	@GetMapping("/")
	public String getList(Model model) {
		List<BoardDTO> boardDTOList = boardService.findAll();
		model.addAttribute("boardList",boardDTOList);
		return "/board/boardlist";
	}
	
	// 글 목록 페이지 처리
	// /board/paging?page=2
	// @RequestParam(required=true/false) false는 필수가 아니다 라는 의미
	@GetMapping("/paging")
	public String getPageList(Model model, 
			 				// page가 필수가 아니라는 의미
			@RequestParam(value="page", required=false, defaultValue="1") int page) {
//		log.info("page=", + page);
		// 페이지와 글 개수를 구현된 목록 보기
		List<BoardDTO> pagingList = boardService.pagingList(page);
//		log.info("pagingList=", pagingList);
		model.addAttribute("boardList", pagingList);
		
		// 화면 하단 구현
		PageDTO pageDTO = boardService.pagingParam(page);
		model.addAttribute("paging", pageDTO);
		
		return "/board/pagelist";                          
	}
	
	// 글 상세보기
	// /board?id=
	@GetMapping
	public String getBoard(@RequestParam("id") Long id, Model model) {
	 	// 조회수 증가
		boardService.updateHit(id);
		
		// 글 상세보기
		BoardDTO boardDTO = boardService.findById(id);
		
		// 댓글 목록 보기
		List<ReplyDTO> replyListDTO = replyService.getReplyList(id);
		
	 	model.addAttribute("board", boardDTO);
	 	model.addAttribute("replyList", replyListDTO);
		return "/board/detail";
	}
	
	// 게시글 삭제
	@GetMapping("/delete")
	public String delete(@RequestParam("id") Long id) {
		boardService.delete(id);
		return "redirect:/board/";
	}
	
	// 게시글 수정
	@GetMapping("/update")
	public String update(Model model, @RequestParam("id") Long id) {
		BoardDTO baordDTO = boardService.findById(id);
		model.addAttribute("board",baordDTO);
		return "/board/boardupdate";
	}
	
	@PostMapping("/update")
	public String update(@ModelAttribute BoardDTO boardDTO) {
		boardService.update(boardDTO);
		return "redirect:/board?id=" + boardDTO.getId();
	}
}
