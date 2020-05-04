CREATE SCHEMA IF NOT EXISTS book_library;

USE book_library;

CREATE TABLE IF NOT EXISTS `books` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `uuid` VARCHAR(45) UNIQUE NULL,
  `book_name` VARCHAR(45) NOT NULL,
  `publisher_name` VARCHAR(45) NOT NULL,
  `category_name` VARCHAR(45) NOT NULL,
  `number_of_pages` NUMBER(4) NOT NULL
  PRIMARY KEY (`id`)
  );
