package com.springboot.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "delivery")
public class Delivery {
	
	private Long id_deliv;
	private String latitude;
	private String longitud;
	private Long dni;
	private String estado_deliv;
	private Date fecha_deliv;
	private Date horaestimada_deliv;
	private String cod_carta_deliv;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_deliv")
	public Long getId_deliv() {
		return id_deliv;
	}
	public void setId_deliv(Long id_deliv) {
		this.id_deliv = id_deliv;
	}
	
	@Column(name = "estado_deliv")
	public String getEstado_deliv() {
		return estado_deliv;
	}
	public void setEstado_deliv(String estado_deliv) {
		this.estado_deliv = estado_deliv;
	}
	
	@Column(name = "fecha_deliv")
	public Date getFecha_deliv() {
		return fecha_deliv;
	}
	public void setFecha_deliv(Date fecha_deliv) {
		this.fecha_deliv = fecha_deliv;
	}
	
	@Column(name = "cod_carta_deliv")
	public String getCod_carta_deliv() {
		return cod_carta_deliv;
	}
	public void setCod_carta_deliv(String cod_carta_deliv) {
		this.cod_carta_deliv = cod_carta_deliv;
	}
	
	@Column(name = "dni")
	public Long getDni() {
		return dni;
	}
	public void setDni(Long dni) {
		this.dni = dni;
	}
	
	@Column(name = "latitude")
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	
	@Column(name = "longitud")
	public String getLongitud() {
		return longitud;
	}
	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}
	
	@Column(name = "horaestimada_deliv")
	public Date getHoraestimada_deliv() {
		return horaestimada_deliv;
	}
	public void setHoraestimada_deliv(Date horaestimada_deliv) {
		this.horaestimada_deliv = horaestimada_deliv;
	}
	
	
	
	

}
