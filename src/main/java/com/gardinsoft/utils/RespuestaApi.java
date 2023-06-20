package com.gardinsoft.utils;

import java.util.List;

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
	
	

}
