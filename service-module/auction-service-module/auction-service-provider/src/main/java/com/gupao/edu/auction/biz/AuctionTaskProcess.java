package com.gupao.edu.auction.biz;

/*
 * 描述: 竞拍任务类
 * @auth zhengkk19738
 * @time 2018/9/7
 */
public interface AuctionTaskProcess<T> {

    /**
     * 执行竞拍
     * @param auctionContext
     * @return
     */
    T doAuction(T auctionContext);


}
