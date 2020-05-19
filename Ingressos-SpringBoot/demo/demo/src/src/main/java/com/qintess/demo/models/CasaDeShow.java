package com.qintess.demo.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class CasaDeShow {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private int capacidade;
	
	@Column(nullable = false)
	private String logdradouro;
	
	@Column(nullable = false)
	private String complemento;
	
	@Column(nullable = false)
	private String numero;
	
	@Column(nullable = false)
	private String bairro;
	
	@Column(nullable = false)
	private String cidade;
	
	@Column(nullable = false)
	private String uf;
	
	@Column(nullable = false)
	private String cep;
	
	@Column(nullable = false)
	private String telefone;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)    
	private List<Evento> listEventos = new ArrayList<>(); 
	
	
	public CasaDeShow() {}
	public CasaDeShow(int id, String nome, int capacidade, String logdradouro, String complemento, String numero,
			String bairro, String cidade, String uf, String cep, String telefone) {
		this.id = id;
		this.nome = nome;
		this.capacidade = capacidade;
		this.logdradouro = logdradouro;
		this.complemento = complemento;
		this.numero = numero;
		this.bairro = bairro;
		this.cidade = cidade;
		this.uf = uf;
		this.cep = cep;
		this.telefone = telefone;
	}

	@Override
	public String toString() {
		return "CasaDeShow [id=" + id + ", nome=" + nome + ", capacidade=" + capacidade + ", logdradouro=" + logdradouro
				+ ", complemento=" + complemento + ", numero=" + numero + ", bairro=" + bairro + ", cidade=" + cidade
				+ ", uf=" + uf + ", cep=" + cep + ", telefone=" + telefone + "]";
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}

	public String getLogdradouro() {
		return logdradouro;
	}

	public void setLogdradouro(String logdradouro) {
		this.logdradouro = logdradouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	
}
