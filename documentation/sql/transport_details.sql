CREATE TABLE IF NOT EXISTS `transport_details` (
  `transport_id` BIGINT(20) NOT NULL unique ,
  `from_warehouseId` varchar(255) NOT NULL,
  `to_warehouseId` varchar(255) NOT NULL,
  `wareId` varchar(255) NOT NULL,
  `piece` BIGINT(10),
  PRIMARY KEY (from_warehouseId, to_warehouseId, wareId))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;
