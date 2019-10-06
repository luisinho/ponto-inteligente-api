package com.udemy.pontointeligente.api.services.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udemy.pontointeligente.api.entitys.Empresa;
import com.udemy.pontointeligente.api.repositories.EmpresaRepository;
import com.udemy.pontointeligente.api.services.EmpresaService;

@Service
public class EmpresaServiceImpl implements EmpresaService{

	private static final Logger log = org.slf4j.LoggerFactory.getLogger(EmpresaServiceImpl.class);

	@Autowired
	private EmpresaRepository empresaRepository;	

	@Override
	public Optional<Empresa> buscarEmpresaPorCnpj(String cnpj) {
		log.info("Buscando uma empresa para o CNPJ {}" + cnpj);
		return Optional.ofNullable(this.empresaRepository.findByCnpj(cnpj));
	}

	@Override
	public Empresa persistir(Empresa empresa) {
		log.info("Persistindo a empresa {}" + empresa);
		return this.empresaRepository.save(empresa);
	}
	
	

}
