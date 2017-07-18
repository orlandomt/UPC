package com.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "local")
public class Local {
	
	private Long cod_local;
	private String ubicacion;
	private String telefono;
	private Long aforo;
	
	@Id
    @Column(name = "cod_local")
	public Long getCod_local() {
		return cod_local;
	}
	public void setCod_local(Long cod_local) {
		this.cod_local = cod_local;
	}
	
	@Column(name = "ubicacion")
	public String getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	
	@Column(name = "telefono")
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	@Column(name = "aforo")
	public Long getAforo() {
		return aforo;
	}
	public void setAforo(Long aforo) {
		this.aforo = aforo;
	}
	
	

}
