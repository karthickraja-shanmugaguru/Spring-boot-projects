package com.example.demoimage;

import com.example.demoimage.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@SpringBootApplication
@RestController
@RequestMapping("api/images")
public class DemoImageApplication {
	@Autowired
	private StorageService service;
	@PostMapping
	public ResponseEntity<?> uploadImage(@RequestParam("image")MultipartFile file) throws IOException {
		String uploadImage = service.uploadImage(file);
		return ResponseEntity.status(HttpStatus.OK)
				.body(uploadImage);
	}
	@GetMapping("/{fileId}")
	public  ResponseEntity<?> downloadImage(@PathVariable Long fileId){
		byte[] imageDate =service.downloadImage(fileId);
	return ResponseEntity.status(HttpStatus.OK )
			.contentType(MediaType.valueOf("image/png"))
			.body(imageDate);
	}
	public static void main(String[] args) {
		SpringApplication.run(DemoImageApplication.class, args);
	}


}
