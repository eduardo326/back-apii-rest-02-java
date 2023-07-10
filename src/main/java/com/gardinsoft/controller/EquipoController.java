package com.gardinsoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.gardinsoft.models.Equipo;
import com.gardinsoft.services.IEquipoService;
import com.gardinsoft.utils.RespuestaApi;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/v1/equipos")
public class EquipoController {
	
	@Autowired
	private IEquipoService iEquipoService;
	
	private RespuestaApi resp = new RespuestaApi();
	
	@GetMapping("")
	public RespuestaApi<List<Equipo>> getEquipos() {
		resp = new RespuestaApi();
		
		resp.setMsg("Equipos consultados satisfactoriamente");
		resp.setData(iEquipoService.findAll());
		resp.setSucces(true);
		
		return  resp;
	}
	
	@GetMapping("/{id}")
	public RespuestaApi<List<Equipo>> getEquipo(@PathVariable Long id) {
		resp = new RespuestaApi();
		
		resp.setMsg("Equipo consultado satisfactoriamente");
		resp.setData(iEquipoService.findById(id));
		resp.setSucces(true);
		
		return  resp;
	}
	
	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	public RespuestaApi<Equipo> crearEquipo(@Valid @RequestBody Equipo equipo, BindingResult result) {
		resp = new RespuestaApi();
		
		if(result.hasErrors()) {
			resp.setErrors(result);
			return resp;
		}
		
		Equipo miEquipo;
		try {
			miEquipo = iEquipoService.save(equipo);
		} catch (Exception e) {
			
			resp.setMsg(e.getMessage());
			resp.setSucces(false);
			
			return resp;
		}
		
		resp.setMsg("Equipo creado correctamente");
		resp.setData(miEquipo);
		resp.setSucces(true);
		
		return resp;
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public RespuestaApi<Equipo> actualizarEquipo(@Valid @RequestBody Equipo equipo, BindingResult result, @PathVariable Long id) {
		resp = new RespuestaApi();
		
		if(result.hasErrors()) {
			resp.setErrors(result);
			return resp;
		}
		
		Equipo miEquipo;
		try {
			miEquipo = iEquipoService.update(id, equipo);
		} catch (Exception e) {
			resp.setMsg(e.getMessage());
			resp.setSucces(false);
			return resp;
			
		}
		
		resp.setMsg("Equipo actualizado correctamente");
		resp.setData(miEquipo);
		resp.setSucces(true);
		
		return resp;
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public RespuestaApi<Equipo> borrarEquipo(@PathVariable Long id) {
		resp = new RespuestaApi();
		
		try {
			iEquipoService.delete(id);
		} catch (Exception e) {
			resp.setMsg(e.getMessage());
			resp.setSucces(false);
			return resp;
			
		}
		
		resp.setMsg("Equipo eliminado correctamente");
		resp.setSucces(true);
		
		return resp;
	}
}
