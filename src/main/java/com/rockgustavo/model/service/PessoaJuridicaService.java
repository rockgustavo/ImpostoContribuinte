package com.rockgustavo.model.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rockgustavo.model.entities.Juridica;
import com.rockgustavo.model.repository.PessoaJuridicaRepository;

@Service
public class PessoaJuridicaService {
	@Autowired
	private PessoaJuridicaRepository pj;
	
	public List<Juridica> findAll() {
		return pj.findAll();
	}
	
	public Juridica findById(Integer id) {
		Optional<Juridica> pessoa = pj.findById(id);
		return pessoa.orElseThrow(() -> new ResourceNotFoundException(id));

	}

	public Juridica insert(Juridica obj) {
		return pj.save(obj);

	}
	
	public Juridica update(Juridica obj) {
		return pj.save(obj);

	}
	
	public void delete(Integer id) {
		pj.deleteById(id);
	}
	
	
	public Juridica update(Integer id, Juridica obj) {
		try {			
			Juridica entity = pj.getReferenceById(id);
			updateData(entity, obj);
			return pj.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}


	private void updateData(Juridica entity, Juridica obj) {
		entity.setNome(obj.getNome());
		entity.setRendaAnual(obj.getRendaAnual());
		entity.setNumFuncionarios(obj.getNumFuncionarios());
	}
}
