package com.rockgustavo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.rockgustavo.model.entities.Fisica;
import com.rockgustavo.model.service.PessoaFisicaService;

@RestController
@RequestMapping(value = "/pf")
public class PessoaFisicaController {

	@Autowired
	private PessoaFisicaService service;
	
	@GetMapping("/cad")
	public ModelAndView pessoafisica(Fisica fisica) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("pessoaFisica/cadastro");
		return mv;
	}
	
	@PostMapping("/salvar")
	public ModelAndView salvar(Fisica fisica, RedirectAttributes attr) {
		if(service.insert(fisica) != null) {
			attr.addFlashAttribute("success", "Cadastro efetuado com sucesso!");
		}else {
			attr.addFlashAttribute("fail", "Ocorreu um erro! cadastro não efetuado!");
		}
		ModelAndView mv = new ModelAndView("redirect:/pf/cad");
		return mv;
	}
	
	@GetMapping("/listar")
	public ModelAndView pessoafisicaListar() {
		ModelAndView mv = new ModelAndView();
		List<Fisica> list = service.findAll();
		mv.addObject("listaPf", list);
		mv.setViewName("pessoaFisica/lista");
		return mv;
	}
	
	@GetMapping(value = "/editar/{id}")
	public ModelAndView preEditar(@PathVariable Integer id, RedirectAttributes attr) {
		attr.addFlashAttribute("info", "Modo de edição!");
		Fisica pessoa = service.findById(id);
		ModelAndView mv = new ModelAndView("redirect:/pf/cad");
		mv.addObject(pessoa);
		return mv;
	}
	
	@PostMapping(value = "/editar")
	public ModelAndView editar(Fisica fisica, RedirectAttributes attr) {
		if(service.update(fisica) != null) {
			attr.addFlashAttribute("success", "Cadastro atualizado com sucesso!");
		}else {
			attr.addFlashAttribute("fail", "Ocorreu um erro! cadastro não atualizado!");
		}
		return new ModelAndView("redirect:/pf/listar");
	}
	
	@GetMapping(value = "/delete/{id}")
	public ModelAndView deletar(@PathVariable Integer id, RedirectAttributes attr) {
		service.delete(id);
		attr.addFlashAttribute("success", "Exclusão realizada com sucesso!");
		return new ModelAndView("redirect:/pf/listar");
	}
	
	@ModelAttribute("pessoasF")
	public List<Fisica> listarPf() {
		List<Fisica> list = service.findAll();
		return list;
	}

}
