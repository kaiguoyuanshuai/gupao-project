package com.gupao.edu.auction.dto;

import com.gupao.edu.serviceext.common.dto.BaseRequest;

/*
 * 描述:
 * @auth zhengkk19738
 * @time 2018/9/28
 */
public class AuctionWorkRequest extends BaseRequest {

    /**
     * 竞购活动ID
     */
    public String auctionActivityId;

    /**
     * 竞购活动获取的秘钥信息
     */
    private String auctionKey;

    public String getAuctionActivityId() {
        return auctionActivityId;
    }

    public void setAuctionActivityId(String auctionActivityId) {
        this.auctionActivityId = auctionActivityId;
    }

    public String getAuctionKey() {
        return auctionKey;
    }

    public void setAuctionKey(String auctionKey) {
        this.auctionKey = auctionKey;
    }
}
