package com.pokedex.lucas.tipo.entity;

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

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "rel_tipofraqueza")
public class RelTipoFraqueza {

	@Id
	@SequenceGenerator(name="seq_reltipofraqueza", sequenceName = "seq_reltipofraqueza", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_reltipofraqueza")
	private Long id;
	@ManyToOne
	@JoinColumn(name= "idTipo")
	private Tipo tipo;
	@ManyToOne
	@JoinColumn(name= "idTipoFraqueza")
	private Tipo tipoFraqueza;
}
