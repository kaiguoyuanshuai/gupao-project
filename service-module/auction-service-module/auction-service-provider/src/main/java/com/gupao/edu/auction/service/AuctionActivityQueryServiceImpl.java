package com.gupao.edu.auction.service;

import com.gupao.edu.auction.constants.AuctionCacheKeyConstants;
import com.gupao.edu.auction.dal.entity.AuctionDetail;
import com.gupao.edu.auction.dal.persistence.AuctionDetailMapper;
import com.gupao.edu.auction.dto.AuctionActivityInfoDto;
import com.gupao.edu.auction.dto.AuctionDetailRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/*
 * 描述:
 * 获取竞购活动信息，从缓存信息，需要防止缓存击穿等问题
 * @auth zhengkk19738
 * @time 2018/11/7
 */

@Service("auctionActivityQueryService")
public class AuctionActivityQueryServiceImpl implements AuctionActivityQueryService {


    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private AuctionDetailMapper auctionDetailMapper;

    @Override
    public AuctionActivityInfoDto queryAuctionActivity(AuctionDetailRequest auctionDetailRequest) {

        if (auctionDetailRequest == null) {
            return null;
        }

        AuctionActivityInfoDto auctionActivityInfoDto =
                (AuctionActivityInfoDto) redisTemplate.opsForValue().get(AuctionCacheKeyConstants.AUCTION_ACTIVITY_DETAIL + auctionDetailRequest.getId());

        if (auctionActivityInfoDto == null) {
            AuctionDetail auctionDetail = auctionDetailMapper.selectByPrimaryKey(auctionDetailRequest.getId());
            auctionActivityInfoDto = convertAuctionActivityInfoDto(auctionDetail);
            if (auctionDetail != null) {
                redisTemplate.opsForValue().set(AuctionCacheKeyConstants.AUCTION_ACTIVITY_DETAIL + auctionDetailRequest.getId(), auctionActivityInfoDto);
            }
        }

        return auctionActivityInfoDto;
    }

    /**
     * 将AuctionDetail对象转为AuctionActivityInfoDto对象
     *
     * @param auctionDetail
     * @return
     */
    private AuctionActivityInfoDto convertAuctionActivityInfoDto(AuctionDetail auctionDetail) {

        AuctionActivityInfoDto auctionActivityInfoDto = new AuctionActivityInfoDto();


        return auctionActivityInfoDto;
    }
}
