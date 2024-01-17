package com.pokedex.lucas.pokemon.service;

import com.pokedex.lucas.pokemon.repository.dto.PokemonDTO;
import com.pokedex.lucas.pokemon.repository.dto.PokemonForm;
import com.pokedex.lucas.pokemon.repository.entity.Pokemon;
import com.pokedex.lucas.tipo.repository.entity.Tipo;
import com.pokedex.lucas.tipo.service.mapper.TipoMapper;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@ApplicationScoped
public class PokemonMapper {

	@Inject
	TipoMapper tipoMapper;

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
				.geracao(pokemonForm.getGeracao())
				.build();
	}

	public PokemonDTO paraDto(Pokemon pokemon, List<Tipo> tipos){
		return PokemonDTO.builder()
				.id(pokemon.getId())
				.nome(pokemon.getNome())
				.numeroDex(pokemon.getNumeroDex())
				.habilidades(Arrays.asList(pokemon.getHabilidades().split(";")))
				.idsEvolucoes(Arrays.asList(pokemon.getIdsEvolucoes().split(";")))
				.altura(pokemon.getAltura())
				.peso(pokemon.getPeso())
				.descricao(pokemon.getDescricao())
				.categoria(pokemon.getCategoria())
				.tipos(tipoMapper.paraListaDTO(tipos))
				.geracao(pokemon.getGeracao())
				.build();
	}

	public List<PokemonDTO> paraListaDto(List<Pokemon> pokemons) {
		return pokemons.stream()
				.map(pokemon -> (this.paraDto(pokemon,new ArrayList<>())))
				.collect(Collectors.toList());
	}
}
