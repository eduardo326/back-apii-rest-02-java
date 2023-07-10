package com.gardinsoft.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

public class RespuestaApi<T> {
	
	private String msg;
	private List<String> errors;
	private boolean succes;
	private T data;
	
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public List<String> getErrors() {
		return errors;
	}
	public void setErrors(List<String> errors) {
		this.errors = errors;
	}
	public boolean isSucces() {
		return succes;
	}
	public void setSucces(boolean succes) {
		this.succes = succes;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	
	public void setErrors(BindingResult result) {
		if(result.hasErrors()) {
			List<String> errors = new ArrayList<>();
			
			for (FieldError err: result.getFieldErrors()) {
				errors.add("El campo '"+err.getField()+"' "+err.getDefaultMessage());
			}
			
			this.errors = errors;
			this.succes=false;
			this.msg="Error en la validacion de campos";
			
		} 
	}

}
