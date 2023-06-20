package com.gardinsoft.services;

import java.util.List;

import com.gardinsoft.models.Writer;

public interface IWriterService {
	
	public List<Writer> findAll();
	
	public Writer save(Writer writer);
	
}
