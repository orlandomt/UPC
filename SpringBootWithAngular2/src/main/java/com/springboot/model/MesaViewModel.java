package com.springboot.model;

import java.util.Date;

public class MesaViewModel {

	private String cod_mesa;
	private String tipo_mesa;
	private Date fechaActual;
	private String disponibilidad;
	public String getCod_mesa() {
		return cod_mesa;
	}
	public void setCod_mesa(String cod_mesa) {
		this.cod_mesa = cod_mesa;
	}
	public String getTipo_mesa() {
		return tipo_mesa;
	}
	public void setTipo_mesa(String tipo_mesa) {
		this.tipo_mesa = tipo_mesa;
	}
	public Date getFechaActual() {
		return fechaActual;
	}
	public void setFechaActual(Date fechaActual) {
		this.fechaActual = fechaActual;
	}
	public String getDisponibilidad() {
		return disponibilidad;
	}
	public void setDisponibilidad(String disponibilidad) {
		this.disponibilidad = disponibilidad;
	}
	
	
}
