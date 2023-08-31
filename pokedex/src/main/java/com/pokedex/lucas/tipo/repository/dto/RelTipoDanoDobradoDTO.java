package com.pokedex.lucas.tipo.repository.dto;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@RegisterForReflection
public class RelTipoDanoDobradoDTO {

	private Long id;
	private String tipo;
	private List<TipoDTO> tipoDanoDobrado;
}
