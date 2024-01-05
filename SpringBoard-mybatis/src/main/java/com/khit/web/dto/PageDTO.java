package com.khit.web.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class PageDTO {
	private int page;      // 현재 페이지
	private int maxPage;   // 최대 페이지 (총개수에 따른 페이지)
	private int startPage; // 시작 페이지 (현재 페이지 기준)
	private int endPage;   // 끝 페이지 (현재 페이지 기준)
}
