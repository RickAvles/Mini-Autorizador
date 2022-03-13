package br.solutis.exemplo.cartoes.api.dto;

import br.solutis.exemplo.cartoes.api.model.Endereco;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoDto {
    private Integer id;
    private String logradouro;
    private String cidade;
    private String estado;
    private String complemento;
    
	public static EnderecoDto createEnderecoDto(Endereco endereco) {
		EnderecoDto enderecoDto = new EnderecoDto(endereco.getId(), endereco.getLogradouro(), endereco.getCidade(), endereco.getEstado(), endereco.getComplemento());
    	return enderecoDto;
    }
}
