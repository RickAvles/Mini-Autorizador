package br.solutis.exemplo.cartoes.api.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Cartao {
	@Id
	private String numeroCartao;
	private Double saldo;
	private String senha;
	private LocalDate dataCriacao;
	private LocalDate validade;
	
	@ManyToOne
	private Cliente cliente;

	public Cartao(String numeroCartao, double saldo, String senha) {
		this.numeroCartao = numeroCartao;
		this.saldo = saldo;
		this.senha = senha;
	}
	
	
	//NoArgsConstructor
//	public Cartao() {
//		
//	}
//	
	//AllArgsConstructor
//	public Cartao(String numeroCartao, Double saldo, String senha, LocalDate dataCriacao, LocalDate validade, Cliente cliente) {
//		this.numeroCartao = numeroCartao;
//		this.saldo = saldo;
//		this.senha = senha;
//		this.dataCriacao = dataCriacao;
//		this.validade = validade;
//		this.cliente = cliente;
//	}
}