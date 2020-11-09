package br.com.minhaLojaDeGames.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.minhaLojaDeGames.model.Jogos;

public interface JogosRepository extends JpaRepository<Jogos, Long> 
{

	Jogos findByDescricao(String descricao);

	 

	

}
