package com.gupao.edu.seckill.dto;

import com.gupao.edu.serviceext.common.dto.BaseRequest;

import java.util.Date;

/*
 * 描述:
 * @auth zhengkk19738
 * @time 2019/1/11
 */
public class SeckillInfoRequest extends BaseRequest {

    /**
     * <pre>
     *
     * 表字段： seckill-activity.id
     * </pre>
     */
    private Integer id;

    /**
     * <pre>
     * 秒杀名称
     * 表字段： seckill-activity.seckill_name
     * </pre>
     */
    private String seckillName;

    /**
     * <pre>
     * 货物名称
     * 表字段： seckill-activity.seckill_goods_name
     * </pre>
     */
    private String seckillGoodsName;

    /**
     * <pre>
     * 货物数量
     * 表字段： seckill-activity.seckill_goods_num
     * </pre>
     */
    private Integer seckillGoodsNum;

    /**
     * <pre>
     * 秒杀开始时间
     * 表字段： seckill-activity.seckill_start_time
     * </pre>
     */
    private Date seckillStartTime;

    /**
     * <pre>
     * 秒杀结束时间
     * 表字段： seckill-activity.seckill_end_time
     * </pre>
     */
    private Date seckillEndTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSeckillName() {
        return seckillName;
    }

    public void setSeckillName(String seckillName) {
        this.seckillName = seckillName;
    }

    public String getSeckillGoodsName() {
        return seckillGoodsName;
    }

    public void setSeckillGoodsName(String seckillGoodsName) {
        this.seckillGoodsName = seckillGoodsName;
    }

    public Integer getSeckillGoodsNum() {
        return seckillGoodsNum;
    }

    public void setSeckillGoodsNum(Integer seckillGoodsNum) {
        this.seckillGoodsNum = seckillGoodsNum;
    }

    public Date getSeckillStartTime() {
        return seckillStartTime;
    }

    public void setSeckillStartTime(Date seckillStartTime) {
        this.seckillStartTime = seckillStartTime;
    }

    public Date getSeckillEndTime() {
        return seckillEndTime;
    }

    public void setSeckillEndTime(Date seckillEndTime) {
        this.seckillEndTime = seckillEndTime;
    }
}
