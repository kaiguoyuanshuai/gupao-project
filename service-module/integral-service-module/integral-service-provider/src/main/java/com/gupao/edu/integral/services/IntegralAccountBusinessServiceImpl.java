package com.gupao.edu.integral.services;

import com.gupao.edu.exceptions.enums.ResponseCodeEnum;
import com.gupao.edu.integral.dal.entity.IntegralAccountDetail;
import com.gupao.edu.integral.dal.persistence.IntegralAccountDetailMapper;
import com.gupao.edu.integral.dto.IntegralAccountRequest;
import com.gupao.edu.integral.dto.ScoreOperationRequest;
import com.gupao.edu.integral.dto.ScoreOperationResponse;
import com.gupao.edu.integral.service.IntegralAccountBusinessService;
import com.gupao.edu.integral.service.IntegralAccountService;
import com.gupao.edu.integral.vo.IntegralAccount;
import com.gupao.edu.serviceext.common.dto.BaseResponse;
import com.gupao.edu.serviceext.common.utils.GPDecimalUtil;
import com.gupao.edu.serviceext.common.utils.GPJsonUtils;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/*
 * 描述:
 * @auth zhengkk19738
 * @time 2019/1/7
 */
@Service("integralAccountBusinessService")
public class IntegralAccountBusinessServiceImpl implements IntegralAccountBusinessService {

    private Logger LOGGER = LoggerFactory.getLogger(IntegralAccountBusinessServiceImpl.class);

    public static final String OPERATION_SCORE_ACCOUNT_LOCK = "OPERATION_SCORE_ACCOUNT_LOCK:";

    public static final int MAX_TRYLOCK_TIMES = 3;

    @Autowired
    private IntegralAccountService integralAccountService;

    @Autowired
    private IntegralAccountDetailMapper integralAccountDetailMapper;

    @Autowired
    private RedissonClient redisson;


    @Override
    public BaseResponse deductionScore(ScoreOperationRequest scoreOperationRequest) {
        // 锁
        // 幂等
        ScoreOperationResponse scoreOperationResponse = new ScoreOperationResponse();
        //校验参数
        if (!validateParam(scoreOperationRequest)) {
            return scoreOperationResponse.fail(ResponseCodeEnum.SYS_PARAM_NOT_RIGHT);
        }

        //1、先查询是否已经有流水操作，该操作为幂等性操作
        IntegralAccountDetail integralAccountDetail = integralAccountDetailMapper.selectIntegralAccountDetailByBusineesCode(scoreOperationRequest.getOuterBusinessCode());

        if (integralAccountDetail != null) {
            LOGGER.warn("流水号为:{}的操作已经被操作过，请查询是否为重复操作！操作参数为:{}", scoreOperationRequest.getOuterBusinessCode(), GPJsonUtils.toJson(scoreOperationRequest));
            return scoreOperationResponse.success();
        }
        RLock lock = redisson.getLock(OPERATION_SCORE_ACCOUNT_LOCK + scoreOperationRequest.getUserId());

        //设置获取锁的次数
        int tryLockTimes = 0;

        try {
            boolean res = lock.tryLock(20, 10, TimeUnit.SECONDS);
            while (!res && tryLockTimes <= MAX_TRYLOCK_TIMES) {
                LOGGER.warn(scoreOperationRequest.getOuterBusinessCode()+"重新获取锁信息!!!!!!!!!!!!");
                //再次获取锁信息
                res = lock.tryLock(20, 10, TimeUnit.SECONDS);
                tryLockTimes++;
            }

            if (res) {
                //再次判断流水号是否存在
                integralAccountDetail = integralAccountDetailMapper.selectIntegralAccountDetailByBusineesCode(scoreOperationRequest.getOuterBusinessCode());
                if (integralAccountDetail != null) {
                    LOGGER.warn("流水号为:{}的操作已经被操作过，请查询是否为重复操作！操作参数为:{}", scoreOperationRequest.getOuterBusinessCode(), GPJsonUtils.toJson(scoreOperationRequest));
                    return scoreOperationResponse.success();
                }

                IntegralAccountRequest integralAccountRequest = new IntegralAccountRequest();
                integralAccountRequest.setUserId(Integer.valueOf(scoreOperationRequest.getUserId()));

                IntegralAccount integralAccount = integralAccountService.queryIntgralAccountInfo(integralAccountRequest);
                if (integralAccount == null) {
                    LOGGER.error("业务执行错误,用户:{} 积分账户不存在！！！");
                    return scoreOperationResponse.fail();
                }
                integralAccountRequest.setAvailableScoreBalance(String.valueOf(GPDecimalUtil.sub(integralAccount.getAvailableScoreBalance(), scoreOperationRequest.getScore())));

                if (!GPDecimalUtil.campare(integralAccountRequest.getAvailableScoreBalance(), 0)) {
                    LOGGER.error("业务执行错误,用户:{} 积分账户余额不足！！！");
                    return scoreOperationResponse.fail();
                }

                integralAccountRequest.setId(integralAccount.getId());
                BaseResponse baseResponse = integralAccountService.updateINtegralAccountInfo(integralAccountRequest);

                if (baseResponse != null && baseResponse.isSuccess()) {
                    IntegralAccountDetail integralAccountDetailBean = new IntegralAccountDetail();
                    integralAccountDetailBean.setUserId(Integer.valueOf(scoreOperationRequest.getUserId()));
                    integralAccountDetailBean.setAvailableScore(integralAccountRequest.getAvailableScoreBalance());
                    integralAccountDetailBean.setOprationScore(String.valueOf(scoreOperationRequest.getScore()));
                    integralAccountDetailBean.setOuterBusinessCode(scoreOperationRequest.getOuterBusinessCode());
                    integralAccountDetailBean.setIntegralAccountId(integralAccount.getId());
                    //integralAccountDetailBean.set
                    integralAccountDetailMapper.insert(integralAccountDetailBean);
                }
            } else {
                //记录错误日志,允许手动触发操作
            }


        } catch (InterruptedException e) {
            LOGGER.error("获取锁失败!,操作参数为:{}", GPJsonUtils.toJson(scoreOperationRequest));
            LOGGER.error(e.getMessage());
        } finally {
            LOGGER.info("操作结束，释放锁");
            lock.unlock();
        }
        return scoreOperationResponse.success();
    }

