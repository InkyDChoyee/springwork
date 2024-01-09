package com.khit.todoweb.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PageRequestDTO { // �Ķ����(page, kw) ������ DTO
	// ����¡ �κ�
	private int page = 1;    // ������ ��ȣ
	private int size = 10;   // �������� �Խñ� ��
	
	public int getSkip() {   // = #{skip}
		return (page - 1) * 10;   // 1p - 0, 2p - 10
	}
	
	// �˻� �κ�
	private String[] types;  // �˻� ����
	private String keyword;  // �˻���
	
}
