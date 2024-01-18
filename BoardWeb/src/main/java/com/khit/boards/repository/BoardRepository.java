package com.khit.boards.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.khit.boards.dto.BoardDTO;

@Repository
public class BoardRepository {
	
	@Autowired
	private SqlSessionTemplate sql;
	// 지원 메서드 - insert(), update(), delete(), selectList(), selectAll()

	public void insert(BoardDTO boardDTO) {
		sql.insert("Board.insert", boardDTO);
	}

	public List<BoardDTO> findAll() {
		return sql.selectList("Board.findAll");
	}

	public void delete(Integer id) {
		sql.delete("Board.delete", id);
	}

	public BoardDTO findById(Integer id) {
		return sql.selectOne("Board.findById", id);
	}

	public void update(BoardDTO boardDTO) {
		sql.update("Board.update", boardDTO);
	}
}
