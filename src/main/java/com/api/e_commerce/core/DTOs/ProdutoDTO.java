package com.api.e_commerce.core.DTOs;

import com.api.e_commerce.core.interfaces.ConvertEntity;
import com.api.e_commerce.core.models.Produto;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ProdutoDTO implements ConvertEntity<Produto> {

	public Long id;

//	public CategoriaDTO categoria;

	public String nome;

	public Float valor;

	public Long codigoBarras;

//	public static class CatergoriaDTO()
//	{
//		public Long id;
//
//	}

//	public ProdutoDTO (Produto produto) {
//		
//		this.id = produto.getId();
//		this.nome = produto.getNome();
//		this.valor = produto.getValor();
//		this.codigoBarras = produto.getCodigoBarras();
//		
//	}

	@Override
	public Produto convert() {
		Produto produto = new Produto();
//		produto.setId(id);
		produto.setNome(nome);
		produto.setValor(valor);
		produto.setCodigoBarras(codigoBarras);
		
		return null;
	}
}
