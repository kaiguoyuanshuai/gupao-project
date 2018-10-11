package com.gupao.edu.auction.controller;

import com.gupao.edu.auction.constants.AuctionMessageTopicConstants;
import com.gupao.edu.auction.dto.AuctionDetailRequest;
import com.gupao.edu.auction.service.AuctionDetailService;
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
    private AuctionDetailService auctionDetailService;

    @RequestMapping("doAuction")
    public ResponseData doAuction() {

        LOGGER.info("发起一个竞购的消息内容");
        kafkaTemplate.send(AuctionMessageTopicConstants.AUCTION_WORK_MESSAGE, new Object());

        return ResponseData.SUCCESS();
    }


    @RequestMapping("createAuction")
    public ResponseData createAuction(AuctionDetailRequest auctionDetailRequest) {

        auctionDetailService.saveAuctionDetail(auctionDetailRequest);

        return ResponseData.SUCCESS();
    }
}
