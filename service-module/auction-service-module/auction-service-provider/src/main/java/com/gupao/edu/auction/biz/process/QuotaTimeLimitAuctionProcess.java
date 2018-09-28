package com.gupao.edu.auction.biz.process;

import com.gupao.edu.auction.biz.AbstractAuctionTaskProcess;
import org.springframework.stereotype.Service;

/*
 * 描述: 定额限定时间竞购模式
 * @auth zhengkk19738
 * @time 2018/9/28
 */

@Service("quotaTimeLimitAuctionProcess")
public class QuotaTimeLimitAuctionProcess extends AbstractAuctionTaskProcess {

    @Override
    public void doProcess() {

    }

    @Override
    protected int getAuctionType() {
        return 0;
    }
}
