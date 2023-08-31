package com.pokedex.lucas.pokemon.service;

import com.pokedex.lucas.pokemon.repository.PokemonRepository;
import com.pokedex.lucas.pokemon.repository.dto.PokemonDTO;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class PokemonPesquisarService {

	@Inject
	PokemonRepository pokemonRepository;

	public List<PokemonDTO> pesquisarTodosPokemons(){
		var listaPokemon = pokemonRepository.pesquisarTodosPokemons();
		return new ArrayList<>();
	}
}
