package com.qintess.estudo.hibernate.modelo;





import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;



@Entity
public class Venda {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	private Cliente cliente;
	
	private double desconto;
	
	private int forma_pagamento;
	
	private String data;

	
	public Venda() {}
	
	public Venda(Cliente cliente, double desconto, int forma_pagamento, String data) {
		this.cliente = cliente;
		this.desconto = (desconto/ 100);
		this.forma_pagamento = forma_pagamento;
		this.data = data;
	}
	
	@Override
	public String toString() {
		return "Venda [id=" + id + ", cliente=" + cliente + ", desconto=" + desconto + ", forma_pagamento="
				+ forma_pagamento + ", data=" + data + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public double getDesconto() {
		return desconto;
	}

	public void setDesconto(double desconto) {
		this.desconto = desconto;
	}

	public int getForma_pagamento() {
		return forma_pagamento;
	}

	public void setForma_pagamento(int forma_pagamento) {
		this.forma_pagamento = forma_pagamento;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	
	
}
