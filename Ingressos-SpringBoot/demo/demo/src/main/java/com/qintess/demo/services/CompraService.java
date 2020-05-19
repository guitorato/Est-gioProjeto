package com.qintess.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qintess.demo.models.Compra;
import com.qintess.demo.repos.CompraRepository;

@Service
public class CompraService {

	@Autowired
	private CompraRepository compraRepository;
	
	public void insere(Compra compra) {
		compraRepository.save(compra);
	}
	
	public void altera(Compra compra) {
		compraRepository.saveAndFlush(compra);
	}
	
	public void deleta(Compra cliente) {
		compraRepository.delete(cliente);
		}
	
	
	public Compra buscaPorId(int id) {
		return compraRepository.findById(id);
	}
	
	public List<Compra> buscarTodos(){
		return compraRepository.findAll();
	}
}
