package com.pokedex.lucas.tipo.repository;

import com.pokedex.lucas.tipo.repository.entity.Tipo;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class TipoRepository implements PanacheRepository<Tipo> {

	public List<Tipo> buscarTodosOsTipos(){
		return findAll().list();
	}

	public Tipo pesquisarTipoPorNome(String nome){
		return find("nome", nome).firstResult();
	}

}
