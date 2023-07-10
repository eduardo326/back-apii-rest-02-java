package com.gardinsoft.models;

import java.io.Serializable;
import java.util.Date;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="equipos")
public class Equipo implements Serializable{
	
	private static final long serialVersionUID = 2944165943652821653L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, unique = true)
	private Long id;
	
	@NotNull
	@Column(unique=true)
	private String numeroSerial;
	
	private String descripcion;
	
	private String nombre; 
	
	private Date fechaCompra;
	
	private double valorCompra;
	
	private double valorDepreciado;
	private Date fechaCreacion;
	private Date fechaModificacion;
	
	@PrePersist
	public void prePersist() {
		this.fechaCreacion = new Date();
		this.fechaModificacion = new Date();
		this.valorDepreciado=this.valorCompra-(this.valorCompra*0.04);
	}
	
	@PreUpdate
	public void preUpdate() {
		this.fechaModificacion = new Date();
		this.valorDepreciado=this.valorCompra-(this.valorCompra*0.04);
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNumeroSerial() {
		return numeroSerial;
	}
	public void setNumeroSerial(String numeroSerial) {
		this.numeroSerial = numeroSerial;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Date getFechaCompra() {
		return fechaCompra;
	}
	public void setFechaCompra(Date fechaCompra) {
		this.fechaCompra = fechaCompra;
	}
	public double getValorCompra() {
		return valorCompra;
	}
	public void setValorCompra(double valorCompra) {
		this.valorCompra = valorCompra;
	}
	public double getValorDepreciado() {
		return valorDepreciado;
	}
	public void setValorDepreciado(double valorDepreciado) {
		this.valorDepreciado = valorDepreciado;
	}
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public Date getFechaModificacion() {
		return fechaModificacion;
	}
	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}
	
}
