package com.pratica06.Test.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pratica06.Test.Model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    
}
