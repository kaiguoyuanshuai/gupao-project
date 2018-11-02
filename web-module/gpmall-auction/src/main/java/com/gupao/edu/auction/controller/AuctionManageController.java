package com.gupao.edu.auction.controller;

import com.gupao.edu.auction.dto.AuctionDetailRequest;
import com.gupao.edu.auction.dto.AuctionDetailResponse;
import com.gupao.edu.auction.service.AuctionDetailService;
import com.gupao.edu.web.controller.BaseController;
import com.gupao.edu.web.support.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * 描述: 竞购管理接口
 * @auth zhengkk19738
 * @time 2018/11/2
 */

@RestController
@RequestMapping("/auction/manage/")
public class AuctionManageController extends BaseController {

    @Autowired
    private AuctionDetailService auctionDetailService;


    @RequestMapping("createAuction")
    public ResponseData createAuction(AuctionDetailRequest auctionDetailRequest) {
        try {
            AuctionDetailResponse auctionDetailResponse = auctionDetailService.saveAuctionDetail(auctionDetailRequest);
            if (auctionDetailResponse.isSuccess()) {
                return ResponseData.SUCCESS();
            } else {
                LOGGER.warn("创建竞购信息的失败:{},{}", auctionDetailResponse.getCode(), auctionDetailResponse.getMsg());
                return new ResponseData(auctionDetailResponse.getCode(), auctionDetailResponse.getMsg());
            }
        } catch (Exception ex) {
            LOGGER.error("创建竞购信息的时候出现异常!", ex);
            return ResponseData.FAILED();
        }
    }

}
