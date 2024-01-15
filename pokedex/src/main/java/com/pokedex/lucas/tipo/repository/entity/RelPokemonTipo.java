package com.pokedex.lucas.tipo.repository.entity;

import com.pokedex.lucas.pokemon.repository.entity.Pokemon;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="rel_pokemontipo")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RelPokemonTipo {

	@Id
	@SequenceGenerator(name="seq_relpokemontipo", sequenceName = "seq_relpokemontipo", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_relpokemontipo")
	private Long id;
	@ManyToOne
	@JoinColumn(name= "idPokemon")
	private Pokemon pokemon;
	@ManyToOne
	@JoinColumn(name= "idTipo")
	private Tipo tipo;
}
