package com.rockgustavo.model.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_pessoa_juridica")
public class Juridica extends Pessoa {
	private static final long serialVersionUID = 1L;

	private Integer numFuncionarios;

	public Juridica() {

	}

	public Juridica(Integer id, String nome, Double rendaAnual, Integer numFuncionarios) {
		super(id, nome, rendaAnual);
		this.numFuncionarios = numFuncionarios;
	}

	@Override
	String calculoImposto() {
		if (getNumFuncionarios() > 10) {
			return String.format("R$ %,.2f", getRendaAnual() * 0.14);
		} else {
			return String.format("R$ %,.2f", getRendaAnual() * 0.16);
		}
	}

	public Integer getNumFuncionarios() {
		return numFuncionarios;
	}

	public void setNumFuncionarios(Integer numFuncionarios) {
		this.numFuncionarios = numFuncionarios;
	}

}