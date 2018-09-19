package com.gupao.edu.auction.dal.entity;

import java.math.BigDecimal;
import java.util.Date;

public class AuctionDetail {
    /**
     * <pre>
     * 
     * 表字段： auction_detail.id
     * </pre>
     * 
     */
    private Integer id;

    /**
     * <pre>
     * 竞拍的属性对象
     * 表字段： auction_detail.product_id
     * </pre>
     * 
     */
    private Integer productId;

    /**
     * <pre>
     * 竞拍模式 -时间模式  -价格模式
     * 表字段： auction_detail.auction_mode
     * </pre>
     * 
     */
    private String auctionMode;

    /**
     * <pre>
     * 竞拍开始时间
     * 表字段： auction_detail.auction_start_time
     * </pre>
     * 
     */
    private Date auctionStartTime;

    /**
     * <pre>
     * 竞拍截止时间,两种模式都需要截止时间
     * 表字段： auction_detail.auction_dend_lime
     * </pre>
     * 
     */
    private Date auctionDendLime;

    /**
     * <pre>
     * 成交最低价，两种模式都需要符合最低价
     * 表字段： auction_detail.auction_product_minimum_price
     * </pre>
     * 
     */
    private BigDecimal auctionProductMinimumPrice;

    /**
     * <pre>
     * 每次加价幅度
     * 表字段： auction_detail.auction_per_price
     * </pre>
     * 
     */
    private String auctionPerPrice;

    /**
     * <pre>
     * 如果是时间模式，则为空，如果是价格模式，则需要预设价格
     * 表字段： auction_detail.auction_final_price
     * </pre>
     * 
     */
    private BigDecimal auctionFinalPrice;

    /**
     * <pre>
     * 实际最终成交价格（竞拍没有成功，则展示出价最高价格）
     * 表字段： auction_detail.auction_actual_price
     * </pre>
     * 
     */
    private BigDecimal auctionActualPrice;

