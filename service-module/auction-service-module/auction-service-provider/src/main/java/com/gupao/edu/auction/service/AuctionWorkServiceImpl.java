package com.gupao.edu.auction.service;

import com.gupao.edu.auction.biz.AuctionContext;
import com.gupao.edu.auction.biz.AuctionTaskProcess;
import com.gupao.edu.auction.dto.AuctionWorkRequest;
import com.gupao.edu.auction.dto.AuctionWorkResponse;
import org.springframework.stereotype.Service;

/*
 * 描述:
 * @auth zhengkk19738
 * @time 2018/11/7
 */
@Service
public class AuctionWorkServiceImpl implements AuctionWorkService {

    private AuctionTaskProcess auctionTaskProcess;

    @Override
    public AuctionWorkResponse doAuctionWork(AuctionWorkRequest auctionWorkRequest) {

        checkAuctionWorkParam(auctionWorkRequest);

        AuctionContext auctionContext = new AuctionContext();
        auctionContext.setAuctionWorkRequest(auctionWorkRequest);
        auctionTaskProcess.doAuction(auctionContext);

        return null;
    }

    private void checkAuctionWorkParam(AuctionWorkRequest auctionWorkRequest) {
    }


}
