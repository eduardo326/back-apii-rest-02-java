package com.gardinsoft.services;

import java.util.List;
import java.util.Optional;

import com.gardinsoft.models.Equipo;

public interface IEquipoService {

	public List<Equipo> findAll();
	
	public Equipo save(Equipo equipo) throws Exception;
	
	public Equipo findById(Long id);
	
	public void delete(Long id) throws Exception;

	public Equipo update(Long id, Equipo equipo) throws Exception;
	
}
