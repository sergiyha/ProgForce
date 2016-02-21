-- MySQL Workbench Synchronization
-- Generated: 2016-02-19 23:05
-- Model: New Model
-- Version: 1.0
-- Project: Name of the project
-- Author: dukal

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `shops_db` DEFAULT CHARACTER SET utf8 ;

CREATE TABLE IF NOT EXISTS `shops_db`.`shops` (
  `shop_id` INT(11) NOT NULL AUTO_INCREMENT,
  `shop` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`shop_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `shops_db`.`categories` (
  `categories_id` INT(11) NOT NULL AUTO_INCREMENT,
  `category` VARCHAR(45) NOT NULL,
  `shop_id` INT(11) NOT NULL,
  PRIMARY KEY (`categories_id`),
  INDEX `fk_categories_shops_idx` (`shop_id` ASC),
  CONSTRAINT `fk_categories_shops`
    FOREIGN KEY (`shop_id`)
    REFERENCES `shops_db`.`shops` (`shop_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `shops_db`.`status` (
  `status_id` INT(11) NOT NULL AUTO_INCREMENT,
  `status` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`status_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `shops_db`.`products` (
  `product_id` INT(11) NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(45) NOT NULL,
  `price` VARCHAR(45) NOT NULL,
  `status_id` INT(11) NOT NULL,
  `category_id` INT(11) NOT NULL,
  PRIMARY KEY (`product_id`),
  INDEX `fk_products_categories1_idx` (`category_id` ASC),
  INDEX `fk_products_status1_idx` (`status_id` ASC),
  CONSTRAINT `fk_products_categories1`
    FOREIGN KEY (`category_id`)
    REFERENCES `shops_db`.`categories` (`categories_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_products_status1`
    FOREIGN KEY (`status_id`)
    REFERENCES `shops_db`.`status` (`status_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

USE  shops_db; 
INSERT INTO shops (shop) VALUES ('shop_1'),('shop_2');
INSERT INTO status (status) VALUES ('Available'), ('Absent'), ('Expected');
INSERT INTO categories (category,shop_id) VALUES ('tools',1),('fruits',1),('anumals',2),('meat',2);

