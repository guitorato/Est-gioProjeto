package com.qintess.ingresso.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qintess.ingresso.entity.CasaDeShow;


public interface CasaDeShowRepository extends JpaRepository<CasaDeShow, Integer> {

	public CasaDeShow findByNome(String nome);
	
	public CasaDeShow findById (int id);
}
