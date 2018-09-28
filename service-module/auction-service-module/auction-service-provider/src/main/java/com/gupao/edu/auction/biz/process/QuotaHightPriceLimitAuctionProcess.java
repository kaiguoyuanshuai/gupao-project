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
    public void doProcess() {

    }

    @Override
    protected int getAuctionType() {
        return 0;
    }

}
