package com.qintess.estudo.hibernate.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Produto {
	@Id 
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;

	@Column(nullable = false , length = 10 , precision = 2)
	private double preco_venda;
	
	private int min_estoque;
	
	@Column(length = 45, nullable = false)
	private String nome;
	
	@Column(length = 45, nullable = false)
	private String foto;
	
	
	public Produto() {}
	public Produto(double preco_venda, int min_estoque, String nome, String foto) {
		FornecedorProduto fp = new FornecedorProduto();
		this.preco_venda = preco_venda;
		this.min_estoque = (min_estoque + fp.getEstoque());
		this.nome = nome;
		this.foto = foto;
	}

	

	@Override
	public String toString() {
		return "Produto [id=" + id + ", preco_venda=" + preco_venda + ", min_estoque=" + min_estoque + ", nome=" + nome
				+ ", foto=" + foto + "]";
	}
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public double getPreco_venda() {
		return preco_venda;
	}


	public void setPreco_venda(double preco_venda) {
		this.preco_venda = preco_venda;
	}


	public int getMin_estoque() {
		return min_estoque;
	}


	public void setMin_estoque(int min_estoque) {
		this.min_estoque = min_estoque;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getFoto() {
		return foto;
	}


	public void setFoto(String foto) {
		this.foto = foto;
	}
	
	
	
}
