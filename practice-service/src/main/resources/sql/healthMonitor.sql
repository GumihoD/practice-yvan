DROP TABLE  if exists `practice_yvan`.`health_monitor`;
CREATE TABLE `practice_yvan`.`health_monitor` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` varchar(50) NOT NULL COMMENT '用户编号',
  `is_abnormal` tinyint NOT NULL COMMENT '是否异常',
  `is_upload` tinyint NOT NULL COMMENT '是否上传',
  `ogpr` varchar(10) NOT NULL COMMENT '血氧脉率',
  `spo2` varchar(10) NOT NULL COMMENT '血氧值',
  `testTime` datetime NULL COMMENT '测量时间',
  `created_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='血氧信息表';