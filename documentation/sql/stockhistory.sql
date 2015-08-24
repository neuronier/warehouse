CREATE TABLE IF NOT EXISTS `stockhistory` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `changeTime` datetime DEFAULT NULL,
  `new_piece` int(11) NOT NULL,
  `old_piece` int(11) NOT NULL,
  `ware_id` bigint(20) DEFAULT NULL,
  `warehouse_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKD11AE8BEC69CFA64` (`ware_id`),
  KEY `FKD11AE8BE4ED7EF50` (`warehouse_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

ALTER TABLE `stockhistory`
  ADD CONSTRAINT `FKD11AE8BE4ED7EF50` FOREIGN KEY (`warehouse_id`) REFERENCES `warehouse` (`id`),
  ADD CONSTRAINT `FKD11AE8BEC69CFA64` FOREIGN KEY (`ware_id`) REFERENCES `ware` (`id`);