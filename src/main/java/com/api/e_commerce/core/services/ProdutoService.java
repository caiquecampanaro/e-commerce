package com.api.e_commerce.core.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.api.e_commerce.core.BusinessException;
import com.api.e_commerce.core.models.Produto;
import com.api.e_commerce.core.repositories.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	ProdutoRepository repository;

	public List<Produto> buscarProdutos() {
		return repository.findAll();
	}

	public Optional<Produto> buscarId(Long id) {
		Optional<Produto>  produtoOpt = repository.findById(id);
		if (produtoOpt.isEmpty()){
			throw new BusinessException("Produto não encontrado", HttpStatus.BAD_REQUEST);
		}
		return produtoOpt;
	}

	public void deletarProduto(Long id) {
		repository.deleteById(id);
	}

	public Produto salvarProduto (Produto produto) {
	   return repository.save(produto);	
	}
	public Produto atualizarProduto (Produto produto, Long id) {
		Optional<Produto> produtoOpt = repository.findById(id);
		if (produtoOpt.isEmpty()) {
			throw new BusinessException("Produto não encontrado", HttpStatus.BAD_REQUEST);
		}
		
		Produto obj = produtoOpt.get();
		obj.setCategoria(produto.getCategoria());
		obj.setNome(produto.getNome());
		obj.setValor(produto.getValor());
		obj.setCodigoBarras(produto.getCodigoBarras());
		
		return repository.save(obj);
	} 

}
