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
	
	int pageLimit = 10;  // �������� ǥ���� �Խñ� ��
	int blockLimit = 5;  // �ϴܿ� ǥ���� ������ ��
	
	@Override
	public List<BoardDTO> pagingList(int page) {
		/*
		   1page (0, 5), 2page(5,5), 3page(10,5), 4page(15,5)
		   select * from boards order by id desc limit 0, 5;
		 	
		 */

		int pageStart = (page - 1) * pageLimit; // ������ ���� �ε��� ��ȣ
		
		Map<String, Integer> pagingParam = new HashMap<>();
		pagingParam.put("start", pageStart);  // ������ ���� ��ȣ
		pagingParam.put("limit", pageLimit);  // ������ �Խñ� ��
		
		List<BoardDTO> pagingList = boardMapper.pagingList(pagingParam);
		return pagingList;
	}

	@Override
	public PageDTO pagingParam(int page) {
		// �ϴܿ� ������ ������ �� ���
		int totalRow = boardMapper.boardCount(); // ��ü �Խñ� ��
		// ��ü ������ ���� - �ø�(Math.ceil) 52/10 = 5.2 -> 6.0 => (int)6
		int maxPage = (int)(Math.ceil((double)totalRow/pageLimit));
		// �ϴܿ� ������ ���� �������� ���(1~5, 6~10 = 1, 6, 11, 16)
		int startPage = (((int)(Math.ceil((double)page/blockLimit))-1) * blockLimit) + 1 ;
		// �ϴܿ� ������ ������ �������� ���(5, 10, 15)
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
