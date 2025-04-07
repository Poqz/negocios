-- MySQL Workbench Forward Engineering
 
SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
 
-- -----------------------------------------------------
-- Schema efa0124_ms_publicacao
-- -----------------------------------------------------
 
-- -----------------------------------------------------
-- Schema efa0124_ms_publicacao
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `efa0124_ms_publicacao` DEFAULT CHARACTER SET utf8 ;
USE `efa0124_ms_publicacao` ;
 
-- -----------------------------------------------------
-- Table `efa0124_ms_publicacao`.`categoria`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `efa0124_ms_publicacao`.`categoria` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `tipoCategoria` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;
 
 
-- -----------------------------------------------------
-- Table `efa0124_ms_publicacao`.`publicacao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `efa0124_ms_publicacao`.`publicacao` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `texto` VARCHAR(100) NULL,
  `titulo` VARCHAR(45) NULL,
  `numVotosPos` INT NULL,
  `numVotosNeg` INT NULL,
  `estado` TINYINT NULL,
  `utilizadorId` INT NULL,
  `data` DATETIME NULL,
  `imagem` VARCHAR(100) NULL,
  `localizacaoProduto` VARCHAR(50) NULL,
  `categoriaId` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_publicacao_categoria_idx` (`categoriaId` ASC) VISIBLE,
  CONSTRAINT `fk_publicacao_categoria`
    FOREIGN KEY (`categoriaId`)
    REFERENCES `efa0124_ms_publicacao`.`categoria` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;
 
 
-- -----------------------------------------------------
-- Table `efa0124_ms_publicacao`.`comentario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `efa0124_ms_publicacao`.`comentario` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `texto` VARCHAR(100) NULL,
  `numVotoPos` INT NULL,
  `numVotoNeg` INT NULL,
  `utilizadorId` INT NULL,
  `dataHora` DATETIME NULL,
  `publicacaoId` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_comentario_publicacao1_idx` (`publicacaoId` ASC) VISIBLE,
  CONSTRAINT `fk_comentario_publicacao1`
    FOREIGN KEY (`publicacaoId`)
    REFERENCES `efa0124_ms_publicacao`.`publicacao` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;
 
 
-- -----------------------------------------------------
-- Table `efa0124_ms_publicacao`.`votoComentario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `efa0124_ms_publicacao`.`votoComentario` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `votanteId` INT NULL,
  `tipoVoto` TINYINT NULL,
  `data` DATETIME NULL,
  `comentarioId` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_votoComentario_comentario1_idx` (`comentarioId` ASC) VISIBLE,
  CONSTRAINT `fk_votoComentario_comentario1`
    FOREIGN KEY (`comentarioId`)
    REFERENCES `efa0124_ms_publicacao`.`comentario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;
 
 
-- -----------------------------------------------------
-- Table `efa0124_ms_publicacao`.`votoPublicacao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `efa0124_ms_publicacao`.`votoPublicacao` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `votanteId` INT NULL,
  `tipoVoto` TINYINT NULL,
  `data` DATETIME NULL,
  `publicacaoId` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_votoPublicacao_publicacao1_idx` (`publicacaoId` ASC) VISIBLE,
  CONSTRAINT `fk_votoPublicacao_publicacao1`
    FOREIGN KEY (`publicacaoId`)
    REFERENCES `efa0124_ms_publicacao`.`publicacao` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;
 
 
SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
