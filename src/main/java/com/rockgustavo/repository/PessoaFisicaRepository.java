package com.rockgustavo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rockgustavo.model.Fisica;

public interface PessoaFisicaRepository extends JpaRepository<Fisica, Integer>{

}
