package com.khit.todoweb.mapper;

import java.util.List;

//import java.sql.Timestamp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.khit.todoweb.dto.PageRequestDTO;
import com.khit.todoweb.mapper.TodoMapper;
import com.khit.todoweb.vo.TodoVO;

import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src\\main\\webapp\\WEB-INF\\spring\\root-context.xml")
public class TodoMapperTest {
	
	@Autowired	//자동주입 - todoMapper가 new한거랑 같음
	private TodoMapper todoMapper;
	
	@Test
	public void testGetTime() {
		log.info(todoMapper.getTime());
	}
	
//	@Test
//	public void testInsert() {
//		//데이터 1개 생성 - setter -> builer()
//		
//		/*TodoVO todoVO = new TodoVO();
//		//todoVO.setTno(1L);
//		todoVO.setTitle("12시 전에 취침 실패");
//		todoVO.setWriter("대상현");
//		//todoVO.setCreatedDate(new Timestamp(System.currentTimeMillis()));*/
//		
//		TodoVO todoVO = TodoVO.builder()
//				.title("20분 운동하기")
//				.writer("user01")
//				.build();
//		
//		todoMapper.insert(todoVO);
//	}
	
	@Test
	public void testFindAll() {
		// db에 있는 데이터 추출하기
		List<TodoVO> todoList = todoMapper.findAll();
		
//		for(TodoVO todo : todoList) {
//			log.info(todo);
//		}
		// 람다식으로 출력
		todoList.forEach(todo -> log.info(todo));
	}
	
	@Test
	public void testFindById() {
		// 데이터 1개 가져오기
		// db에서 1번 데이터 검색(1L)
		TodoVO todoVO = todoMapper.findById(1L);
		log.info(todoVO);
	}
//	
//	@Test
//	public void testDelete() {
//		todoMapper.delete(7L);
//		log.info("삭제 완료");
//	}
	
//	@Test
//	public void testUpdate() {
//		TodoVO todoVO = todoMapper.findById(10L);
//		todoVO.setTno(10L);
//		todoVO.setTitle("테스트수정");
//		todoVO.setWriter("테스터2");
//		
//		todoMapper.update(todoVO);
//	}
	
	@Test
	public void testPagingList() {
		PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
				.page(1)
				.size(10)
				.build();
		List<TodoVO> todoList = todoMapper.pagingList(pageRequestDTO);
		for(TodoVO todo : todoList) {
			log.info(todo);
		}
	}
}
