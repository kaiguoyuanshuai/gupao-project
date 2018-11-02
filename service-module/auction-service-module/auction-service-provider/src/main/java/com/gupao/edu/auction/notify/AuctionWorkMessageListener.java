package com.gupao.edu.auction.notify;


import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.listener.MessageListener;
import org.springframework.stereotype.Service;

/**
 * 处理 AUCTION_GENERATE_MQ_TOPIC 发送出来的消息内容
 */
@Service
public class AuctionWorkMessageListener implements MessageListener<Integer, String> {

    @Override
    public void onMessage(ConsumerRecord<Integer, String> integerStringConsumerRecord) {
        //
    }


}
