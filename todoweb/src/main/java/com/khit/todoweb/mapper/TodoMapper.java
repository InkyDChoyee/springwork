package com.khit.todoweb.mapper;

import com.khit.todoweb.vo.TodoVO;

public interface TodoMapper {
	
	public String getTime();
	
	public void insert(TodoVO todoVO); //등록하기
}
