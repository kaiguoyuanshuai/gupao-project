package com.gupao.edu.auction.service;

import com.gupao.edu.auction.dto.AuctionWorkRequest;
import com.gupao.edu.auction.dto.AuctionWorkResponse;

/*
 * 描述: 竞购线程类
 * @auth zhengkk19738
 * @time 2018/9/28
 */
public interface AuctionWorkService {

    /**
     * 参与竞购方式
     * @param auctionWorkRequest
     * @return
     */
    public AuctionWorkResponse doAuctionWork(AuctionWorkRequest auctionWorkRequest);

}