    /**
     * <pre>
     * 竞拍状态
     * 表字段： auction_detail.auction_status
     * </pre>
     * 
     */
    private String auctionStatus;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column auction_detail.id
     *
     * @return the value of auction_detail.id
     *
     * @mbg.generated Thu Sep 06 18:20:41 GMT+08:00 2018
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column auction_detail.id
     *
     * @param id the value for auction_detail.id
     *
     * @mbg.generated Thu Sep 06 18:20:41 GMT+08:00 2018
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column auction_detail.product_id
     *
     * @return the value of auction_detail.product_id
     *
     * @mbg.generated Thu Sep 06 18:20:41 GMT+08:00 2018
     */
    public Integer getProductId() {
        return productId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column auction_detail.product_id
     *
     * @param productId the value for auction_detail.product_id
     *
     * @mbg.generated Thu Sep 06 18:20:41 GMT+08:00 2018
     */
    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column auction_detail.auction_mode
     *
     * @return the value of auction_detail.auction_mode
     *
     * @mbg.generated Thu Sep 06 18:20:41 GMT+08:00 2018
     */
    public String getAuctionMode() {
        return auctionMode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column auction_detail.auction_mode
     *
     * @param auctionMode the value for auction_detail.auction_mode
     *
     * @mbg.generated Thu Sep 06 18:20:41 GMT+08:00 2018
     */
    public void setAuctionMode(String auctionMode) {
        this.auctionMode = auctionMode == null ? null : auctionMode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column auction_detail.auction_start_time
     *
     * @return the value of auction_detail.auction_start_time
     *
     * @mbg.generated Thu Sep 06 18:20:41 GMT+08:00 2018
     */
    public Date getAuctionStartTime() {
        return auctionStartTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column auction_detail.auction_start_time
     *
     * @param auctionStartTime the value for auction_detail.auction_start_time
     *
     * @mbg.generated Thu Sep 06 18:20:41 GMT+08:00 2018
     */
    public void setAuctionStartTime(Date auctionStartTime) {
        this.auctionStartTime = auctionStartTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column auction_detail.auction_dend_lime
     *
     * @return the value of auction_detail.auction_dend_lime
     *
     * @mbg.generated Thu Sep 06 18:20:41 GMT+08:00 2018
     */
    public Date getAuctionDendLime() {
        return auctionDendLime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column auction_detail.auction_dend_lime
     *
     * @param auctionDendLime the value for auction_detail.auction_dend_lime
     *
     * @mbg.generated Thu Sep 06 18:20:41 GMT+08:00 2018
     */
    public void setAuctionDendLime(Date auctionDendLime) {
        this.auctionDendLime = auctionDendLime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column auction_detail.auction_product_minimum_price
     *
     * @return the value of auction_detail.auction_product_minimum_price
     *
     * @mbg.generated Thu Sep 06 18:20:41 GMT+08:00 2018
     */
    public BigDecimal getAuctionProductMinimumPrice() {
        return auctionProductMinimumPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column auction_detail.auction_product_minimum_price
     *
     * @param auctionProductMinimumPrice the value for auction_detail.auction_product_minimum_price
     *
     * @mbg.generated Thu Sep 06 18:20:41 GMT+08:00 2018
     */
    public void setAuctionProductMinimumPrice(BigDecimal auctionProductMinimumPrice) {
        this.auctionProductMinimumPrice = auctionProductMinimumPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column auction_detail.auction_per_price
     *
     * @return the value of auction_detail.auction_per_price
     *
     * @mbg.generated Thu Sep 06 18:20:41 GMT+08:00 2018
     */
    public String getAuctionPerPrice() {
        return auctionPerPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column auction_detail.auction_per_price
     *
     * @param auctionPerPrice the value for auction_detail.auction_per_price
     *
     * @mbg.generated Thu Sep 06 18:20:41 GMT+08:00 2018
     */
    public void setAuctionPerPrice(String auctionPerPrice) {
        this.auctionPerPrice = auctionPerPrice == null ? null : auctionPerPrice.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column auction_detail.auction_final_price
     *
     * @return the value of auction_detail.auction_final_price
     *
     * @mbg.generated Thu Sep 06 18:20:41 GMT+08:00 2018
     */
    public BigDecimal getAuctionFinalPrice() {
        return auctionFinalPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column auction_detail.auction_final_price
     *
     * @param auctionFinalPrice the value for auction_detail.auction_final_price
     *
     * @mbg.generated Thu Sep 06 18:20:41 GMT+08:00 2018
     */
    public void setAuctionFinalPrice(BigDecimal auctionFinalPrice) {
        this.auctionFinalPrice = auctionFinalPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column auction_detail.auction_actual_price
     *
     * @return the value of auction_detail.auction_actual_price
     *
     * @mbg.generated Thu Sep 06 18:20:41 GMT+08:00 2018
     */
    public BigDecimal getAuctionActualPrice() {
        return auctionActualPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column auction_detail.auction_actual_price
     *
     * @param auctionActualPrice the value for auction_detail.auction_actual_price
     *
     * @mbg.generated Thu Sep 06 18:20:41 GMT+08:00 2018
     */
    public void setAuctionActualPrice(BigDecimal auctionActualPrice) {
        this.auctionActualPrice = auctionActualPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column auction_detail.auction_status
     *
     * @return the value of auction_detail.auction_status
     *
     * @mbg.generated Thu Sep 06 18:20:41 GMT+08:00 2018
     */
    public String getAuctionStatus() {
        return auctionStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column auction_detail.auction_status
     *
     * @param auctionStatus the value for auction_detail.auction_status
     *
     * @mbg.generated Thu Sep 06 18:20:41 GMT+08:00 2018
     */
    public void setAuctionStatus(String auctionStatus) {
        this.auctionStatus = auctionStatus == null ? null : auctionStatus.trim();
    }
}