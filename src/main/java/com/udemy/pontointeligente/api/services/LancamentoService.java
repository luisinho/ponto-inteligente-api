package com.udemy.pontointeligente.api.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.udemy.pontointeligente.api.entitys.Lancamento;

public interface LancamentoService {
	
	/**
	 * 
	 * @param funcionarioId
	 * @param pageRequest
	 * @return Page<Lancamento>
	 */
	Page<Lancamento> buscarFuncionarioPorId(Long funcionarioId, PageRequest pageRequest);
	
	/**
	 * Retorna um lancamento por ID
	 * 
	 * @param id
	 * @return Optional<Lancamento>
	 */
	Optional<Lancamento> buscarPorId(Long id);
	
	/**
	 * Persiste um lançamento na base de dados
	 * 
	 * @param lancamento
	 * @return lancamento
	 */
	Lancamento persistir(Lancamento lancamento);
	
	/**
	 * Remove um lancamento da base de dados
	 * 
	 * @param id
	 */
	void remover(Long id);	
}
