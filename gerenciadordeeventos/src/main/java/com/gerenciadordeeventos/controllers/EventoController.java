package com.gerenciadordeeventos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gerenciadordeeventos.entities.Evento;
import com.gerenciadordeeventos.services.CasaDeShowService;
import com.gerenciadordeeventos.services.EventoService;

@Controller
@RequestMapping("/evento")
public class EventoController {

	@Autowired
	private EventoService eventoService;
	
	@Autowired
	private CasaDeShowService casaDeShowService;
	
	@RequestMapping() 
	public ModelAndView evento(@RequestParam (required = false) Long id) throws Exception {
		
		ModelAndView mv = new ModelAndView("evento.html");
		if(id == null) {
			mv.addObject("evento", new Evento());
		}else {
			eventoService.obterEvento(id);
			mv.addObject("evento", eventoService.obterEvento(id));
		}
		mv.addObject("listaevento", eventoService.listaEventos());
		
		mv.addObject("listacasa", casaDeShowService.casasDeShows());
		
		return mv;
		
	}
	
	
	@RequestMapping(method = RequestMethod.POST)     
	public ModelAndView novoEvento(Evento evento) {  
		
		ModelAndView mv = new ModelAndView("redirect:/evento");
		try {
			eventoService.cadastrarEvento(evento);
		}catch(Exception e){
			mv.addObject("mensagem", e.getStackTrace());
		}
		return mv;
	}
	
	@RequestMapping("/deletar") 
	public ModelAndView excluirEvento(@RequestParam Long id, RedirectAttributes redirectAttributes) {
		ModelAndView mv = new ModelAndView("redirect:/evento");
		
		try {	
			eventoService.deletarEvento(id);
			redirectAttributes.addFlashAttribute("mensagem","Excluído com sucesso!");
		}catch(Exception e) {
			redirectAttributes.addFlashAttribute("mensagem", "Não foi possível excluir!");
		}
		
			return mv; 
	}
}
