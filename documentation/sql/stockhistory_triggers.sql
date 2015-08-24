CREATE TRIGGER `stockhistorytriggerinsert` AFTER INSERT ON `stock` FOR EACH ROW INSERT INTO `stockhistory`(`changeTime`, `new_piece`, `ware_id`, `warehouse_id`) VALUES (NOW(),NEW.piece,NEW.ware_id,NEW.warehouse_id);
CREATE TRIGGER `stockhistorytriggerupdate` AFTER UPDATE ON `stock` FOR EACH ROW INSERT INTO `stockhistory`(`changeTime`, `new_piece`, `old_piece`, `ware_id`, `warehouse_id`) VALUES (NOW(),NEW.piece,OLD.piece,OLD.ware_id,OLD.warehouse_id);