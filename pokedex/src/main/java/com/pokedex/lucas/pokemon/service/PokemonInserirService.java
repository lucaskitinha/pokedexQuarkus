package com.pokedex.lucas.pokemon.service;

import com.pokedex.lucas.pokemon.repository.PokemonRepository;
import com.pokedex.lucas.pokemon.repository.dto.PokemonForm;
import com.pokedex.lucas.pokemon.repository.entity.Pokemon;
import com.pokedex.lucas.tipo.repository.RelPokemonTipoRepository;
import com.pokedex.lucas.tipo.repository.TipoRepository;
import com.pokedex.lucas.tipo.repository.entity.RelPokemonTipo;
import com.pokedex.lucas.tipo.repository.entity.Tipo;
import io.smallrye.openapi.runtime.util.StringUtil;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class PokemonInserirService {

	@Inject
	PokemonRepository pokemonRepository;
	@Inject
	PokemonMapper pokemonMapper;
	@Inject
	RelPokemonTipoRepository relPokemonTipoRepository;
	@Inject
	TipoRepository tipoRepository;

	@Transactional
	public Pokemon inserirPokemon(PokemonForm pokemonForm){

		Pokemon pokemon = pokemonMapper.paraEntidade(pokemonForm);
		pokemonRepository.persist(pokemon);
		var tipos = inserirRelacionamento(pokemonForm.getTipo1(),pokemonForm.getTipo2(),pokemon);

		return pokemon;
	}

	private List<Tipo> inserirRelacionamento(String tipo1, String tipo2, Pokemon pokemon){
		var tipoUm = tipoRepository.pesquisarTipoPorNome(tipo1);
		RelPokemonTipo relTipo1Pokemon = new RelPokemonTipo();
		relTipo1Pokemon.setPokemon(pokemon);
		relTipo1Pokemon.setTipo(tipoUm);
		relPokemonTipoRepository.persist(relTipo1Pokemon);
		List<Tipo> tipos = new ArrayList<>();
		tipos.add(tipoUm);

		if(StringUtil.isNotEmpty(tipo2)){
			var tipoDois = tipoRepository.pesquisarTipoPorNome(tipo2);
			RelPokemonTipo relTipo2Pokemon = new RelPokemonTipo();
			relTipo2Pokemon.setPokemon(pokemon);
			relTipo2Pokemon.setTipo(tipoDois);
			relPokemonTipoRepository.persist(relTipo2Pokemon);
			tipos.add(tipoDois);
		}
		return tipos;
	}
}
