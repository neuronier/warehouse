CREATE TABLE IF NOT EXISTS `Manager` (
  `id` bigint(20) NOT NULL unique AUTO_INCREMENT,
  `userName` varchar(255) DEFAULT NULL,
  `warehouseId` varchar(255) DEFAULT NULL,
  PRIMARY KEY (userName, warehouseId)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1;
