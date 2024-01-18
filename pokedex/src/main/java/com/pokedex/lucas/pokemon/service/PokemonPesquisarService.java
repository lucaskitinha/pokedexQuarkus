package com.pokedex.lucas.pokemon.service;

import com.pokedex.lucas.pokemon.repository.PokemonRepository;
import com.pokedex.lucas.pokemon.repository.dto.EvolucaoDTO;
import com.pokedex.lucas.pokemon.repository.dto.PokemonDTO;
import com.pokedex.lucas.pokemon.repository.dto.PokemonFiltro;
import com.pokedex.lucas.pokemon.repository.dto.PokemonTabelaDTO;
import com.pokedex.lucas.tipo.repository.TipoRepository;
import com.pokedex.lucas.tipo.repository.dto.TipoDTO;
import com.pokedex.lucas.tipo.service.mapper.TipoMapper;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.ArrayList;
import java.util.List;

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

	public PokemonDTO pesquisarPokemonPorId(Long idPokemon){
		var pokemonDTO = pokemonMapper.paraDto(pokemonRepository.pesquisarPokemonPorId(idPokemon), new ArrayList<>());
		List<TipoDTO> tipos = tipoMapper.paraListaDTO(tipoRepository.pesquisarTiposPorIdPokemon(idPokemon));
		pokemonDTO.setTipos(tipos);

		List<EvolucaoDTO> evolucoes = new ArrayList<>();
		pokemonDTO.getIdsEvolucoes().forEach(idEvolucao -> {
			var evolucaoDTO = pokemonMapper.paraEvolucaoDto(pokemonRepository.pesquisarPokemonPorId(Long.valueOf(idEvolucao)));
			List<TipoDTO> tipoEvolucao = tipoMapper.paraListaDTO(tipoRepository.pesquisarTiposPorIdPokemon(Long.valueOf(idEvolucao)));
			evolucaoDTO.setTipos(tipoEvolucao);
			evolucoes.add(evolucaoDTO);
		});
		pokemonDTO.setEvolucoes(evolucoes);

		return pokemonDTO;
	}

	public List<PokemonTabelaDTO> pesquisarPokemonsPorFiltros(PokemonFiltro filtro){
		return pokemonRepository.pesquisarPokemonPorFiltro(filtro);
	}
}
