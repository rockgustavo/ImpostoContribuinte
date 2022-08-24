package com.rockgustavo.model.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_pessoa_fisica")
public class Fisica extends Pessoa {
	private static final long serialVersionUID = 1L;
	
	private Double gastosComSaude;
	
	public Fisica() {
		
	}
	
	public Fisica(Integer id, String nome, Double rendaAnual, Double gastosComSaude) {
		super(id, nome, rendaAnual);
		this.gastosComSaude = gastosComSaude;
	}

	@Override
	String calculoImposto() {
		if(getRendaAnual() < 20000.0) {
			return String.valueOf((getRendaAnual() * 0.15) - (getGastosComSaude() * 0.5));
		}else {
			return String.valueOf((getRendaAnual() * 0.25) - (getGastosComSaude() * 0.5));
		}
	}
	
	public Double getGastosComSaude() {
		return gastosComSaude;
	}

	public void setGastosComSaude(Double gastosComSaude) {
		this.gastosComSaude = gastosComSaude;
	}
	
}