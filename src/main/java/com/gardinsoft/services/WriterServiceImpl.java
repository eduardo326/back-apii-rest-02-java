package com.gardinsoft.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gardinsoft.models.Writer;
import com.gardinsoft.repository.IWriterDao;

@Service
public class WriterServiceImpl implements IWriterService{
	
	@Autowired
	private IWriterDao writerDao;
	
	@Override
	public List<Writer> findAll() {
		// TODO Auto-generated method stub
		return (List<Writer>) writerDao.findAll();
	}
	
	@Override
	@Transactional
	public Writer save(Writer writer) {
		// TODO Auto-generated method stub
		return writerDao.save(writer);
	}


}
