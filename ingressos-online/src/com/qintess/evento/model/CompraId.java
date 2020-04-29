package com.qintess.evento.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;


@Embeddable
public class CompraId implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int cliente_id;
	
	private int evento_id;
	
	public CompraId() {}

	
	@Override
	public boolean equals(Object o) {
		if(this == o) return true;
		
		if(o == null || getClass() != o.getClass())
			return false;
		
		CompraId that = (CompraId) o;
		return Objects.equals(cliente_id, that.cliente_id) &&
			   Objects.equals(evento_id, that.evento_id);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(cliente_id, evento_id);
	}


	public int getCliente_id() {
		return cliente_id;
	}


	public void setCliente_id(int cliente_id) {
		this.cliente_id = cliente_id;
	}


	public int getEvento_id() {
		return evento_id;
	}


	public void setEvento_id(int evento_id) {
		this.evento_id = evento_id;
	}
	
}
