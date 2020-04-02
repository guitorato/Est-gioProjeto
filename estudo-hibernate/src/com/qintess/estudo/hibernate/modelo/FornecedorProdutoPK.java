package com.qintess.estudo.hibernate.modelo;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;

@Embeddable
public class FornecedorProdutoPK implements Serializable{

	private static final long serialVersionUID = 1L; 
	private int produto_id;
	private int fornecedor_id;
	
	public FornecedorProdutoPK () {}

	public FornecedorProdutoPK(Integer produto_id, Integer forncedor_id) {
		this.produto_id = produto_id;
		this.fornecedor_id = forncedor_id;
	}

	public Integer getProdutoId() {
		return produto_id;
	}

	public void setProdutoId(Integer produtoId) {
		this.produto_id = produtoId;
	}

	public Integer getForncedorId() {
		return fornecedor_id;
	}

	public void setForncedorId(Integer forncedorId) {
		this.fornecedor_id = forncedorId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(fornecedor_id, produto_id);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		if(obj == null)
			return false;
		if(getClass() != obj.getClass())
			return false;
		
		FornecedorProdutoPK other = (FornecedorProdutoPK) obj;
		return fornecedor_id == other.fornecedor_id && produto_id == other.produto_id;
	}

}
