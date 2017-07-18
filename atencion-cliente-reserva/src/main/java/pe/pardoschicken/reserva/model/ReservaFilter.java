package pe.pardoschicken.reserva.model;

import java.util.Date;

public class ReservaFilter {

	
	private String codLocal;
	private Date fechaInicial;
	private Date fechaFin;
	private String tipoReserva;
	private String apPaterno;
	private String nombre;
	public String getCodLocal() {
		return codLocal;
	}
	public void setCodLocal(String codLocal) {
		this.codLocal = codLocal;
	}
	public Date getFechaInicial() {
		return fechaInicial;
	}
	public void setFechaInicial(Date fechaInicial) {
		this.fechaInicial = fechaInicial;
	}
	public Date getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	public String getTipoReserva() {
		return tipoReserva;
	}
	public void setTipoReserva(String tipoReserva) {
		this.tipoReserva = tipoReserva;
	}
	public String getApPaterno() {
		return apPaterno;
	}
	public void setApPaterno(String apPaterno) {
		this.apPaterno = apPaterno;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
}
