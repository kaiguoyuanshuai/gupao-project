package com.gupao.edu.activity.service;


import com.gupao.edu.activity.dto.ActivityTurntableDrawReq;
import com.gupao.edu.activity.dto.AwardDrawRecordBean;
import com.gupao.edu.serviceext.common.dto.BaseResponse;

public interface ActivityTurntableDrawService {

    /**
     * 构建实体类
     *
     * @param activityTurntableDrawReq
     * @return
     */
    BaseResponse<AwardDrawRecordBean> doDraw(ActivityTurntableDrawReq activityTurntableDrawReq);

}
