package com.algaworks.delivery.api.exceptionhandler;

import java.time.OffsetDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(Include.NON_NULL)
@Getter
@Setter
public class Problema {
	
	private int status;
	private OffsetDateTime datahora;
	private String titulo;
	private List<Campo> campos;
	
	// Classe interna
	@AllArgsConstructor
	@Getter
	public static class Campo{
		private String nome;
		private String mensagem;
	}
}
