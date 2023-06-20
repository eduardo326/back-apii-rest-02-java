package com.gardinsoft.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.gardinsoft.models.Book;
import com.gardinsoft.models.Writer;
import com.gardinsoft.services.IWriterService;
import com.gardinsoft.services.WriterServiceImpl;
import com.gardinsoft.utils.RespuestaApi;

@RestController
public class ApiController {
	
	@Autowired
	private IWriterService iWriteService;
	
	private RespuestaApi resp = new RespuestaApi();
	
	@GetMapping("/writers")
	public RespuestaApi<List<Writer>> getWriters() {
		
		resp.setMsg("Usuarios consultados satisfactoriamente");
		resp.setData(iWriteService.findAll());
		resp.setSucces(true);
		
		return  resp;
	}
	
	@PostMapping("/writers")
	@ResponseStatus(HttpStatus.CREATED)
	public RespuestaApi<Writer> newWriter(@RequestBody Writer writer) {
		
		Writer miWriter = iWriteService.save(writer);
		
		resp.setMsg("Usuario creado correctamente");
		resp.setData(miWriter);
		resp.setSucces(true);
		
		return resp;
	}

}
