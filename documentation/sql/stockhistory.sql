CREATE TABLE IF NOT EXISTS `stockhistory` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `changeTime` datetime DEFAULT NULL,
  `piece` int(11) NOT NULL,
  `ware` varchar(255) DEFAULT NULL,
  `warehouse` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=12 ;
