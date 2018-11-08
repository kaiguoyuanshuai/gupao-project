package com.gupao.edu.auction.notify;


import com.gupao.edu.auction.dal.entity.AuctionDetail;
import com.gupao.edu.auction.factory.PriceThresholdModelFactory;
import com.gupao.edu.auction.internal.AuctionDetailInfoProcess;
import com.gupao.edu.auction.internal.AuctionPriceThresholdProcess;
import com.gupao.edu.serviceext.common.dto.BaseResponse;
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
    private AuctionDetailInfoProcess auctionDetailInfoProcess;

    @Override
    public void onMessage(ConsumerRecord<Integer, AuctionDetail> integerStringConsumerRecord) {
        BaseResponse baseResponse = new BaseResponse();
        LOGGER.info("添加一个新的产品活动");
        AuctionDetail auctionDetail = integerStringConsumerRecord.value();
        //TODO 添加Zset集合
        AuctionPriceThresholdProcess auctionPriceProcess = PriceThresholdModelFactory.getAuctionPriceProcess(auctionDetail.getAuctionMode());
        if (auctionPriceProcess != null) {
            baseResponse = auctionPriceProcess.buildModelAuctionPriceWay(auctionDetail);
            if (!baseResponse.isSuccess()) {
                LOGGER.error("某某活动创建失败，请手动进行创建!");
            }
        }


        //TODO 添加活动详情集合
        auctionDetailInfoProcess.buildAuctionDetailInfo(auctionDetail);

    }


}
