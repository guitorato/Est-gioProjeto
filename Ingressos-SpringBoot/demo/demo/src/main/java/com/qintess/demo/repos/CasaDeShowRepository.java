package com.qintess.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qintess.demo.models.CasaDeShow;


public interface CasaDeShowRepository extends JpaRepository<CasaDeShow, Integer> {

	public CasaDeShow findByNome(String nome);
	
	public CasaDeShow findById (int id);
}
