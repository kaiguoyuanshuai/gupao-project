package com.gupao.edu.user.dto;

import com.gupao.edu.exceptions.enums.BaseEnum;
import com.gupao.edu.serviceext.common.dto.BaseRequest;
import com.gupao.edu.serviceext.common.dto.BaseResponse;
import com.gupao.edu.user.enums.UserResponseCodeEnum;

/**
 * Created by Administrator on 2018/7/1.
 */
public class CheckAuthResponse extends BaseResponse {
    private static final long serialVersionUID = 662074793006768797L;

    private String uid;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "CheckAuthResponse{" +
                "uid='" + uid + '\'' +
                '}';
    }
}
