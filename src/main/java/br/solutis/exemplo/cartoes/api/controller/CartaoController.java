package br.solutis.exemplo.cartoes.api.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.solutis.exemplo.cartoes.api.dto.CartaoDto;
import br.solutis.exemplo.cartoes.api.exceptions.CartaoInvalidoException;
import br.solutis.exemplo.cartoes.api.model.Cartao;
import br.solutis.exemplo.cartoes.api.services.CartaoService;

@RestController
@RequestMapping("/cartao")
public class CartaoController {

	@Autowired
	private CartaoService service;

	@GetMapping
	private ResponseEntity<Iterable<Cartao>> listarCartoes() {
		return new ResponseEntity<Iterable<Cartao>>(service.listarCartoes(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<String> getSaldo(@PathVariable("id") String id) {
		try {
			return new ResponseEntity<String>(service.consultarSaldo(id), HttpStatus.OK);
		} catch (CartaoInvalidoException ex) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping
	private ResponseEntity<CartaoDto> criarCartao(@RequestBody(required = true) @Valid CartaoDto novoCartao) {
		try {
			return new ResponseEntity<CartaoDto>(service.criarCartao(novoCartao), HttpStatus.CREATED);
		} catch (CartaoInvalidoException ex) {
			return new ResponseEntity<CartaoDto>(novoCartao, HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}
}
