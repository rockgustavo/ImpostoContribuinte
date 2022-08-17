package com.rockgustavo.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rockgustavo.model.entities.Fisica;

public interface PessoaFisicaRepository extends JpaRepository<Fisica, Integer>{

}
