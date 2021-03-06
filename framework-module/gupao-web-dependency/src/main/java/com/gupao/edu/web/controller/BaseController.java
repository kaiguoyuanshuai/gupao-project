package com.gupao.edu.web.controller;

import com.gupao.edu.exceptions.enums.ResponseCodeEnum;
import com.gupao.edu.serviceext.common.dto.BaseResponse;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 作者：Administrator
 * 时间：2018/7/2
 */
public class BaseController {

    protected Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    protected boolean resultSuccess(BaseResponse baseResponse) {
        return StringUtils.equals(baseResponse.getCode(), ResponseCodeEnum.SUCCESS.getCode());
    }

}
