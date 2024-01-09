package com.khit.todoweb.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PageRequestDTO { // 파라미터(page, kw) 수집용 DTO
	// 페이징 부분
	private int page = 1;    // 페이지 번호
	private int size = 10;   // 페이지당 게시글 수
	
	public int getSkip() {   // = #{skip}
		return (page - 1) * 10;   // 1p - 0, 2p - 10
	}
	
	// 검색 부분
	private String[] types;  // 검색 유형
	private String keyword;  // 검색어
	
}
