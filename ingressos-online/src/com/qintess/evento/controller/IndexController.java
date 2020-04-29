package com.qintess.evento.controller;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qintess.evento.dao.Dao;
import com.qintess.evento.model.Evento;

@Controller
public class IndexController {

	@Autowired
	private Dao dao;
	
	@RequestMapping("/")
	public String index(Model model) {
		try {
			List<Evento> eventos = dao.buscaTodos(Evento.class);
			model.addAttribute("eventos", encodaImagemEvento(eventos));
		 
		} catch (UnsupportedEncodingException e) {
			model.addAttribute("mensagemErro", "ERRO GRAVE: " + e.getMessage());
		}
		
		return "index";
	}
	
	@RequestMapping("/rodape")
	public String rodape() {
		return "rodape";
	}
	
	@RequestMapping("/menu")
	public String menu() {
		return "menu";
	}
	
	@RequestMapping("/menuLateral")
	public String menuLateral() {
		return "menuLateral";
	}
	
private List<Evento> encodaImagemEvento(List<Evento> eventos) throws UnsupportedEncodingException {
		
		for (Evento evento : eventos) {
			byte[] encodeBase64 = Base64.getEncoder().encode(evento.getImagemProd());
			evento.setImagemEncoded(new String(encodeBase64, "UTF-8"));
		}
		return eventos;
	}

}
