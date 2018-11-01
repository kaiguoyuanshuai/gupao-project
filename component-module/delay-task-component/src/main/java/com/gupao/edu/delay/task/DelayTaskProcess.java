package com.gupao.edu.delay.task;

import com.gupao.edu.delay.task.job.JobDetail;
import com.gupao.edu.serviceext.common.dto.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/*
 * 描述:
 * @auth zhengkk19738
 * @time 2018/11/1
 */
@Service("delayTaskProcess")
public class DelayTaskProcess {


    @Autowired
    RedisTemplate redisTemplate;

    public static final String DELAY_TASK_PREFIX = "base:delay_queue";

    /**
     * 添加延迟任务
     *
     * @param jobDetail
     */
    public BaseResponse put(JobDetail jobDetail) {
        Boolean result = redisTemplate.opsForZSet().add(DELAY_TASK_PREFIX, jobDetail, jobDetail.getTime());
        if (result) {
            return new BaseResponse().success();
        }
        return new BaseResponse().fail();
    }

    //TODO 删除任务

    /**
     * 删除延迟任务
     * @param jobDetail
     * @return
     */
    public BaseResponse delete(JobDetail jobDetail) {
        redisTemplate.opsForZSet().remove(DELAY_TASK_PREFIX, jobDetail);
        return new BaseResponse().fail();
    }

}
