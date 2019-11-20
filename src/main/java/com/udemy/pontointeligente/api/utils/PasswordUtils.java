package com.udemy.pontointeligente.api.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordUtils {
	
	private static final Logger log = LoggerFactory.getLogger(PasswordUtils.class);
	
	public PasswordUtils() {
		
	}
	
	public static String gerarBCrypt(String senha) {
		if (senha == null) {
			return senha;
		}
		
		log.info("Gerando senha com BCrypt. ");
		BCryptPasswordEncoder bCryptEncoder = new BCryptPasswordEncoder();
		return bCryptEncoder.encode(senha);
	}
	
	public static void main(String [] args) {
		
		String senha = gerarBCrypt("12345678");
		System.out.println(senha);
	}

}
