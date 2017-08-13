package com.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pedidodetalle")
public class PedidoDetalle {
	
	private Long id_pedidetalle;
	private Pedido pedido;
	private String cod_carta;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pedidetalle")
	public Long getId_pedidetalle() {
		return id_pedidetalle;
	}
	public void setId_pedidetalle(Long id_pedidetalle) {
		this.id_pedidetalle = id_pedidetalle;
	}
	
	@ManyToOne()
    @JoinColumn(name = "id_pedido")
	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	
	@Column(name = "cod_carta")
	public String getCod_carta() {
		return cod_carta;
	}
	public void setCod_carta(String cod_carta) {
		this.cod_carta = cod_carta;
	}
	
	

}
