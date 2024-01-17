package com.pokedex.lucas.tipo.repository;

import com.pokedex.lucas.tipo.repository.entity.RelPokemonTipo;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class RelPokemonTipoRepository implements PanacheRepository<RelPokemonTipo> {


}
