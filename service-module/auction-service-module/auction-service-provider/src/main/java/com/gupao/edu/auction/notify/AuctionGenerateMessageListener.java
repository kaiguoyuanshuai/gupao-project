package com.gupao.edu.auction.notify;


import com.gupao.edu.auction.dal.entity.AuctionDetail;
import com.gupao.edu.auction.internal.AuctionPriceThresholdProcess;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.listener.MessageListener;
import org.springframework.stereotype.Service;

/**
 * 处理 AUCTION_GENERATE_MQ_TOPIC 发送出来的消息内容
 */
@Service
public class AuctionGenerateMessageListener implements MessageListener<Integer, AuctionDetail> {

    Logger LOGGER = LoggerFactory.getLogger(AuctionGenerateMessageListener.class);

    @Autowired
    private AuctionPriceThresholdProcess auctionPriceThresholdProcess;

    @Override
    public void onMessage(ConsumerRecord<Integer, AuctionDetail> integerStringConsumerRecord) {

        LOGGER.info("添加一个新的产品活动");
        AuctionDetail auctionDetail = integerStringConsumerRecord.value();
        //TODO 添加Zset集合

        auctionPriceThresholdProcess.buildModelAuctionPriceWay(auctionDetail);


        //TODO 添加活动详情集合


    }


}
