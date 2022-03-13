package br.solutis.exemplo.cartoes.api.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.solutis.exemplo.cartoes.api.model.Cliente;
import br.solutis.exemplo.cartoes.api.utils.Utils;
import br.solutis.exemplo.cartoes.api.viewmodel.EnderecoViewModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDto {

	public Integer id;
	public String cpf;
	public String data_inicio;
	List<CartaoDto> cartoes = new ArrayList<>();
	EnderecoViewModel endereco;
	
	public static ClienteDto createClienteDto(Cliente cliente) {
		List<CartaoDto> listaCartaoDto = cliente.getCartoes().stream().map(cartao ->  CartaoDto.createCartaoDto(cartao)).collect(Collectors.toList());
		ClienteDto clienteDto = new ClienteDto(cliente.getId(), cliente.getCpf(), Utils.formatarDateToString(cliente.dataInicio), listaCartaoDto , EnderecoViewModel.createEnderecoViewModel(cliente.getEndereco()));
		return clienteDto;
	}
}
