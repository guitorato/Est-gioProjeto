package com.qintess.demo.controllers;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.qintess.demo.models.Evento;
import com.qintess.demo.services.EventoService;

@Controller
public class IndexController {

	@Autowired
	private EventoService eventoService;
	
	@RequestMapping("")
	public String index(Model model) {
		try {
			List<Evento> eventos = eventoService.buscarTodos();
			model.addAttribute("eventos", encodaImagemEvento(eventos));
		 
		} catch (UnsupportedEncodingException e) {
			model.addAttribute("mensagemErro", "ERRO GRAVE: " + e.getMessage());
		}
		
		return "index";
	}
	
	@RequestMapping ("/detalhe/{id}")
	public String detalhe(Model model,
			@PathVariable(name = "id") int id) throws UnsupportedEncodingException {
			
		Evento evento = eventoService.buscaPorId(id);
		byte[] encodeBase64 = Base64.getEncoder().encode(evento.getImagemProd());
		String base64Encoded = new String(encodeBase64, "UTF-8");
		model.addAttribute("evento",eventoService.buscaPorId(id));
		model.addAttribute("imageEvento", base64Encoded);
		
		return "detalhe";
	}	
	
	@RequestMapping ("/detalhe/{id}/{ingresso}")
	public String compra(@PathVariable(name = "id") int id ,
						@PathVariable(name = "ingresso") int ingresso , 
						RedirectAttributes redirectAtt) {
			
		Evento evento = eventoService.buscaPorId(id);
		int totalIngressos = evento.getQtdIngresso();
		
		if(evento.getQtdIngresso()>= ingresso){
			totalIngressos -= ingresso;
			evento.setQtdIngresso(totalIngressos);
			eventoService.altera(evento);
			redirectAtt.addFlashAttribute("mensagemSucesso", "Ingresso Comprado com Sucesso!");
			
		}else {
			redirectAtt.addFlashAttribute("mensagemErro", "Ingressos Esgotados!");
		}
		
		return "redirect:/detalhe/{id}";
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
