package com.udemy.pontointeligente.api.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class JwtAuthenticationDto {

	@NotEmpty(message = "Email não pode ser vazio.")
	@Email(message = "Email inválido")
	private String email;

	@NotEmpty(message = "Semha não pode ser vazia.")
	private String senha;

	public JwtAuthenticationDto() {

	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "JwtAuthenticationDto [email=" + email + ", senha=" + senha + "]";
	}
}