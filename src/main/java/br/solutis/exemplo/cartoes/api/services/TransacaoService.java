package br.solutis.exemplo.cartoes.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.solutis.exemplo.cartoes.api.dto.TransacaoDto;
import br.solutis.exemplo.cartoes.api.exceptions.CartaoInvalidoException;
import br.solutis.exemplo.cartoes.api.model.Cartao;
import br.solutis.exemplo.cartoes.api.repositories.CartaoRepository;

@Service
public class TransacaoService {
	@Autowired
	private CartaoRepository cartaoRepository;
	
	@Autowired
	private ExceptionHandler exceptionHandler;
	
//	@Autowired
//	private TransacaoRepository transacaoRepository;

	public String realizarTransacao(TransacaoDto dto) {
		Cartao cartao = cartaoRepository.findById(dto.getNumeroCartao()).orElseThrow(CartaoInvalidoException::new);

		if (!cartao.getSenha().equals(dto.getSenhaCartao())) {
			// transacaoRepository.save(cartao);
			exceptionHandler.throwSenhaException();
		}

		if (!(dto.getValor() <= cartao.getSaldo())) {
			// transacaoRepository.save(cartao);
			exceptionHandler.throwSaldoInsuficienteException();
		}

		cartao.setSaldo(cartao.getSaldo() - dto.getValor());
		cartaoRepository.save(cartao);
		// transacaoRepository.save(cartao);

		return "OK";
	}
}
