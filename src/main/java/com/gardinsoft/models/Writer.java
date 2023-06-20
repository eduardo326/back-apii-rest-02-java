package com.gardinsoft.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="writers")
public class Writer implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, unique = true)
	private Long id;
	
	private String name;
	
	@Column(name = "last_name")
	private String lastName;
	
	@JsonIgnoreProperties(value={"writer", "hibernateLazyInitializer", "handler"}, allowSetters=true)
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "writer", cascade = CascadeType.ALL)
	private List<Book> books;
	
	
	public Writer() {
		this.books = new ArrayList<Book>();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public List<Book> getBooks() {
		return books;
	}
	
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
	public int numberBooks() {
		
		return books.size();
	}
}
