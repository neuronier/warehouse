create table UserRoleMap (id bigint not null auto_increment, role_name varchar(255), user_name varchar(255), primary key (id));
alter table UserRoleMap add index FKA37CDA9B979E02F4 (role_name), add constraint FKA37CDA9B979E02F4 foreign key (role_name) references Role (roleName);
alter table UserRoleMap add index FKA37CDA9B97D4D014 (user_name), add constraint FKA37CDA9B97D4D014 foreign key (user_name) references User (userName);