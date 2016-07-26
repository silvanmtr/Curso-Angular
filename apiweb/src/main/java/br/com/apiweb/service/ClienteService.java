/**
 * 
 */
package br.com.apiweb.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.apiweb.model.Cliente;
import br.com.apiweb.repository.ClienteRepository;

/**
 * @author Silvan de Jesus
 *
 */

@Service
public class ClienteService {
	
	@Autowired
	ClienteRepository clienteRepository;
	
	public Cliente salvar(Cliente cliente){		
		return clienteRepository.save(cliente);
		
	}
	
	public Collection<Cliente> buscarTodos(){
		return clienteRepository.findAll();
	}
	
	
	public Cliente buscarPorId(Long id) {
		return clienteRepository.findOne(id);
	}
	
	public void excluir(Cliente cliente) {
		clienteRepository.delete(cliente);		
	}
	
	
}
