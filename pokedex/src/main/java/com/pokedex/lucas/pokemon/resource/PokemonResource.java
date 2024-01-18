package com.pokedex.lucas.pokemon.resource;

import com.pokedex.lucas.pokemon.repository.dto.PokemonDTO;
import com.pokedex.lucas.pokemon.repository.dto.PokemonFiltro;
import com.pokedex.lucas.pokemon.repository.dto.PokemonForm;
import com.pokedex.lucas.pokemon.repository.dto.PokemonTabelaDTO;
import com.pokedex.lucas.pokemon.repository.entity.Pokemon;
import com.pokedex.lucas.pokemon.service.PokemonInserirService;
import com.pokedex.lucas.pokemon.service.PokemonPesquisarService;
import com.pokedex.lucas.tipo.repository.dto.TipoDTO;
import jakarta.inject.Inject;
import jakarta.ws.rs.BeanParam;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

import java.util.List;

@Path("/public/pokemon")
public class PokemonResource {
	@Inject
	PokemonInserirService pokemonInserirService;
	@Inject
	PokemonPesquisarService pokemonPesquisarService;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public PokemonDTO inserirPokemon(@RequestBody PokemonForm pokemonForm){
		return pokemonInserirService.inserirPokemon(pokemonForm);
	}

	@Path("/todos")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<PokemonDTO> pesquisarTodosOsPokemons(){
		return pokemonPesquisarService.pesquisarTodosPokemons();
	}

	@Path("/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public PokemonDTO pesquisarPokemonPorId(@PathParam("id") Long id){
		return pokemonPesquisarService.pesquisarPokemonPorId(id);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<PokemonTabelaDTO> pesquisarPokemonsPorFiltro(@BeanParam PokemonFiltro filtro){
		return pokemonPesquisarService.pesquisarPokemonsPorFiltros(filtro);
	}
}
