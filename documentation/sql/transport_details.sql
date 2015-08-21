CREATE TABLE IF NOT EXISTS `transport_details` (
  `id` BIGINT(20) NOT NULL unique auto_increment,
  `transport_id` BIGINT(20) NOT NULL unique,
  `ware_id` varchar(255) NOT NULL,
  `piece` BIGINT(10),
  PRIMARY KEY (id))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;
