package com.pokedex.lucas.pokemon.service;

import com.pokedex.lucas.pokemon.repository.dto.PokemonForm;
import com.pokedex.lucas.pokemon.repository.entity.Pokemon;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PokemonMapper {

	public Pokemon paraEntidade(PokemonForm pokemonForm){
		return Pokemon.builder()
				.nome(pokemonForm.getNome())
				.apelido(pokemonForm.getApelido())
				.altura(pokemonForm.getAltura())
				.peso(pokemonForm.getPeso())
				.descricao(pokemonForm.getDescricao())
				.numeroDex(pokemonForm.getNumeroDex())
				.build();
	}
}
