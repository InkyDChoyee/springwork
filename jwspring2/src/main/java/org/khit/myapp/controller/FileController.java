package org.khit.myapp.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class FileController {
	
	@GetMapping("/file/upload")
	public String uploadForm() {
		return "/file/uploadform";
	}
	
	@PostMapping("/file/upload")
	// MultipartFile class import => 여러 함수 사용 가능
	public String upload(MultipartFile filename, Model model) throws IllegalStateException, IOException {
		long fileSize = filename.getSize();
		String fileType = filename.getContentType();
//		log.info(originFilename);
		log.info(fileSize + "B");
		log.info(fileType);
		
		// 서버에 저장
		String filepath = "C:\\springwork\\jwspring2\\src\\main\\webapp\\upload";
		String savedFilename = filename.getOriginalFilename();
		
		// 파일 이름이 중복되지 않는 고유 ID 객체 생성 => UUID class import
		UUID uuid = UUID.randomUUID();
		savedFilename = uuid.toString() + "_" + savedFilename;
		
		File file = new File(filepath + "\\" + savedFilename);
		filename.transferTo(file);  // 서버폴더에 저장
		
		model.addAttribute("filename", savedFilename);
		
		return "/file/uploadform";
	}
}
