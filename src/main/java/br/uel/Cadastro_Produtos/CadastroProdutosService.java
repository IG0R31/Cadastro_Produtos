package com.example.produtos.service;

import com.example.produtos.model.Produto;
import com.example.produtos.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    
    @Autowired
    private ProdutoRepository produtoRepository;
    
    public List<Produto> listarTodos() {
        return produtoRepository.findAll();
    }
    
  
    public Optional<Produto> buscarPorId(Long id) {
        return produtoRepository.findById(id);
    }
    
    
    public List<Produto> buscarPorNome(String nome) {
        return produtoRepository.findByNomeContainingIgnoreCase(nome);
    }
    
    
    public Produto salvar(Produto produto) {
        return produtoRepository.save(produto);
    }
    
    
    public void excluir(Long id) {
        produtoRepository.deleteById(id);
    }
}