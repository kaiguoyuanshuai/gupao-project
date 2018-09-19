package com.gupao.edu.auction.service;

import com.gupao.edu.auction.biz.AuctionTaskProcess;
import com.gupao.edu.auction.dal.persistence.AuctionDetailMapper;
import com.gupao.edu.auction.dto.AuctionDetailRequest;
import com.gupao.edu.auction.dto.AuctionDetailResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
 * 描述:
 * @auth zhengkk19738
 * @time 2018/9/6
 */
@Service
public class AuctionDetailServiceImpl implements AuctionDetailService {

    private AuctionTaskProcess auctionTaskProcess;

    @Autowired
    private AuctionDetailMapper auctionDetailMapper;

    @Override
    public AuctionDetailResponse saveAuctionDetail(AuctionDetailRequest auctionDetailRequest) {

        //存储相关活动内容

        //创建活动细节内容

        //存储到redis 中

        return null;
    }
}
