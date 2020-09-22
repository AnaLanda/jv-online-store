CREATE SCHEMA `internet_shop` DEFAULT CHARACTER SET utf8 ;

CREATE TABLE `internet_shop`.`products` (
  `product_id` BIGINT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `price` DECIMAL(7,2) NOT NULL,
  `deleted` TINYINT NOT NULL DEFAULT 0,
  PRIMARY KEY (`product_id`));

CREATE TABLE `internet_shop`.`users` (
  `user_id` BIGINT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `login` VARCHAR(255) NOT NULL,
  `password` VARCHAR(255) NOT NULL,
  `deleted` TINYINT NOT NULL DEFAULT 0,
  PRIMARY KEY (`user_id`);
  UNIQUE INDEX `login_UNIQUE` (`login` ASC) VISIBLE);

CREATE TABLE `internet_shop`.`roles` (
  `role_id` BIGINT(11) NOT NULL AUTO_INCREMENT,
  `role_name` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`role_id`));

INSERT INTO `internet_shop`.`roles` (`role_name`) VALUES ('USER');
INSERT INTO `internet_shop`.`roles` (`role_name`) VALUES ('ADMIN');

CREATE TABLE `internet_shop`.`users_roles` (
  `id` BIGINT(11) NOT NULL AUTO_INCREMENT,
  `user_id` BIGINT(11) NULL,
  `role_id` BIGINT(11) NULL,
  PRIMARY KEY (`id`),
  INDEX `user_id_fk_idx` (`user_id` ASC) VISIBLE,
  INDEX `role_id_fk_idx` (`role_id` ASC) VISIBLE,
  CONSTRAINT `user_id_fk`
    FOREIGN KEY (`user_id`)
    REFERENCES `internet_shop`.`users` (`user_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `role_id_fk`
    FOREIGN KEY (`role_id`)
    REFERENCES `internet_shop`.`roles` (`role_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);

CREATE TABLE `internet_shop`.`shopping_carts` (
  `cart_id` BIGINT(11) NOT NULL AUTO_INCREMENT,
  `user_id` BIGINT(11) NOT NULL,
  `deleted` TINYINT NOT NULL DEFAULT 0,
  PRIMARY KEY (`cart_id`),
  INDEX `user_id_fk_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `cart_fk`
    FOREIGN KEY (`user_id`)
    REFERENCES `internet_shop`.`users` (`user_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);

CREATE TABLE `internet_shop`.`shopping_carts_products` (
  `id` BIGINT(11) NOT NULL AUTO_INCREMENT,
  `cart_id` BIGINT(11) NULL,
  `product_id` BIGINT(11) NULL,
  PRIMARY KEY (`id`),
  INDEX `product_id_fk_idx` (`product_id` ASC) VISIBLE,
  INDEX `cart_id_fk_idx` (`cart_id` ASC) VISIBLE,
  CONSTRAINT `cart_id_fk`
    FOREIGN KEY (`cart_id`)
    REFERENCES `internet_shop`.`shopping_carts` (`cart_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `product_id_fk`
    FOREIGN KEY (`product_id`)
    REFERENCES `internet_shop`.`products` (`product_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
