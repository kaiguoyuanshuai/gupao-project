package com.gupao.edu.auction.notify;


import com.gupao.edu.auction.dto.AuctionWorkRequest;
import com.gupao.edu.auction.dto.AuctionWorkResponse;
import com.gupao.edu.auction.service.AuctionWorkService;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.listener.MessageListener;
import org.springframework.stereotype.Service;

/**
 * 处理 AUCTION_WORK_MESSAGE 发送出来的消息内容
 */
@Service
public class AuctionWorkMessageListener implements MessageListener<Integer, AuctionWorkRequest> {

    private Logger LOGGER = LoggerFactory.getLogger(AuctionWorkMessageListener.class);

    @Autowired
    private AuctionWorkService auctionWorkService;

    @Override
    public void onMessage(ConsumerRecord<Integer, AuctionWorkRequest> auctionWorkRequestConsumerRecord) {
        AuctionWorkRequest auctionWorkRequest = auctionWorkRequestConsumerRecord.value();
        LOGGER.debug("开始消费竞购抢购的请求内容！请求参数为:{}", auctionWorkRequest);

        if (auctionWorkRequest != null) {
            //TODO 稍微处理一下
            AuctionWorkResponse auctionWorkResponse =
                    auctionWorkService.doAuctionWork(auctionWorkRequest);
        }
        LOGGER.debug("结束消费竞购抢购的请求内容！请求参数为:{}", auctionWorkRequest);
    }


}
