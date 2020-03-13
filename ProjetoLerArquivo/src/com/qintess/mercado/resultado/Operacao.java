package com.qintess.mercado.resultado;

import java.util.Date;

public class Operacao {

	private long cd_operacao;
	private Date dt_inicio;
	private Date dt_fim;
	private String nm_empresa;
	private String nm_mesas;
	private String nm_estrategia;
	private String nm_centralizado;
	private String nm_gestao;
	private String nm_subgestao;
	private String nm_subproduto;
	private String nm_caracteristica;
	private String cd_ativoObjt;
	private double quantidade;
	private int id_preco;
	private double diasCorrido;

	
	public Operacao(String nm_subproduto, double quantidade, int id_preco,
			double diasCorrido) {
		this.nm_subproduto = nm_subproduto;
		this.quantidade = quantidade;
		this.id_preco = id_preco;
		this.setDiasCorrido(diasCorrido);
	}


	public long getCd_operacao() {
		return cd_operacao;
	}
	public void setCd_operacao(long cd_operacao) {
		this.cd_operacao = cd_operacao;
	}
	public Date getDt_inicio() {
		return dt_inicio;
	}
	public void setDt_inicio(Date dt_inicio) {
		this.dt_inicio = dt_inicio;
	}
	public Date getDt_fim() {
		return dt_fim;
	}
	public void setDt_fim(Date dt_fim) {
		this.dt_fim = dt_fim;
	}
	public String getNm_empresa() {
		return nm_empresa;
	}
	public void setNm_empresa(String nm_empresa) {
		this.nm_empresa = nm_empresa;
	}
	public String getNm_mesas() {
		return nm_mesas;
	}
	public void setNm_mesas(String nm_mesas) {
		this.nm_mesas = nm_mesas;
	}
	public String getNm_estrategia() {
		return nm_estrategia;
	}
	public void setNm_estrategia(String nm_estrategia) {
		this.nm_estrategia = nm_estrategia;
	}
	public String getNm_centralizado() {
		return nm_centralizado;
	}
	public void setNm_centralizado(String nm_centralizado) {
		this.nm_centralizado = nm_centralizado;
	}
	public String getNm_gestao() {
		return nm_gestao;
	}
	public void setNm_gestao(String nm_gestao) {
		this.nm_gestao = nm_gestao;
	}
	public String getNm_subgestao() {
		return nm_subgestao;
	}
	public void setNm_subgestao(String nm_subgestao) {
		this.nm_subgestao = nm_subgestao;
	}
	public String getNm_subproduto() {
		return nm_subproduto;
	}
	public void setNm_subproduto(String nm_subproduto) {
		this.nm_subproduto = nm_subproduto;
	}
	public String getNm_caracteristica() {
		return nm_caracteristica;
	}
	public void setNm_caracteristica(String nm_caracteristica) {
		this.nm_caracteristica = nm_caracteristica;
	}
	public String getCd_ativoObjt() {
		return cd_ativoObjt;
	}
	public void setCd_ativoObjt(String cd_ativoObjt) {
		this.cd_ativoObjt = cd_ativoObjt;
	}
	public double getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(double quantidade) {
		this.quantidade = quantidade;
	}
	public int getId_preco() {
		return id_preco;
	}
	public void setId_preco(int id_preco) {
		this.id_preco = id_preco;
	}


	public double getDiasCorrido() {
		return diasCorrido;
	}


	public void setDiasCorrido(double diasCorrido) {
		this.diasCorrido = diasCorrido;
	}
	
	

}
