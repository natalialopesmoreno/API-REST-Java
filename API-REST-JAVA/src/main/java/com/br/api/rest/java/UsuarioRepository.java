package com.br.api.rest.java;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.api.rest.java.model.UsuarioModel;

public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {

}
