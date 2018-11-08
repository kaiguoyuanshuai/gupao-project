package com.gupao.edu.auction.internal;

import com.gupao.edu.auction.dal.entity.AuctionDetail;
import com.gupao.edu.serviceext.common.dto.BaseResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

/*
 * 描述:
 * @auth zhengkk19738
 * @time 2018/11/8
 */
@Service("hightPriceLimitModelPriceThresholdProcess")
public class HightPriceLimitModelPriceThresholdProcess extends AuctionPriceThresholdProcess {

    @Override
    public BaseResponse buildModelAuctionPriceWay(AuctionDetail auctionDetail) {
        BaseResponse baseResponse = new BaseResponse();
        if (!StringUtils.equals(auctionDetail.getAuctionMode(), "TODO")) {
            return baseResponse.fail();
        }

        BigDecimal buildTimes = (auctionDetail.getAuctionFinalPrice().subtract(auctionDetail.getAuctionStartPrice()))
                .divide(new BigDecimal(auctionDetail.getAuctionPerPrice()), 0, RoundingMode.DOWN);
        int times = buildTimes.intValue();


        //算出需要设置多少次
        for (int j = 1; j <= times; j++) {
            long price = new BigDecimal(auctionDetail.getAuctionPerPrice()).multiply(new BigDecimal(times)).longValue();
            BaseResponse baseResponse1 = buildAuctionThresholdPrice(auctionDetail, price);
        }

        return baseResponse.success();
    }

    @Override
    public String priceType() {
        return "HightPriceLimitModel";
    }
}
