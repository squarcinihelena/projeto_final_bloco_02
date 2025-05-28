package com.generation.farmacia.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.generation.farmacia.repository.ProdutoRepository;
import com.generation.farmacia.model.Produto;
import com.generation.farmacia.repository.CategoriaRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/produtos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping
    public ResponseEntity<List<Produto>> getAll() {
        return ResponseEntity.ok(produtoRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> getById(@PathVariable Long id) {
        return produtoRepository.findById(id)
                .map(resposta -> ResponseEntity.ok(resposta))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<Produto>> getByNome(@PathVariable String nome) {
        return ResponseEntity.ok(produtoRepository.findAllByNomeContainingIgnoreCase(nome));
    }

    @PostMapping
    public ResponseEntity<Produto> postProduto(@Valid @RequestBody Produto produto) {
        return categoriaRepository.findById(produto.getCategoria().getId())
                .map(resposta -> ResponseEntity.status(HttpStatus.CREATED).body(produtoRepository.save(produto)))
                .orElse(ResponseEntity.badRequest().build());
    }

    @PutMapping
    public ResponseEntity<Produto> putProduto(@Valid @RequestBody Produto produto) {
        if (produtoRepository.existsById(produto.getId())) {
            return categoriaRepository.findById(produto.getCategoria().getId())
                    .map(resposta -> ResponseEntity.ok().body(produtoRepository.save(produto)))
                    .orElse(ResponseEntity.badRequest().build());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduto(@PathVariable Long id) {
        return produtoRepository.findById(id)
                .map(resposta -> {
                    produtoRepository.deleteById(id);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/preco_maior/{preco}")
    public ResponseEntity<List<Produto>> getPrecoMaiorQue(@PathVariable BigDecimal preco) {
        return ResponseEntity.ok(produtoRepository.findByPrecoGreaterThanOrderByPreco(preco));
    }

    @GetMapping("/preco_menor/{preco}")
    public ResponseEntity<List<Produto>> getPrecoMenorQue(@PathVariable BigDecimal preco) {
        return ResponseEntity.ok(produtoRepository.findByPrecoLessThanOrderByPrecoDesc(preco));
    }
}