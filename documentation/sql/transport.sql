CREATE TABLE IF NOT EXISTS `transport` (
	`id` BIGINT(20) not null unique auto_increment,
	`fromWarehouse_id` BIGINT(20) NOT NULL,
	`toWarehouse_id` BIGINT(20) NOT NULL,
	`status` VARCHAR(255),
	PRIMARY KEY (fromWarehouse_id, toWarehouse_id))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;