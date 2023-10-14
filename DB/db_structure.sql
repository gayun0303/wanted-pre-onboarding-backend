-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema wanted
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema wanted
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `wanted` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `wanted` ;

-- -----------------------------------------------------
-- Table `wanted`.`company`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `wanted`.`company` (
                                                  `company_id` BIGINT NOT NULL AUTO_INCREMENT,
                                                  `company_name` VARCHAR(45) NOT NULL,
    `country` VARCHAR(45) NOT NULL,
    `region` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`company_id`))
    ENGINE = InnoDB
    AUTO_INCREMENT = 3
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `wanted`.`job_posting`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `wanted`.`job_posting` (
                                                      `job_posting_id` BIGINT NOT NULL AUTO_INCREMENT,
                                                      `position` VARCHAR(100) NOT NULL,
    `reward` INT NOT NULL,
    `tech_stack` VARCHAR(45) NOT NULL,
    `content` VARCHAR(2000) NULL DEFAULT NULL,
    `company_id` BIGINT NOT NULL,
    PRIMARY KEY (`job_posting_id`),
    INDEX `fk_job_posting_company1_idx` (`company_id` ASC) VISIBLE,
    CONSTRAINT `fk_job_posting_company1`
    FOREIGN KEY (`company_id`)
    REFERENCES `wanted`.`company` (`company_id`))
    ENGINE = InnoDB
    AUTO_INCREMENT = 7
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `wanted`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `wanted`.`user` (
                                               `user_id` BIGINT NOT NULL AUTO_INCREMENT,
                                               `user_name` VARCHAR(20) NOT NULL,
    PRIMARY KEY (`user_id`))
    ENGINE = InnoDB
    AUTO_INCREMENT = 4
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `wanted`.`apply`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `wanted`.`apply` (
                                                `apply_id` BIGINT NOT NULL AUTO_INCREMENT,
                                                `user_id` BIGINT NOT NULL,
                                                `job_posting_id` BIGINT NOT NULL,
                                                `create_datetime` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
                                                PRIMARY KEY (`apply_id`),
    INDEX `fk_user_has_job_posting_job_posting2_idx` (`job_posting_id` ASC) VISIBLE,
    INDEX `fk_user_has_job_posting_user1_idx` (`user_id` ASC) VISIBLE,
    CONSTRAINT `fk_user_has_job_posting_job_posting2`
    FOREIGN KEY (`job_posting_id`)
    REFERENCES `wanted`.`job_posting` (`job_posting_id`),
    CONSTRAINT `fk_user_has_job_posting_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `wanted`.`user` (`user_id`))
    ENGINE = InnoDB
    AUTO_INCREMENT = 4
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
