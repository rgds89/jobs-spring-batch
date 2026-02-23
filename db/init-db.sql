-- init.sql
-- Cria os bancos e usuários solicitados e concede privilégios totais.
-- Este script é executado automaticamente pelo entrypoint do container
-- apenas na inicialização quando o diretório de dados estiver vazio.

-- 1) Schema: jobs_spring_batch
CREATE DATABASE IF NOT EXISTS `jobs_spring_batch`
  CHARACTER SET utf8mb4
  COLLATE utf8mb4_unicode_ci;

CREATE USER IF NOT EXISTS 'jobs_spring_batch'@'%' IDENTIFIED BY 'root1234';
GRANT ALL PRIVILEGES ON `jobs_spring_batch`.* TO 'jobs_spring_batch'@'%';

FLUSH PRIVILEGES;