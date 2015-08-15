CREATE TABLE IF NOT EXISTS `warehouse_user` (
  `warehouseId` BIGINT(20) NOT NULL,
  `userId` BIGINT(20) NOT NULL ,
  PRIMARY KEY (warehouseId,userId))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;