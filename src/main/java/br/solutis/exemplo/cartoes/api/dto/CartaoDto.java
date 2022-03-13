package br.solutis.exemplo.cartoes.api.dto;

import br.solutis.exemplo.cartoes.api.model.Cartao;
import br.solutis.exemplo.cartoes.api.utils.Utils;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartaoDto {

	private String numeroCartao;
	private Double saldo;
	private String senha;
	private String dataCriacao;
	private String validade;
	
	public static CartaoDto createCartaoDto(Cartao cartao) {
		CartaoDto cartaoDto = new CartaoDto(cartao.getNumeroCartao(), cartao.getSaldo(), cartao.getSenha(), Utils.formatarDateToString(cartao.getDataCriacao()), Utils.formatarDateToString(cartao.getValidade())); 
		return cartaoDto;
	}


}
