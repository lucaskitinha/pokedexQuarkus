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
@Table(name = "rel_tiposemdano")
public class RelTipoSemDano {

	@Id
	@SequenceGenerator(name="seq_reltiposemdano", sequenceName = "seq_reltiposemdano", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_reltiposemdano")
	private Long id;
	@ManyToOne
	@JoinColumn(name= "idTipo")
	private Tipo tipo;
	@ManyToOne
	@JoinColumn(name= "idTipoSemDano")
	private Tipo tipoSemDano;
}
