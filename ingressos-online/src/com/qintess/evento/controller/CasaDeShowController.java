package com.qintess.evento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.qintess.evento.dao.Dao;
import com.qintess.evento.model.CasaDeShow;

@Controller
@RequestMapping("/registrarCasaShow")
public class CasaDeShowController {
	
	@Autowired
	private Dao dao;
	
	
	@RequestMapping("")
	public String carrega(Model model) {
		model.addAttribute("casaDeShows", dao.buscaTodos(CasaDeShow.class));
		model.addAttribute("casaDeShow", new CasaDeShow());
		return "registrarCasaShow";
	}
	
	@RequestMapping("/salva")
	public String salva(@ModelAttribute CasaDeShow casaDeShow,
			            @RequestParam(required = false, value="cancela") String cancela,
			            RedirectAttributes redirectAtt) {
		try {
			
			if(cancela != null) {
				return "redirect:/registrarCasaShow";
			}
			if(casaDeShow.getId() == 0) {
				
				dao.salva(casaDeShow);
				redirectAtt.addFlashAttribute("mensagemSucesso", "Casa de show cadastrada com sucesso!");
			}else {
				dao.altera(casaDeShow);
				redirectAtt.addFlashAttribute("mensagemSucesso", "Alterações realizadas com sucesso!");
			}
		} catch (Exception e) {
			redirectAtt.addFlashAttribute("mensagemErro", "ERRO GRAVE" + e.getMessage());
		}
		
		return "redirect:/registrarCasaShow";
	}
	
	@RequestMapping("/deleta/{id}")
	public String deleta(@PathVariable (name="id") int id,
						 RedirectAttributes redirectAtt) {
		
		CasaDeShow casaDeShow = dao.buscaPorId(CasaDeShow.class, id);
		dao.deleta(casaDeShow);
		redirectAtt.addFlashAttribute("mensagemSucesso", "Casa de show deletada com sucesso!");
		
		return "redirect:/registrarCasaShow";
	}
	@RequestMapping ("/alterar/{id}")
	public String carregaAlterar(@PathVariable(name = "id") int id , Model model) {
			
		model.addAttribute("casaDeShows", dao.buscaTodos(CasaDeShow.class));
		model.addAttribute("casaDeShow", dao.buscaPorId(CasaDeShow.class, id));
		
		return "registrarCasaShow";
	}

}
