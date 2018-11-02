package com.gupao.edu.delay.task.job;

import java.io.Serializable;

/*
 * 描述:
 * @auth zhengkk19738
 * @time 2018/11/1
 */
public class JobDetail<T> implements Serializable {

    private static final long serialVersionUID = 4952588684365959682L;

    private String jobSeId;

    /**
     * 任务名称
     */
    private String jobName;

    /**
     * 任务描述
     */
    private String jobDesc;

    /**
     * 任务处理消息
     */
    private String jobTopic;

    /**
     * 任务处理详情
     */
    private T jobDetail;

    /**
     * 任务处理时间搓
     */
    private long time;

    public JobDetail() {
    }

    public JobDetail(String jobSeId , String jobName, String jobTopic, long time, T jobDetail) {
        this.jobSeId = jobSeId;
        this.jobName = jobName;
        this.jobTopic = jobTopic;
        this.jobDetail = jobDetail;
        this.time = time;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobDesc() {
        return jobDesc;
    }

    public void setJobDesc(String jobDesc) {
        this.jobDesc = jobDesc;
    }

    public String getJobTopic() {
        return jobTopic;
    }

    public void setJobTopic(String jobTopic) {
        this.jobTopic = jobTopic;
    }

    public T getJobDetail() {
        return jobDetail;
    }

    public void setJobDetail(T jobDetail) {
        this.jobDetail = jobDetail;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getJobSeId() {
        return jobSeId;
    }

    public void setJobSeId(String jobSeId) {
        this.jobSeId = jobSeId;
    }
}
