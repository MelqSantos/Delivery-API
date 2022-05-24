package com.algaworks.delivery.domain.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.groups.ConvertGroup;
import javax.validation.groups.Default;

import com.algaworks.delivery.domain.ValidationGroups;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Entrega {
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	// Relacionamento entre as entidades
	@Valid
	@ConvertGroup(from = Default.class, to = ValidationGroups.ClienteId.class)
	@NotNull
	@ManyToOne
	private Cliente cliente;
	
	// Traz os atributos de outra classe e une nessa tabela
	@Valid
	@NotNull
	@Embedded
	private Destinatario destinatario;
	
	@NotNull
	private BigDecimal taxa;
	
	// Indica que o dado é somente leitura e não poderá ser enviado no corpo da requisição
	@JsonProperty(access = Access.READ_ONLY)
	@Enumerated(EnumType.STRING)
	private StatusEntrega status;
	
	@JsonProperty(access = Access.READ_ONLY)
	private OffsetDateTime dataPedido;
	
	@JsonProperty(access = Access.READ_ONLY)
	private OffsetDateTime dataFinalizacao;
}
