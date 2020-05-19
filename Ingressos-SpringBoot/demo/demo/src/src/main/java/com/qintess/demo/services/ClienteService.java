package com.qintess.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qintess.demo.models.Cliente;
import com.qintess.demo.repos.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public void insere(Cliente cliente) {
		clienteRepository.save(cliente);
	}
	
	public void altera(Cliente cliente) {
		clienteRepository.saveAndFlush(cliente);
	}
	
	public void deleta(Cliente cliente) {
		clienteRepository.delete(cliente);
		}
	
	public Cliente buscaPorNome(String nome) {
		return clienteRepository.findByNome(nome);
	}
	
	public Cliente buscaPorId(int id) {
		return clienteRepository.findById(id);
	}
	
	public List<Cliente> buscarTodos(){
		return clienteRepository.findAll();
	}

}
