package br.solutis.exemplo.cartoes.api.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PositiveOrZero;

public class TransacaoDto {

	@NotEmpty
	private String numeroCartao;
	@NotEmpty
	private String senhaCartao;
	@PositiveOrZero
	private double valor;

	public TransacaoDto(String numeroCartao, String senha, double valor) {
		this.numeroCartao = numeroCartao;
		this.senhaCartao = senha;
		this.valor = valor;
	}
	
	

	public String getNumeroCartao() {
		return numeroCartao;
	}

	public String getSenhaCartao() {
		return senhaCartao;
	}

	public double getValor() {
		return valor;
	}
}
