package com.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "carta")
public class Carta {
	
	private Long id_carta;
	private String cod_carta;
	private String nombre_carta;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_carta")
	public Long getId_carta() {
		return id_carta;
	}
	public void setId_carta(Long id_carta) {
		this.id_carta = id_carta;
	}
	
	@Column(name = "cod_carta")
	public String getCod_carta() {
		return cod_carta;
	}
	public void setCod_carta(String cod_carta) {
		this.cod_carta = cod_carta;
	}
	
	@Column(name = "nombre_carta")
	public String getNombre_carta() {
		return nombre_carta;
	}
	public void setNombre_carta(String nombre_carta) {
		this.nombre_carta = nombre_carta;
	}
	
	

}
