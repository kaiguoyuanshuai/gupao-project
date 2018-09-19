package com.gupao.edu.auction.service;

import com.gupao.edu.auction.dto.AuctionDetailRequest;
import com.gupao.edu.auction.dto.AuctionDetailResponse;

/*
 * 描述: 竞拍活动操作相关
 * @auth zhengkk19738
 * @time 2018/9/6
 */
public interface AuctionDetailService {

    /**
     * 存储竞购活动细节内容
     *
     * @param auctionDetailRequest
     * @return
     */
    public AuctionDetailResponse saveAuctionDetail(AuctionDetailRequest auctionDetailRequest);
}


