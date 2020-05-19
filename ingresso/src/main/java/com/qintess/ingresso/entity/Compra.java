package com.qintess.ingresso.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;


@Entity
public class Compra {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("clienteId")
	private Cliente cliente;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("eventoId")
	private Evento evento;
	
	private int qtdIngresso;

	public Compra() {}
	public Compra(Cliente cliente, Evento evento, int qtdIngresso) {
		this.cliente = cliente;
		this.evento = evento;
		this.qtdIngresso = qtdIngresso;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	public int getQtdIngresso() {
		return qtdIngresso;
	}
	public void setQtdIngresso(int qtdIngresso) {
		this.qtdIngresso = qtdIngresso;
	}
	
	
	
	
	
}
