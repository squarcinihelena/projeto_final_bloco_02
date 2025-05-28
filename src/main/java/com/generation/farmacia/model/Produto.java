package com.generation.farmacia.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name = "tb_produtos")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 255)
	@NotNull(message = "Nome é obrigatório!")
	private String nome;

	@NotNull(message = "Preço é obrigatório!")
	@Positive(message = "O preço deve ser maior do que zero!")
	private BigDecimal preco;

	@Column(length = 5000)
	private String foto;

	@NotNull(message = "O estoque é obrigatório!") // Add validação para estoque
	@Positive(message = "O estoque deve ser maior ou igual a zero!")
	private Integer estoque; 

	@NotNull(message = "A data de validade é obrigatória!")
	@FutureOrPresent(message = "A data de validade não pode ser no passado!") 
	private LocalDate validade; // validade!!

	@ManyToOne
	@JsonIgnoreProperties("produto")
	@NotNull(message = "A categoria é obrigatória!") 
	private Categoria categoria;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	public Integer getEstoque() {
	        return estoque;
	 }

	public void setEstoque(Integer estoque) {
	        this.estoque = estoque;
	}

	public LocalDate getValidade() {
	        return validade;
	}

	public void setValidade(LocalDate validade) {
	     this.validade = validade;
	    
	}
}

