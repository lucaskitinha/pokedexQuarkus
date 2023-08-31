package com.pokedex.lucas.tipo.repository;

import com.pokedex.lucas.tipo.repository.entity.RelTipoFracoContra;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class RelTipoFracoContraRepository implements PanacheRepository<RelTipoFracoContra> {

	public List<RelTipoFracoContra> pesquisarTiposFraqueza(Long id){
		return find("tipo.id in ?1", id).list();
	}
}
