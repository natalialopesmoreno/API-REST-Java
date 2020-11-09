package br.com.minhaLojaDeGames.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import br.com.minhaLojaDeGames.model.Jogador;
import br.com.minhaLojaDeGames.repository.JogadorRepository;

@RestController
@RequestMapping("/jogador")
public class JogadorController implements WebMvcConfigurer
{

	
	public void addViewControllers(ViewControllerRegistry index) {
		index.addViewController("/").setViewName("forward:/index.html");
	}
	
	
	//ESSE É O GET DA API REST
		//INJETOU O REPOSITÓRIO DO SERVICO PARA COMUNICAR COM O BANCO DE DADOS
			@Autowired
			private JogadorRepository repository;
		// FAÇO O GET DO HTTP e o Read DO CRUD COM O COMANDO .findAll()
			
			//CRUD
			//CREATE --> POST
			@PostMapping 
			public ResponseEntity<Jogador> postJogador(@RequestBody Jogador jogador)
			{
				return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(jogador));	
			}
			
			//READ --> GET
			@GetMapping 
			public ResponseEntity<List<Jogador>> findAllJogador() 
			{		
				return ResponseEntity.ok(repository.findAll());
			}
			
			@GetMapping ("/{id}")
			public ResponseEntity<Jogador> findByIdJogador(@PathVariable Long id) 
			{		
				return repository.findById(id)
						.map(resposta -> ResponseEntity.ok(resposta))
						.orElse(ResponseEntity.notFound().build());
			}
			
			
	
			
			
			//UPDATE --> PUT
			@PutMapping("/{id}")
			public ResponseEntity<Jogador> putJogador(@PathVariable Long id, @RequestBody Jogador jogador) 
			{
				jogador.setId(id);
				return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(jogador));
			}
			
			//DELETE --> DELETE
			@DeleteMapping ("/{id}")
			public void deleteJogador(@PathVariable Long id) 
			{		
				repository.deleteById(id);
			}
			
}