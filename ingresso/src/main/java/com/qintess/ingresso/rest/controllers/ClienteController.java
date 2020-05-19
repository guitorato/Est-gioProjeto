package com.qintess.ingresso.rest.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qintess.ingresso.entity.Cliente;
import com.qintess.ingresso.repository.ClienteRepository;

@RestController
@RequestMapping("/api")
public class ClienteController {
	
	
	private ClienteRepository clienteRepo;

	public ClienteController(ClienteRepository clienteRepo) {
		this.clienteRepo = clienteRepo;
	}

	@GetMapping("/cliente")
	public List<Cliente> getClientes(){
	   return clienteRepo.findAll();
	}
	
	@GetMapping("/cliente/{id}")
	public Cliente getClienteId(@PathVariable(name = "id") int id){
		
		return clienteRepo.findById(id);
	}
	
	@PostMapping("/cliente")
	public Cliente save(@RequestBody Cliente cliente) {
		
		return clienteRepo.save(cliente);
	}
	
	@DeleteMapping("/cliente/{id}")
	public ResponseEntity<String> delete(@PathVariable(name = "id") int id) {
		
		clienteRepo.deleteById(id);
		
		return ResponseEntity.ok("Deletado Cliente com sucesso");
	}	
	
	@PutMapping("/cliente/{id}")	
	public ResponseEntity<String> update(@PathVariable(name = "id") int id,
								@RequestBody Cliente cliente) {
		
		clienteRepo.findById(id);
		clienteRepo.save(cliente);
		
		return ResponseEntity.ok("Atualizado Cliente com sucesso");
	
	}
}
