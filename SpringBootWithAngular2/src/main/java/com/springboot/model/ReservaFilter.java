package com.springboot.model;

import java.util.Date;

public class ReservaFilter {

	private String cod_local;
	private Date fechaInicio;
	private Date fechaFin;
	private String tipo_reserva;
	private String ap_paterno;
	private String nombre;
	public String getCod_local() {
		return cod_local;
	}
	public void setCod_local(String cod_local) {
		this.cod_local = cod_local;
	}
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public Date getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	public String getTipo_reserva() {
		return tipo_reserva;
	}
	public void setTipo_reserva(String tipo_reserva) {
		this.tipo_reserva = tipo_reserva;
	}
	public String getAp_paterno() {
		return ap_paterno;
	}
	public void setAp_paterno(String ap_paterno) {
		this.ap_paterno = ap_paterno;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
}
