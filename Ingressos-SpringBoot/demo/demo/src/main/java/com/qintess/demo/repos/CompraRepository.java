package com.qintess.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qintess.demo.models.Compra;

public interface CompraRepository extends JpaRepository<Compra , Integer>{
	

	
	public Compra findById (int id);

}
