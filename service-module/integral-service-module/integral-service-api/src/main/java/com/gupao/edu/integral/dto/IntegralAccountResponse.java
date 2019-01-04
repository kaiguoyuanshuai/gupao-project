package com.gupao.edu.integral.dto;

import com.gupao.edu.serviceext.common.dto.BaseResponse;

/*
 * 描述:
 * @auth zhengkk19738
 * @time 2019/1/4
 */
public class IntegralAccountResponse extends BaseResponse {

    private static final long serialVersionUID = -3508099793972169615L;
    /**
     * <pre>
     *
     * 表字段： integral_account.id
     * </pre>
     */
    private Integer id;

    /**
     * <pre>
     * 用户编号
     * 表字段： integral_account.user_id
     * </pre>
     */
    private Integer userId;

    /**
     * <pre>
     *
     * 表字段： integral_account.user_name
     * </pre>
     */
    private String userName;

    /**
     * <pre>
     * 积分总额
     * 表字段： integral_account.score_balance
     * </pre>
     */
    private String scoreBalance;

    /**
     * <pre>
     * 可用积分
     * 表字段： integral_account.available_score_balance
     * </pre>
     */
    private String availableScoreBalance;

    public String getAvailableScoreBalance() {
        return availableScoreBalance;
    }

    public void setAvailableScoreBalance(String availableScoreBalance) {
        this.availableScoreBalance = availableScoreBalance;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getScoreBalance() {
        return scoreBalance;
    }

    public void setScoreBalance(String scoreBalance) {
        this.scoreBalance = scoreBalance;
    }
}
