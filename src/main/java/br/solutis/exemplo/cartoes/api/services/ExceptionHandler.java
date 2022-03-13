package br.solutis.exemplo.cartoes.api.services;

import org.springframework.stereotype.Component;

import br.solutis.exemplo.cartoes.api.exceptions.CartaoInvalidoException;
import br.solutis.exemplo.cartoes.api.exceptions.SaldoInsuficienteException;
import br.solutis.exemplo.cartoes.api.exceptions.SenhaInvalidaException;

@Component
public class ExceptionHandler {

	public boolean throwSenhaException() {
		throw new SenhaInvalidaException();
	}

	public boolean throwSaldoInsuficienteException() {
		throw new SaldoInsuficienteException();
	}

	public boolean throwCartaoInvalidoException() {
		throw new CartaoInvalidoException();
	}

}

