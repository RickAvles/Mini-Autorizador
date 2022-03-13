package br.solutis.exemplo.cartoes.api.services;

import java.time.LocalDate;
import java.util.Locale;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.solutis.exemplo.cartoes.api.dto.CartaoDto;
import br.solutis.exemplo.cartoes.api.dto.TransacaoDto;
import br.solutis.exemplo.cartoes.api.exceptions.CartaoInvalidoException;
import br.solutis.exemplo.cartoes.api.model.Cartao;
import br.solutis.exemplo.cartoes.api.repositories.CartaoRepository;
import br.solutis.exemplo.cartoes.api.utils.Utils;

@Service
public class CartaoService {

	@Autowired
	private ExceptionHandler exceptionHandler;

	@Autowired
	private CartaoRepository repository;

	private static final double SALDO_INICIAL = 500.00;
	private static final LocalDate VALIDADE_INICIAL = LocalDate.now().plusYears(3).plusMonths(10);

	public Iterable<Cartao> listarCartoes() {
		return repository.findAll();
	}

	private Cartao gerarCartao(CartaoDto dto) {
		return new Cartao(dto.getNumeroCartao(), SALDO_INICIAL, dto.getSenha());
	}

	public CartaoDto criarCartao(CartaoDto novoCartaoDto) {
		if (!Utils.verificarCartaoDto(novoCartaoDto)) {
			exceptionHandler.throwCartaoInvalidoException();
		}
		if (repository.existsById(novoCartaoDto.getNumeroCartao())) {
			exceptionHandler.throwCartaoInvalidoException();
		}

		Cartao novoCartao = repository.save(gerarCartao(novoCartaoDto));

		return CartaoDto.createCartaoDto(novoCartao);
	}

	public String consultarSaldo(String numeroCartao) {
		Cartao cartao = repository.findById(numeroCartao).orElseThrow(CartaoInvalidoException::new);
		return String.format(Locale.ENGLISH, "%.2f", cartao.getSaldo());
	}

	public String realizarTransacao(TransacaoDto dto) {
		Cartao cartao = repository.findById(dto.getNumeroCartao()).orElseThrow(CartaoInvalidoException::new);

		if (!cartao.getSenha().equals(dto.getSenhaCartao())) {
			exceptionHandler.throwSenhaException();
		}
		if (!(dto.getValor() <= cartao.getSaldo())) {
			exceptionHandler.throwSaldoInsuficienteException();
		}

		cartao.setSaldo(cartao.getSaldo() - dto.getValor());
		repository.save(cartao);

		return "OK";
	}

}
