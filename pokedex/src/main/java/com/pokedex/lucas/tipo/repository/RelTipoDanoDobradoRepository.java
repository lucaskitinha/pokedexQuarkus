package com.pokedex.lucas.tipo.repository;

import com.pokedex.lucas.tipo.repository.entity.RelTipoDanoDobrado;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class RelTipoDanoDobradoRepository implements PanacheRepository<RelTipoDanoDobrado> {

	public List<RelTipoDanoDobrado> pesquisarTiposDanoDobradoPorId(Long id){
		return find("tipo.id in ?1", id).list();
	}
}
