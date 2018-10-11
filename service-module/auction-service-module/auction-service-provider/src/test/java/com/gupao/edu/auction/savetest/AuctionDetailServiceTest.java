package com.gupao.edu.auction.savetest;

import com.gupao.edu.auction.AuctionModelEnum;
import com.gupao.edu.auction.dto.AuctionDetailRequest;
import com.gupao.edu.auction.dto.AuctionDetailResponse;
import com.gupao.edu.auction.service.AuctionDetailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;

/*
 * 描述:
 * @auth zhengkk19738
 * @time 2018/10/11
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:META-INF/spring/service-common.xml", "classpath:META-INF/spring/service-transaction.xml"})
@Transactional(transactionManager = "transactionManager")
@Rollback(true)
public class AuctionDetailServiceTest {


    @Autowired
    private AuctionDetailService auctionDetailService;


    @Test
    public void testInsert() {
        AuctionDetailRequest auctionDetailRequest = new AuctionDetailRequest();
        auctionDetailRequest.setId(100001);
        auctionDetailRequest.setProductId(10);
        auctionDetailRequest.setAuctionPerPrice("1000");
        auctionDetailRequest.setAuctionProductMinimumPrice(new BigDecimal("5000"));
        auctionDetailRequest.setAuctionStartTime(new Date());
        auctionDetailRequest.setAuctionDendLime(new Date());
        auctionDetailRequest.setAuctionMode(AuctionModelEnum.AUCTION_PRICE_MODEL.getLabel());
        auctionDetailRequest.setAuctionFinalPrice(new BigDecimal(10000));
        AuctionDetailResponse auctionDetailResponse = auctionDetailService.saveAuctionDetail(auctionDetailRequest);

        System.out.println(auctionDetailResponse.getCode());
    }
}
