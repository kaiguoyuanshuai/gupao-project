package com.gupao.edu.integral.notify;

import com.gupao.edu.integral.dto.IntegralAccountRequest;
import com.gupao.edu.integral.service.IntegralAccountService;
import com.gupao.edu.integral.vo.IntegralAccount;
import com.gupao.edu.serviceext.common.dto.BaseResponse;
import com.gupao.edu.serviceext.common.utils.GPJsonUtils;
import com.gupao.edu.user.notify.UserRegistryMessage;
import com.rabbitmq.client.Channel;
import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/*
 * 描述:
 * @auth zhengkk19738
 * @time 2019/1/4
 */
@Component("integralScoreInitListener")
public class IntegralScoreInitListener implements ChannelAwareMessageListener {
    Logger LOGGER = LoggerFactory.getLogger(IntegralScoreInitListener.class);

    @Autowired
    private IntegralAccountService integralAccountService;

    @Autowired
    private Redisson redisson;

    public static final String INTEGRAL_SCORE_PREFIX = "SCORE-";

    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        LOGGER.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>接收初始化积分账户消息>>>>>>>>>>>>>>>>>>>>>>>>>");
        LOGGER.info("初始化积分参数:{}", message.getBody());

        UserRegistryMessage userRegistryMessage = GPJsonUtils.json2Object(new String(message.getBody(), "utf-8"), UserRegistryMessage.class);

        if (userRegistryMessage == null) {
            LOGGER.warn("消息消费的实体对象为空");
        }
        RLock lock = redisson.getLock(INTEGRAL_SCORE_PREFIX + userRegistryMessage.getUserId());

        IntegralAccountRequest integralAccountRequest = new IntegralAccountRequest();
        integralAccountRequest.setUserId(Integer.valueOf(userRegistryMessage.getUserId()));
        integralAccountRequest.setUserName(userRegistryMessage.getUserName());
        try {
            //加锁,3秒之后自动解锁，做幂等性处理
            //1、幂等
            lock.lock(3, TimeUnit.SECONDS);

            IntegralAccount integralAccount = integralAccountService.queryIntgralAccountInfo(integralAccountRequest);
            if (integralAccount != null) {
                //手动ACK
                channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
                LOGGER.warn("账号信息【{}】已经初始化过，不再进行初始化", userRegistryMessage.getUserId());
                return;
            }

            //初始化分数
            integralAccountRequest.setAvailableScoreBalance("100");
            BaseResponse baseResponse = integralAccountService.initIntegralAccountInfo(integralAccountRequest);
            if (baseResponse != null && baseResponse.isSuccess()) {
                //手动ACK
                channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);

                //增加积分记录信息
            }

        } catch (Exception ex) {
            //出现异常之后 ，检查是否已经存储到库中，如果有则进行ACK ，如果没有，则不进行
            //  channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);

        } finally {
            //手动ACK
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
            //解锁
            lock.unlock();
        }
    }
}
