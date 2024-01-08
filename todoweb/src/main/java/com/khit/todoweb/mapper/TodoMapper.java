package com.khit.todoweb.mapper;

import com.khit.todoweb.vo.TodoVO;

public interface TodoMapper {
	
	public String getTime();   // 현재 시간 테스트
	
	public void insert(TodoVO todoVO); //등록하기
}
