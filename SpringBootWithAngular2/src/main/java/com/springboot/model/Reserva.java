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
@Table(name = "reserva")
public class Reserva {

	private static final long serialVersionUID = 1L;	
	
	private Long cod_reserva;
    private Date fecha_reserva;
    private String tipo_reserva;
    private String motivo;
    private Date fecha;
    private String hora;
    private String estado;
    private Cliente cliente;
    private Local local;
    private Mesa mesa;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_reserva")
	public Long getCod_reserva() {
		return cod_reserva;
	}
	public void setCod_reserva(Long cod_reserva) {
		this.cod_reserva = cod_reserva;
	}
	
	@Column(name = "fecha_reserva")
	public Date getFecha_reserva() {
		return fecha_reserva;
	}
	public void setFecha_reserva(Date fecha_reserva) {
		this.fecha_reserva = fecha_reserva;
	}
	
	@Column(name = "tipo_reserva")
	public String getTipo_reserva() {
		return tipo_reserva;
	}
	public void setTipo_reserva(String tipo_reserva) {
		this.tipo_reserva = tipo_reserva;
	}
	
	@Column(name = "motivo")
	public String getMotivo() {
		return motivo;
	}
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	
	@Column(name = "fecha")
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	@ManyToOne()
    @JoinColumn(name = "dni")
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	@ManyToOne()
    @JoinColumn(name = "cod_local")
	public Local getLocal() {
		return local;
	}
	public void setLocal(Local local) {
		this.local = local;
	}
	
	@Column(name = "hora")
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	
	@ManyToOne()
    @JoinColumn(name = "cod_mesa")
	public Mesa getMesa() {
		return mesa;
	}
	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}
	
	@Column(name = "estado")
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	
}
