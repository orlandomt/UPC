package com.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "reniec")
public class Reniec {

	private String reniec_dni;
    private String nombre;
    private String ap_paterno;
    private String ap_materno;
    private String direccion;
    
    @Id
    @Column(name = "reniec_dni")
    public String getReniec_dni() {
		return reniec_dni;
	}
	public void setReniec_dni(String reniec_dni) {
		this.reniec_dni = reniec_dni;
	}
	
	@Column(name = "nombre")
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Column(name = "ap_paterno")
	public String getAp_paterno() {
		return ap_paterno;
	}
	public void setAp_paterno(String ap_paterno) {
		this.ap_paterno = ap_paterno;
	}
	
	@Column(name = "ap_materno")
	public String getAp_materno() {
		return ap_materno;
	}
	public void setAp_materno(String ap_materno) {
		this.ap_materno = ap_materno;
	}
	
	@Column(name = "direccion")
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

    
    
}
