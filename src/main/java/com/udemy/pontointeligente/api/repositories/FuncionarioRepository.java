package com.udemy.pontointeligente.api.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.udemy.pontointeligente.api.entitys.Funcionario;

@Transactional(readOnly = true)
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{

	Funcionario findByCpf(String cpf);

	Funcionario findByEmail(String email);

	Funcionario findByCpfOrEmail(String cpf, String email);
	
	Optional<Funcionario> buscarPorId(Long id);

}
