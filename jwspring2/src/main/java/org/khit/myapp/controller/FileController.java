package org.khit.myapp.controller;

import org.springframework.stereotype.Controller;
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
	public String upload(MultipartFile filename) {
		String originFilename = filename.getOriginalFilename();
		long fileSize = filename.getSize();
		String fileType = filename.getContentType();
		log.info(originFilename);
		log.info(fileSize + "B");
		log.info(fileType);
		
		return "/file/uploadform";
	}
}
