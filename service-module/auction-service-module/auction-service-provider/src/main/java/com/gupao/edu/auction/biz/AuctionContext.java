package com.gupao.edu.auction.biz;

import com.gupao.edu.auction.dto.AuctionWorkRequest;

/*
 * 描述:
 * @auth zhengkk19738
 * @time 2018/11/7
 */
public class AuctionContext {

    private AuctionWorkRequest auctionWorkRequest ;

    public AuctionWorkRequest getAuctionWorkRequest() {
        return auctionWorkRequest;
    }

    public void setAuctionWorkRequest(AuctionWorkRequest auctionWorkRequest) {
        this.auctionWorkRequest = auctionWorkRequest;
    }
}
