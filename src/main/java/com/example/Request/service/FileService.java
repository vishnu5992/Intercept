package com.example.Request.service;

import java.util.List;

import com.example.Request.model.FileModel;

public interface FileService {
         
	public  FileModel saveFiles(FileModel fileModel);
	public List<FileModel> getAllFiles();
	public FileModel getFile(int id);
	
	
	}
