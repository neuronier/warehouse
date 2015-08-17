CREATE TABLE IF NOT EXISTS `stock` (
  `id` BIGINT(20) NOT NULL unique ,
  `warehouseId` VARCHAR (20) NOT NULL,
  `wareId` BIGINT(20) NOT NULL,
  `piece` INT(6),
  PRIMARY KEY (warehouseId, wareId))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


