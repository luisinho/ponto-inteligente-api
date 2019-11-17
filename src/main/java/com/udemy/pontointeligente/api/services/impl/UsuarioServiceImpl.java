package com.udemy.pontointeligente.api.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udemy.pontointeligente.api.entitys.Usuario;
import com.udemy.pontointeligente.api.repositories.UsuarioRepository;
import com.udemy.pontointeligente.api.services.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public Optional<Usuario> buscarPorEmail(String email) {		
		return Optional.ofNullable(this.usuarioRepository.findByEmail(email));
	}
	
	

}
