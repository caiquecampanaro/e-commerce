package com.api.e_commerce.core.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.e_commerce.core.models.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
