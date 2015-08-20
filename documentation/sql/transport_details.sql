CREATE TABLE IF NOT EXISTS `transport_details` (
  `transport_id` BIGINT(20) NOT NULL unique ,
  `wareId` varchar(255) NOT NULL,
  `piece` BIGINT(10),
  PRIMARY KEY (transport_id))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;
