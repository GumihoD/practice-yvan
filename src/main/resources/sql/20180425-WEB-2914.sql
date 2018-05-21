
-- 编码字典表
CREATE TABLE code_dictionary (
  id INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
  variable_key VARCHAR(100) NOT NULL COMMENT '变量键值',
  variable_value VARCHAR(1000) NOT NULL COMMENT '变量内容',
  variable_name VARCHAR(100) NOT NULL COMMENT '变量名称',
  variable_type VARCHAR(50) NOT NULL COMMENT '变量类型',
  created_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  updated_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  CONSTRAINT uk_variable_key UNIQUE uk_variable_key (variable_key)
) ENGINE = InnoDB COMMENT '编码字典表';

-- 提示信息表
CREATE TABLE s62.`brief_message_info` (
  `id` INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
  `app_id` VARCHAR(24) NOT NULL COMMENT '服务ID',
  `message_type` VARCHAR(24) NOT NULL COMMENT '信息类型',
  `message_code` VARCHAR(64) NOT NULL COMMENT '信息编码',
  `message_content` VARCHAR(1024) NOT NULL COMMENT '信息内容',
  `message_describe` VARCHAR(1024) NOT NULL COMMENT '信息描述',
  `created_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  CONSTRAINT uk_message_code UNIQUE (message_code)
) ENGINE = InnoDB COMMENT '提示信息表';
