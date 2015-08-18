CREATE TABLE IF NOT EXISTS `stock` (
  `id` BIGINT(20) NOT NULL unique auto_increment ,
  `warehouse_id` BIGINT(20) NOT NULL,
  `ware_id` BIGINT(20) NOT NULL,
  `piece` INT(6),
  PRIMARY KEY (warehouse_id, ware_id))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


