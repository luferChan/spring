/* 员工信息管理系统1.0.0 脚本文件  */

/** 新增帐号数据表 */
DROP TABLE IF EXISTS `te_account`;
CREATE TABLE `te_account` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id号',
  `timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '乐观锁-时间戳',
  `creation` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `type` int(5) DEFAULT NULL COMMENT '类型 0-超级管理员 1-普通管理员',
  `state` int(5) DEFAULT NULL COMMENT '状态 0-正常 1-删除',
  `username` varchar(128) DEFAULT NULL,
  `password` varchar(128) DEFAULT NULL,
  `nickname` varchar(128) DEFAULT NULL,
  `creator` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/** 插入超级管理员的数据*/
INSERT INTO `te_account` VALUES(NULL,NOW(),NOW(),0,0,'admin','e10adc3949ba59abbe56e057f20f883e','超级管理员','System'); 