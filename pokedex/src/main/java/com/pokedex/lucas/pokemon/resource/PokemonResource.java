package com.pokedex.lucas.pokemon.resource;

import com.pokedex.lucas.pokemon.repository.dto.PokemonDTO;
import com.pokedex.lucas.pokemon.repository.dto.PokemonForm;
import com.pokedex.lucas.pokemon.repository.entity.Pokemon;
import com.pokedex.lucas.pokemon.service.PokemonInserirService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

import java.awt.*;

@Path("/public/pokemon")
public class PokemonResource {
	@Inject
	PokemonInserirService pokemonInserirService;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Pokemon inserirPokemon(@RequestBody PokemonForm pokemonForm){
		return pokemonInserirService.inserirPokemon(pokemonForm);
	}
}
