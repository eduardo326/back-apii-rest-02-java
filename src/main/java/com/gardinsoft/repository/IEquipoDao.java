package com.gardinsoft.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gardinsoft.models.Equipo;

public interface IEquipoDao  extends JpaRepository<Equipo, Long>{
	
	public List<Equipo> findAll();
	
	public Optional<Equipo> findById(Long id);
	
	public List<Equipo> findByNumeroSerial(String numeroSerial);
	
}
