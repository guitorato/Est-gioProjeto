package com.qintess.estudo.hibernate;



import com.qintess.estudo.hibernate.DAO.DAO;
import com.qintess.estudo.hibernate.modelo.Cliente;
import com.qintess.estudo.hibernate.modelo.Fornecedor;
import com.qintess.estudo.hibernate.modelo.FornecedorProduto;
import com.qintess.estudo.hibernate.modelo.ItemVenda;
import com.qintess.estudo.hibernate.modelo.Produto;
import com.qintess.estudo.hibernate.modelo.Venda;

public class App {

	public static void main(String[] args) {
		
		DAO<Produto> produtoDAO = new DAO<Produto>();
		DAO<Cliente> clienteDAO = new DAO<Cliente>();
		DAO<Fornecedor> fornecedorDAO = new DAO<Fornecedor>();
		DAO<FornecedorProduto> fpDAO = new DAO<FornecedorProduto>();
		DAO<ItemVenda> itemVendaDAO = new DAO<ItemVenda>();
		DAO<Venda> vendaDAO = new DAO<Venda>();
		

		//List<Produto> produtos = produtoDAO.obterTodos(Produto.class);
		
		//for(Produto produto: produtos) {
		//	System.out.println(produto.toString());
		//}
				
		Produto produto1 = new Produto(2000.00, 100, "NotebookAcer", "imagemAcer1.jpg");
		Produto produto2 = new Produto(3500.00, 100, "Notebook DELL", "imagemDELL1.jpg");
		Produto produto3 = new Produto(5000.00, 100, "Notebook Acer Gamer", "imagemAcerGamer1.jpg");
		produtoDAO.salvar(produto1);
		produtoDAO.salvar(produto2);
		produtoDAO.salvar(produto3);
		
		Cliente cliente1 = new Cliente("Guilherme", "(13)3435-2432");
		Cliente cliente2 = new Cliente("Pedro", "(13)3432-6431");
		Cliente cliente3 = new Cliente("Lucas", "(13)3435-8424");
		clienteDAO.salvar(cliente1);
		clienteDAO.salvar(cliente2);
		clienteDAO.salvar(cliente3);
		
		Fornecedor fornecedor1 = new Fornecedor("ACER", "(13)3423-1231", "acer@acer.com.br");
		Fornecedor fornecedor2 = new Fornecedor("DELL", "(13)3423-1233", "dell@dell.com.br");
		fornecedorDAO.salvar(fornecedor1);
		fornecedorDAO.salvar(fornecedor2);
		
		
		Venda venda1 = new Venda(cliente1, 10, 1,"01/04/2020");
		Venda venda2 = new Venda(cliente2, 0, 2,"01/04/2020");
		Venda venda3 = new Venda(cliente3, 5, 3,"01/04/2020");
		vendaDAO.salvar(venda1);
		vendaDAO.salvar(venda2);
		vendaDAO.salvar(venda3);
		
		ItemVenda itemVenda1 = new ItemVenda(produto1, venda1, 2);
		ItemVenda itemVenda2 = new ItemVenda(produto2, venda2, 1);
		ItemVenda itemVenda3 = new ItemVenda(produto3, venda3, 1);
		itemVendaDAO.salvar(itemVenda1);
		itemVendaDAO.salvar(itemVenda2);
		itemVendaDAO.salvar(itemVenda3);
		
	
		FornecedorProduto fp1 = new FornecedorProduto(10, 1000.00,fornecedor2, produto2);
		//FornecedorProduto fp2 = new FornecedorProduto(20, 4000.00,fornecedor1, produto3);
		//FornecedorProduto fp3 = new FornecedorProduto(50, 2000.00,fornecedor2, produto2);
		fpDAO.salvar(fp1);
		//fpDAO.salvar(fp2);
		//fpDAO.salvar(fp3);
		
	}
}
