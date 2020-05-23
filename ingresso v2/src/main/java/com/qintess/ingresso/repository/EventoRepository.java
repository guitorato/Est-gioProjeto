package com.qintess.ingresso.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qintess.ingresso.entity.Evento;

public interface EventoRepository extends JpaRepository<Evento , Integer>{

	public Evento findByNome(String nome);
	
	public Evento findById (int id);
}
