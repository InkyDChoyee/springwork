package com.khit.todoweb.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.khit.todoweb.dto.PageRequestDTO;
import com.khit.todoweb.dto.PageResponseDTO;
import com.khit.todoweb.dto.TodoDTO;
import com.khit.todoweb.mapper.TodoMapper;
import com.khit.todoweb.vo.TodoVO;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class TodoServiceImpl implements TodoService {
	// �������� �Ű������� ��
	private TodoMapper todoMapper;
	private ModelMapper modelMapper;

	@Override
	public void insert(TodoDTO todoDTO) {
		// DTO�� VO�� ��ȯ�ؾ� -> DB�� �����͸� ����
		// 1. ���(ModelMapper)�� ������ ���
		TodoVO todoVO = TodoVO.builder().title(todoDTO.getTitle()).writer(todoDTO.getWriter()).build();
		todoMapper.insert(todoVO);

		// 2. ���(ModelMapper)�� ����� ���
//		TodoVO todoVO = modelMapper.map(todoDTO, TodoVO.class);
//		todoMapper.insert(todoVO);
	}

	@Override
	public List<TodoDTO> findAll() {
		// vo�� dto�� ��ȯ�ؾ� -> DB���� �����͸� ����
		// vo����Ʈ ������ ��������
		List<TodoVO> voList = todoMapper.findAll();
		
		// dto�� ��ȯ�ؼ� ��ȯ�� ��
		List<TodoDTO> dtoList = new ArrayList<>();
		for(TodoVO todoVO : voList) {
			// vo -> dto
			TodoDTO todoDTO = TodoDTO.builder()
					.tno(todoVO.getTno())
					.title(todoVO.getTitle())
					.writer(todoVO.getWriter())
					.createDate(todoVO.getCreateDate())
					.build();
			dtoList.add(todoDTO);
		}
		// vo ����Ʈ�� dto�� �����ϰ� ��ȯ��(���ٽ����� ����)
//		List<TodoDTO> dtoList = voList.stream()
//								.map(vo -> modelMapper.map(vo, TodoDTO.class))
//								.collect(Collectors.toList());
		return dtoList;
	}

	@Override
	public TodoDTO findById(Long tno) {
		// vo�� �������� dto�� ��ȯ
		TodoVO todoVO = todoMapper.findById(tno);
		/*TodoDTO todoDTO = TodoDTO.builder()
				.tno(todoVO.getTno())
				.title(todoVO.getTitle())
				.writer(todoVO.getWriter())
				.createDate(todoVO.getCreateDate())
				.build();*/
		TodoDTO todoDTO = modelMapper.map(todoVO, TodoDTO.class);
		return todoDTO;
	}
	
	@Override
	public void update(TodoDTO todoDTO) {
		TodoVO todoVO = modelMapper.map(todoDTO, TodoVO.class);
		todoMapper.update(todoVO);
	}

	@Override
	public void delete(Long tno) {
		todoMapper.delete(tno);
	}

	@Override
	public PageResponseDTO<TodoDTO> pagingList(PageRequestDTO pageRequestDTO) {
		// db���� voList ��������
		List<TodoVO> voList = todoMapper.pagingList(pageRequestDTO);
		// voList�� dtoList�� ��ȯ 
		List<TodoDTO> dtoList = voList.stream()
									  .map(vo -> modelMapper.map(vo, TodoDTO.class))
				                      .collect(Collectors.toList());
		// ��ü ������ ���� ������
		int total = todoMapper.todoCount();
		
		PageResponseDTO<TodoDTO> pageResponseDTO = PageResponseDTO.<TodoDTO>withAll()  // builder() ��� Ȱ��
																.dtoList(dtoList)
																.total(total)
																.pageRequestDTO(pageRequestDTO)
																.build();
		return pageResponseDTO;
	}
}
