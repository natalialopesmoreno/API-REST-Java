package br.com.minhaLojaDeGames.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.minhaLojaDeGames.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

	Categoria findByDescricao(String descricao);

}
