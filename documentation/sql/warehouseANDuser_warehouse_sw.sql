CREATE TABLE IF NOT EXISTS `warehouse_user` (
  `warehouseId` VARCHAR (20) NOT NULL,
  `userName` VARCHAR (20) NOT NULL ,
  PRIMARY KEY (warehouseId,userName))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


