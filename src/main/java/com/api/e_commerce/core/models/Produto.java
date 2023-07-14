package com.api.e_commerce.core.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Table(name = "PRODUTO")
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "produto_sequence")
	@SequenceGenerator(allocationSize = 1, name = "produto_sequence", sequenceName = "produto_sequence")
	@Column(columnDefinition = "integer")
	@Getter @Setter
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "categoria_id")
	@JsonBackReference
	@Getter @Setter
	private Categoria categoria;
	
	@Getter @Setter
	private String nome;
	
	@Getter @Setter
	private float valor;
	
	@Getter @Setter
	private Long codigoBarras;
		
}
