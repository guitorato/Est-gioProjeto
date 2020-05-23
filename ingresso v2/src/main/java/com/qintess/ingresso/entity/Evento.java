package com.qintess.ingresso.entity;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

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
	
	@Column(nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dtEvento;
	
	@Column(nullable = false)
	private int estoque_ingresso;
	
	@Column(nullable = false, scale = 2 )
	private BigDecimal valor = new BigDecimal(0);
	
	@Lob
	@Column(columnDefinition="mediumblob")
	private byte[] imagemProd;
	
	@Transient //esse campo n�o ser� persistido no hibernate
	private String imagemEncoded;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE})
	@JoinColumn(name = "casaDeShow_id")
	private CasaDeShow casaDeShow;
	
	@OneToMany(mappedBy = "evento")
	private List <Compra> compras;

	public Evento() {}
	
	
	
	@Override
	public String toString() {
		return "Evento [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", dtEvento=" + dtEvento
				+ ", qtdIngresso=" + estoque_ingresso + ", valor=" + valor + ", imagemProd=" + Arrays.toString(imagemProd)
				+ ", imagemEncoded=" + imagemEncoded + ", casaDeShow=" + casaDeShow + ", compras=" + compras + "]";
	}



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

	public LocalDate getDtEvento() {
		return dtEvento;
	}

	public void setDtEvento(LocalDate dtEvento) {
		this.dtEvento = dtEvento;
	}

	public int getEstoque_ingresso() {
		return estoque_ingresso;
	}

	public void setEstoque_ingresso(int estoque_ingresso) {
		this.estoque_ingresso = estoque_ingresso;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
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

	public byte[] getImagemProd() {
		return imagemProd;
	}

	public void setImagemProd(byte[] imagemProd) {
		this.imagemProd = imagemProd;
	}

	public String getImagemEncoded() {
		return imagemEncoded;
	}

	public void setImagemEncoded(String imagemEncoded) {
		this.imagemEncoded = imagemEncoded;
	}

	
	
	
	

}
