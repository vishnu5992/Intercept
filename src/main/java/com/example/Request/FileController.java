package com.example.Request;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.example.Request.model.FileModel;
import com.example.Request.service.FileServiceImplementation;

@Controller
public class FileController {
	
	@Autowired
	FileServiceImplementation fsi;
	
	@GetMapping("/")
    public String getUploadPage() {
		return "UploadFile";
	}
	
	@PostMapping("/processUpload")
	public String processUpload(@RequestParam("file") MultipartFile file, Model model) throws IOException {
		String content = file.getContentType();
		String name = file.getOriginalFilename();
		String fileType = file.getContentType();
		FileModel filemodel  = new FileModel(0, content,name,fileType);
		fsi.saveFiles(filemodel);
		model.addAttribute("allFiles",fsi.getAllFiles());
		return "Displayfiles";	
	}
	@GetMapping("/{id}")
	public ResponseEntity<String> getFile(@PathVariable int id) {
		FileModel fm = fsi.getFile(id);
		HttpHeaders header = new HttpHeaders();
		header.add(HttpHeaders.CONTENT_TYPE,fm.getFileType());
		header.add(HttpHeaders.CONTENT_DISPOSITION,"attachment; filename="+fm.getName());
		return  ResponseEntity.ok()
		  .headers(header)
		  .body(fm.getContent());
	}
}
