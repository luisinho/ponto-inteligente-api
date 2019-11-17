package com.udemy.pontointeligente.api.services;

import java.util.Optional;

import com.udemy.pontointeligente.api.entitys.Usuario;

public interface UsuarioService {

	/**
	 * Busca e retorna um usuário dado um email
	 * 
	 * @param email
	 * @return Optional<Usuario>
	 */
	Optional<Usuario> buscarPorEmail(String email);

}
