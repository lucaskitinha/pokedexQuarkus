package com.pokedex.lucas.tipo.service;

import com.pokedex.lucas.tipo.repository.TipoRepository;
import com.pokedex.lucas.tipo.repository.dto.TipoDTO;
import com.pokedex.lucas.tipo.repository.dto.TipoForm;
import com.pokedex.lucas.tipo.service.mapper.TipoMapper;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class TipoInserirService {

	@Inject
	TipoRepository tipoRepository;

	@Inject
	TipoMapper tipoMapper;

	@Transactional
	public TipoDTO inserirTipo(TipoForm tipoDTO){

		var tipo = tipoMapper.paraEntidade(tipoDTO);

		tipoRepository.persist(tipo);

		return tipoMapper.paraDTO(tipo);

	}
}
