package br.solutis.exemplo.cartoes.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.solutis.exemplo.cartoes.api.services.ClienteService;
import br.solutis.exemplo.cartoes.api.viewmodel.ClienteViewModel;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@PostMapping
    public ResponseEntity<Object> criar(@RequestBody ClienteViewModel clienteViewModel){

        try {
            return new ResponseEntity<Object>(clienteService.criarNoBanco(clienteViewModel), HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<Object>(clienteViewModel, HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> obterClientePorId(@PathVariable("id") Integer id){
		try{
			return new ResponseEntity<Object>(clienteService.obterCliente(id), HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/{id}/endereco")
	public ResponseEntity<Object> obterEnderecoClientePorId(@PathVariable("id") Integer id){
		try {
			return new ResponseEntity<Object>(clienteService.obterEnderecoCliente(id), HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
		}
	}
}
 