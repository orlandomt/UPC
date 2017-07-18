package com.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mesa")
public class Mesa {
	
	private String cod_mesa;
	private boolean disponibilidad;
	private String ambiente;
	private String sugerencia;
	private boolean reservado_dni;
	
	@Id
    @Column(name = "cod_mesa")
	public String getCod_mesa() {
		return cod_mesa;
	}
	public void setCod_mesa(String cod_mesa) {
		this.cod_mesa = cod_mesa;
	}
	
	@Column(name = "disponibilidad")
	public boolean isDisponibilidad() {
		return disponibilidad;
	}
	public void setDisponibilidad(boolean disponibilidad) {
		this.disponibilidad = disponibilidad;
	}
	
	@Column(name = "ambiente")
	public String getAmbiente() {
		return ambiente;
	}
	public void setAmbiente(String ambiente) {
		this.ambiente = ambiente;
	}
	
	@Column(name = "sugerencia")
	public String getSugerencia() {
		return sugerencia;
	}
	public void setSugerencia(String sugerencia) {
		this.sugerencia = sugerencia;
	}
	
	@Column(name = "reservado_dni")
	public boolean isReservado_dni() {
		return reservado_dni;
	}
	public void setReservado_dni(boolean reservado_dni) {
		this.reservado_dni = reservado_dni;
	}
	
	
	
}
