package com.pratica06.Test.ServiceTest;

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
        
        Produto produtoMock = new Produto();
        produtoMock.setId(1L);
        produtoMock.setNome("Mouse Sem Fio");

        when(produtoRepository.findById(1L)).thenReturn(Optional.of(produtoMock));

        
        Optional<Produto> resultado = produtoService.buscarPorId(1L);

        
        assertTrue(resultado.isPresent());
        assertEquals(1L, resultado.get().getId());
        verify(produtoRepository, times(1)).findById(1L);
    }

    @Test
    void deveListarTodosOsProdutos() {

        Produto p1 = new Produto();
        p1.setId(1L);
        p1.setNome("Produto A");
        
        Produto p2 = new Produto();
        p2.setId(2L);
        p2.setNome("Produto B");

        List<Produto> listarDeProdutosMock = Arrays.asList(p1, p2);

        when(produtoRepository.findAll()).thenReturn(listaDeProdutosMock);

        List<Produto> resultado = produtoService.listarTodos();

        asserNotNull(resultado);
        asserEquals(2, resultado.size());
        asserEquals("Produto B", resultado.get(1).getNome());
        verify(produtoRepository, times(1)).findAll();
    }

    @Test
    void deveAtualizarProdutoComSucesso() {

        Produto produtoExistente= new Produto();

        produtoExistente.setId(1L);
        produtoExistente.setNome("Nome Antigo");

        Produto produtoComNovoDados = new Produto();
        produtoComNovosDados.setNome("Nome Novo");
        produtoComNovosDados.setDescricao("Descricao Nova");
        produtoComNovosDados.setPreco(new java.math.BigDecimal("99.99"));

        when(produtoRepository.findById(idExistente)).thenReturn(java.uil.Optional.of(produtoExistente));

        when(produtoRepository.save(any(Produto.class))).theReturn(produtoComNovosDados);

        Produto resultado = produtoService.atualizar(idExistente, produtoComNovosDados);

        asserNotNull(resultado);
        asserEquals("Nome novo", resultado.getNome());
        asserEquals("Descricao Nova", resultado.getDescricao());
        verify(produtoRepository, time(1)).findById(idExistente);
        verify(produtoRepository, time(1)).save(any(Produto.class));
    }

    @Test
    void deveExcluirComSucesso() {
        
        Long idParaExcluir = 1L;

        when(produtoRepository.existById(idParaExcluir)).thenReturn(true);
        doNothing().when(produtoRepository).deleteById(idParaExcluir);

        asserDoesNotThrow(() -> produtoService.excluir(idParaExcluir));

        verify(produtoRepository, times(1)).existsById(idParaExcluir);
        verify(produtoRepository, times(1)).deleteById(idParaExcluir);
    }

}
