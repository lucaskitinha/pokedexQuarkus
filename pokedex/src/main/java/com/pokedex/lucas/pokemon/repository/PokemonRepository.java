package com.pokedex.lucas.pokemon.repository;

import com.pokedex.lucas.pokemon.repository.dto.PokemonFiltro;
import com.pokedex.lucas.pokemon.repository.dto.PokemonTabelaDTO;
import com.pokedex.lucas.pokemon.repository.entity.Pokemon;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.Query;
import org.apache.commons.lang3.StringUtils;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ApplicationScoped
public class PokemonRepository implements PanacheRepository<Pokemon> {

	public List<Pokemon> pesquisarTodosPokemons(){
		return findAll().list();
	}

	public List<PokemonTabelaDTO> pesquisarPokemonPorFiltro(PokemonFiltro filtro){
		Map<String, Object> params = new HashMap<>();

		StringBuilder hql = new StringBuilder();
		hql.append("select p.id, p.nome, p.numeroDex, ");
		hql.append("(select string_agg(t.nome, ', ') from tipo t left join rel_pokemontipo rel on rel.idtipo = t.id where rel.idpokemon = p.id) ");
		hql.append("from pokemon p ");
		hql.append("where 1=1 ");

		if(StringUtils.isNotBlank(filtro.getNome())){
			hql.append("and p.nome like :nome");
			params.put("nome", filtro.getNome());
		}

		hql.append("GROUP BY p.id, p.nome ");
		hql.append("order by p.id");

		Query query = getEntityManager().createNativeQuery(hql.toString());

		params.forEach((key, value)->{
			if(key.equals("nome"))
				query.setParameter("nome",value);
		});

		return mapToDTO(query.getResultList());
	}

	private List<PokemonTabelaDTO> mapToDTO(List<Object[]> resultList) {
		List<PokemonTabelaDTO> listaPokemons = new ArrayList<>();

		for (Object[] objeto: resultList) {
			var dto = new PokemonTabelaDTO();

			Long id = (Long) objeto[0];
			dto.setId(id);
			dto.setNome((String) objeto[1]);
			dto.setNumeroDex((Long) objeto[2]);
			var tipos = (String) objeto[3];
			dto.setTipos(Arrays.asList(tipos.split(",")));

			listaPokemons.add(dto);
		}

		return listaPokemons;
	}

}
