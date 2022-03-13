package br.solutis.exemplo.cartoes.api.viewmodel;

import br.solutis.exemplo.cartoes.api.model.Endereco;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoViewModel {
    private String logradouro;
    private String cidade;
    private String estado;
    private String complemento;
    
	public static EnderecoViewModel createEnderecoViewModel(Endereco endereco) {
		if(endereco == null) {
			return null;
		} 
		EnderecoViewModel enderecoViewModel = new EnderecoViewModel(endereco.getLogradouro(), endereco.getCidade(), endereco.getEstado(), endereco.getComplemento());
    	return enderecoViewModel;
    }
}
