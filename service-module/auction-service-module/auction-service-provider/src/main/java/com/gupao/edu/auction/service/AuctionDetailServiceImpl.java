package com.gupao.edu.auction.service;

import com.gupao.edu.auction.AuctionModelEnum;
import com.gupao.edu.auction.dal.entity.AuctionDetail;
import com.gupao.edu.auction.dal.persistence.AuctionDetailMapper;
import com.gupao.edu.auction.dto.AuctionDetailRequest;
import com.gupao.edu.auction.dto.AuctionDetailResponse;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
 * 描述:
 * @auth zhengkk19738
 * @time 2018/9/6
 */
@Service
public class AuctionDetailServiceImpl implements AuctionDetailService {

    private Logger LOGGER = LoggerFactory.getLogger(AuctionDetailServiceImpl.class);

/*    @Autowired
    private AuctionTaskProcess auctionTaskProcess;*/

    @Autowired
    private AuctionDetailMapper auctionDetailMapper;

    @Override
    public AuctionDetailResponse saveAuctionDetail(AuctionDetailRequest auctionDetailRequest) {
        AuctionDetailResponse auctionDetailResponse = new AuctionDetailResponse();
        if (!checkAucationDetailParam(auctionDetailRequest)) {
            auctionDetailResponse.fail("10004", "参数校验失败");
            return auctionDetailResponse;
        }
        //存储相关活动内容
        AuctionDetail auctionDetail = new AuctionDetail();
        BeanUtils.copyProperties(auctionDetailRequest, auctionDetail);

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("执行存储竞购细节的参数为：", auctionDetail.toString());
        }

        //TODO 检查产品信息存不存在

        auctionDetailMapper.insert(auctionDetail);

        //创建活动细节内容

        //存储到redis 中
        auctionDetailResponse.success();
        return auctionDetailResponse;
    }

    /**
     * 检查竞购的细节参数
     *
     * @param auctionDetailRequest
     * @return
     */
    private boolean checkAucationDetailParam(AuctionDetailRequest auctionDetailRequest) {

        //检查产品ID
        if (auctionDetailRequest.getProductId() == null) {
            LOGGER.error("参与竞购的产品ID不能为空");
            return false;
        }

        //检查竞购模式
        if (StringUtils.isEmpty(auctionDetailRequest.getAuctionMode())) {
            LOGGER.error("竞购模式不能为空");
            return false;
        }

        //检查开始时间
        if (auctionDetailRequest.getAuctionStartTime() == null) {
            LOGGER.error("竞购开始时间不能为空");
            return false;
        }
        //检查结束时间
        if (auctionDetailRequest.getAuctionDendLime() == null) {
            LOGGER.error("竞购结束时间不能为空");
            return false;
        }

        //检查结束时间不能比开始时间早
        if (auctionDetailRequest.getAuctionDendLime().compareTo(auctionDetailRequest.getAuctionStartTime()) <= 0) {
            LOGGER.error("竞购结束时间不能比竞购开始时间早");
            return false;
        }

        //检查最低成交价格不能为空
        if (auctionDetailRequest.getAuctionProductMinimumPrice() == null) {
            LOGGER.error("最低成交价格不能为空");
            return false;
        }

        if (StringUtils.isEmpty(auctionDetailRequest.getAuctionPerPrice()) && !StringUtils.isNumeric(auctionDetailRequest.getAuctionPerPrice())) {
            LOGGER.error("加价幅度不能为空或者必须为数值");
            return false;
        }

        if (StringUtils.equals(auctionDetailRequest.getAuctionMode(), AuctionModelEnum.AUCTION_PRICE_MODEL.getLabel())
                && !(auctionDetailRequest.getAuctionFinalPrice() != null
                && StringUtils.isNumeric(auctionDetailRequest.getAuctionFinalPrice().toString()))) {
            LOGGER.error("时间模式下,预设的最终价格不能为空或者必须为数值");
            return false;
        }

        return true;
    }
}
