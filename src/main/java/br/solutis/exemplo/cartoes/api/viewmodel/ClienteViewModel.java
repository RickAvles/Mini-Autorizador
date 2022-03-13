package br.solutis.exemplo.cartoes.api.viewmodel;
import br.solutis.exemplo.cartoes.api.model.Cliente;
import br.solutis.exemplo.cartoes.api.utils.Utils;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClienteViewModel {

	public String cpf;
	public String data_inicio;
	EnderecoViewModel endereco;
	
	public static ClienteViewModel createClienteViewModel(Cliente cliente) {
		ClienteViewModel clienteViewModel = new ClienteViewModel(cliente.getCpf(), Utils.formatarDateToString(cliente.dataInicio), EnderecoViewModel.createEnderecoViewModel(cliente.getEndereco()));
		return clienteViewModel;
	}
}
