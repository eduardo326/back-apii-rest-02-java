package com.gardinsoft.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gardinsoft.models.Equipo;
import com.gardinsoft.repository.IEquipoDao;

@Service
public class IEquipoServiceImpl implements IEquipoService{
	
	@Autowired
	private IEquipoDao equipoDao;
	
	@Override
	public List<Equipo> findAll() {

		return (List<Equipo>) equipoDao.findAll();
	}
	
	@Override
	@Transactional
	public Equipo save(Equipo equipo) throws Exception {
		
		List<Equipo> equipoActual = equipoDao.findByNumeroSerial(equipo.getNumeroSerial());
		
		if(!equipoActual.isEmpty()) {
			throw new Exception("El equipo con numero de serie "+ equipo.getNumeroSerial() +" ya existe en la base de datos");
		}
		
		return equipoDao.save(equipo);
		
	}
	
	@Override
	@Transactional
	public Equipo update(Long id, Equipo equipo) throws Exception {
		Optional<Equipo> equipoActual = equipoDao.findById(id);
		List<Equipo> equiposRepetidos = equipoDao.findByNumeroSerial(equipo.getNumeroSerial());
		
		if(equipoActual.isEmpty()) {
			throw new Exception("El registro no existe en la base de datos");
		}
		
		if(!equiposRepetidos.isEmpty()) {
			if (equiposRepetidos.get(0).getId()!=id) {
				throw new Exception("El equipo con numero de serie "+ equipo.getNumeroSerial() +" no se puede usar, ya existe en la base de datos");
			}
		}
		
		equipoActual.get().setDescripcion(equipo.getDescripcion());
		equipoActual.get().setNombre(equipo.getNombre());
		equipoActual.get().setNumeroSerial(equipo.getNumeroSerial());
		equipoActual.get().setValorCompra(equipo.getValorCompra());
		
		return equipoDao.save(equipoActual.get());
		
	}

	@Override
	public Equipo findById(Long id) {
		
		return (Equipo) equipoDao.findById(id).orElse(null);
	}

	@Override
	public void delete(Long id) throws Exception {
		
		Optional<Equipo> equipoActual = equipoDao.findById(id);
		
		if(equipoActual.isEmpty()) {
			throw new Exception("El registro que quiere eliminar no existe en la base de datos");
		}
		
		equipoDao.deleteById(id);
	}
	
}
