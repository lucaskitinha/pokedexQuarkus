package com.pokedex.lucas.tipo.repository.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@RegisterForReflection
public class TipoDTO {

	private Long id;
	@JsonProperty("nome")
	private String nome;
}
