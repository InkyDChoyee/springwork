package com.khit.web.mapper;

import java.util.List;

import com.khit.web.dto.BoardDTO;

public interface BoardMapper {

	void insert(BoardDTO boardDTO); // 글쓰기

	List<BoardDTO> findAll(); // 글 목록

	BoardDTO findById(Long id); // 글 상세보기

	void updateHit(Long id);

	void delete(Long id);

	void update(BoardDTO boardDTO);

}
