package com.generation.farmacia.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_categorias")
public class Categoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "O tipo é obrigatório!")
	@Size(min = 3, message = "O tipo deve ter no mínimo 3 caracteres") // Adicionado message para clareza
	@Pattern(regexp = "^[^0-9].*", message = "O tipo não pode começar com número")
	private String tipo;

	@NotBlank(message = "A descrição é obrigatória!") // Adicionar se você quiser descrição
	@Size(min = 5, max = 255, message = "A descrição deve ter entre 5 e 255 caracteres") // Exemplo de validação
	private String descricao; // <<< ADICIONAR ESTA LINHA SE VOCÊ QUISER DESCRICAO

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "categoria", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("categoria")
	private List<Produto> produto;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<Produto> getProduto() {
		return produto;
	}

	public void setProduto(List<Produto> produto) {
		this.produto = produto;
	}
	
	public String getDescricao() {
	    return descricao;
	}

	public void setDescricao(String descricao) {
	    this.descricao = descricao;
	}
}