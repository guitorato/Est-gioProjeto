package com.qintess.estudo.hibernate;



import java.util.List;

import com.qintess.estudo.hibernate.DAO.DAOGeneric;
import com.qintess.estudo.hibernate.modelo.Cliente;
import com.qintess.estudo.hibernate.modelo.Fornecedor;
import com.qintess.estudo.hibernate.modelo.FornecedorProduto;
import com.qintess.estudo.hibernate.modelo.ItemVenda;
import com.qintess.estudo.hibernate.modelo.Produto;
import com.qintess.estudo.hibernate.modelo.Venda;

public class App {

	

	public static void main(String[] args) {
		
		

				
		DAOGeneric<Produto> produtoDAO = new DAOGeneric<Produto>();
		Produto produto1 = new Produto(2000.00, 100, "NotebookAcer", "imagemAcer1.jpg");
		Produto produto2 = new Produto(3500.00, 100, "Notebook DELL", "imagemDELL1.jpg");
		Produto produto3 = new Produto(5000.00, 100, "Notebook Acer Gamer", "imagemAcerGamer1.jpg");
		produtoDAO.salvar(produto1);
		produtoDAO.salvar(produto2);
		produtoDAO.salvar(produto3);
		
		
		DAOGeneric<Cliente> clienteDAO = new DAOGeneric<Cliente>();
		Cliente cliente1 = new Cliente("Guilherme", "(13)3435-2432");
		Cliente cliente2 = new Cliente("Pedro", "(13)3432-6431");
		Cliente cliente3 = new Cliente("Lucas", "(13)3435-8424");
		clienteDAO.salvar(cliente1);
		clienteDAO.salvar(cliente2);
		clienteDAO.salvar(cliente3);
		
		DAOGeneric<Fornecedor> fornecedorDAO = new DAOGeneric<Fornecedor>();
		Fornecedor fornecedor1 = new Fornecedor("ACER", "(13)3423-1231", "acer@acer.com.br");
		Fornecedor fornecedor2 = new Fornecedor("DELL", "(13)3423-1233", "dell@dell.com.br");
		fornecedorDAO.salvar(fornecedor1);
		fornecedorDAO.salvar(fornecedor2);
		
		
		DAOGeneric<Venda> vendaDAO = new DAOGeneric<Venda>();
		Venda venda1 = new Venda(cliente1, 10, 1,"01/04/2020");
		Venda venda2 = new Venda(cliente2, 0, 2,"01/04/2020");
		Venda venda3 = new Venda(cliente3, 5, 3,"01/04/2020");
		vendaDAO.salvar(venda1);
		vendaDAO.salvar(venda2);
		vendaDAO.salvar(venda3);
		
		DAOGeneric<ItemVenda> itemVendaDAO = new DAOGeneric<ItemVenda>();
		ItemVenda itemVenda1 = new ItemVenda(produto1, venda1, 2);
		ItemVenda itemVenda2 = new ItemVenda(produto2, venda2, 1);
		ItemVenda itemVenda3 = new ItemVenda(produto3, venda3, 1);
		itemVendaDAO.salvar(itemVenda1);
		itemVendaDAO.salvar(itemVenda2);
		itemVendaDAO.salvar(itemVenda3);
		
	   
		DAOGeneric<FornecedorProduto> fpDAO = new DAOGeneric<FornecedorProduto>();
	
		
		List<Produto> produtos = produtoDAO.obterTodos(Produto.class);
		
		for(Produto produto: produtos) {
			System.out.println(produto.toString());
		}
		
		List<Cliente> clientes = clienteDAO.obterTodos(Cliente.class);
		
		for(Cliente cliente: clientes) {
			System.out.println(cliente.toString());
		}
		
	}
}
