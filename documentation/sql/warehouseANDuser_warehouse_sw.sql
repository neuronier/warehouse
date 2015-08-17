CREATE TABLE IF NOT EXISTS `warehouse_user2s` (
  `warehouseId` VARCHAR (20) NOT NULL,
  `userName` VARCHAR (20) NOT NULL ,
  PRIMARY KEY (userName,userId))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


