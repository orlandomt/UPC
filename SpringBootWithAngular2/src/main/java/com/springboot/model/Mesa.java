package com.springboot.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mesa")
public class Mesa {

	private String cod_mesa;
	private String tipo_mesa;
	private Date fechaActual;
	private String disponibilidad;
	
	@Id
    @Column(name = "cod_mesa")
	public String getCod_mesa() {
		return cod_mesa;
	}
	public void setCod_mesa(String cod_mesa) {
		this.cod_mesa = cod_mesa;
	}
	
	@Column(name = "tipo_mesa")
	public String getTipo_mesa() {
		return tipo_mesa;
	}
	public void setTipo_mesa(String tipo_mesa) {
		this.tipo_mesa = tipo_mesa;
	}
	
	@Column(name = "fechaActual")
	public Date getFechaActual() {
		return fechaActual;
	}
	public void setFechaActual(Date fechaActual) {
		this.fechaActual = fechaActual;
	}
	
	@Column(name = "disponibilidad")
	public String getDisponibilidad() {
		return disponibilidad;
	}
	public void setDisponibilidad(String disponibilidad) {
		this.disponibilidad = disponibilidad;
	}
	
	
}
