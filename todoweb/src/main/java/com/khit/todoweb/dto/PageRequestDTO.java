package com.khit.todoweb.dto;

import java.util.Arrays;

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
	
	// 0, 11, 21 => skip = ����(����)
	public int getSkip() {   // = #{skip}
		return (page - 1) * 10;   // 1p - 0, 2p - 10
	}
	
	// �˻� �κ�
	private String[] types;  // �˻� ����
	private String keyword;  // �˻���
	
	// �˻����� üũ�ڽ� üũ
	public boolean checkType(String type) {
		// Ÿ�Կ� üũ�� ������ ��ȯ���� ����
		if(types == null || types.length == 0) {
			return false;
		}
		// type�� ��ġ�Ǵ� ������ ��ȯ�Ѵٴ� �ǹ�
		return Arrays.stream(types).anyMatch(type::equals);
	}
	
}
