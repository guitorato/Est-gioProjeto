package com.qintess.estudo.hibernate.modelo;


import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;


@Entity
@Table (name = "fornecedor_has_produto")
public class FornecedorProduto implements Serializable{

	private static final long serialVersionUID = 1L; 
	
	@EmbeddedId
	private FornecedorProdutoPK id = new FornecedorProdutoPK();

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("fornecedor_id")
	private Fornecedor fornecedor;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@MapsId("prodouto_id")
	private Produto produto;
	
	@Column (nullable = false)
	private int estoque;
	
	@Column(nullable = false , length = 10 , precision = 2)
	private double preco_custo;

	
	public FornecedorProduto() {}

	
	
	public FornecedorProduto(int estoque, double preco_custo, Fornecedor fornecedor, Produto produto) {
		this.fornecedor = fornecedor;
		this.produto = produto;
		this.estoque = estoque;
		this.preco_custo = preco_custo;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public FornecedorProdutoPK getId() {
		return id;
	}


	public void setId(FornecedorProdutoPK id) {
		this.id = id;
	}


	public Fornecedor getFornecedor() {
		return fornecedor;
	}


	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}


	public Produto getProduto() {
		return produto;
	}


	public void setProduto(Produto produto) {
		this.produto = produto;
	}


	public int getEstoque() {
		return estoque;
	}


	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}


	public double getPreco_custo() {
		return preco_custo;
	}


	public void setPreco_custo(double preco_custo) {
		this.preco_custo = preco_custo;
	}
	
	
	
	
}
