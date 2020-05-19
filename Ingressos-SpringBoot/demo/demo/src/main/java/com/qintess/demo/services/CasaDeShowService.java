package com.qintess.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qintess.demo.models.CasaDeShow;
import com.qintess.demo.repos.CasaDeShowRepository;

@Service
public class CasaDeShowService {
	
	@Autowired
	private CasaDeShowRepository casaDeShowRepository;
	
	public void insere(CasaDeShow casaDeShow) {
		casaDeShowRepository.save(casaDeShow);
	}
	
	public void altera(CasaDeShow casaDeShow) {
		casaDeShowRepository.saveAndFlush(casaDeShow);
	}
	
	public void deleta(CasaDeShow casaDeShow) {
		casaDeShowRepository.delete(casaDeShow);
		}
	
	public CasaDeShow buscaPorNome(String nome) {
		return casaDeShowRepository.findByNome(nome);
	}
	
	public CasaDeShow buscaPorId(int id) {
		return casaDeShowRepository.findById(id);
	}
	
	public List<CasaDeShow> buscarTodos(){
		return casaDeShowRepository.findAll();
	}

}
