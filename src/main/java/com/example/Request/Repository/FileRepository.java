package com.example.Request.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Request.model.FileModel;

@Repository
public interface FileRepository extends JpaRepository<FileModel,Long> {

	Optional<FileModel> findById(int id);

	
	
	

}
