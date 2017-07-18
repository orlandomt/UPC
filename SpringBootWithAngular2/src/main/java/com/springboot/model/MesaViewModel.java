package com.springboot.model;

public class MesaViewModel {

	private String cod_mesa;
	private boolean disponibilidad;
	private String ambiente;
	private String sugerencia;
	private boolean reservado_dni;
	
	public String getCod_mesa() {
		return cod_mesa;
	}
	public void setCod_mesa(String cod_mesa) {
		this.cod_mesa = cod_mesa;
	}
	public boolean isDisponibilidad() {
		return disponibilidad;
	}
	public void setDisponibilidad(boolean disponibilidad) {
		this.disponibilidad = disponibilidad;
	}
	public String getAmbiente() {
		return ambiente;
	}
	public void setAmbiente(String ambiente) {
		this.ambiente = ambiente;
	}
	public String getSugerencia() {
		return sugerencia;
	}
	public void setSugerencia(String sugerencia) {
		this.sugerencia = sugerencia;
	}
	public boolean isReservado_dni() {
		return reservado_dni;
	}
	public void setReservado_dni(boolean reservado_dni) {
		this.reservado_dni = reservado_dni;
	}
	
	
	
	
	
}
