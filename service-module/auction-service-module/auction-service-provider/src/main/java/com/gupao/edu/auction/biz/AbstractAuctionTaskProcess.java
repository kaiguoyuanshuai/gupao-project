package com.gupao.edu.auction.biz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
 * 描述: 竞拍任务类
 * @auth zhengkk19738
 * @time 2018/9/7
 */
public abstract class AbstractAuctionTaskProcess<AuctionContext> implements AuctionTaskProcess {

    protected Logger LOGGER = LoggerFactory.getLogger(AbstractAuctionTaskProcess.class);

    @Override
    public Object doAuction(Object auctionContext) {

        //减库存

        doProcess((AuctionContext) auctionContext);

        return null;

    }

    public abstract void doProcess(AuctionContext auctionContext);


    /**
     * 返回当前竞价类型
     *
     * @return
     */
    protected abstract int getAuctionType();
}
