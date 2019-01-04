package com.gupao.edu.integral.services;

import com.gupao.edu.integral.dal.persistence.IntegralAccountMapper;
import com.gupao.edu.integral.dto.IntegralAccountRequest;
import com.gupao.edu.integral.dto.IntegralAccountResponse;
import com.gupao.edu.integral.enums.IntegralAccountResponseCodeEnum;
import com.gupao.edu.integral.service.IntegralAccountService;
import com.gupao.edu.integral.vo.IntegralAccount;
import com.gupao.edu.serviceext.common.dto.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
 * 描述:
 * @auth zhengkk19738
 * @time 2019/1/4
 */
@Service("integralAccountService")
public class IntegralAccountServiceImpl implements IntegralAccountService {

    @Autowired
    private IntegralAccountMapper integralAccountMapper;

    @Override
    public BaseResponse initIntegralAccountInfo(IntegralAccountRequest integralAccountRequest) {
        IntegralAccountResponse integralAccountResponse = new IntegralAccountResponse();
        if (validateParam(integralAccountRequest)) {
            return integralAccountResponse.fail(IntegralAccountResponseCodeEnum.SYS_PARAM_NOT_RIGHT);
        }

        IntegralAccount integralAccount = new IntegralAccount();
        integralAccount.setId(integralAccountRequest.getId());
        integralAccount.setUserId(integralAccountRequest.getUserId());
        integralAccount.setUserName(integralAccountRequest.getUserName());
        integralAccount.setAvailableScoreBalance(integralAccountRequest.getAvailableScoreBalance());
        integralAccount.setScoreBalance(integralAccountRequest.getScoreBalance());
        int insert = integralAccountMapper.insert(integralAccount);
        return integralAccountResponse.success();
    }

    @Override
    public com.gupao.edu.integral.vo.IntegralAccount queryIntgralAccountInfo(IntegralAccountRequest integralAccountRequest) {
        return null;
    }

    private boolean validateParam(IntegralAccountRequest integralAccountRequest) {

        if (integralAccountRequest == null) {
            return false;
        }

        return true;
    }
}
