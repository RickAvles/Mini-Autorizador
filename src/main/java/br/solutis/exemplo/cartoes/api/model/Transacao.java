package br.solutis.exemplo.cartoes.api.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Transacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String numeroCartao;
	private double valor;
	private String senha;
	private String StatusTransacao;

	public Long getId() {
		return id;
	}

	public String getNumeroCartao() {
		return numeroCartao;
	}

	public double getSaldo() {
		return valor;
	}

	public String getSenha() {
		return senha;
	}

	public String getStatus() {
		return StatusTransacao;
	}
}
