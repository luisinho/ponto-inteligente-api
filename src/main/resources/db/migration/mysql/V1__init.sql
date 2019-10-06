CREATE TABLE `ponto_inteligente`.`empresa`(
`id` BIGINT(20) NOT NULL,
`razao_social` VARCHAR(80) NOT NULL,
`cnpj` VARCHAR(20) NOT NULL,
`data_criacao` DATETIME NOT NULL,
`data_atualizacao` DATETIME NOT NULL
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `ponto_inteligente`.`funcionario`(
 `id` BIGINT(20) NOT NULL,
 `nome` VARCHAR(80) NOT NULL,
 `email` VARCHAR(30) NOT NULL,
 `senha` VARCHAR(80) NOT NULL,
 `cpf` VARCHAR(80) NOT NULL,
 `valor_hora` DECIMAL(19,2) NOT NULL,
 `qtd_horas_trabalho_dia` FLOAT DEFAULT NULL,
 `qtd_horas_almoco` FLOAT DEFAULT NULL,
 `perfil` VARCHAR(20) NOT NULL,
 `data_criacao` DATETIME NOT NULL,
 `data_atualizacao` DATETIME NOT NULL,
 `empresa_id` BIGINT(20) DEFAULT NULL
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `ponto_inteligente`.`lancamento`(
 `id` BIGINT(20) NOT NULL,
 `data` DATETIME NOT NULL,
 `descricao` VARCHAR(30) DEFAULT NULL,
 `localizacao` VARCHAR(30) DEFAULT NULL,
 `data_criacao` DATETIME NOT NULL,
 `data_atualizacao` DATETIME NOT NULL,
 `tipo` VARCHAR(20) NOT NULL,
 `funcionario_id` BIGINT(20) DEFAULT NULL
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Indexes for table `empresa`
ALTER TABLE `empresa` ADD PRIMARY KEY(`id`);

-- Indexes for table `funcionario`
ALTER TABLE `funcionario` ADD PRIMARY KEY(`id`), ADD KEY `empresa_fk` (`empresa_id`);

-- Indexes for table `lancamento`
ALTER TABLE `lancamento` ADD PRIMARY KEY(`id`), ADD KEY `funcionario_fk` (`funcionario_id`);


-- AUTO_INCREMENT for table `empresa`
ALTER TABLE `empresa` MODIFY `id`BIGINT(20) NOT NULL AUTO_INCREMENT;

-- AUTO_INCREMENT for table `funcionario`
ALTER TABLE `funcionario` MODIFY `id`BIGINT(20) NOT NULL AUTO_INCREMENT;

-- AUTO_INCREMENT for table `lancamento`
ALTER TABLE `lancamento` MODIFY `id`BIGINT(20) NOT NULL AUTO_INCREMENT;

-- Constraints for dumped tables


-- Constraints for table funcionario
ALTER TABLE `funcionario` ADD CONSTRAINT `empresa_fk` FOREIGN KEY (`empresa_id`) REFERENCES `empresa` (`id`);

-- Constraints for table lancamento
ALTER TABLE `lancamento` ADD CONSTRAINT `funcionario_fk` FOREIGN KEY (`funcionario_id`) REFERENCES `funcionario` (`id`);	