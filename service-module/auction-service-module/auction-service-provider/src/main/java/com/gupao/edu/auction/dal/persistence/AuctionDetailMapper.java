package com.gupao.edu.auction.dal.persistence;

import com.gupao.edu.auction.dal.entity.AuctionDetail;

import java.util.List;

public interface AuctionDetailMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AuctionDetail record);

    AuctionDetail selectByPrimaryKey(Integer id);

    List<AuctionDetail> selectAll();

    int updateByPrimaryKey(AuctionDetail record);
}