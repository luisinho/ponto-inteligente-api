CREATE TABLE `ponto_inteligente`.`usuario`(
`id` BIGINT(20) NOT NULL,
`email` VARCHAR(30) NOT NULL,
`senha` VARCHAR(80) NOT NULL
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Indexes for table `usuario`
ALTER TABLE `usuario` ADD PRIMARY KEY(`id`);

-- AUTO_INCREMENT for table `usuario`
ALTER TABLE `usuario` MODIFY `id`BIGINT(20) NOT NULL AUTO_INCREMENT;

