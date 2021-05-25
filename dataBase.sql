create database livro;
use livro;
CREATE TABLE `livro`.`receita` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `nome` VARCHAR(45) NULL COMMENT '',
  `passo` VARCHAR(255) NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '');
  
CREATE TABLE `livro`.`ingrediente`(
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `nome` VARCHAR(45) NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '');
  
  
insert into ingrediente values (1, "leite");
insert into ingrediente values (2, "açucar");
insert into ingrediente values (3, "leite condensado");

CREATE TABLE `livro`.`receita_ingrediente`(
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `medida` VARCHAR(45) NULL COMMENT '',
  `id_receita` INT NOT NULL ,
  `id_ingrediente` INT NOT NULL,
  PRIMARY KEY (`id`)  COMMENT '',
  FOREIGN KEY(`id_receita`) REFERENCES receita(`id`),
  FOREIGN KEY(`id_ingrediente`) REFERENCES ingrediente(`id`));