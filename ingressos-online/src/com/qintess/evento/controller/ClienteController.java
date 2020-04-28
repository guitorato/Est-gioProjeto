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
import com.qintess.evento.model.Cliente;
import com.qintess.evento.model.Cliente;

@Controller
@RequestMapping("/registrarCliente")
public class ClienteController {
	
	@Autowired
	private Dao dao;
	
	
	@RequestMapping("")
	public String carrega(Model model) {
		model.addAttribute("clientes", dao.buscaTodos(Cliente.class));
		model.addAttribute("cliente", new Cliente());
		return "registrarCliente";
	}
	
	@RequestMapping("/salva")
	public String salva(@ModelAttribute Cliente cliente,
			            @RequestParam(required = false, value="cancela") String cancela,
			            RedirectAttributes redirectAtt) {
		try {
			
			if(cancela != null) {
				return "redirect:/registrarCliente";
			}
			if(cliente.getId() == 0) {
				
				dao.salva(cliente);
				redirectAtt.addFlashAttribute("mensagemSucesso", "Casa de show cadastrada com sucesso!");
			}else {
				dao.altera(cliente);
				redirectAtt.addFlashAttribute("mensagemSucesso", "Alterações realizadas com sucesso!");
			}
		} catch (Exception e) {
			redirectAtt.addFlashAttribute("mensagemErro", "ERRO GRAVE" + e.getMessage());
		}
		
		return "redirect:/registrarCliente";
	}
	
	@RequestMapping("/deleta/{id}")
	public String deleta(@PathVariable (name="id") int id,
						 RedirectAttributes redirectAtt) {
		
		Cliente cliente = dao.buscaPorId(Cliente.class, id);
		dao.deleta(cliente);
		redirectAtt.addFlashAttribute("mensagemSucesso", "Casa de show deletada com sucesso!");
		
		return "redirect:/registrarCliente";
	}
	@RequestMapping ("/alterar/{id}")
	public String carregaAlterar(@PathVariable(name = "id") int id , Model model) {
			
		model.addAttribute("clientes", dao.buscaTodos(Cliente.class));
		model.addAttribute("cliente", dao.buscaPorId(Cliente.class, id));
		
		return "registrarCliente";
	}

}
