package com.pokedex.lucas.tipo.resource;

import com.pokedex.lucas.tipo.repository.dto.RelTipoDanoDobradoDTO;
import com.pokedex.lucas.tipo.repository.dto.TipoDTO;
import com.pokedex.lucas.tipo.repository.dto.TipoForm;
import com.pokedex.lucas.tipo.service.TipoInserirService;
import com.pokedex.lucas.tipo.service.TipoPesquisarService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import lombok.Getter;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

import java.util.List;

@Path("/public/tipo")
public class TipoResource {

	@Inject
	TipoInserirService tipoInserirService;
	@Inject
	TipoPesquisarService tipoPesquisarService;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public TipoDTO inserirTipo(@RequestBody TipoForm tipoDTO){
		return tipoInserirService.inserirTipo(tipoDTO);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<TipoDTO> pesquisarTodosOsTipos(){
		return tipoPesquisarService.buscarTodosOsTipos();
	}

	@Path("/danoDobrado/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public RelTipoDanoDobradoDTO pesquisarTiposDanoDobrado(@PathParam("id") Long id){
		return tipoPesquisarService.buscarTiposDanoDobrado(id);
	}
}