    /**
     * 参数校验
     *
     * @param scoreOperationRequest
     * @return
     */
    private boolean validateParam(ScoreOperationRequest scoreOperationRequest) {
        if (scoreOperationRequest == null) {
            return false;
        }
        return true;
    }

    @Override
    public BaseResponse increaseScore(ScoreOperationRequest scoreOperationRequest) {
        // 锁
        // 幂等
        ScoreOperationResponse scoreOperationResponse = new ScoreOperationResponse();
        //校验参数
        if (!validateParam(scoreOperationRequest)) {
            return scoreOperationResponse.fail(ResponseCodeEnum.SYS_PARAM_NOT_RIGHT);
        }

        //1、先查询是否已经有流水操作，该操作为幂等性操作
        IntegralAccountDetail integralAccountDetail = integralAccountDetailMapper.selectIntegralAccountDetailByBusineesCode(scoreOperationRequest.getOuterBusinessCode());

        if (integralAccountDetail != null) {
            LOGGER.warn("流水号为:{}的操作已经被操作过，请查询是否为重复操作！操作参数为:{}", scoreOperationRequest.getOuterBusinessCode(), GPJsonUtils.toJson(scoreOperationRequest));
            return scoreOperationResponse.success();
        }
        RLock lock = redisson.getLock(OPERATION_SCORE_ACCOUNT_LOCK + scoreOperationRequest.getUserId());

        //设置获取锁的次数
        int tryLockTimes = 0;

        try {
            boolean res = lock.tryLock(20, 10, TimeUnit.SECONDS);
            while (!res && tryLockTimes <= MAX_TRYLOCK_TIMES) {
                //再次获取锁信息
                res = lock.tryLock(20, 10, TimeUnit.SECONDS);
                tryLockTimes++;
            }

            if (res) {
                //再次判断流水号是否存在
                integralAccountDetail = integralAccountDetailMapper.selectIntegralAccountDetailByBusineesCode(scoreOperationRequest.getOuterBusinessCode());
                if (integralAccountDetail != null) {
                    LOGGER.warn("流水号为:{}的操作已经被操作过，请查询是否为重复操作！操作参数为:{}", scoreOperationRequest.getOuterBusinessCode(), GPJsonUtils.toJson(scoreOperationRequest));
                    return scoreOperationResponse.success();
                }

                IntegralAccountRequest integralAccountRequest = new IntegralAccountRequest();
                integralAccountRequest.setUserId(Integer.valueOf(scoreOperationRequest.getUserId()));

                IntegralAccount integralAccount = integralAccountService.queryIntgralAccountInfo(integralAccountRequest);
                if (integralAccount == null) {
                    LOGGER.error("业务执行错误,用户:{} 积分账户不存在！！！");
                    return scoreOperationResponse.fail();
                }
                integralAccountRequest.setAvailableScoreBalance(String.valueOf(GPDecimalUtil.add(integralAccount.getAvailableScoreBalance(), scoreOperationRequest.getScore())));

                if (!GPDecimalUtil.campare(integralAccountRequest.getAvailableScoreBalance(), 0)) {
                    LOGGER.error("业务执行错误,用户:{} 积分账户余额不足！！！");
                    return scoreOperationResponse.fail();
                }
                integralAccountRequest.setId(integralAccount.getId());
                BaseResponse baseResponse = integralAccountService.updateINtegralAccountInfo(integralAccountRequest);

                if (baseResponse != null && baseResponse.isSuccess()) {
                    IntegralAccountDetail integralAccountDetailBean = new IntegralAccountDetail();
                    integralAccountDetailBean.setUserId(Integer.valueOf(scoreOperationRequest.getUserId()));
                    integralAccountDetailBean.setAvailableScore(integralAccountRequest.getAvailableScoreBalance());
                    integralAccountDetailBean.setOprationScore(String.valueOf(scoreOperationRequest.getScore()));
                    integralAccountDetailBean.setIntegralAccountId(integralAccount.getId());
                    integralAccountDetailMapper.insert(integralAccountDetailBean);
                } else {
                    LOGGER.error(baseResponse.getMsg());
                }
            } else {
                //记录错误日志,允许手动触发操作
            }


        } catch (InterruptedException e) {
            LOGGER.error("获取锁失败!,操作参数为:{}", GPJsonUtils.toJson(scoreOperationRequest));
            LOGGER.error(e.getMessage());
        } finally {
            LOGGER.info("操作结束，释放锁");
            lock.unlock();
        }
        return scoreOperationResponse.success();
    }
}
