package com.khit.web.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.khit.web.dto.BoardDTO;
import com.khit.web.mapper.BoardMapper;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class BoardServiceImpl implements BoardService{
	
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

}
