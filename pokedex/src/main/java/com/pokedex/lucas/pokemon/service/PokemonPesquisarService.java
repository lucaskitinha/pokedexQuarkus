package com.pokedex.lucas.pokemon.service;

import com.pokedex.lucas.pokemon.repository.PokemonRepository;
import com.pokedex.lucas.pokemon.repository.dto.PokemonDTO;
import com.pokedex.lucas.tipo.repository.TipoRepository;
import com.pokedex.lucas.tipo.repository.dto.TipoDTO;
import com.pokedex.lucas.tipo.service.mapper.TipoMapper;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class PokemonPesquisarService {

	@Inject
	PokemonRepository pokemonRepository;
	@Inject
	PokemonMapper pokemonMapper;
	@Inject
	TipoRepository tipoRepository;
	@Inject
	TipoMapper tipoMapper;

	public List<PokemonDTO> pesquisarTodosPokemons(){
		var listaPokemon = pokemonMapper.paraListaDto(pokemonRepository.pesquisarTodosPokemons());

		listaPokemon.forEach(pokemonDTO -> {
			List<TipoDTO> tipos = tipoMapper.paraListaDTO(tipoRepository.pesquisarTiposPorIdPokemon(pokemonDTO.getId()));
			pokemonDTO.setTipos(tipos);
		});
		return listaPokemon;
	}
}
