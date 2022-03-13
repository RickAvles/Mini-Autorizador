package br.solutis.exemplo.cartoes.api.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer id;
	public String cpf;
	public LocalDate dataInicio;
	
	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Cartao> cartoes = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id", referencedColumnName = "id")
    private Endereco endereco;
    
    public Cliente( String cpf, LocalDate dataInicio, List<Cartao> cartoes, Endereco endereco) {
        this.cpf = cpf;
        this.dataInicio = dataInicio;
        this.cartoes = cartoes;
        this.endereco = endereco;
    }

//    public Cliente(ClienteCriacaoDto clienteRequest) {
//        this.cpf = clienteRequest.getCpf();
//        this.dataInicio = LocalDate.now();
//        this.endereco = new Endereco(clienteRequest.getEndereco());
//    }

}
