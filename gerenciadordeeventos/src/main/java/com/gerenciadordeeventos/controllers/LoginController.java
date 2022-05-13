package com.gerenciadordeeventos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

	@Autowired
	private HomeController homeController;
	
	@RequestMapping("/login")
	public ModelAndView login() {
		
		ModelAndView mv = new ModelAndView("login.html");
		
		return mv;
	}
	
	@RequestMapping("/")
	public ModelAndView index() {
			return homeController.home();
	}
	
	@RequestMapping("/logout")
	public ModelAndView logout() {
		
		ModelAndView mv = new ModelAndView("redirect:/login");
		
		return mv;
	}
	
}
