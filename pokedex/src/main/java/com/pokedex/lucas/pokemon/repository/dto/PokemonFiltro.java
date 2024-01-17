package com.pokedex.lucas.pokemon.repository.dto;

import io.quarkus.runtime.annotations.RegisterForReflection;
import jakarta.ws.rs.QueryParam;
import lombok.Data;

@Data
@RegisterForReflection
public class PokemonFiltro {

	@QueryParam("nome")
	private String nome;
	@QueryParam("tipo")
	private String tipo;
	@QueryParam("geracao")
	private Long geracao;
}
