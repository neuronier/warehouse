INSERT INTO `role`(`roleName`) VALUES ('ROLE_ADMIN');
INSERT INTO `role`(`roleName`) VALUES ('ROLE_USER');

INSERT INTO `user` (`email`, `enabled`, `fullName`, `password`, `phoneNumber`, `userName`) VALUES
('admin@admin.admin', 0, 'Adminus Maximus', '$2a$10$pNotpuCVFsm6K9Zi3cgUI.b3YsgDdDFD3DEsbWu3pYiVBXbV3sg7G', '0620321456789', 'admin');

INSERT INTO `userrolemap` (`userName`, `roleName`) VALUES ('admin', 'ROLE_USER');
INSERT INTO `userrolemap` (`userName`, `roleName`) VALUES ('admin', 'ROLE_ADMIN');