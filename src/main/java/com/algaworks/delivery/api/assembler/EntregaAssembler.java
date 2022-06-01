package com.algaworks.delivery.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.algaworks.delivery.api.model.EntregaModel;
import com.algaworks.delivery.domain.model.Entrega;

import lombok.AllArgsConstructor;

// Classe responsável por converter objetos de um tipo para outro (Entity x DTO e vice-versa)
@AllArgsConstructor
@Component
public class EntregaAssembler {
	
	private ModelMapper modelMapper;
	
	// converte o objeto Entity para DTO
	public EntregaModel toModel (Entrega entrega) {
		
		return modelMapper.map(entrega, EntregaModel.class);
	}
	
	public List<EntregaModel> toCollectionModel(List<Entrega> entregas){
		return entregas.stream()
				.map(this::toModel)
				.collect(Collectors.toList());
	}
}
