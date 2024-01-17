package com.pokedex.lucas.pokemon.repository.dto;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@RegisterForReflection
public class PokemonForm {

	private String nome;
	private Long numeroDex;
	private List<String> habilidades;
	private List<Long> idsEvolucoes;
	private String categoria;
	private String descricao;
	private Float altura;
	private Float peso;
	private String tipo1;
	private String tipo2;
	private Long geracao;

}
