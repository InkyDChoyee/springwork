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
	
	@Autowired	//�ڵ����� - todoMapper�� new�ѰŶ� ����
	private TodoMapper todoMapper;
	
	@Test
	public void testGetTime() {
		log.info(todoMapper.getTime());
	}
	
//	@Test
//	public void testInsert() {
//		//������ 1�� ���� - setter -> builer()
//		
//		/*TodoVO todoVO = new TodoVO();
//		//todoVO.setTno(1L);
//		todoVO.setTitle("12�� ���� ��ħ ����");
//		todoVO.setWriter("�����");
//		//todoVO.setCreatedDate(new Timestamp(System.currentTimeMillis()));*/
//		
//		TodoVO todoVO = TodoVO.builder()
//				.title("20�� ��ϱ�")
//				.writer("user01")
//				.build();
//		
//		todoMapper.insert(todoVO);
//	}
	
	@Test
	public void testFindAll() {
		// db�� �ִ� ������ �����ϱ�
		List<TodoVO> todoList = todoMapper.findAll();
		
//		for(TodoVO todo : todoList) {
//			log.info(todo);
//		}
		// ���ٽ����� ���
		todoList.forEach(todo -> log.info(todo));
	}
	
	@Test
	public void testFindById() {
		// ������ 1�� ��������
		// db���� 1�� ������ �˻�(1L)
		TodoVO todoVO = todoMapper.findById(1L);
		log.info(todoVO);
	}
//	
//	@Test
//	public void testDelete() {
//		todoMapper.delete(7L);
//		log.info("���� �Ϸ�");
//	}
	
//	@Test
//	public void testUpdate() {
//		TodoVO todoVO = todoMapper.findById(10L);
//		todoVO.setTno(10L);
//		todoVO.setTitle("�׽�Ʈ����");
//		todoVO.setWriter("�׽���2");
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
