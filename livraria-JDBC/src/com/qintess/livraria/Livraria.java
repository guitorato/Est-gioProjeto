package com.qintess.livraria;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Livraria {
	
	static final String DRIVER = "org.h2.Driver";
	static final String URL = "jdbc:h2:tcp://localhost/~/test";
	
	static final String USER = "root";
	static final String PASS = "";
	
	static int idlivro;
	static int idvenda;
	static int qtd = 0;
	static float subtotal = 0;
	
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		
		try {
			
			Class.forName("org.h2.Driver");
			
			System.out.println("Conectando ao banco de dados");
			conn = DriverManager.getConnection(URL,USER,PASS);
			stmt = conn.createStatement();
			Scanner sc = new Scanner(System.in);
			int opcao = 0;
			
			do {
				System.out.println("------ Menu Opção ------");
				System.out.println("Digite o numero para opção desejada:");
				System.out.println("1 - INSERIR ITENS DE VENDA");
				System.out.println("2 - LER ITENS DE VENDA");
				System.out.println("3 - ALTERAR ITENS DE VENDA");
				System.out.println("4 - DELETAR ITENS DE VENDA");
				System.out.println("5 - RELATORIO DOS LIVROS MAIS VENDIDOS");
				System.out.println("6 - RELATORIO DE VENDA COM MAIOR VALOR");
				System.out.println("7 - CLIENTE QUE MAIS COMPROU");
				System.out.println("8 - SAIR");
				opcao = sc.nextInt();
				
				if (opcao == 1) {
					
					System.out.println("Digite o código da venda ");
					idvenda = sc.nextInt();
					System.out.println("Digite o código do livro ");
					idlivro = sc.nextInt();
					System.out.println("Digite a quantidade de livros comprados");
					qtd = sc.nextInt();
					System.out.println("Digite o subtotal");
					subtotal = sc.nextFloat();
					
					String query = " insert into itens_da_venda(idvenda, idlivro, qtd, subtotal)"
					        + " values (?, ?, ?, ?)";
					PreparedStatement preparedStmt = conn.prepareStatement(query);
					preparedStmt.setInt (1, idvenda);
					preparedStmt.setInt (2, idlivro);
					preparedStmt.setFloat (3, qtd);
					preparedStmt.setFloat(4, subtotal);
				 
					preparedStmt.execute();
					System.out.println("Cadastrado com sucesso !");
					
				}else if (opcao == 2) {
					 String sql = "SELECT idvenda, idlivro, qtd, subtotal FROM itens_da_venda"; 
				         ResultSet rs = stmt.executeQuery(sql);  
				         
				         System.out.println("----------------------------------------------");
				         System.out.println("----------------Itens da Venda----------------");
				         System.out.println("----------------------------------------------");
				         System.out.println("|  IDVENDA  |  IDLIVRO  |  QTD  |  SUBTOTAL  |");
				        
				         while(rs.next()){ 
				           
				            idvenda  = rs.getInt("IDVENDA"); 
				            idvenda  = rs.getInt("IDLIVRO"); 
				            qtd  = rs.getInt("QTD");
				            subtotal  = rs.getInt("SUBTOTAL");  
				            
				       
				            System.out.println("|  "+idvenda+"        |  "+idlivro+"        |  "
				            +qtd+"    |  "+subtotal+"      |");
				         } 
				         System.out.println("----------------------------------------------\n");
				         rs.close(); 
				         
				}else if (opcao == 3) {
					
					String update = "UPDATE itens_da_venda SET qtd = ?, subtotal = ? "
							+ "WHERE idvenda= ? AND idlivro = ?";
					
					System.out.println("Digite o código da venda para alteração");
					idvenda = sc.nextInt();
					System.out.println("Digite o código do livro para alteração ");
					idlivro = sc.nextInt();
					System.out.println("Digite a quantidade de livro que irá ser alterado");
					qtd = sc.nextInt();
					System.out.println("Digite o subtotal que irá ser alterado");
					subtotal = sc.nextFloat();
					
					
					PreparedStatement preparedStmt = conn.prepareStatement(update);
					preparedStmt.setFloat (1, qtd);
					preparedStmt.setFloat(2, subtotal);
					preparedStmt.setInt (3, idvenda);
					preparedStmt.setInt (4, idlivro);
				 
					preparedStmt.execute();
					
				}else if (opcao == 4) {
					String sql = "delete from itens_da_venda Where idvenda = ? AND idlivro = ? AND qtd = ? ";
					System.out.println("Digite o codigo do venda");
					idvenda = sc.nextInt();
					System.out.println("Digite o codigo do livro");
					idlivro = sc.nextInt();
					System.out.println("Digite a quantidade de livros vendidos");
					qtd = sc.nextInt();
					
					PreparedStatement preparedStmt = conn.prepareStatement(sql);
					preparedStmt.setInt (1, idvenda);
					preparedStmt.setInt (2, idlivro);
					preparedStmt.setFloat (3, qtd);
					preparedStmt.execute();
					
					System.out.println("Deletado com sucesso");
					
				}else if (opcao == 5) {
					
					String livroMaisVendido = "SELECT sum(g.qtd) as total, l.titulo FROM ITENS_DA_VENDA g JOIN "
							+ "livro l ON l.idlivro = g.idlivro GROUP BY "
							+ "l.titulo  ORDER BY sum(g.qtd) desc,l.titulo";
					ResultSet rs = stmt.executeQuery(livroMaisVendido);  
					
					 System.out.println("----------------------------------------------");
			         System.out.println("----------------LIVRO MAIS VENDIDO------------");
			         System.out.println("----------------------------------------------");
			         System.out.println("|  TOTAL  |  TÍTULO ");
			        
			         while(rs.next()){ 

			        	 int total  = rs.getInt("total"); 
			            String livro  = rs.getString("titulo"); 
			            
			            
			            System.out.println("|  "+total+"      |  "+livro+"        ");
			         } 
			         System.out.println("----------------------------------------------\n");
			         rs.close(); 
					
				}else if (opcao == 6) {
					String vendaMaior =   "SELECT  cli.nome, v.data, max(total) TotalVenda from venda v  "
							+ "join cliente cli on v.idcliente = cli.idcliente "
							+ "group by  cli.nome, v.data order by max(total) desc";
					
					ResultSet rs = stmt.executeQuery(vendaMaior);  
					
					System.out.println("----------------------------------------------");
					System.out.println("------------VENDA COM MAIOR VALOR-------------");
					System.out.println("----------------------------------------------");
					System.out.println("|  CLIENTE    |  DATA   | MAIOR VENDA  | ");
					
					while(rs.next()){ 
						
						String cliente  = rs.getString("nome"); 
						float maiorV  = rs.getFloat("TotalVenda"); 
						String data = rs.getString("data"); 
						
						
						System.out.println("|  "+cliente+"      |      "+data+"      |      "+maiorV+"        ");
					} 
					System.out.println("----------------------------------------------\n");
					rs.close(); 
					
				}else if (opcao == 7) {
					
					String clienteCompra = "SELECT count(v.idcliente) as quantidade, c.nome as nome "
							+ "FROM venda v JOIN  cliente c  ON v.idcliente = c.idcliente "
							+ "GROUP BY v.idcliente, c.nome "
							+ "ORDER BY count(v.idcliente) desc,c.nome";
					
					ResultSet rs = stmt.executeQuery(clienteCompra);  
					
					System.out.println("----------------------------------------------");
					System.out.println("-----------CLIENTE QUE MAIS COMPROU-----------");
					System.out.println("----------------------------------------------");
					System.out.println("|  QTD  |  CLIENTE ");
					
					while(rs.next()){ 
						
						int maiorV  = rs.getInt("quantidade"); 
						String cliente  = rs.getString("nome"); 
						
						
					 
						System.out.println("|  "+maiorV+"      |  "+cliente+"        ");
					} 
					System.out.println("----------------------------------------------\n");
					rs.close(); 
					
				}
					
				
			}while(opcao <8);
			
			sc.close();
			conn.close();
			
			
		} catch (SQLException se) {
			
			se.printStackTrace();
			
		}catch (Exception e) {
			
			System.err.println("Got an exception!");
		      System.err.println(e.getMessage());
		      
		} finally {
			try {
				if(conn!=null) conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		
	}
}
