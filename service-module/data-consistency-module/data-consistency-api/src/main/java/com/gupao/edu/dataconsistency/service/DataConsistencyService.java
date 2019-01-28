package com.gupao.edu.dataconsistency.service;

/*
 * 描述: 数据一致性接口
 * @auth zhengkk19738
 * @time 2019/1/28
 */
public interface DataConsistencyService {

    /**
     * 预发消息
     */
    public void prepareMessage();


    /**
     * 确认消息
     */
    public void confirmMessage();

    /**
     * 删除消息
     */
    public void deleteMessage();


    /**
     * 完成消息
     */
    public void completeMessage();
    
}
