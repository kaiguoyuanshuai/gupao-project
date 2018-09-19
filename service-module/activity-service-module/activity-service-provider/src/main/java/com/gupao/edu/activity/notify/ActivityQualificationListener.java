package com.gupao.edu.activity.notify;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.listener.MessageListener;
import org.springframework.stereotype.Component;

/**
 * 用户抽奖资格的异步消息处理
 * 作者：Administrator
 * 时间：2018/7/14
 */
@Component("activityQualificationListener")
public class ActivityQualificationListener implements MessageListener<Integer, String> {
    @Override
    public void onMessage(ConsumerRecord<Integer, String> data) {
        System.out.println("收到消息了");
        System.out.println(data.value());

    }
}
