package com.gupao.edu.activity.service.processor;

import com.gupao.edu.activity.dal.entity.ActivityAwardItem;
import com.gupao.edu.activity.dto.ActivityTurntableDrawReq;

/**
 * 抽奖活动上下文
 * 封装
 */
public class ActivityDrawContext {

    /**
     * 抽奖请求
     */
    private ActivityTurntableDrawReq ActivityTurntableDrawReq;

    /**
     * 奖品
     */
    private ActivityAwardItem activityAwardItem;

    public com.gupao.edu.activity.dto.ActivityTurntableDrawReq getActivityTurntableDrawReq() {
        return ActivityTurntableDrawReq;
    }

    public void setActivityTurntableDrawReq(com.gupao.edu.activity.dto.ActivityTurntableDrawReq activityTurntableDrawReq) {
        ActivityTurntableDrawReq = activityTurntableDrawReq;
    }

    public ActivityAwardItem getActivityAwardItem() {
        return activityAwardItem;
    }

    public void setActivityAwardItem(ActivityAwardItem activityAwardItem) {
        this.activityAwardItem = activityAwardItem;
    }
}
