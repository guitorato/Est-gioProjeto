package com.qintess.evento.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@RequestMapping("/")
	public String index() {
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

}
