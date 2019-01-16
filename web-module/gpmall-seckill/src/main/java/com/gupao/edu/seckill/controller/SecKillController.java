package com.gupao.edu.seckill.controller;

import com.google.common.collect.Lists;
import com.gupao.edu.seckill.business.SecKillBusinessInvokerService;
import com.gupao.edu.seckill.constant.SecKillConstant;
import com.gupao.edu.seckill.dto.SeckillRequest;
import com.gupao.edu.seckill.service.MockInitSecKillService;
import com.gupao.edu.web.annotations.Anoymous;
import com.gupao.edu.web.controller.BaseController;
import com.gupao.edu.web.support.ResponseData;
import org.redisson.api.RScript;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

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

    @Autowired
    private RedissonClient redisson;


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
        SeckillRequest seckillRequest = new SeckillRequest();
        seckillRequest.setSeckillId(seckillId);
        secKillBusinessInvokerService.seckill(seckillRequest);
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


    /**
     * 查看秒杀订单
     *
     * @param seckillId
     * @return
     */
    @RequestMapping("/lua_init")
    @Anoymous
    public ResponseData lua(String seckillId) throws ExecutionException, InterruptedException {

        RScript s = redisson.getScript();

        String res = s.scriptLoad(SecKillConstant.INIT_SECKILL_GOODS__COUNT_SCRIPT);
        // 再通过SHA值调用脚本
        Object eval = redisson.getScript().evalSha(RScript.Mode.READ_WRITE,
                res,
                RScript.ReturnType.INTEGER, Lists.newArrayList(seckillId), "10000", "1020");
        return ResponseData.SUCCESS(eval);
    }


    /**
     * 查看秒杀订单
     *
     * @param seckillId
     * @return
     */
    @RequestMapping("/lua_decr")
    @Anoymous
    public ResponseData lua_decr(String seckillId) throws ExecutionException, InterruptedException {

        RScript s = redisson.getScript();

        String res = s.scriptLoad(SecKillConstant.DECR_SECKILL_GOODS__COUNT_SCRIPT);
        // 再通过SHA值调用脚本
        Object eval = redisson.getScript().evalSha(RScript.Mode.READ_WRITE,
                res,
                RScript.ReturnType.INTEGER, Lists.newArrayList(seckillId));
        return ResponseData.SUCCESS(eval);
    }

}
