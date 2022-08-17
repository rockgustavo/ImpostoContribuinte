package com.rockgustavo.model.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rockgustavo.model.entities.Fisica;
import com.rockgustavo.model.repository.PessoaFisicaRepository;

@Service
public class PessoaFisicaService {
	@Autowired
	private PessoaFisicaRepository pf;
	
	public List<Fisica> findAll() {
		return pf.findAll();
	}
	
	public Fisica findById(Integer id) {
		Optional<Fisica> pessoa = pf.findById(id);
		return pessoa.orElseThrow(() -> new ResourceNotFoundException(id));

	}

	public Fisica insert(Fisica obj) {
		return pf.save(obj);

	}
	
	public void delete(Integer id) {
		pf.deleteById(id);
	}
	
	
	public Fisica update(Integer id, Fisica obj) {
		try {			
			Fisica entity = pf.getReferenceById(id);
			updateData(entity, obj);
			return pf.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}


	private void updateData(Fisica entity, Fisica obj) {
		entity.setNome(obj.getNome());
		entity.setRendaAnual(obj.getRendaAnual());
		entity.setRendaAnual(obj.getRendaAnual());
	}

}
