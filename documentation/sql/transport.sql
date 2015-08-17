CREATE TABLE IF NOT EXISTS `Transport` (
  `fromWarehouseId` BIGINT(20) NOT NULL,
  `toWarehouseId` BIGINT(20) NOT NULL,
  `status` VARCHAR(255),
  PRIMARY KEY (fromWarehouseId, toWarehouseId))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;