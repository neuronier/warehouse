CREATE TABLE IF NOT EXISTS `Warehouse` (
  `id` BIGINT(20) NOT NULL COMMENT '',
  `warehouseId` BIGINT(20) NOT NULL UNIQUE COMMENT '',
  `name` VARCHAR(255) NULL COMMENT '',
  `zipCode` INT(6) NULL COMMENT '',
  `city` VARCHAR(255) NULL COMMENT '',
  `address` VARCHAR(255) NULL COMMENT '',
  `addressNumber` int(6) NULL COMMENT '',
  `users` BIGINT(20) NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '')
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


CREATE TABLE IF NOT EXISTS `user_warehouse_sw` (
  `users_id` BIGINT(20) NOT NULL COMMENT '',
  `warehouse_id` BIGINT(20) NOT NULL COMMENT '',
  INDEX `userI` (`warehouse_id` ASC)  COMMENT '',
  INDEX `warehouseI` (`users_id` ASC)  COMMENT '',
  CONSTRAINT `warehouseI`
    FOREIGN KEY (`users_id`)
    REFERENCES `user` (`id`),
  CONSTRAINT `userI`
    FOREIGN KEY (`warehouse_id`)
    REFERENCES `warehouse` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;
