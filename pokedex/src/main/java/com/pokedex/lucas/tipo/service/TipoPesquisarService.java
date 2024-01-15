package com.pokedex.lucas.tipo.service;

import com.pokedex.lucas.tipo.repository.RelTipoDanoDobradoRepository;
import com.pokedex.lucas.tipo.repository.RelTipoFracoContraRepository;
import com.pokedex.lucas.tipo.repository.RelTipoImunidadeRepository;
import com.pokedex.lucas.tipo.repository.TipoRepository;
import com.pokedex.lucas.tipo.repository.dto.RelTipoDTO;
import com.pokedex.lucas.tipo.repository.dto.TipoDTO;
import com.pokedex.lucas.tipo.service.mapper.RelTipoMapper;
import com.pokedex.lucas.tipo.service.mapper.TipoMapper;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.apache.commons.collections4.CollectionUtils;

import java.util.Collection;
import java.util.Collections;
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
	RelTipoMapper relTipoMapper;
	@Inject
	RelTipoFracoContraRepository relTipoFracoContraRepository;
	@Inject
	RelTipoImunidadeRepository relTipoImunidadeRepository;

	public List<TipoDTO> buscarTodosOsTipos(){
		var listaTipos = tipoRepository.buscarTodosOsTipos();
		return tipoMapper.paraListaDTO(listaTipos);

	}

	public RelTipoDTO buscarTiposDaDanoDobrado(Long id){
		var lista =relTipoDanoDobradoRepository.pesquisarTiposDaDanoDobradoPorId(id);
		if(CollectionUtils.isEmpty(lista))
			return new RelTipoDTO();
		return relTipoMapper.tipoDanoDobradoParaDto(lista);
	}

	public RelTipoDTO buscarTiposSofreDanoDobrado(Long id){
		var lista =relTipoDanoDobradoRepository.pesquisarTiposSofreDanoDobradoPorId(id);
		if(CollectionUtils.isEmpty(lista))
			return new RelTipoDTO();
		return relTipoMapper.tipoSofreDanoDobradoParaDto(lista);
	}

	public RelTipoDTO buscarTiposFracoContra(Long id){
		var lista = relTipoFracoContraRepository.pesquisarTiposFracoContra(id);
		if(CollectionUtils.isEmpty(lista))
			return new RelTipoDTO();
		return relTipoMapper.tipoDanoFracoContraParaDto(lista);
	}

	public RelTipoDTO buscarTiposResistente(Long id){
		var lista = relTipoFracoContraRepository.pesquisarTiposResistentes(id);
		if(CollectionUtils.isEmpty(lista))
			return new RelTipoDTO();
		return relTipoMapper.tipoResistenteParaDto(lista);
	}

	public RelTipoDTO buscarTiposImunidade(Long id){
		var lista = relTipoImunidadeRepository.pesquisarTiposImunidade(id);
		if(CollectionUtils.isEmpty(lista))
			return new RelTipoDTO();
		return relTipoMapper.tipoImunidadeDto(lista);
	}

	public RelTipoDTO buscarTiposSemDano(Long id){
		var lista = relTipoImunidadeRepository.pesquisarTiposSemDano(id);
		if(CollectionUtils.isEmpty(lista))
			return new RelTipoDTO();
		return relTipoMapper.tipoSemDanoDto(lista);
	}
}
