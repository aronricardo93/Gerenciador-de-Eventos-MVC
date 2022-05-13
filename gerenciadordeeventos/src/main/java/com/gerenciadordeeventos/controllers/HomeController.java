package com.gerenciadordeeventos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gerenciadordeeventos.services.EventoService;

@Controller
@RequestMapping("/home")
public class HomeController {

	@Autowired
	private EventoService eventoService;
	
	@RequestMapping()  
	public ModelAndView home() {
		
		ModelAndView mv = new ModelAndView("home.html");
		
		mv.addObject("listaevento", eventoService.listaEventos());
		
		return mv;
		
	}
}
