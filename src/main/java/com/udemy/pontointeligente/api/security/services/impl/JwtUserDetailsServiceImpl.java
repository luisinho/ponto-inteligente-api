package com.udemy.pontointeligente.api.security.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.udemy.pontointeligente.api.entitys.Funcionario;
import com.udemy.pontointeligente.api.entitys.Usuario;
import com.udemy.pontointeligente.api.security.utils.JwtUserFactory;
import com.udemy.pontointeligente.api.services.FuncionarioService;
import com.udemy.pontointeligente.api.services.UsuarioService;

@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private FuncionarioService funcionarioService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		// Optional<Usuario> funcionario = this.usuarioService.buscarPorEmail(username);
		
		Optional<Funcionario> funcionario = this.funcionarioService.buscarPorEmail(username);

		if (funcionario.isPresent()) {
			UserDetails user = JwtUserFactory.create(funcionario.get());
			return user;
		}

		throw new UsernameNotFoundException("Email não encontrado");
	}

}
