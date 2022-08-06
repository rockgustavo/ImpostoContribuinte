package com.rockgustavo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HomeController {
	ModelAndView mv = new ModelAndView();

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@GetMapping("/")
	public ModelAndView index2() {
		mv.setViewName("home/index");
		return mv;
	}

	@GetMapping("/logar")
	public ModelAndView index() {
		mv.setViewName("home/index");
		return mv;
	}

	@PostMapping("/logar")
	public ModelAndView create(String name, String password) {
		System.out.println("LOGIN: " + name + " - SENHA: " + passwordEncoder.encode(password));

		mv.setViewName("home/index");
		return mv;
	}

}