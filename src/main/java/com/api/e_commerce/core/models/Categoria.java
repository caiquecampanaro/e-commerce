package com.api.e_commerce.core.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Table(name = "CATEGORIA")
public class Categoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "categoria_sequence")
	@SequenceGenerator(allocationSize = 1, name = "categoria_sequence", sequenceName = "categoria_sequence")
	@Column(columnDefinition = "integer")
	@Getter @Setter
	private Long id;
	
	@Getter @Setter
	@NonNull
	private String nome;
		
	@OneToMany(cascade = CascadeType.MERGE, mappedBy = "categoria")
	@Getter @Setter
	@JsonBackReference
	private List<Produto> produtos;

}
