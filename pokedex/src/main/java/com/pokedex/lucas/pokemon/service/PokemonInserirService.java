package com.pokedex.lucas.pokemon.service;

import com.pokedex.lucas.pokemon.repository.PokemonRepository;
import com.pokedex.lucas.pokemon.repository.dto.PokemonDTO;
import com.pokedex.lucas.pokemon.repository.dto.PokemonForm;
import com.pokedex.lucas.pokemon.repository.entity.Pokemon;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class PokemonInserirService {

	@Inject
	PokemonRepository pokemonRepository;
	@Inject
	PokemonMapper pokemonMapper;

	public Pokemon inserirPokemon(PokemonForm pokemonForm){

		Pokemon pokemon = pokemonMapper.paraEntidade(pokemonForm);
		pokemonRepository.persist(pokemon);

		return pokemon;
	}
}
