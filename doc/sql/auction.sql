/*
Navicat MySQL Data Transfer

Target Server Type    : MYSQL
Target Server Version : 50616
File Encoding         : 65001

Date: 2018-09-06 18:19:16
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for auction_detail
-- ----------------------------
DROP TABLE IF EXISTS `auction_detail`;
CREATE TABLE `auction_detail` (
  `id` int(11) NOT NULL,
  `product_id` int(11) DEFAULT NULL COMMENT '竞拍的属性对象',
  `auction_mode` varchar(255) DEFAULT NULL COMMENT '竞拍模式 -时间模式  -价格模式',
  `auction_start_time` datetime DEFAULT NULL COMMENT '竞拍开始时间',
  `auction_dend_lime` datetime DEFAULT NULL COMMENT '竞拍截止时间,两种模式都需要截止时间',
  `auction_product_minimum_price` decimal(10,2) DEFAULT NULL COMMENT '成交最低价，两种模式都需要符合最低价',
  `auction_per_price` varchar(255) DEFAULT NULL COMMENT '每次加价幅度',
  `auction_final_price` decimal(10,2) DEFAULT NULL COMMENT '如果是时间模式，则为空，如果是价格模式，则需要预设价格',
  `auction_actual_price` decimal(10,2) DEFAULT NULL COMMENT '实际最终成交价格（竞拍没有成功，则展示出价最高价格）',
  `auction_status` varchar(255) DEFAULT NULL COMMENT '竞拍状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='竞拍细节表';

-- ----------------------------
-- Records of auction_detail
-- ----------------------------

-- ----------------------------
-- Table structure for auction_product
-- ----------------------------
DROP TABLE IF EXISTS `auction_product`;
CREATE TABLE `auction_product` (
  `id` int(11) NOT NULL,
  `product_name` varchar(255) DEFAULT NULL COMMENT '商品名称',
  `product_price` decimal(10,2) DEFAULT NULL COMMENT '价格',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='竞拍产品内容';

-- ----------------------------
-- Records of auction_product
-- ----------------------------
