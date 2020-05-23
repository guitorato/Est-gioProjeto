package com.qintess.ingresso.rest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qintess.ingresso.entity.Cliente;
import com.qintess.ingresso.entity.Compra;
import com.qintess.ingresso.entity.Evento;
import com.qintess.ingresso.repository.ClienteRepository;
import com.qintess.ingresso.repository.CompraRepository;
import com.qintess.ingresso.repository.EventoRepository;

@RestController
@RequestMapping("/api")
public class CompraController {

	@Autowired
	private EventoRepository eventoRepo;
	
	@Autowired
	private ClienteRepository clienteRepo;
	
	@Autowired
	private CompraRepository compraRepo;
	
	@GetMapping("/compra")
	public List<Compra> getCompra(){
		
		return compraRepo.findAll();
	}
	
	@PostMapping("/compra/{clienteId}/{eventoId}")
	private List<Compra> postCompra(@RequestBody Compra compra, 
			@PathVariable(name = "eventoId") int eventoId ,
			@PathVariable(name = "clienteId") int clienteId){
		
		System.out.println("Entrou no Post");
		
		Evento evento = eventoRepo.findById(eventoId);
		Cliente cliente = clienteRepo.findById(clienteId);
		
		if(evento.getEstoque_ingresso() >= compra.getQtdIngresso()) {
			
			System.out.println("Primeiro if total <= qtdingresso");
			
			if(compra.getQtdIngresso() > 0 && compra.getQtdIngresso() <= 4 ) {
				
				System.out.println("Segundo if qtIngresso maior que 0 e menor e igual a 4");
				
				int ingresso = evento.getEstoque_ingresso() - compra.getQtdIngresso();
			
				System.out.println("antes do INT: " + ingresso);
				
				
				compra.setEvento(evento);
				
				System.out.println("Salva evento " + evento);
				
				compra.setCliente(cliente);
				
				System.out.println("Salva cliente " + cliente);
				
				evento.setEstoque_ingresso(ingresso);
				
				System.out.println("Salva ingresso");
				
				
				compraRepo.save(compra);
				
				System.out.println("Salva compra");
				
				return compraRepo.findAll();
			}
			return null;	
		
		}
		return null;
	}
}
