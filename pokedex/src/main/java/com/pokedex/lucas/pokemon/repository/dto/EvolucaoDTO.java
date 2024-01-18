package com.pokedex.lucas.pokemon.repository.dto;

import com.pokedex.lucas.tipo.repository.dto.TipoDTO;
import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@RegisterForReflection
@Data
@Builder
public class EvolucaoDTO {

	private Long id;
	private String nome;
	private Long numeroDex;
	private List<TipoDTO> tipos;
}
