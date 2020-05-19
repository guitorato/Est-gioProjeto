package com.qintess.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qintess.demo.models.Evento;

public interface EventoRepository extends JpaRepository<Evento , Integer>{

	public Evento findByNome(String nome);
	
	public Evento findById (int id);
}
