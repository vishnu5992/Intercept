package com.example.Request.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="filemodel")
public class FileModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
    private int id;
	
	@Column(name="content")
	@Lob
    private byte[] content;
	
	@Column(name="name")
    private String name;
	
	@Column(name="filetype")
    private String fileType;
	
	public FileModel(int id, byte[] string, String name, String fileType) {
		super();
		this.id = id;
		this.content = string;
		this.name = name;
		this.fileType = fileType;
	}
	
	public FileModel() {
		super();
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public byte[] getContent() {
		return content;
	}
	public void setContent(byte[] content) {
		this.content = content;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
    
    
    
}
