-- noinspection SqlNoDataSourceInspectionForFile
-- noinspection SqlDialectInspectionForFile
SET MODULE Mysql;

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `birthday` datetime DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `gender` int(11) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;


INSERT INTO `user` (`id`,`birthday`,`email`,`gender`,`password`,`username`,`create_date`,`last_modified_date`)
VALUES (1,NULL,NULL,NULL,'password','username','2016-08-05 11:02:56','2016-08-05 11:02:56');
INSERT INTO `user` (`id`,`birthday`,`email`,`gender`,`password`,`username`,`create_date`,`last_modified_date`)
VALUES (2,'2016-08-05 10:59:45','123@123.com',1,'123123','yvan','2016-08-05 11:02:56','2016-08-05 11:02:56');
INSERT INTO `user` (`id`,`birthday`,`email`,`gender`,`password`,`username`,`create_date`,`last_modified_date`)
VALUES (3,'2016-08-05 11:02:56','123@123.com',1,'123123','yvan','2016-08-05 11:02:56','2016-08-05 11:02:56');


