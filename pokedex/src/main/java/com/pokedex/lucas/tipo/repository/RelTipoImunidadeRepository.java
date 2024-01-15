package com.pokedex.lucas.tipo.repository;

import com.pokedex.lucas.tipo.repository.entity.RelTipoImunidade;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class RelTipoImunidadeRepository implements PanacheRepository<RelTipoImunidade> {

	public List<RelTipoImunidade> pesquisarTiposImunidade(Long id){
		return find("tipo.id in ?1", id).list();
	}

	public List<RelTipoImunidade> pesquisarTiposSemDano(Long id){
		return find("tipoImunidade.id in ?1", id).list();
	}
}
