package com.pokedex.lucas.pokemon.repository.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Pokemon {

	@Id
	@SequenceGenerator(name = "seq_pokemon", sequenceName = "seq_pokemon", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_pokemon")
	private Long id;
	private String nome;
	private Long numeroDex;
	private String habilidades;
	private String idsEvolucoes;
	private String categoria;
	private String descricao;
	private Float altura;
	private Float peso;
}
