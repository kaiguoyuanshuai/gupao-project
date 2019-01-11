CREATE TABLE `seckill-activity` (
  `id` int(11) NOT NULL,
  `seckill_name` varchar(255) DEFAULT NULL COMMENT '秒杀名称',
  `seckill_goods_name` varchar(255) DEFAULT NULL COMMENT '货物名称',
  `seckill_goods_num` int(11) DEFAULT NULL COMMENT '货物数量',
  `seckill_start_time` datetime DEFAULT NULL COMMENT '秒杀开始时间',
  `seckill_end_time` datetime(6) DEFAULT NULL COMMENT '秒杀结束时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='秒杀活动';


INSERT INTO `seckill-activity` (`id`, `seckill_name`, `seckill_goods_name`, `seckill_goods_num`, `seckill_start_time`, `seckill_end_time`) VALUES ('1', '测试活动', 'iPhone MAX', '10', '2019-01-11 14:27:27', '2019-03-11 14:27:33.000000');

