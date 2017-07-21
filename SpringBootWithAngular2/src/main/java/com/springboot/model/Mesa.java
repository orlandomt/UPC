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
	
	private Long cod_mesa;
	private String nombre_mesa;
	private boolean disponibilidad;
	private Date fecha_mesa;
	private String hora_mesa;
	private String sugerencia_mesa;
	private Long reservadoPor_mesa;
	
	@Id
    @Column(name = "cod_mesa")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getCod_mesa() {
		return cod_mesa;
	}
	public void setCod_mesa(Long cod_mesa) {
		this.cod_mesa = cod_mesa;
	}
	
	@Column(name = "nombre_mesa")
	public String getNombre_mesa() {
		return nombre_mesa;
	}
	public void setNombre_mesa(String nombre_mesa) {
		this.nombre_mesa = nombre_mesa;
	}
	
	@Column(name = "disponibilidad")
	public boolean isDisponibilidad() {
		return disponibilidad;
	}
	public void setDisponibilidad(boolean disponibilidad) {
		this.disponibilidad = disponibilidad;
	}
	
	@Column(name = "fecha_mesa")
	public Date getFecha_mesa() {
		return fecha_mesa;
	}
	public void setFecha_mesa(Date fecha_mesa) {
		this.fecha_mesa = fecha_mesa;
	}
	
	@Column(name = "hora_mesa")
	public String getHora_mesa() {
		return hora_mesa;
	}
	public void setHora_mesa(String hora_mesa) {
		this.hora_mesa = hora_mesa;
	}
	
	@Column(name = "sugerencia_mesa")
	public String getSugerencia_mesa() {
		return sugerencia_mesa;
	}
	public void setSugerencia_mesa(String sugerencia_mesa) {
		this.sugerencia_mesa = sugerencia_mesa;
	}
	
	@Column(name = "reservadoPor_mesa")
	public Long getReservadoPor_mesa() {
		return reservadoPor_mesa;
	}
	public void setReservadoPor_mesa(Long reservadoPor_mesa) {
		this.reservadoPor_mesa = reservadoPor_mesa;
	}
	
}
