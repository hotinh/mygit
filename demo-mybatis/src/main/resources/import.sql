drop table if exists city;

create table city (id int primary key auto_increment, name varchar, state varchar, country varchar);

insert into city (name, state, country) values ('San Francisco', 'CA', 'US');

/**
 * MySQL
 * CREATE TABLE `city_demo` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '城市编号',
  `name` varchar(25) DEFAULT NULL COMMENT '省份编号',
  `state` varchar(25) DEFAULT NULL COMMENT '城市名称',
  `country` varchar(25) DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
 * 
 */