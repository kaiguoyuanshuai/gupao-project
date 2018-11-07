package com.gupao.edu.auction.service;

import com.gupao.edu.auction.dto.AuctionActivityInfoDto;
import com.gupao.edu.auction.dto.AuctionDetailRequest;

/*
 * 描述:
 * @auth zhengkk19738
 * @time 2018/11/7
 */
public interface AuctionActivityQueryService {

    /**
     * 获取竞购活动请求
     *
     * @param auctionDetailRequest
     * @return
     */
    public AuctionActivityInfoDto queryAuctionActivity(AuctionDetailRequest auctionDetailRequest);




}
