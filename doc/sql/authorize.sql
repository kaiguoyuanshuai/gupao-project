
-- ----------------------------
-- Table structure for t_security_auth
-- ----------------------------
DROP TABLE IF EXISTS `t_security_auth`;
CREATE TABLE `t_security_auth` (
  `F_ID` varchar(45) NOT NULL,
  `F_AUTH_CODE` varchar(80) DEFAULT NULL,
  `F_AUTH_TYPE` varchar(100) DEFAULT NULL,
  `F_RESOURCE_ID` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`F_ID`),
  KEY `I_T_SECURITY_AUTH_CODE` (`F_AUTH_CODE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_security_auth
-- ----------------------------
INSERT INTO `t_security_auth` VALUES ('index', 'ROLE_index', 'MENU', 'index');
INSERT INTO `t_security_auth` VALUES ('indexPage', 'ROLE_indexPage', 'PAGE', 'indexPage');

-- ----------------------------
-- Table structure for t_security_data_filter
-- ----------------------------
DROP TABLE IF EXISTS `t_security_data_filter`;
CREATE TABLE `t_security_data_filter` (
  `F_ID` varchar(45) NOT NULL,
  `F_EXPRESSION` text,
  `F_SIMPLE_DESC` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`F_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_security_data_filter
-- ----------------------------

-- ----------------------------
-- Table structure for t_security_menu
-- ----------------------------
DROP TABLE IF EXISTS `t_security_menu`;
CREATE TABLE `t_security_menu` (
  `F_ID` varchar(45) NOT NULL,
  `F_MENU_TITLE` varchar(50) DEFAULT NULL,
  `F_ICON` varchar(200) DEFAULT NULL,
  `F_CAPTION` varchar(500) DEFAULT NULL,
  `F_URL` varchar(2038) DEFAULT NULL,
  `F_TYPE` varchar(100) DEFAULT NULL,
  `F_TARGET` varchar(100) DEFAULT NULL,
  `F_ENABLE` decimal(1,0) DEFAULT NULL,
  `F_PARENT_ID` varchar(45) DEFAULT NULL,
  `F_ORDER` int(11) DEFAULT NULL,
  PRIMARY KEY (`F_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_security_menu
-- ----------------------------
INSERT INTO `t_security_menu` VALUES ('index', '首页', 'fa-home', '默认进入的首页', '/main/default.pagelet', '', '', '1', '', '0');

-- ----------------------------
-- Table structure for t_security_menu_page
-- ----------------------------
DROP TABLE IF EXISTS `t_security_menu_page`;
CREATE TABLE `t_security_menu_page` (
  `F_PAGE_ID` varchar(45) DEFAULT NULL,
  `F_MENU_ID` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_security_menu_page
-- ----------------------------
INSERT INTO `t_security_menu_page` VALUES ('initIndexPage', 'index');
INSERT INTO `t_security_menu_page` VALUES ('indexPage', 'index');

-- ----------------------------
-- Table structure for t_security_page
-- ----------------------------
DROP TABLE IF EXISTS `t_security_page`;
CREATE TABLE `t_security_page` (
  `F_ID` varchar(45) NOT NULL,
  `F_URL` varchar(2038) DEFAULT NULL,
  `F_SIMPLE_DESC` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`F_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_security_page
-- ----------------------------
INSERT INTO `t_security_page` VALUES ('indexPage', '/index.htm', '');

-- ----------------------------
-- Table structure for t_security_page_operation
-- ----------------------------
DROP TABLE IF EXISTS `t_security_page_operation`;
CREATE TABLE `t_security_page_operation` (
  `F_ID` varchar(45) NOT NULL,
  `F_PAGE_ID` varchar(45) DEFAULT NULL,
  `F_ELEMENT` varchar(80) DEFAULT NULL,
  `F_SIMPLE_DESC` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`F_ID`),
  KEY `I_PAGE_OPERATION` (`F_ELEMENT`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_security_page_operation
-- ----------------------------

-- ----------------------------
-- Table structure for t_security_role
-- ----------------------------
DROP TABLE IF EXISTS `t_security_role`;
CREATE TABLE `t_security_role` (
  `F_ID` varchar(45) NOT NULL,
  `F_ROLE_NAME` varchar(50) DEFAULT NULL,
  `F_SIMPLE_DESC` varchar(500) DEFAULT NULL,
  `F_DEFAULT_ROLE` decimal(1,0) DEFAULT NULL,
  PRIMARY KEY (`F_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_security_role
-- ----------------------------
INSERT INTO `t_security_role` VALUES ('1', '超级管理员', '系统默认的管理员，拥有最高级别权限，仅可用于运维，不参与应用的业务处理(不能赋予定义的用户此角色)', '0');

-- ----------------------------
-- Table structure for t_security_role_auth
-- ----------------------------
DROP TABLE IF EXISTS `t_security_role_auth`;
CREATE TABLE `t_security_role_auth` (
  `F_ROLE_ID` varchar(45) DEFAULT NULL,
  `F_AUTH_ID` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_security_role_auth
-- ----------------------------
INSERT INTO `t_security_role_auth` VALUES ('1', 'index');
INSERT INTO `t_security_role_auth` VALUES ('1', 'indexPage');

-- ----------------------------
-- Table structure for t_security_user_role
-- ----------------------------
DROP TABLE IF EXISTS `t_security_user_role`;
CREATE TABLE `t_security_user_role` (
  `F_ROLE_ID` varchar(45) DEFAULT NULL,
  `F_USER_ID` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_security_user_role
-- ----------------------------
INSERT INTO `t_security_user_role` VALUES ('1', '1');