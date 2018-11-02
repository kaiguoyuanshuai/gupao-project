package com.gupao.edu.delay.task;

import com.gupao.edu.delay.task.constants.DelayTaskConstants;
import com.gupao.edu.delay.task.job.JobDetail;
import com.gupao.edu.serviceext.common.utils.JsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.PostConstruct;
import java.util.Set;

/*
 * 描述:
 *  从redis 中获取当前时间的允许执行的任务，并且发送一条 jobTopic 的消息内容
 * @auth zhengkk19738
 * @time 2018/11/1
 */
@Service
public class BootStrapTaskHandler implements Runnable {

    private static Logger logger = LoggerFactory.getLogger(BootStrapTaskHandler.class);

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    KafkaTemplate kafkaTemplate;

    /**
     * 初始化启动本监听器
     */
    @PostConstruct
    public void startListen() {
        System.out.println("run");
        // 启动监听
        new Thread(this).start();
    }


    /**
     * 监听的消息类型
     */
    private String messageType;

    public void run() {
        while (true) {
            System.out.println("延时任务消息...");
            listen();
        }
    }

    /**
     * 监听消息
     */
    @SuppressWarnings("unchecked")
    public void listen() {
        Set<ZSetOperations.TypedTuple> set = redisTemplate.opsForZSet().rangeByScoreWithScores(DelayTaskConstants.DELAY_TASK_PREFIX, 0, System.currentTimeMillis());
        if (!CollectionUtils.isEmpty(set)) {
            for (ZSetOperations.TypedTuple typedTuple : set) {
                JobDetail jobDetail = (JobDetail) typedTuple.getValue();
                //防止部署多套程序的时候出现并发问题
                if (redisTemplate.opsForZSet().remove(DelayTaskConstants.DELAY_TASK_PREFIX, jobDetail) > 0) {
                    logger.info("处理一条延时任务消息:ID:{}", jobDetail.getJobSeId());
                    try {
                        kafkaTemplate.send(jobDetail.getJobTopic(), JsonUtils.toJson(jobDetail.getJobDetail()));
                    }catch (Exception ex){
                        logger.error("执行发送定时任务消息队列的时候出现异常!");
                    }
                }
            }
        } else {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}