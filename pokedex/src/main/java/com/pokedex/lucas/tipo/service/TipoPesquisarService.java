package com.pokedex.lucas.tipo.service;

import com.pokedex.lucas.tipo.repository.RelTipoDanoDobradoRepository;
import com.pokedex.lucas.tipo.repository.RelTipoFracoContraRepository;
import com.pokedex.lucas.tipo.repository.TipoRepository;
import com.pokedex.lucas.tipo.repository.dto.RelTipoDanoDobradoDTO;
import com.pokedex.lucas.tipo.repository.dto.RelTipoFracoContraDTO;
import com.pokedex.lucas.tipo.repository.dto.TipoDTO;
import com.pokedex.lucas.tipo.service.mapper.RelTipoDanoDobradoMapper;
import com.pokedex.lucas.tipo.service.mapper.RelTipoFraquezaMapper;
import com.pokedex.lucas.tipo.service.mapper.TipoMapper;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class TipoPesquisarService {

	@Inject
	TipoRepository tipoRepository;
	@Inject
	RelTipoDanoDobradoRepository relTipoDanoDobradoRepository;
	@Inject
	TipoMapper tipoMapper;
	@Inject
	RelTipoDanoDobradoMapper relTipoDanoDobradoMapper;
	@Inject
	RelTipoFracoContraRepository relTipoFracoContraRepository;
	@Inject
	RelTipoFraquezaMapper relTipoFraquezaMapper;

	public List<TipoDTO> buscarTodosOsTipos(){
		var listaTipos = tipoRepository.buscarTodosOsTipos();
		return tipoMapper.paraListaDTO(listaTipos);

	}

	public RelTipoDanoDobradoDTO buscarTiposDanoDobrado(Long id){
		var lista =relTipoDanoDobradoRepository.pesquisarTiposDanoDobradoPorId(id);
		return relTipoDanoDobradoMapper.paraDto(lista);
	}

	public RelTipoFracoContraDTO buscarTiposFraqueza(Long id){
		var lista = relTipoFracoContraRepository.pesquisarTiposFraqueza(id);
		return relTipoFraquezaMapper.paraDto(lista);
	}
}
