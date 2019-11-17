package com.udemy.pontointeligente.api.security.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.udemy.pontointeligente.api.entitys.Funcionario;
import com.udemy.pontointeligente.api.entitys.Usuario;
import com.udemy.pontointeligente.api.enums.PerfilEnum;

public class JwtUserFactory {
	
	private JwtUserFactory() {
		
	}
	
	/**
	 * Converte e gera um JwtUser com base nos dados de um funcionário
	 * 
	 * @param usuario
	 * @return JwtUser
	 */
	public static JwtUser create(Funcionario usuario) {		
		return new JwtUser(usuario.getId(), 
				       usuario.getEmail(), 
				       usuario.getSenha(), 
				       mapGrantedAuthority(usuario.getPerfil()));
		
		
	}

	/**
	 * Converte o perfil do usuário para o formato utilizado pelo Spring Security.
	 * 
	 * @param perfilEnum
	 * @return ​ List<GrantedAuthority>
	 */
	private static List<GrantedAuthority> mapGrantedAuthority(PerfilEnum perfilEnum) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(perfilEnum.toString()));		
		return authorities;		
	}

}
