package com.khit.todoweb.vo;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder   // getter, setter 를 쉽게 해줌
@NoArgsConstructor    // 기본 생성자
@AllArgsConstructor   // 매개변수(파라미터)가 있는 생성자
@Data   // = Getter, Setter, ToString
public class TodoVO {
	// 필드
	private Long tno;
	private String title;
	private String writer;
	private Timestamp createDate;
}
