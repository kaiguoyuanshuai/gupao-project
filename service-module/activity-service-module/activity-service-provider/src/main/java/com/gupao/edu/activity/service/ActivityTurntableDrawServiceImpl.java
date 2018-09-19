package com.gupao.edu.activity.service;

import com.gupao.edu.activity.dto.ActivityTurntableDrawReq;
import com.gupao.edu.activity.dto.AwardDrawRecordBean;
import com.gupao.edu.activity.service.processor.ActivityDrawContext;
import com.gupao.edu.activity.service.processor.ActivityTurntableDrawProxy;
import com.gupao.edu.serviceext.common.dto.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
 * 描述:
 * @auth zhengkk19738
 * @time 2018/9/18
 */
@Service("activityTurntableDrawService")
public class ActivityTurntableDrawServiceImpl implements ActivityTurntableDrawService {


    @Autowired
    private ActivityTurntableDrawProxy activityTurntableDrawProxy;

    @Override
    public BaseResponse<AwardDrawRecordBean> doDraw(ActivityTurntableDrawReq activityTurntableDrawReq) {
        BaseResponse<AwardDrawRecordBean> recordBeanResultResp = new BaseResponse<AwardDrawRecordBean>();

        checkDrawParams(activityTurntableDrawReq);//检查请求参数
        ActivityDrawContext activityDrawContext = new ActivityDrawContext();
        activityDrawContext.setActivityTurntableDrawReq(activityTurntableDrawReq);

        //抽奖
        activityTurntableDrawProxy.doDrawForProxy(activityDrawContext);

        AwardDrawRecordBean awardDrawRecordBean = new AwardDrawRecordBean();
        //发放奖品
        if (activityDrawContext.getActivityAwardItem() != null) {
            //发出中奖消息
            awardDrawRecordBean.setLevel(activityDrawContext.getActivityAwardItem().getLevel());

        }else{
            //返回并设置为中奖
            awardDrawRecordBean.setLevel(0);
        }

        return recordBeanResultResp.success(awardDrawRecordBean);
    }

    /**
     * 参数检查
     *
     * @param activityTurntableDrawReq
     */
    private void checkDrawParams(ActivityTurntableDrawReq activityTurntableDrawReq) {

    }


}
