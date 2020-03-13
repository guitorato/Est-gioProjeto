package com.qintess.mercado.resultado;

public class Resultado implements Comparable <Resultado>{
	
	public String nm_subproduto;
	public double resultado;
	
	public Resultado(String nm_subproduto, double resultado) {
		super();
		this.nm_subproduto = nm_subproduto;
		this.resultado = resultado;
	}
	public String getNm_subproduto() {
		return nm_subproduto;
	}
	public void setNm_subproduto(String nm_subproduto) {
		this.nm_subproduto = nm_subproduto;
	}
	public double getResultado() {
		return resultado;
	}
	public void setResultado(double resultado) {
		this.resultado = resultado;
	}
	@Override
	public int compareTo(Resultado o) {
		return this.getNm_subproduto().compareTo(o.getNm_subproduto());
	}
	
	
}
