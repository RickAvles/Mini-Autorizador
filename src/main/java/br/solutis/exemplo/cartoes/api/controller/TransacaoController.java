package br.solutis.exemplo.cartoes.api.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.solutis.exemplo.cartoes.api.dto.TransacaoDto;
import br.solutis.exemplo.cartoes.api.exceptions.CartaoInvalidoException;
import br.solutis.exemplo.cartoes.api.exceptions.SaldoInsuficienteException;
import br.solutis.exemplo.cartoes.api.exceptions.SenhaInvalidaException;
import br.solutis.exemplo.cartoes.api.services.TransacaoService;

@RestController
@RequestMapping("/transacoes")
public class TransacaoController {
	@Autowired
	private TransacaoService service;

	@PostMapping
	private ResponseEntity<String> efetuarTransacao(@RequestBody @Valid TransacaoDto transacaoDto) {
		try {
			return new ResponseEntity<String>(service.realizarTransacao(transacaoDto), HttpStatus.CREATED);
		} catch (CartaoInvalidoException ex) {
			return new ResponseEntity<String>("CARTAO_INEXISTENTE", HttpStatus.UNPROCESSABLE_ENTITY);
		} catch (SaldoInsuficienteException ex) {
			return new ResponseEntity<String>("SALDO_INSUFICIENTE", HttpStatus.UNPROCESSABLE_ENTITY);
		} catch (SenhaInvalidaException ex) {
			return new ResponseEntity<String>("SENHA_INVALIDA", HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}
}
