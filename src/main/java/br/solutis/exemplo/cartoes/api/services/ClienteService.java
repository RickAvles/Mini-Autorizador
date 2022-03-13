package br.solutis.exemplo.cartoes.api.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.solutis.exemplo.cartoes.api.dto.ClienteDto;
import br.solutis.exemplo.cartoes.api.dto.EnderecoDto;
import br.solutis.exemplo.cartoes.api.model.Cartao;
import br.solutis.exemplo.cartoes.api.model.Cliente;
import br.solutis.exemplo.cartoes.api.model.Endereco;
import br.solutis.exemplo.cartoes.api.repositories.ClienteRepository;
import br.solutis.exemplo.cartoes.api.viewmodel.ClienteViewModel;

@Service
public class ClienteService {
	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private ExceptionHandler exceptionHandle;

	public Cliente gerarCliente(ClienteViewModel clienteViewModel) {
		return new Cliente(clienteViewModel.getCpf(), LocalDate.now(), new ArrayList<Cartao>(), new Endereco(clienteViewModel.getEndereco()));
	}

	public ClienteViewModel obterCliente(Integer idCliente) {

		Cliente cliente = clienteRepository.findById(idCliente).get();
		
		return ClienteViewModel.createClienteViewModel(cliente);
	}
	
	public ClienteDto criarNoBanco(ClienteViewModel clienteViewModel) {
		Cliente cliente = this.gerarCliente(clienteViewModel);
		cliente = clienteRepository.save(cliente);
		
		return ClienteDto.createClienteDto(cliente);
	}
	
	public EnderecoDto obterEnderecoCliente(Integer id){
		Cliente cliente = clienteRepository.getById(id);

		return EnderecoDto.createEnderecoDto(cliente.getEndereco());  
	}
}
