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
