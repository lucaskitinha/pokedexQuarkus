package com.pokedex.lucas.pokemon.service;

import com.pokedex.lucas.pokemon.repository.dto.PokemonForm;
import com.pokedex.lucas.pokemon.repository.entity.Pokemon;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.Objects;
import java.util.stream.Collectors;

@ApplicationScoped
public class PokemonMapper {

	public Pokemon paraEntidade(PokemonForm pokemonForm){
		return Pokemon.builder()
				.nome(pokemonForm.getNome())
				.habilidades(String.join(";", pokemonForm.getHabilidades()))
				.idsEvolucoes(pokemonForm.getIdsEvolucoes().stream().map(Objects::toString).collect(Collectors.joining(";")))
				.categoria(pokemonForm.getCategoria())
				.altura(pokemonForm.getAltura())
				.peso(pokemonForm.getPeso())
				.descricao(pokemonForm.getDescricao())
				.numeroDex(pokemonForm.getNumeroDex())
				.build();
	}
}
