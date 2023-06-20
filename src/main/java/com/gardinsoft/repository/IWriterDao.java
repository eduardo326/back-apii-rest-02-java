package com.gardinsoft.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gardinsoft.models.Writer;

public interface IWriterDao extends JpaRepository<Writer, Long>{
	
	@Query("from Writer")
	public List<Writer> findAllWriter();
	
}
