package com.api.e_commerce.core.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.e_commerce.core.models.Produto;
import com.api.e_commerce.core.repositories.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	ProdutoRepository repository;

	public List<Produto> buscarProdutos() {
		return repository.findAll();
	}

	public Produto buscarId(Long id) {
		return repository.findById(id).orElse(null);
	}

	public void deletarProduto(Long id) {
		repository.deleteById(id);
	}

	public Produto salvarProduto (Produto produto) {
	   return repository.save(produto);	
	}
	public Produto atualizarProduto (Produto produto, Long id) {
		Optional<Produto> produtoOpt = repository.findById(id);
		
		return repository.save(produto);
	} 

}
