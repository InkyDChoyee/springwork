package org.khit.myapp.dto;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
public class BoardDTO {
	//필드
	private Long id;            //글번호
	private String boardTitle;  //글제목
	private String boardWriter; //글쓴이
	private String boardContent; //글내용
	private Timestamp createdTime; //작성일
}
