package com.udemy.pontointeligente.api.services;

import java.util.Optional;

import com.udemy.pontointeligente.api.entitys.Empresa;

public interface EmpresaService {
	
	/**
	 * Retorna uma empresa dado o CNPJ
	 *	 
	 * @param cnpj
	 * @return Optional<Empresa>
	 */
	Optional<Empresa> buscarEmpresaPorCnpj(String cnpj);
	
	/**
	 * Cadastra uma nova empresa na base de dados
	 * 
	 * @param empresa
	 * @return Empresa
	 */
	Empresa persistir(Empresa empresa);

}
