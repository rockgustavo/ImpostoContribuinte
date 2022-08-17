package com.rockgustavo.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rockgustavo.model.entities.Juridica;

public interface PessoaJuridicaRepository extends JpaRepository<Juridica, Integer>{

}
