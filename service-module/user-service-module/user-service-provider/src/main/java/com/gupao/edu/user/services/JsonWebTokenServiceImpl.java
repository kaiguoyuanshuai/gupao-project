package com.gupao.edu.user.services;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.gupao.edu.base.service.BaseService;
import com.gupao.edu.exceptions.ExceptionUtil;
import com.gupao.edu.exceptions.ServiceException;
import com.gupao.edu.exceptions.ValidateException;
import com.gupao.edu.user.dto.CheckAuthRequest;
import com.gupao.edu.user.dto.CheckAuthResponse;
import com.gupao.edu.user.enums.UserResponseCodeEnum;
import com.gupao.edu.user.service.IJsonWebTokenService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.SignatureException;
import org.springframework.stereotype.Service;
import com.gupao.edu.user.utils.JwtTokenUtils;

/**
 * Created by Administrator on 2018/7/1.
 */
@Service("jsonWebTokenService")
public class JsonWebTokenServiceImpl extends BaseService implements IJsonWebTokenService {

    @Override
    public CheckAuthResponse validateJwt(CheckAuthRequest checkAuthRequest) {
        CheckAuthResponse response = new CheckAuthResponse();
        try {
            beforeValidateAuth(checkAuthRequest);

            Claims claims = JwtTokenUtils.phaseToken(checkAuthRequest.getToken());
            response.setUid(claims.get("uid").toString());
            response.success();
        } catch (ExpiredJwtException e) {
            LOGGER.error("Expire :" + e);
            response.fail(UserResponseCodeEnum.TOKEN_EXPIRE);
        } catch (SignatureException e1) {
            LOGGER.error("SignatureException :" + e1);
            response.fail(UserResponseCodeEnum.SIGNATURE_ERROR);
        } catch (Exception e) {
            LOGGER.error("login occur exception :" + e);
            ServiceException serviceException = (ServiceException) ExceptionUtil.handlerException4biz(e);
            response.fail(serviceException);
        } finally {
            LOGGER.info("response:" + response);
        }

        return response;
    }

    /**
     * 校驗檢查參數
     *
     * @param request
     */
    private void beforeValidateAuth(CheckAuthRequest request) {
        if (request == null) {
            throw new ValidateException("请求对象为空");
        }
        if (StringUtils.isEmpty(request.getToken())) {
            throw new ValidateException("token信息为空");
        }
    }
}
