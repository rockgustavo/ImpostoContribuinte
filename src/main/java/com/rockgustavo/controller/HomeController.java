package com.rockgustavo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RestController
@RequestMapping(value = "/")
public class HomeController {
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@GetMapping("/")
	public ModelAndView index2() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		return mv;
	}

	@GetMapping("/logar")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		return mv;
	}
	
	@GetMapping("/main")
	public ModelAndView layout() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("main");
		return mv;
	}

	@GetMapping("/voltar")
	public ModelAndView voltar() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home");
		return mv;
	}
	
	@GetMapping("/sair")
	public ModelAndView sair() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		return mv;
	}

	@PostMapping("/logar")
	public ModelAndView create(String login, String password, RedirectAttributes attr) {
		ModelAndView mv = new ModelAndView();
		System.out.println("LOGIN: " + login + " - SENHA: " + passwordEncoder.encode(password));
		boolean autSenha = new BCryptPasswordEncoder().matches("123", passwordEncoder.encode(password));
		
		if ("admin".equals(login) && autSenha) {
			mv.setViewName("main");
		} else {
			attr.addFlashAttribute("fail", "Login ou senha inválida!");
			mv.setViewName("redirect:/logar");
		}

		return mv;
	}

}