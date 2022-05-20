package com.algaworks.delivery.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.delivery.domain.exception.NegocioException;
import com.algaworks.delivery.domain.model.Cliente;
import com.algaworks.delivery.domain.repository.ClienteRepository;

@Service
public class CatalogoClientesService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	// Declara que o método deve ser executado dentro de uma transação
	@Transactional
	public Cliente salvar(Cliente cliente) {
		// Validação se existe um usuário com o mesmo email
		boolean emailEmUso = clienteRepository.findByEmail(cliente.getEmail())
				.stream()
				.anyMatch(clienteExistente -> !clienteExistente.equals(cliente));
		
		if(emailEmUso) {
			throw new NegocioException("Já existe um cliente com este email.");
		}
		
		return clienteRepository.save(cliente);
	}
	
	public void excluir(Long id) {
		clienteRepository.deleteById(id);
	}
	
	

}
