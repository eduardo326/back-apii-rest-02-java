package com.gardinsoft.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gardinsoft.models.Book;

public interface IBookDao extends JpaRepository<Book, Long>{
	
	public List<Book> findAll();
	
}
