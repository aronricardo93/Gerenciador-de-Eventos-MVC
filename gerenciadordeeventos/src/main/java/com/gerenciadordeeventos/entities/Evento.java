package com.gerenciadordeeventos.entities;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Evento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	private Long capacidade;
	
	private BigDecimal precoDoIngresso;
	
	private String data;
	
	@ManyToOne
	private CasaDeShow casaDeshow;
	
	private String generoMusical;

	
	public String getGeneroMusical() {
		return generoMusical;
	}

	public void setGeneroMusical(String generoMusical) {
		this.generoMusical = generoMusical;
	}

	public CasaDeShow getCasaDeshow() {
		return casaDeshow;
	}

	public void setCasaDeshow(CasaDeShow casaDeshow) {
		this.casaDeshow = casaDeshow;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(Long capacidade) {
		this.capacidade = capacidade;
	}

	public BigDecimal getPrecoDoIngresso() {
		return precoDoIngresso;
	}

	public void setPrecoDoIngresso(BigDecimal precoDoIngresso) {
		this.precoDoIngresso = precoDoIngresso;
	}

}
