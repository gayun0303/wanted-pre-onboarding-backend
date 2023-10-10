-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema wanted
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema wanted
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `wanted` DEFAULT CHARACTER SET utf8 ;
-- -----------------------------------------------------
-- Schema wanted
-- -----------------------------------------------------
USE `wanted` ;

-- -----------------------------------------------------
-- Table `wanted`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `wanted`.`user` (
  `user_id` BIGINT NOT NULL,
  `user_name` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`user_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `wanted`.`company`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `wanted`.`company` (
  `company_id` BIGINT NOT NULL AUTO_INCREMENT,
  `company_name` VARCHAR(45) NOT NULL,
  `country` VARCHAR(45) NOT NULL,
  `region` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`company_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `wanted`.`job_posting`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `wanted`.`job_posting` (
  `job_posting_id` BIGINT NOT NULL AUTO_INCREMENT,
  `position` VARCHAR(100) NOT NULL,
  `reward` INT NOT NULL DEFAULT 0,
  `techStack` VARCHAR(45) NOT NULL,
  `content` VARCHAR(2000) NULL,
  `company_id` BIGINT NOT NULL,
  PRIMARY KEY (`job_posting_id`),
  INDEX `fk_job_posting_company1_idx` (`company_id` ASC) VISIBLE,
  CONSTRAINT `fk_job_posting_company1`
    FOREIGN KEY (`company_id`)
    REFERENCES `wanted`.`company` (`company_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `wanted`.`apply`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `wanted`.`apply` (
  `user_id` BIGINT NOT NULL,
  `job_posting_id` BIGINT NOT NULL,
  PRIMARY KEY (`user_id`, `job_posting_id`),
  INDEX `fk_user_has_job_posting_job_posting1_idx` (`job_posting_id` ASC) VISIBLE,
  INDEX `fk_user_has_job_posting_user_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_user_has_job_posting_user`
    FOREIGN KEY (`user_id`)
    REFERENCES `wanted`.`user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_has_job_posting_job_posting1`
    FOREIGN KEY (`job_posting_id`)
    REFERENCES `wanted`.`job_posting` (`job_posting_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
