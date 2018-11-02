package com.gupao.edu.delay.task;

import com.gupao.edu.delay.task.enums.DelayTaskErrorCodeEnum;
import com.gupao.edu.delay.task.job.JobDetail;
import com.gupao.edu.serviceext.common.dto.BaseResponse;
import com.gupao.edu.serviceext.common.utils.JsonUtils;
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

        if (jobDetail == null) {
            return new BaseResponse().fail(DelayTaskErrorCodeEnum.PPARAM_ILLEGAL);
        }

        Boolean result = redisTemplate.opsForZSet().add(DELAY_TASK_PREFIX, JsonUtils.toJson(jobDetail), jobDetail.getTime());
        if (result) {
            return new BaseResponse().success();
        }
        return new BaseResponse().fail(DelayTaskErrorCodeEnum.FAIL);
    }

    /**
     * 删除延迟任务
     *
     * @param jobDetail
     * @return
     */
    public BaseResponse delete(JobDetail jobDetail) {
        if (jobDetail == null) {
            //TODO 加上返回错误枚举
            return new BaseResponse().fail(DelayTaskErrorCodeEnum.PPARAM_ILLEGAL);
        }


        Long remove = redisTemplate.opsForZSet().remove(DELAY_TASK_PREFIX, JsonUtils.toJson(jobDetail));
        if (remove > 0) {
            return new BaseResponse().success();
        }
        //删除任务失败
        return new BaseResponse().fail(DelayTaskErrorCodeEnum.FAIL);
    }

}
