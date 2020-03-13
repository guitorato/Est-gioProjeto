package com.qintess.mercado.resultado;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;





public class LerArquivo{
	
	public static void main(String[] args) throws FileNotFoundException {
		
		String arquivo1 = ("C:\\Users\\Qintess\\Desktop\\Projetos Git\\ProjetoLerArquivo\\DadosMercado.csv");
		String arquivo2 = ("C:\\Users\\Qintess\\Desktop\\Projetos Git\\ProjetoLerArquivo\\Operacoes.csv");
		String arquivo3 =("C:\\Users\\Qintess\\Desktop\\Projetos Git\\ProjetoLerArquivo\\Resultado.csv");
		
		long inicio = System.currentTimeMillis();
		
		List <Operacao>listaOp = new ArrayList<Operacao>();
		List <DadosMercados>listaMercado = new ArrayList<DadosMercados>();
		List <Resultado>listaResultado = new ArrayList<Resultado>();
		
		
		try {
			
			
			FileReader input1 = new FileReader(arquivo1);
			FileReader input2 = new FileReader(arquivo2);
			FileReader input3 = new FileReader(arquivo3);
			
			
			BufferedReader lerMercado = new BufferedReader(input1);
			BufferedReader lerOperacao = new BufferedReader(input2);
			BufferedReader lerResultado = new BufferedReader(input3);

			
			String calendario = "dd/MM/yyyy";
			SimpleDateFormat sdf = new SimpleDateFormat(calendario);
			
			Boolean primeiro = true;
			String nome1 = null;
			double totalResultado = 0;
			String nome2 = null;
			boolean nEncontrado = false;
			
			
			
			String[] colunasMercado = null;
			String[] colunasOp = null;
			
			String linhaMercado;
			String linhaOp;
			lerMercado.readLine();
			
			while ((linhaMercado = lerMercado.readLine()) != null) {
				
				colunasMercado = linhaMercado.split(";");
				
				int id_preco = Integer.parseInt(colunasMercado[0]);
				int prazo_corridos  = Integer.parseInt(colunasMercado[1]);
				double vl_preco = Double.parseDouble(colunasMercado[2].replace(',', '.'));
				
				DadosMercados dadosMercados = new DadosMercados(id_preco, prazo_corridos, vl_preco);
				
				listaMercado.add(dadosMercados);
				
			
			}
			lerMercado.close();
			
		
			lerOperacao.readLine();
			
			while ((linhaOp = lerOperacao.readLine()) != null) {
			
				
				colunasOp = linhaOp.split(";");

				String data_inicio = colunasOp[1];
				String data_fim = colunasOp[2];
				
				Date dataInicio = sdf.parse(data_inicio);
			    Date dataFim = sdf.parse(data_fim);
			    
				String nm_subproduto = colunasOp[9];
				Double quantidade = Double.parseDouble(colunasOp[12].replace(',', '.'));
				
				int id_preco = Integer.parseInt(colunasOp[13]);
				double dia_corrido = (dataFim.getTime()-dataInicio.getTime())/ (24 * 60 * 60 * 1000) ;
				
				Operacao operacao = new Operacao(nm_subproduto, quantidade, id_preco , dia_corrido);
				
				listaOp.add(operacao);
				
			}
			
		lerOperacao.close();
		
		for(Operacao operacao : listaOp) {
			
			
			for(DadosMercados dadosMercados : listaMercado) {
				
				if(dadosMercados.getPrazo_corrido() == operacao.getDiasCorrido() && 
						dadosMercados.getId_preco() == operacao.getId_preco()) {
					
					listaResultado.add(new Resultado(operacao.getNm_subproduto(), 
							(operacao.getQuantidade()* dadosMercados.getVl_preco())));
					
					break;
				}
			  }
			   
			}
			
			Collections.sort(listaResultado);

			BufferedWriter bufferWriter = new BufferedWriter(new FileWriter(arquivo3));
			bufferWriter.write("SubProduto | Resultado\n");
			
			for(Resultado resultado : listaResultado) {
				nome1 = resultado.getNm_subproduto().toString();
				
				if (nome1.equals(nome2)) {
					
					if(primeiro == false) {
						totalResultado = totalResultado + resultado.getResultado();
						
					}else {
						primeiro = false;
					}
					
				}else {
					bufferWriter.write(nome2+" | "+ Double.toString(totalResultado).replace(".", ",")+"\n");
					totalResultado = resultado.getResultado();
					nome2 = resultado.getNm_subproduto();
					
				}
				
			}
			
			//bufferWriter.write(nome2+" | "+ Double.toString(totalResultado).replace(".", ",")+"\n");
			bufferWriter.close();
			
			String linhaResultado;
			
			long fim = System.currentTimeMillis();
			System.out.println("Tempo: "+ ((fim - inicio)/1000)+ "s\n\n");
			
			while ((linhaResultado = lerResultado.readLine()) != null) {
				
				System.out.println(linhaResultado);
			}
			
		}catch(Exception e) {
			System.err.printf("ERRO: %s. \n ", e.getLocalizedMessage());
		}
		
		
		
	}
		
}
	