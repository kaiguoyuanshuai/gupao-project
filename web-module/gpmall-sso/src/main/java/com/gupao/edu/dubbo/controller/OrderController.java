package com.gupao.edu.dubbo.controller;

import com.gupao.edu.web.annotations.Anoymous;
import com.gupao.edu.web.controller.BaseController;
import com.gupao.edu.web.support.ResponseData;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * 描述: 测试支付订单场景
 * @auth zhengkk19738
 * @time 2019/1/9
 */
@RestController
public class OrderController extends BaseController {


    /**
     * 测试 分布式事物的问题
     *
     * @param orderId
     * @return
     */
    @RequestMapping("/pay")
    @Anoymous
    public ResponseData pay(String orderId) {
        //初始化预购库存 =  真实库存 *2  --》 2倍库存的人数能够进入秒杀队列

        //初始化真实库存 = 货物的真实库存


        return ResponseData.SUCCESS();
    }


}
