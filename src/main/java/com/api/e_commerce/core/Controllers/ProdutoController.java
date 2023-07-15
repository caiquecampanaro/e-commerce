package com.api.e_commerce.core.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.e_commerce.core.DTOs.ProdutoDTO;
import com.api.e_commerce.core.models.Produto;
import com.api.e_commerce.core.services.ProdutoService;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

	@Autowired
	ProdutoService service;

	@GetMapping("{id}")
	public ResponseEntity<Optional<Produto>> buscarTodosProdutos(@PathVariable Long id) {
		return new ResponseEntity<Optional<Produto>>(service.buscarId(id), HttpStatus.OK);
	}

	@GetMapping("")
	public ResponseEntity<List<Produto>> buscarProdutos() {
		return new ResponseEntity<List<Produto>>(service.buscarProdutos(), HttpStatus.OK);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<Produto> deletarProduto(@PathVariable Long id) {
		service.deletarProduto(id);
		return new ResponseEntity<Produto>(HttpStatus.NO_CONTENT);
	}
	@PostMapping("")
	public ResponseEntity<Produto> salvarNovoProduto (@RequestBody ProdutoDTO produtoDTO) {
		service.salvarProduto(produtoDTO.convert());
		return new ResponseEntity<Produto>(HttpStatus.CREATED);	
	}	
	@PutMapping("{id}")
	public ResponseEntity<Produto> atualizarProduto (@PathVariable Long id, @RequestBody ProdutoDTO produtoDTO){
		service.atualizarProduto(produtoDTO.convert(), id);
		return new ResponseEntity<Produto>(HttpStatus.RESET_CONTENT);
		
	}

}
