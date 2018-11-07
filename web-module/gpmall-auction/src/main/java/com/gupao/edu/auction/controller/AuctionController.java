package com.gupao.edu.auction.controller;

import com.gupao.edu.auction.constants.AuctionMessageTopicConstants;
import com.gupao.edu.auction.dto.AuctionActivityInfoDto;
import com.gupao.edu.auction.dto.AuctionDetailRequest;
import com.gupao.edu.auction.dto.AuctionWorkRequest;
import com.gupao.edu.auction.service.AuctionActivityQueryService;
import com.gupao.edu.web.controller.BaseController;
import com.gupao.edu.web.support.ResponseData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    private AuctionActivityQueryService auctionActivityQueryService;


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
        if(true){

        }


        LOGGER.info("发起一个竞购的消息内容");
        kafkaTemplate.send(AuctionMessageTopicConstants.AUCTION_WORK_MESSAGE, new Object());

        return ResponseData.SUCCESS();
    }


}
