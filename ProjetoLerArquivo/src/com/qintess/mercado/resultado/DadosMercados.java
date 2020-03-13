package com.qintess.mercado.resultado;

public class DadosMercados {
	
	private int id_preco;
	private int prazo_corrido;
	private double vl_preco;
	
	public DadosMercados(int id_preco, int prazo_corrido, double vl_preco) {
		
		this.id_preco = id_preco;
		this.prazo_corrido = prazo_corrido;
		this.vl_preco = vl_preco;
	}
	public int getId_preco() {
		return id_preco;
	}
	public void setId_preco(int id_preco) {
		this.id_preco = id_preco;
	}
	public int getPrazo_corrido() {
		return prazo_corrido;
	}
	public void setPrazo_corrido(int prazo_corrido) {
		this.prazo_corrido = prazo_corrido;
	}
	public double getVl_preco() {
		return vl_preco;
	}
	public void setVl_preco(double vl_preco) {
		this.vl_preco = vl_preco;
	}
	
	
	

}
