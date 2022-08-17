package com.rockgustavo.web.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.rockgustavo.model.entities.Juridica;
import com.rockgustavo.model.service.PessoaJuridicaService;

@RestController
@RequestMapping(value = "/pj")
public class PessoaJuridicaController {
	
	@Autowired
	private PessoaJuridicaService service;

	@GetMapping
	public ModelAndView findAll() {
		ModelAndView mv = new ModelAndView();
		List<Juridica> listPessoas = service.findAll();
		mv.addObject("listPessoas", listPessoas);
		mv.setViewName("pj");
		return mv;
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Juridica> findById(@PathVariable Integer id) {
		Juridica pessoa = service.findById(id);

		return ResponseEntity.ok().body(pessoa);

	}
	
	@GetMapping(value = "/impostos")
	public ResponseEntity<List<String>> findAllTax() {
		List<String> list = service.findAll().stream().map(pf -> pf.toString()).collect(Collectors.toList());
		return ResponseEntity.ok().body(list);

	}
	
	@GetMapping(value = "/imposto/{id}")
	public ResponseEntity<List<String>> findTax(@PathVariable Integer id) {
		List<String> pessoa = new ArrayList<>();
		pessoa.add(service.findById(id).toString());
		return ResponseEntity.ok().body(pessoa);

	}
	
	@PostMapping("/inserirpj")
	public ModelAndView insert(Juridica juridica) {
		ModelAndView mv = new ModelAndView();
		service.insert(juridica);
		mv.setViewName("pj");
		return mv;
	}
	
	@PostMapping("/atualizarpj")
	public ModelAndView update(Integer id, Juridica juridica) {
		ModelAndView mv = new ModelAndView();
		service.update(id, juridica);
		mv.setViewName("pj");
		return mv;
	}
	
	@PostMapping("/deletarpj")
	public ModelAndView delete(Integer id) {
		ModelAndView mv = new ModelAndView();
		service.delete(id);
		mv.setViewName("pj");
		return mv;
	}

}
