package com.khit.todoweb.dto;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor 		//�⺻ ������
@AllArgsConstructor 	//�Ķ���Ͱ� �ִ� ������
@Data					//Getter, Setter, ToString
public class TodoDTO {
	//�ʵ�
	private Long tno;
	private String title;
	private String writer;
	private Timestamp createDate;
}