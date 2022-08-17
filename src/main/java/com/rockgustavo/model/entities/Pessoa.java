package com.rockgustavo.model.entities;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private Double rendaAnual;

	abstract Double calculoImposto();

	public Pessoa() {

	}

	public Pessoa(Integer id, String nome, Double rendaAnual) {
		this.id = id;
		this.nome = nome;
		this.rendaAnual = rendaAnual;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getRendaAnual() {
		return rendaAnual;
	}

	public void setRendaAnual(Double rendaAnual) {
		this.rendaAnual = rendaAnual;
	}
	
	public Double getImposto() {
		return calculoImposto();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("(ID: %d) Nome: %s - Imposto à Pagar: R$ %.2f",  this.getId(), this.getNome(),
				calculoImposto()));
		return sb.toString();
	}
}
