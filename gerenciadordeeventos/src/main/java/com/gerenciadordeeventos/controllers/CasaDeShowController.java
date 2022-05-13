package com.gerenciadordeeventos.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gerenciadordeeventos.entities.CasaDeShow;
import com.gerenciadordeeventos.services.CasaDeShowService;


@Controller
@RequestMapping("/")
public class CasaDeShowController {

	@Autowired
	private CasaDeShowService casaDeShowService;
	
	
	@RequestMapping(method = RequestMethod.GET, path = "/casadeshow")
	public ModelAndView CasaDeShow(@RequestParam (required = false) Long id) {
		ModelAndView mv = new ModelAndView("casadeshow.html");
		
		if(id == null) {
			mv.addObject("novacasa", new CasaDeShow());
		}else {
			casaDeShowService.obterCasaDeShow(id);
			mv.addObject("novacasa",casaDeShowService.obterCasaDeShow(id));
		}
		
		mv.addObject("lista", casaDeShowService.casasDeShows());
		
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/casadeshow") //Funcionando
	public ModelAndView novaCasaDeShow(CasaDeShow casaDeShow) {
		ModelAndView mv = new ModelAndView("redirect:/casadeshow");

		casaDeShowService.salvarCasaDeShow(casaDeShow);
		
		return mv;
	}
	
	@RequestMapping("/excluir") //funcionando
	public ModelAndView excluirCasaDeShow(@RequestParam Long id, RedirectAttributes redirectAttributes) {
		ModelAndView mv = new ModelAndView("redirect:/casadeshow");		
		
		try {
			casaDeShowService.excluirCasaDeShow(id);
			redirectAttributes.addFlashAttribute("mensagemSucesso","Excluído com Sucesso!");			
		}catch(Exception e){
			redirectAttributes.addFlashAttribute("mensagemErro","Não foi possível excluir essa casa de show! Obs: Há eventos vínculados");
		}
		return mv;
	}
}