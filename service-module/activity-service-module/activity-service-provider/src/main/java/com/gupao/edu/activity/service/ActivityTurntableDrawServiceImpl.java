package com.gupao.edu.activity.service;

import com.gupao.edu.activity.dto.ActivityTurntableDrawReq;
import com.gupao.edu.activity.dto.AwardDrawRecordBean;
import com.gupao.edu.serviceext.common.dto.BaseResponse;
import org.springframework.stereotype.Service;

/*
 * 描述:
 * @auth zhengkk19738
 * @time 2018/9/18
 */
@Service("activityTurntableDrawService")
public class ActivityTurntableDrawServiceImpl implements ActivityTurntableDrawService {

    @Override
    public BaseResponse<AwardDrawRecordBean> doDraw(ActivityTurntableDrawReq activityTurntableDrawReq) {
        return null;
    }
}
