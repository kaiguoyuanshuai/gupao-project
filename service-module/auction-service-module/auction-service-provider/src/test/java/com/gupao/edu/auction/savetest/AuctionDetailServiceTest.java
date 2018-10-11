package com.gupao.edu.auction.savetest;

import com.gupao.edu.auction.dal.entity.AuctionDetail;
import com.gupao.edu.auction.dal.persistence.AuctionDetailMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/*
 * 描述:
 * @auth zhengkk19738
 * @time 2018/10/11
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:META-INF/spring/service-common.xml")
/*@Transactional*/
public class AuctionDetailServiceTest {

    @Autowired
    private AuctionDetailMapper auctionDetailMapper ;

    @Test
    public void testInsert(){
        AuctionDetail auctionDetail = new AuctionDetail() ;
        auctionDetail.setId(100001);
        auctionDetail.setProductId(10);
        int insert = auctionDetailMapper.insert(auctionDetail);

        System.out.println(insert);
        System.out.println(auctionDetail.getId());
    }
}
