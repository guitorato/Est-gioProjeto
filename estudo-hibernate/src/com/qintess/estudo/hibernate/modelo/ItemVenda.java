package com.qintess.estudo.hibernate.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "venda_itens")
public class ItemVenda {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	private Produto produto;
	
	@ManyToOne
	private Venda venda;
	
	private int qtd;
	
	@Column (length = 10 , precision = 2)
	private double preco_custo;
	
	@Column (length = 10 , precision = 2)
	private double preco_unit;
	
	
	public ItemVenda() {}
	
	
	
	public ItemVenda(Produto produto, Venda venda, int qtd) {

		this.produto = produto;
		this.venda = venda;
		this.qtd = qtd;
		this.preco_unit = produto.getPreco_venda();
		this.preco_custo = (produto.getPreco_venda() 
				- (this.qtd * produto.getPreco_venda() 
						* venda.getDesconto()));
		
	}



	public ItemVenda(Produto produto, Venda venda, int qtd, double preco_custo, double preco_unit) {
		this.produto = produto;
		this.venda = venda;
		this.qtd = qtd;
		this.preco_custo = preco_custo;
		this.preco_unit = preco_unit;
	}

	@Override
	public String toString() {
		return "ItemVenda [id=" + id + ", produto=" + produto + ", venda=" + venda + ", qtd=" + qtd + ", preco_custo="
				+ preco_custo + ", preco_unit=" + preco_unit + "]";
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public Produto getProduto() {
		return produto;
	}



	public void setProduto(Produto produto) {
		this.produto = produto;
	}



	public Venda getVenda() {
		return venda;
	}



	public void setVenda(Venda venda) {
		this.venda = venda;
	}



	public int getQtd() {
		return qtd;
	}



	public void setQtd(int qtd) {
		this.qtd = qtd;
	}



	public double getPreco_custo() {
		return preco_custo;
	}



	public void setPreco_custo(double preco_custo) {
		this.preco_custo = preco_custo;
	}



	public double getPreco_unit() {
		return preco_unit;
	}



	public void setPreco_unit(double preco_unit) {
		this.preco_unit = preco_unit;
	}


	
		
}
