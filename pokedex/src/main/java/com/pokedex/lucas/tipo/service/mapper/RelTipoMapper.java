package com.pokedex.lucas.tipo.service.mapper;

import com.pokedex.lucas.tipo.repository.dto.RelTipoDTO;
import com.pokedex.lucas.tipo.repository.entity.RelTipoDanoDobrado;
import com.pokedex.lucas.tipo.repository.entity.RelTipoFracoContra;
import com.pokedex.lucas.tipo.repository.entity.RelTipoImunidade;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class RelTipoMapper {
	@Inject
	TipoMapper tipoMapper;

	public RelTipoDTO tipoDanoDobradoParaDto(List<RelTipoDanoDobrado> lista) {
		return RelTipoDTO.builder()
				.id(lista.get(0).getTipo().getId())
				.tipo(lista.get(0).getTipo().getNome())
				.tipoRel(lista.stream()
						.map(relTipoDanoDobrado -> tipoMapper.paraDTO(relTipoDanoDobrado.getTipoDanoDobrado()))
						.collect(Collectors.toList()))
				.build();
	}

	public RelTipoDTO tipoSofreDanoDobradoParaDto(List<RelTipoDanoDobrado> lista) {
		return RelTipoDTO.builder()
				.id(lista.get(0).getTipoDanoDobrado()
						.getId())
				.tipo(lista.get(0).getTipoDanoDobrado().getNome())
				.tipoRel(lista.stream()
						.map(relTipoDanoDobrado -> tipoMapper.paraDTO(relTipoDanoDobrado.getTipo()))
						.collect(Collectors.toList()))
				.build();
	}

	public RelTipoDTO tipoDanoFracoContraParaDto(List<RelTipoFracoContra> lista) {
		return RelTipoDTO.builder()
				.id(lista.get(0).getTipo().getId())
				.tipo(lista.get(0).getTipo().getNome())
				.tipoRel(lista.stream()
						.map(relTipoDanoFracoContra -> tipoMapper.paraDTO(relTipoDanoFracoContra.getTipoFraqueza()))
						.collect(Collectors.toList()))
				.build();
	}

	public RelTipoDTO tipoResistenteParaDto(List<RelTipoFracoContra> lista) {
		return RelTipoDTO.builder()
				.id(lista.get(0).getTipoFraqueza().getId())
				.tipo(lista.get(0).getTipoFraqueza().getNome())
				.tipoRel(lista.stream()
						.map(relTipoDanoFracoContra -> tipoMapper.paraDTO(relTipoDanoFracoContra.getTipo()))
						.collect(Collectors.toList()))
				.build();
	}

	public RelTipoDTO tipoImunidadeDto(List<RelTipoImunidade> lista) {
		return RelTipoDTO.builder()
				.id(lista.get(0).getTipo().getId())
				.tipo(lista.get(0).getTipo().getNome())
				.tipoRel(lista.stream()
						.map(relTipoImunidade -> tipoMapper.paraDTO(relTipoImunidade.getTipoImunidade()))
						.collect(Collectors.toList()))
				.build();
	}

	public RelTipoDTO tipoSemDanoDto(List<RelTipoImunidade> lista) {
		return RelTipoDTO.builder()
				.id(lista.get(0).getTipoImunidade().getId())
				.tipo(lista.get(0).getTipoImunidade().getNome())
				.tipoRel(lista.stream()
						.map(relTipoImunidade -> tipoMapper.paraDTO(relTipoImunidade.getTipo()))
						.collect(Collectors.toList()))
				.build();
	}
}
