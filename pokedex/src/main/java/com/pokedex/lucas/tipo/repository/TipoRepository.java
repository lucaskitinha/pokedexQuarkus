package com.pokedex.lucas.tipo.repository;

import com.pokedex.lucas.tipo.repository.entity.Tipo;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ApplicationScoped
public class TipoRepository implements PanacheRepository<Tipo> {

	public List<Tipo> buscarTodosOsTipos(){
		return findAll().list();
	}

	public Tipo pesquisarTipoPorNome(String nome){
		return find("nome", nome).firstResult();
	}

	public List<Tipo> pesquisarTiposPorIdPokemon(Long idPokemon){
		Map<String, Object> params = new HashMap<>();

		StringBuilder hql = new StringBuilder();
		hql.append("select a from RelPokemonTipo rel ");
		hql.append("left join rel.tipo a ");

		hql.append("where rel.pokemon.id = :idPokemon ");
		params.put("idPokemon", idPokemon);


		return find(hql.toString(), params).list();
	}

}
