package com.qintess.evento.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;


@Entity
public class Compra {

	@EmbeddedId
	private CompraId id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("clienteId")
	private Cliente cliente;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("eventoId")
	private Evento evento;
	
	
	private int qtd;
	
	@Column(scale = 2 )
	private double valorTotal;

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public int getQtd() {
		return qtd;
	}

	public void setQtd(int qtd) {
		this.qtd = qtd;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	
}
