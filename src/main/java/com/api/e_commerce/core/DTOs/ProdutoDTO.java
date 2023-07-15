package com.api.e_commerce.core.DTOs;

import com.api.e_commerce.core.interfaces.ConvertEntity;
import com.api.e_commerce.core.models.Categoria;
import com.api.e_commerce.core.models.Produto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ProdutoDTO implements ConvertEntity<Produto> {
	
	@NotEmpty
	public CategoriaDTO categoria;
	
	@NotBlank
	public String nome;

	@NotEmpty
	public float valor;
	
	@NotBlank
	public Long codigoBarras;

	@NoArgsConstructor
	public static class CategoriaDTO  {

		public Long id;

		public String nome;
		
	}

//	public ProdutoDTO (Produto produto) {
//		
//		this.nome = produto.getNome();
//		this.valor = produto.getValor();
//		this.codigoBarras = produto.getCodigoBarras();
//		
//	}

	@Override
	public Produto convert() {
		Produto produto = new Produto();
		
		produto.setNome(nome);
		produto.setValor(valor);
		produto.setCodigoBarras(codigoBarras);
		
		Categoria categoria = new Categoria();
		categoria.setId(this.categoria.id);
		
		produto.setCategoria(categoria);
		
		return produto;
	}
}
