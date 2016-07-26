/**
 * 
 */
package br.com.apiweb.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.apiweb.model.Cliente;
import br.com.apiweb.service.ClienteService;

/**
 * @author Silvan de Jesus
 *
 */

@RestController
@RequestMapping(value="cliente")
public class ClienteController {

	/*Map<Integer, Cliente> clientes = new HashMap<>();
	Integer proximoId = 1;
	
	private Cliente cadastrar(Cliente cliente){
				
		cliente.setId(proximoId);
		proximoId++;
		
		clientes.put(cliente.getId(), cliente);
		
		return cliente;
		
	}
	
	private Collection<Cliente> buscarTodos(){
		return clientes.values();
	}
	
	
	private Cliente buscarPorId(Integer id) {
		return clientes.get(id);
	}
	
	private void excluir(Cliente cliente) {
		clientes.remove(cliente.getId());		
	}
	
	private Cliente alterar(Cliente cliente){
		clientes.put(cliente.getId(), cliente);
		return cliente;
	}*/
	
	@Autowired
	ClienteService clienteService;
	
	@RequestMapping(method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cliente> cadastrarCliente(@RequestBody Cliente cliente){
		Cliente clienteSalvo = clienteService.salvar(cliente);
		
		return new ResponseEntity<Cliente>(clienteSalvo, HttpStatus.CREATED);
	}	
	
	@RequestMapping(method=RequestMethod.DELETE, value="/{id}")
	public ResponseEntity<Cliente> excluirCliente(@PathVariable Long id){
		Cliente cliente = clienteService.buscarPorId(id);
		
		if(cliente == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		clienteService.excluir(cliente);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Cliente>> buscar(){
		Collection<Cliente> todosClientes =  clienteService.buscarTodos();
		
		return new ResponseEntity<>(todosClientes, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cliente> editarCliente(@RequestBody Cliente cliente){
		
		Cliente clienteASerAlterado = clienteService.buscarPorId(cliente.getId());
		
		if(clienteASerAlterado == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		Cliente clienteAlterado = clienteService.salvar(cliente);
		
		return new ResponseEntity<Cliente>(clienteAlterado, HttpStatus.OK);
	}
}
