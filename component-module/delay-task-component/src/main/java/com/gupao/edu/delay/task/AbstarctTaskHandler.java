package com.gupao.edu.delay.task;

import com.gupao.edu.delay.task.constants.DelayTaskConstants;
import com.gupao.edu.delay.task.job.JobDetail;
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
 * @auth zhengkk19738
 * @time 2018/11/1
 */
@Service
public class AbstarctTaskHandler<T> implements Runnable {

    //  private static Log logger = LogFactory.getLog(AbstarctTaskHandler.class);


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

    /**
     * 消息的class对象l
     */
    private Class<T> clazz;

    private boolean monitor;

    // 默认为3
    private int retryTimes = 3;

    public AbstarctTaskHandler() {
    }

    public AbstarctTaskHandler(String messageType, Class<T> clazz, int retryTimes) {
        this.messageType = messageType;
        this.clazz = clazz;
        this.retryTimes = 3;
    }

    public AbstarctTaskHandler(String messageType, Class<T> clazz) {
        this.messageType = messageType;
        this.clazz = clazz;
    }

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
                    System.out.println("处理一条延时任务消息");
                    kafkaTemplate.send(jobDetail.getJobTopic(), jobDetail.getJobDetail());
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
