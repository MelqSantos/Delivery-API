package com.algaworks.delivery.domain.service;

import java.time.OffsetDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.delivery.domain.model.Cliente;
import com.algaworks.delivery.domain.model.Entrega;
import com.algaworks.delivery.domain.model.StatusEntrega;
import com.algaworks.delivery.domain.repository.EntregaRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class SolicitacaoEntregaService {
	
	private CatalogoClientesService catalogoClientesService;
	private EntregaRepository entregaRepository;
	
	@Transactional
	public Entrega solicitar(Entrega entrega) {
		Cliente cliente = catalogoClientesService.buscar(entrega.getCliente().getId());
		
		entrega.setCliente(cliente);
		entrega.setStatus(StatusEntrega.PENDENTE);
		entrega.setDataPedido(OffsetDateTime.now());
		
		
		return entregaRepository.save(entrega);
	}
}
