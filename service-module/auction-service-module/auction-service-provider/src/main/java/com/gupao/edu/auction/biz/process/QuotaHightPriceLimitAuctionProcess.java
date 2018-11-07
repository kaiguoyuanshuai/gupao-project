package com.gupao.edu.auction.biz.process;

import com.gupao.edu.auction.biz.AbstractAuctionTaskProcess;
import org.springframework.stereotype.Service;

/*
 * 描述: 定额限定价格模式
 * @auth zhengkk19738
 * @time 2018/9/28
 */
@Service("quotaHightPriceLimitAuctionProcess")
public class QuotaHightPriceLimitAuctionProcess extends AbstractAuctionTaskProcess {


    @Override
    public void doProcess(Object o) {

        //判断key是否存在

        //对比获取到的key是否一致

        //移除key是否大于1

        //如果大于1表示成功

    }

    @Override
    protected int getAuctionType() {
        return 0;
    }

}
