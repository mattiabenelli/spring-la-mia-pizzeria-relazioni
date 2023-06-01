package org.java.best.controller;

import java.util.List;

import org.java.best.pojo.Offerta;
import org.java.best.pojo.Pizza;
import org.java.best.service.ServiceOfferta;
import org.java.best.service.ServicePizza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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
	
	@GetMapping("/offerte/create")
	public String createOfferte(Model model) {
		
		List<Pizza> pizzas = pizzaService.findAll();
		
		model.addAttribute("offerta", new Offerta());
		model.addAttribute("pizzas", pizzas);
		
		return "offerta-create";
	}
	@PostMapping("/offerte/create")
	public String offertaPizzeStore(
			@ModelAttribute Offerta offerta
		) {
		
		offertaService.save(offerta);
		
		return "redirect:/offerte";
	}
	
	@GetMapping("/offerte/update/{id}")
	public String editOfferte(Model model,
							@PathVariable int id) {
		
		List<Pizza> pizzas = pizzaService.findAll();
		Offerta offerta = offertaService.findById(id).get();
		
		model.addAttribute("offerta", offerta);
		model.addAttribute("pizzas", pizzas);
		
		return "offerta-update";
	}
	
	@PostMapping("/offerte/update/{id}")
	public String updateOfferte(
			@PathVariable int id,
			@ModelAttribute Offerta offerta
		) {

		offertaService.save(offerta);

		return "redirect:/offerte";
	}
}
