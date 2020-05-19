package com.qintess.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.qintess.demo.services.CasaDeShowService;
import com.qintess.demo.models.CasaDeShow;

@Controller
@RequestMapping("/registrarCasaShow")
public class CasaDeShowController {
	
	@Autowired
	private CasaDeShowService casaDeShowService;
	
	
	@RequestMapping("")
	public String carrega(Model model) {
		model.addAttribute("casaDeShows", casaDeShowService.buscarTodos());
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
				
				casaDeShowService.insere(casaDeShow);
				redirectAtt.addFlashAttribute("mensagemSucesso", "Casa de show cadastrada com sucesso!");
			}else {
				casaDeShowService.altera(casaDeShow);
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
		
		CasaDeShow casaDeShow = casaDeShowService.buscaPorId(id);
		casaDeShowService.deleta(casaDeShow);
		redirectAtt.addFlashAttribute("mensagemSucesso", "Casa de show deletada com sucesso!");
		
		return "redirect:/registrarCasaShow";
	}
	@RequestMapping ("/alterar/{id}")
	public String carregaAlterar(@PathVariable(name = "id") int id , Model model) {
			
		model.addAttribute("casaDeShows", casaDeShowService.buscarTodos());
		model.addAttribute("casaDeShow", casaDeShowService.buscaPorId(id));
		
		return "registrarCasaShow";
	}

}
