package com.gupao.edu.seckill.controller;

import com.gupao.edu.seckill.business.SecKillBusinessInvokerService;
import com.gupao.edu.seckill.service.MockInitSecKillService;
import com.gupao.edu.web.annotations.Anoymous;
import com.gupao.edu.web.controller.BaseController;
import com.gupao.edu.web.support.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * 描述: 秒杀测试类
 * @auth zhengkk19738
 * @time 2019/1/9
 */
@RestController
public class SecKillController extends BaseController {


    @Autowired
    private MockInitSecKillService mockInitSecKillService;

    @Autowired
    private SecKillBusinessInvokerService secKillBusinessInvokerService;

    /**
     * 初始化数据
     *
     * @param seckillId
     * @return
     */
    @RequestMapping("/initData")
    @Anoymous
    public ResponseData initData(String seckillId) {
        //初始化预购库存 =  真实库存 *2  --》 2倍库存的人数能够进入秒杀队列
        mockInitSecKillService.initData(seckillId);
        return ResponseData.SUCCESS();
    }


    /**
     * 秒杀
     *
     * @param seckillId
     * @return
     */
    @RequestMapping("/kill")
    @Anoymous
    public ResponseData kill(String seckillId) {

        return ResponseData.SUCCESS();
    }

    /**
     * 查看秒杀订单
     *
     * @param seckillId
     * @return
     */
    @RequestMapping("/order")
    @Anoymous
    public ResponseData order(String seckillId) {

        return ResponseData.SUCCESS();
    }


}
