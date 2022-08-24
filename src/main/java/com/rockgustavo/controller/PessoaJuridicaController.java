package com.rockgustavo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.rockgustavo.model.entities.Juridica;
import com.rockgustavo.model.service.PessoaJuridicaService;

@RestController
@RequestMapping(value = "/pj")
public class PessoaJuridicaController {
	@Autowired
	private PessoaJuridicaService service;
	
	@GetMapping("/cad")
	public ModelAndView pessoajuridica(Juridica juridica) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("pessoaJuridica/cadastro");
		return mv;
	}
	
	@PostMapping("/salvar")
	public ModelAndView salvar(Juridica juridica, RedirectAttributes attr) {
		if(service.insert(juridica) != null) {
			attr.addFlashAttribute("success", "Cadastro efetuado com sucesso!");
		}else {
			attr.addFlashAttribute("fail", "Ocorreu um erro! cadastro não efetuado!");
		}
		ModelAndView mv = new ModelAndView("redirect:/pj/cad");
		return mv;
	}
	
	@GetMapping("/listar")
	public ModelAndView pessoajuridicaListar() {
		ModelAndView mv = new ModelAndView();
		List<Juridica> list = service.findAll();
		mv.addObject("listaPj", list);
		mv.setViewName("pessoaJuridica/lista");
		return mv;
	}
	
	@GetMapping(value = "/editar/{id}")
	public ModelAndView preEditar(@PathVariable Integer id, RedirectAttributes attr) {
		attr.addFlashAttribute("info", "Modo de edição!");
		Juridica juridica = service.findById(id);
		ModelAndView mv = new ModelAndView("redirect:/pj/cad");
		mv.addObject(juridica);
		return mv;
	}
	
	@PostMapping(value = "/editar")
	public ModelAndView editar(Juridica juridica, RedirectAttributes attr) {
		if(service.update(juridica) != null) {
			attr.addFlashAttribute("success", "Cadastro atualizado com sucesso!");
		}else {
			attr.addFlashAttribute("fail", "Ocorreu um erro! cadastro não atualizado!");
		}
		return new ModelAndView("redirect:/pj/listar");
	}
	
	@GetMapping(value = "/delete/{id}")
	public ModelAndView deletar(@PathVariable Integer id, RedirectAttributes attr) {
		service.delete(id);
		attr.addFlashAttribute("success", "Exclusão realizada com sucesso!");
		return new ModelAndView("redirect:/pj/listar");
	}
	
	@ModelAttribute("pessoasJ")
	public List<Juridica> listarPj() {
		List<Juridica> list = service.findAll();
		return list;
	}

	
	
	
	


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
