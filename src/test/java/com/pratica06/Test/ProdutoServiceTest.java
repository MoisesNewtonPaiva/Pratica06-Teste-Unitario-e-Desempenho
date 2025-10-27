package com.pratica06.Test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.math.BigDecimal;
import java.util.Optional;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;


import com.pratica06.Test.Model.Produto;
import com.pratica06.Test.Repository.ProdutoRepository;
import com.pratica06.Test.Service.ProdutoService;
@ExtendWith(MockitoExtension.class)
public class ProdutoServiceTest {
    
    @Mock
    private ProdutoRepository produtoRepository;

    @InjectMocks
    private ProdutoService produtoService;

    void deveCriarProdutoComSucesso() {
        
        Produto produtoParaSalvar = new Produto();
        produtoParaSalvar.setNome("Notebook Gamer");
        produtoParaSalvar.setPreco(new BigDecimal("8500.00"));

        Produto produtoSalvo = new Produto();
        produtoSalvo.setId(1L);
        produtoSalvo.setNome("Notebook Gamer");
        produtoSalvo.setPreco(new BigDecimal("8500.00"));

        
        when(produtoRepository.save(any(Produto.class))).thenReturn(produtoSalvo);

        
        Produto resultado = produtoService.criar(produtoParaSalvar);

        
        assertNotNull(resultado);
        assertEquals(1L, resultado.getId());
        assertEquals("Notebook Gamer", resultado.getNome());

        
        verify(produtoRepository, times(1)).save(any(Produto.class));
    }

    @Test
    void deveBuscarProdutoPorIdComSucesso() {
        
        Produto produto = new Produto();
        produto.setId(1L);
        produto.setNome("Mouse Sem Fio");

        when(produtoRepository.findById(1L)).thenReturn(Optional.of(produto));

        
        Optional<Produto> resultado = produtoService.buscarPorId(1L);

        
        assertTrue(resultado.isPresent());
        assertEquals(1L, resultado.get().getId());
        verify(produtoRepository, times(1)).findById(1L);
    }

}
