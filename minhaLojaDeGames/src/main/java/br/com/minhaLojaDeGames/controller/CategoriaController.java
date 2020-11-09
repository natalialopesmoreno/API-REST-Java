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

import br.com.minhaLojaDeGames.model.Categoria;
import br.com.minhaLojaDeGames.repository.CategoriaRepository;

@RestController
@RequestMapping("/categoria")
public class CategoriaController implements WebMvcConfigurer
{

	
	public void addViewControllers(ViewControllerRegistry index) {
		index.addViewController("/").setViewName("forward:/index.html");
	}
	
	
	//ESSE É O GET DA API REST
		//INJETOU O REPOSITÓRIO DO SERVICO PARA COMUNICAR COM O BANCO DE DADOS
			@Autowired
			private CategoriaRepository repository;
		// FAÇO O GET DO HTTP e o Read DO CRUD COM O COMANDO .findAll()
			
			//CRUD
			//CREATE --> POST
			@PostMapping 
			public ResponseEntity<Categoria> postCategoria(@RequestBody Categoria categoria)
			{
				return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(categoria));	
			}
			
			//READ --> GET
			@GetMapping 
			public ResponseEntity<List<Categoria>> findAllCategoria() 
			{		
				return ResponseEntity.ok(repository.findAll());
			}
			
			@GetMapping ("/{id}")
			public ResponseEntity<Categoria> findByIdCategoria(@PathVariable Long id) 
			{		
				return repository.findById(id)
						.map(resposta -> ResponseEntity.ok(resposta))
						.orElse(ResponseEntity.notFound().build());
			}
			
			@GetMapping ("/descricao/{descricao}")
			public ResponseEntity<Categoria> findAllByDescricaoCategoria(@PathVariable String descricao) 
			{		
				return ResponseEntity.ok(repository.findByDescricao(descricao));
						
			}
			
			
			
			
			//UPDATE --> PUT
			@PutMapping("/{id}")
			public ResponseEntity<Categoria> putCategoria(@PathVariable Long id, @RequestBody Categoria categoria) 
			{
				categoria.setId(id);
				return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(categoria));
			}
			
			//DELETE --> DELETE
			@DeleteMapping ("/{id}")
			public void deleteCategoria(@PathVariable Long id) 
			{		
				repository.deleteById(id);
			}
			
			
	
	
	
}
