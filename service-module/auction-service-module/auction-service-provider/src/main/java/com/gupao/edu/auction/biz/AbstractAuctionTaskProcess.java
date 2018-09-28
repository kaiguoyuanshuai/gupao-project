package com.gupao.edu.auction.biz;

/*
 * 描述: 竞拍任务类
 * @auth zhengkk19738
 * @time 2018/9/7
 */
public abstract class AbstractAuctionTaskProcess implements AuctionTaskProcess {

    @Override
    public Object doAuction(Object auctionContext) {

        doProcess();

        return null;

    }

    public abstract void doProcess();


    /**
     * 返回当前竞价类型
     *
     * @return
     */
    protected abstract int getAuctionType();
}
