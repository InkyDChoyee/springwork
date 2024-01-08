package com.khit.todoweb.service;

import org.springframework.stereotype.Service;

import com.khit.todoweb.dto.TodoDTO;
import com.khit.todoweb.mapper.TodoMapper;
import com.khit.todoweb.vo.TodoVO;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class TodoServiceImpl implements TodoService{

	private TodoMapper todoMapper;
	
	@Override
	public void insert(TodoDTO todoDTO) {
		// DTO를 VO로 변환해야 -> DB에 데이터를 저장
		// 1. 모듈(ModelMapper)을 사용안한 경우
		TodoVO todoVO = TodoVO.builder()
				.title(todoDTO.getTitle())
				.writer(todoDTO.getWriter())
				.build();
		
		todoMapper.insert(todoVO);
	}

}
