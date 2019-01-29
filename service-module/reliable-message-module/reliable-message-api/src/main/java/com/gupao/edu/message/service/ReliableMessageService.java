package com.gupao.edu.message.service;

/*
 * 描述:
 * @auth zhengkk19738
 * @time 2019/1/29
 */
public interface ReliableMessageService {


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
