CREATE TABLE `integral_account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL COMMENT '用户编号',
  `user_name` varchar(255) DEFAULT NULL,
  `score_balance` varchar(255) DEFAULT NULL COMMENT '积分总额',
  `available_score_balance` varchar(255) DEFAULT NULL COMMENT '可用积分',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;




CREATE TABLE `integral_account_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `integral_account_id` int(11) DEFAULT NULL,
  `outer_business_code` varchar(255) DEFAULT NULL,
  `opration_score` varchar(255) DEFAULT NULL COMMENT '操作分值',
  `available_score` varchar(255) DEFAULT NULL COMMENT '可用积分',
  `opration_type` varchar(255) DEFAULT NULL COMMENT '操作类型',
  `score_type` varchar(255) DEFAULT NULL COMMENT '积分业务类型',
  `score_status` varchar(255) DEFAULT NULL COMMENT '积分状态',
  `score_source` varchar(255) DEFAULT NULL COMMENT '积分来源',
  `is_deleted` varchar(255) DEFAULT NULL,
  `gmt_create` varchar(255) DEFAULT NULL,
  `gmt_modify` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='积分变更明细表';

