package com.gupao.edu.auction.internal;

import com.gupao.edu.auction.constants.AuctionCacheKeyConstants;
import com.gupao.edu.auction.dal.entity.AuctionDetail;
import com.gupao.edu.serviceext.common.dto.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/*
 * 描述:
 * @auth zhengkk19738
 * @time 2018/11/8
 */
@Component
public abstract class AuctionPriceThresholdProcess {


    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 构建初始的架构缓存
     *
     * @return
     */
    public BaseResponse buildAuctionThresholdPrice(AuctionDetail auctionDetail, Long start) {

        BaseResponse baseResponse = new BaseResponse();
        String securityKey = "";

        Boolean addResult = redisTemplate.opsForZSet().add(AuctionCacheKeyConstants.AUCTION_SECURITY_KEY + auctionDetail.getId(), securityKey, start);

        if (addResult) {
            return baseResponse.success();
        }
        return baseResponse.fail();
    }

    public abstract BaseResponse buildModelAuctionPriceWay(AuctionDetail auctionDetail);


    public abstract String priceType();
}
