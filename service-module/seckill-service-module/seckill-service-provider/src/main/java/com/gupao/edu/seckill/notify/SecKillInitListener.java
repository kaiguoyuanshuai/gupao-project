package com.gupao.edu.seckill.notify;

import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.stereotype.Component;

/*
 * 描述:
 * @auth zhengkk19738
 * @time 2019/1/4
 */
@Component("secKillInitListener")
public class SecKillInitListener implements ChannelAwareMessageListener {
    Logger LOGGER = LoggerFactory.getLogger(SecKillInitListener.class);


    public static final String INTEGRAL_SCORE_PREFIX = "SCORE-";

    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        LOGGER.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>消费秒杀消息>>>>>>>>>>>>>>>>>>>>>>>>>");
        LOGGER.info("消费秒杀参数:{}", new String(message.getBody()));


        try {

        } catch (Exception ex) {
            ex.printStackTrace();
            //出现异常之后 ，检查是否已经存储到库中，如果有则进行ACK ，如果没有，则不进行
            LOGGER.error(ex.getMessage());
        } finally {
            //手动ACK
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        }
    }
}
