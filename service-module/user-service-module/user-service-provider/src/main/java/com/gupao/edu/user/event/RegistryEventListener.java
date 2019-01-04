package com.gupao.edu.user.event;

import com.gupao.edu.user.notify.UserRegistryMessage;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/*
 * 描述:
 * @auth zhengkk19738
 * @time 2019/1/4
 */

/**
 * //如果需要有序的监听 则可以使用  SmartApplicationListener
 */


@Component
public class RegistryEventListener implements ApplicationListener<RegistryEvent> {

    Logger logger = LoggerFactory.getLogger(RegistryEventListener.class);

    public static final String MQ_registyr_KEY = "user.registry.event";

    @Autowired
    AmqpTemplate amqpTemplate;

    @Override
    public void onApplicationEvent(RegistryEvent event) {
        logger.info("接收到注册的通知事件,收到的事件参数为：{}", event.toString());


        //TODO 可以做一些 跟用户权限相关的操作，全面的解耦 注册功能

        //最终发送一个MQ消息到系统中
        if (event != null && StringUtils.isNotBlank(event.getUserId())) {
            UserRegistryMessage userRegistryMessage = new UserRegistryMessage();
            userRegistryMessage.setUserId(event.getUserId());
            userRegistryMessage.setUserName(event.getUserName());
            amqpTemplate.convertAndSend(MQ_registyr_KEY, userRegistryMessage);
        }

    }
}
