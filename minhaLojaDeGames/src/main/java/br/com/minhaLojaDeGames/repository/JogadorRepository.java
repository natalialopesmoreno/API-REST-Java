package br.com.minhaLojaDeGames.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.minhaLojaDeGames.model.Jogador;

public interface JogadorRepository extends JpaRepository<Jogador, Long> {

}
