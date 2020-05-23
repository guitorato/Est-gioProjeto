package com.qintess.ingresso.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qintess.ingresso.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

	public Cliente findByNome(String nome);
	
	public Cliente findById (int id);
}
