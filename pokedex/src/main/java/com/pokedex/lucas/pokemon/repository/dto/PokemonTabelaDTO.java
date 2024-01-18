package com.pokedex.lucas.pokemon.repository.dto;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@RegisterForReflection
@Getter
@Setter
public class PokemonTabelaDTO {
	private Long id;
	private String nome;
	private Long numeroDex;
	private List<String> tipos;

}
