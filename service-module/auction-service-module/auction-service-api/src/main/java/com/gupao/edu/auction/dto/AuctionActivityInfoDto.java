package com.gupao.edu.auction.dto;

import com.gupao.edu.serviceext.common.dto.BaseBean;

import java.math.BigDecimal;
import java.util.Date;

/*
 * 描述:
 * @auth zhengkk19738
 * @time 2018/11/7
 */
public class AuctionActivityInfoDto extends BaseBean {


    private static final long serialVersionUID = -4703885169240130306L;


    /**
     * <pre>
     *
     * 表字段： auction_detail.id
     * </pre>
     *
     */
    private String id;

    /**
     * <pre>
     * 竞拍的属性对象
     * 表字段： auction_detail.product_id
     * </pre>
     *
     */
    private String productId;

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getAuctionMode() {
        return auctionMode;
    }

    public void setAuctionMode(String auctionMode) {
        this.auctionMode = auctionMode;
    }

    public Date getAuctionStartTime() {
        return auctionStartTime;
    }

    public void setAuctionStartTime(Date auctionStartTime) {
        this.auctionStartTime = auctionStartTime;
    }

    public Date getAuctionDendLime() {
        return auctionDendLime;
    }

    public void setAuctionDendLime(Date auctionDendLime) {
        this.auctionDendLime = auctionDendLime;
    }

    public BigDecimal getAuctionProductMinimumPrice() {
        return auctionProductMinimumPrice;
    }

    public void setAuctionProductMinimumPrice(BigDecimal auctionProductMinimumPrice) {
        this.auctionProductMinimumPrice = auctionProductMinimumPrice;
    }

    public String getAuctionPerPrice() {
        return auctionPerPrice;
    }

    public void setAuctionPerPrice(String auctionPerPrice) {
        this.auctionPerPrice = auctionPerPrice;
    }

    public BigDecimal getAuctionFinalPrice() {
        return auctionFinalPrice;
    }

    public void setAuctionFinalPrice(BigDecimal auctionFinalPrice) {
        this.auctionFinalPrice = auctionFinalPrice;
    }

    public BigDecimal getAuctionActualPrice() {
        return auctionActualPrice;
    }

    public void setAuctionActualPrice(BigDecimal auctionActualPrice) {
        this.auctionActualPrice = auctionActualPrice;
    }

    public String getAuctionStatus() {
        return auctionStatus;
    }

    public void setAuctionStatus(String auctionStatus) {
        this.auctionStatus = auctionStatus;
    }
}
