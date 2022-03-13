package br.solutis.exemplo.cartoes.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import br.solutis.exemplo.cartoes.api.viewmodel.EnderecoViewModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Endereco {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String logradouro;
	private String cidade;
	private String estado;
	private String complemento;
	
	@OneToOne(mappedBy = "endereco")
	private Cliente cliente;

	public Endereco(EnderecoViewModel enderecoViewModel) {
		this.logradouro = enderecoViewModel.getLogradouro();
		this.cidade = enderecoViewModel.getCidade();
		this.estado = enderecoViewModel.getEstado();
		this.complemento = enderecoViewModel.getComplemento();
	}
}
