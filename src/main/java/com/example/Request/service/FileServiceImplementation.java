package com.example.Request.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Request.Repository.FileRepository;
import com.example.Request.model.FileModel;

@Service
public class FileServiceImplementation implements FileService{

	@Autowired
	private  FileRepository filerepo;
	
	public void saveFile(FileModel fileModel) {
		filerepo.save(fileModel);
	}
	
	public  List<FileModel> getAllFiles(){
		return filerepo.findAll();
	}
	public FileModel getFile(int id) {
		  return filerepo.findById(id).get();
	}
}
