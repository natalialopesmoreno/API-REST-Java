package com.br.api.rest.java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.api.rest.java.UsuarioRepository;
import com.br.api.rest.java.model.UsuarioModel;

@RestController
@RequestMapping("/usuario")
public class UsuarioController 
{

	@Autowired
	private UsuarioRepository repository;
	
	
	@GetMapping("/teste")
	public String teste() 
	{
		return "API funcionando!";
	}
	
	//CREATE - CRUD
	@PostMapping("/cadastrar")
	public UsuarioModel cadastrar(@RequestBody UsuarioModel usuario) 
	{
		repository.save(usuario);
		
		return usuario;
	}
	
	//READ - CRUD
		@GetMapping("/consultar")
		public List<UsuarioModel> consultar()
		{
			return repository.findAll();
		}
		
	//READ- POR ID	
		@GetMapping("/consultar/{id}")
		public ResponseEntity<UsuarioModel> buscarPorId(@PathVariable Long id)
		{
			return ResponseEntity.ok().body(repository.findById(id).get());
		}
	
		//UPDATE - CRUD
		
		
		//DELETE - CRUD
		
		
		
}
