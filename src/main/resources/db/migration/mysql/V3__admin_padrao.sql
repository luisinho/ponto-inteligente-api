INSERT INTO `empresa`(`id`, `cnpj`, `data_atualizacao`, `data_criacao`, `razao_social`)
VALUES (NULL, '24113187000106', CURRENT_DATE(), CURRENT_DATE(), 'ADMIN');

INSERT INTO `funcionario`(`id`, `cpf`, `data_atualizacao`, `data_criacao`, `email`, `nome`, `perfil`, `qtd_horas_almoco`, `qtd_horas_trabalho_dia`, `senha`, `valor_hora`, `empresa_id`)
VALUES (NULL,'01931512000134', CURRENT_DATE(), CURRENT_DATE(), 'admin@gmail1.com', 'ADMIN', 'ROLE_ADMIN', NULL, NULL,'$2a$10$6nQsuuz3/mLf/mQ0FoCrjelOpyHmFD3K/jGtHOSP2qaEgc1JIueYW', 100, (SELECT `id` FROM `empresa` WHERE `cnpj` = '24113187000106'));


