package org.java.best.controller;

import java.util.List;

import org.java.best.pojo.Offerta;
import org.java.best.service.ServiceOfferta;
import org.java.best.service.ServicePizza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OffertaController {
	
	@Autowired
	private ServicePizza pizzaService;
	
	@Autowired
	private ServiceOfferta offertaService;
	
	@GetMapping("/offerte")
	public String getHome(Model model) {
		
		List<Offerta> offerte = offertaService.findAll();
		
		model.addAttribute("offerte", offerte);
		
		return "offerte-index";
	}

}
