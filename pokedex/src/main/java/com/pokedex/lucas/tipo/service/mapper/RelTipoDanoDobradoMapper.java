package com.pokedex.lucas.tipo.service.mapper;

import com.pokedex.lucas.tipo.repository.dto.RelTipoDanoDobradoDTO;
import com.pokedex.lucas.tipo.repository.entity.RelTipoDanoDobrado;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class RelTipoDanoDobradoMapper {
	@Inject
	TipoMapper tipoMapper;

	public RelTipoDanoDobradoDTO paraDto(List<RelTipoDanoDobrado> lista) {
		return RelTipoDanoDobradoDTO.builder()
				.id(lista.get(0).getTipo().getId())
				.tipo(lista.get(0).getTipo().getNome())
				.tipoDanoDobrado(lista.stream()
						.map(relTipoDanoDobrado -> tipoMapper.paraDTO(relTipoDanoDobrado.getTipoDanoDobrado()))
						.collect(Collectors.toList()))
				.build();
	}
}
