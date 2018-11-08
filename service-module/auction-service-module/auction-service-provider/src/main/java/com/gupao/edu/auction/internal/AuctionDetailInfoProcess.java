package com.gupao.edu.auction.internal;

import com.gupao.edu.auction.dal.entity.AuctionDetail;
import com.gupao.edu.serviceext.common.dto.BaseResponse;
import org.springframework.stereotype.Component;

/*
 * 描述:
 * @auth zhengkk19738
 * @time 2018/11/8
 */

@Component
public class AuctionDetailInfoProcess {

    public BaseResponse buildAuctionDetailInfo(AuctionDetail auctionDetail) {
        BaseResponse baseResponse = new BaseResponse();
        return baseResponse.success();
    }
}
