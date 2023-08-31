package com.pokedex.lucas.tipo.service.mapper;

import com.pokedex.lucas.tipo.repository.dto.RelTipoFracoContraDTO;
import com.pokedex.lucas.tipo.repository.entity.RelTipoFracoContra;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class RelTipoFraquezaMapper {

	@Inject
	TipoMapper tipoMapper;

	public RelTipoFracoContraDTO paraDto(List<RelTipoFracoContra> lista) {
		return RelTipoFracoContraDTO.builder()
				.id(lista.get(0).getTipo().getId())
				.tipo(lista.get(0).getTipo().getNome())
				.tipoFracoContra(lista.stream()
						.map(relTipoDanoDobrado -> tipoMapper.paraDTO(relTipoDanoDobrado.getTipoFraqueza()))
						.collect(Collectors.toList()))
				.build();
	}
}
