package com.gupao.edu.auction.controller;

import com.gupao.edu.auction.constants.AuctionCacheKeyConstants;
import com.gupao.edu.auction.constants.AuctionMessageTopicConstants;
import com.gupao.edu.auction.dto.AuctionActivityInfoDto;
import com.gupao.edu.auction.dto.AuctionDetailRequest;
import com.gupao.edu.auction.dto.AuctionWorkRequest;
import com.gupao.edu.auction.service.AuctionActivityQueryService;
import com.gupao.edu.serviceext.common.utils.GPDateUtil;
import com.gupao.edu.web.controller.BaseController;
import com.gupao.edu.web.support.ResponseData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/*
 * 描述: 发起竞价申请
 * @auth zhengkk19738
 * @time 2018/9/28
 */
@RestController
@RequestMapping("/auction/")
public class AuctionController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuctionController.class);

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @Autowired
    private RedisTemplate redisTemplate;


    @Autowired
    private AuctionActivityQueryService auctionActivityQueryService;


    /**
     * 做出判断，然后发出竞购的消息队列
     * 同时可以做限流处理
     *
     * @param auctionWorkRequest
     * @return
     */
    @RequestMapping("doAuction")
    public ResponseData doAuction(AuctionWorkRequest auctionWorkRequest) {

        AuctionDetailRequest auctionDetailRequest = new AuctionDetailRequest();
        auctionDetailRequest.setId(auctionWorkRequest.getAuctionActivityId());
        AuctionActivityInfoDto auctionActivityInfoDto = auctionActivityQueryService.queryAuctionActivity(auctionDetailRequest);

        if (auctionActivityInfoDto == null) {
            //活动信息为空
            return ResponseData.FAILED();
        }

        //开始结束时间判断
        if (GPDateUtil.before(new Date(), auctionActivityInfoDto.getAuctionStartTime())) {
            //活动未开始
            return ResponseData.FAILED();
        }

        if (GPDateUtil.after(new Date(), auctionActivityInfoDto.getAuctionDendLime())) {
            //活动已经结束
            return ResponseData.FAILED();
        }

        //再判断指令是否存在，防攻击服务端
        //sismember 操作
        Boolean member = redisTemplate.opsForSet().isMember(AuctionCacheKeyConstants.AUCTION_SECURITY_KEY + "", auctionWorkRequest.getAuctionKey());

        //如果不存在，则返回失败
        if (!member) {
            //活动不存在，或者手速太慢
            return ResponseData.FAILED();
        }

        //发出竞购的消息队列

        LOGGER.info("发起一个竞购的消息内容");
        kafkaTemplate.send(AuctionMessageTopicConstants.AUCTION_WORK_MESSAGE, auctionWorkRequest);

        return ResponseData.SUCCESS();
    }


}
