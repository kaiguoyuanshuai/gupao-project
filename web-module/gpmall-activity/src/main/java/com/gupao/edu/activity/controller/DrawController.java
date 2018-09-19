package com.gupao.edu.activity.controller;

import com.gupao.edu.activity.dto.ActivityTurntableDrawReq;
import com.gupao.edu.activity.dto.AwardDrawRecordBean;
import com.gupao.edu.activity.service.ActivityTurntableDrawService;
import com.gupao.edu.serviceext.common.dto.BaseResponse;
import com.gupao.edu.web.controller.BaseController;
import com.gupao.edu.web.support.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 腾讯课堂搜索 咕泡学院
 * 加群获取视频：608583947
 * 风骚的Michael 老师
 */


@RestController
public class DrawController extends BaseController {

    @Autowired
    ActivityTurntableDrawService activityTurntableDrawService;


    @PostMapping("/doDraw")
    public ResponseData doDraw(String drawCode) {

        ActivityTurntableDrawReq drawReq = new ActivityTurntableDrawReq();
        drawReq.setDrawCode(drawCode);

        BaseResponse<AwardDrawRecordBean> awardDrawRecordBeanBaseResponse = activityTurntableDrawService.doDraw(drawReq);

        if (resultSuccess(awardDrawRecordBeanBaseResponse)) {
            return ResponseData.SUCCESS(awardDrawRecordBeanBaseResponse.getResult());
        }
        return ResponseData.FAILED(awardDrawRecordBeanBaseResponse.getResult());
    }


}
