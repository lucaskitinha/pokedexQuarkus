package com.pokedex.lucas.pokemon.repository;

import com.pokedex.lucas.pokemon.repository.entity.Pokemon;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class PokemonRepository implements PanacheRepository<Pokemon> {

	public List<Pokemon> pesquisarTodosPokemons(){
		return findAll().list();
	}

}
