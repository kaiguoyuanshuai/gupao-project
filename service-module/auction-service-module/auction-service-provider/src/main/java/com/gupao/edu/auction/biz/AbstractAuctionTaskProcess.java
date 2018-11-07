package com.gupao.edu.auction.biz;

/*
 * 描述: 竞拍任务类
 * @auth zhengkk19738
 * @time 2018/9/7
 */
public abstract class AbstractAuctionTaskProcess<AuctionContext> implements AuctionTaskProcess {

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
