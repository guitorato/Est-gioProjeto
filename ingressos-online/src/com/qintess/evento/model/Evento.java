package com.qintess.evento.model;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Evento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false, length = 1000 )
	private String descricao;
	
	@Column(nullable = false , columnDefinition = "DATETIME")
	@DateTimeFormat(pattern = "yyyy-MM-dd hh.mm.ss")
	private LocalDateTime dtEvento;
	
	@Column(nullable = false)
	private int qtdIngresso;
	
	@Column(nullable = false, scale = 2 )
	private BigDecimal valor = new BigDecimal(0);
	
	@Lob
	@Column(columnDefinition="mediumblob")
	private byte[] folder;
	
	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE})
	@JoinColumn(name = "casaDeShow_id")
	private CasaDeShow casaDeShow;
	
	@OneToMany(mappedBy = "evento")
	private List <Compra> compras;

	public Evento() {}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDateTime getDtEvento() {
		return dtEvento;
	}

	public void setDtEvento(LocalDateTime dtEvento) {
		this.dtEvento = dtEvento;
	}

	public int getQtdIngresso() {
		return qtdIngresso;
	}

	public void setQtdIngresso(int qtdIngresso) {
		this.qtdIngresso = qtdIngresso;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public byte[] getFolder() {
		return folder;
	}

	public void setFolder(byte[] folder) {
		this.folder = folder;
	}

	public CasaDeShow getCasaDeShow() {
		return casaDeShow;
	}

	public void setCasaDeShow(CasaDeShow casaDeShow) {
		this.casaDeShow = casaDeShow;
	}

	public List<Compra> getCompras() {
		return compras;
	}

	public void setCompras(List<Compra> compras) {
		this.compras = compras;
	}

	
	

}
