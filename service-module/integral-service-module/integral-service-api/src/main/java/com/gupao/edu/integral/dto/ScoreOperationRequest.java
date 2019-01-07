package com.gupao.edu.integral.dto;

import com.gupao.edu.serviceext.common.dto.BaseRequest;

import java.math.BigDecimal;

/*
 * 描述:
 * @auth zhengkk19738
 * @time 2019/1/7
 */
public class ScoreOperationRequest extends BaseRequest {

    private static final long serialVersionUID = -5617861864236152017L;

    private String userId;

    /**
     * 账号
     */
    private String userAccount;

    /**
     * 消费积分
     */
    private BigDecimal score;

    /**
     * 扣减、冻结、增加、解冻
     */
    private String oprationType;

    /**
     * 业务操作类型,初始化积分 ，积分消费，注册送积分 等
     */
    private String bizType;

    /**
     * 操作来源
     */
    private String source;

    /**
     * 积分状态
     */
    private String status;

    /**
     * 外部流水操作
     */
    private String outerBusinessCode;


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getOprationType() {
        return oprationType;
    }

    public void setOprationType(String oprationType) {
        this.oprationType = oprationType;
    }

    public String getBizType() {
        return bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOuterBusinessCode() {
        return outerBusinessCode;
    }

    public void setOuterBusinessCode(String outerBusinessCode) {
        this.outerBusinessCode = outerBusinessCode;
    }

    public BigDecimal getScore() {
        return score;
    }

    public void setScore(BigDecimal score) {
        this.score = score;
    }
}
