package com.example.Request;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.Request.Repository.FileRepository;
import com.example.Request.model.FileModel;
import com.example.Request.service.FileServiceImplementation;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;


@RunWith(SpringRunner.class)
@SpringBootTest
public class File {

	
	   @Autowired
	   FileServiceImplementation fsi;
	   
	   @MockBean
	   FileRepository repo;
	
	@Test
	public void fileGet() {
		
		byte[] apple1 = null;
		when(repo.findAll()).thenReturn((List<FileModel>) Stream.of(new FileModel(1,apple1,"apple","jpg")).collect(Collectors.toList()));
		assertEquals(1,fsi.getAllFiles().size());

		}
	
	@Test
	public void saveFile() {
		byte[] content = null;
		FileModel fm = new FileModel(2,content,"orange","jpg");
		when(repo.save(fm)).thenReturn(fm);
		assertEquals(fm,fsi.saveFiles(fm));
	}
	
}
