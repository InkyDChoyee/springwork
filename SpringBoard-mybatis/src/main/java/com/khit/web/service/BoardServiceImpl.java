package com.khit.web.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khit.web.dto.BoardDTO;
import com.khit.web.dto.PageDTO;
import com.khit.web.mapper.BoardMapper;

//import lombok.AllArgsConstructor;

//@AllArgsConstructor

@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	private BoardMapper boardMapper;

	@Override
	public void insert(BoardDTO boardDTO) {
		boardMapper.insert(boardDTO);
	}

	@Override
	public List<BoardDTO> findAll() {
		return boardMapper.findAll();
	}

	@Override
	public BoardDTO findById(Long id) {
		return boardMapper.findById(id);
	}

	@Override
	public void updateHit(Long id) {
		boardMapper.updateHit(id);
		
	}

	@Override
	public void delete(Long id) {
		boardMapper.delete(id);
		
	}

	@Override
	public void update(BoardDTO boardDTO) {
		boardMapper.update(boardDTO);
	}
	
	int pageLimit = 10;  // 페이지에 표시할 게시글 수
	int blockLimit = 5;  // 하단에 표시할 페이지 수
	
	@Override
	public List<BoardDTO> pagingList(int page) {
		/*
		   1page (0, 5), 2page(5,5), 3page(10,5), 4page(15,5)
		   select * from boards order by id desc limit 0, 5;
		 	
		 */

		int pageStart = (page - 1) * pageLimit; // 페이지 시작 인덱스 번호
		
		Map<String, Integer> pagingParam = new HashMap<>();
		pagingParam.put("start", pageStart);  // 페이지 시작 번호
		pagingParam.put("limit", pageLimit);  // 페이지 게시글 수
		
		List<BoardDTO> pagingList = boardMapper.pagingList(pagingParam);
		return pagingList;
	}

	@Override
	public PageDTO pagingParam(int page) {
		// 하단에 보여줄 페이지 블럭 계산
		int totalRow = boardMapper.boardCount(); // 전체 게시글 수
		// 전체 페이지 개수 - 올림(Math.ceil) 52/10 = 5.2 -> 6.0 => (int)6
		int maxPage = (int)(Math.ceil((double)totalRow/pageLimit));
		// 하단에 보여줄 시작 페이지값 계산(1~5, 6~10 = 1, 6, 11, 16)
		int startPage = (((int)(Math.ceil((double)page/blockLimit))-1) * blockLimit) + 1 ;
		// 하단에 보여줄 마지막 페이지값 계산(5, 10, 15)
		int endPage = startPage + blockLimit - 1;
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		PageDTO pageDTO = new PageDTO();
		pageDTO.setPage(page);
		pageDTO.setMaxPage(maxPage);
		pageDTO.setStartPage(startPage);
		pageDTO.setEndPage(endPage);
		return pageDTO;
	}
}
