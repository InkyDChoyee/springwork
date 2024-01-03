package com.khit.web.mapper;

import java.util.List;

import com.khit.web.dto.UserDTO;

public interface UserMapper {

	void insert(UserDTO userDTO);

	List<UserDTO> findAll();

	UserDTO findById(Long id);  // 회원 번호

	UserDTO login(UserDTO userDTO);

	UserDTO findByUserId(String userId); // 회원 아이디

	void update(UserDTO userDTO);

	void delete(Long id);
}
