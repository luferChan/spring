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

/** 新增导航系统模块数据表 */
DROP TABLE IF EXISTS `te_module`;
CREATE TABLE `te_module` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
`timestamp` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '乐观锁-时间戳',
  `name` varchar(64) DEFAULT NULL COMMENT '模块名称',
  `code` varchar(24) DEFAULT NULL COMMENT '模块编号',
  `superCode` varchar(24) DEFAULT NULL COMMENT '上级模块编号',
  `page` varchar(128) DEFAULT NULL COMMENT '跳转页面地址',
  `level` int(2) DEFAULT NULL COMMENT '模块等级',
  PRIMARY KEY (`id`),
  UNIQUE KEY `code` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/** 插入模块数据*/
INSERT INTO `te_module` VALUES (NULL, NOW(),'员工信息管理','01','0',NULL,0);
INSERT INTO `te_module` VALUES (NULL, NOW(),'实习员工','01001','01','employee_internship.html',1);
INSERT INTO `te_module` VALUES (NULL, NOW(),'正式员工','01002','01','employee_formal.html',1);
INSERT INTO `te_module` VALUES (NULL, NOW(),'培训项目','01003','01','employee_training.html',1);
INSERT INTO `te_module` VALUES (NULL, NOW(),'离职员工','01004','01','employee_departure.html',1);
INSERT INTO `te_module` VALUES (NULL, NOW(),'考勤与薪酬','02','0',NULL,0);
INSERT INTO `te_module` VALUES (NULL, NOW(),'员工考勤','02001','02','employee_attendance.html',1);
INSERT INTO `te_module` VALUES (NULL, NOW(),'员工薪酬','02002','02','employee_emolument.html',1);
INSERT INTO `te_module` VALUES (NULL, NOW(),'部门与职位','03','0',NULL,0);
INSERT INTO `te_module` VALUES (NULL, NOW(),'部门管理','03001','03','company_department.html',1);
INSERT INTO `te_module` VALUES (NULL, NOW(),'职位管理','03002','03','company_position.html',1);
INSERT INTO `te_module` VALUES (NULL, NOW(),'权限管理','04','0',NULL,0);
INSERT INTO `te_module` VALUES (NULL, NOW(),'帐号管理','04001','04','system_account.html',1);
INSERT INTO `te_module` VALUES (NULL, NOW(),'角色管理','04002','04','system_role.html',1);