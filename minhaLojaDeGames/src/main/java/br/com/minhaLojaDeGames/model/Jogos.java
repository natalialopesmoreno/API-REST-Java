package br.com.minhaLojaDeGames.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;


@Entity
@Table(name="tb_jogos")
public class Jogos 
{

	//ATRIBUTOS
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long Id;
		
		@Column
		@NotNull
		private String nome;


		@Column
		@NotNull
		private String descricao;
		
		@Column
		private Double preco;
		
		//CHAVE ESTRANGEIRA
		@ManyToOne
		@JsonIgnoreProperties("jogos")
		private Categoria categoria;
		
		
		

		//GETTERS AND SETTERS
		
		public Long getId() {
			return Id;
		}


		public void setId(Long id) {
			Id = id;
		}


		public String getNome() {
			return nome;
		}


		public void setNome(String nome) {
			this.nome = nome;
		}


		public String getDescricao() {
			return descricao;
		}


		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}


		public Double getPreco() {
			return preco;
		}


		public void setPreco(Double preco) {
			this.preco = preco;
		}


		public Categoria getCategoria() {
			return categoria;
		}


		public void setCategoria(Categoria categoria) {
			this.categoria = categoria;
		}
		
		
		
		
	
	
}
