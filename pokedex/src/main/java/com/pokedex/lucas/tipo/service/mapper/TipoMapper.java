package com.pokedex.lucas.tipo.service.mapper;

import com.pokedex.lucas.tipo.repository.dto.TipoDTO;
import com.pokedex.lucas.tipo.repository.dto.TipoForm;
import com.pokedex.lucas.tipo.repository.entity.Tipo;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class TipoMapper {

	public TipoDTO paraDTO(Tipo tipo){
		return TipoDTO.builder()
				.id(tipo.getId())
				.nome(tipo.getNome())
				.build();
	}

	public Tipo paraEntidade(TipoForm tipoDTO){
		return Tipo.builder()
				.id(tipoDTO.getId())
				.nome(tipoDTO.getNome())
				.build();
	}

	public List<TipoDTO> paraListaDTO(List<Tipo> listaTipos){
		return listaTipos.stream()
				.map(tipo -> (this.paraDTO(tipo)))
				.collect(Collectors.toList());
	}
}
