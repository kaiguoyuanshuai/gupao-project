package com.gupao.edu.auction.biz.process;

import com.gupao.edu.auction.biz.AbstractAuctionTaskProcess;
import com.gupao.edu.auction.biz.AuctionContext;
import com.gupao.edu.auction.constants.AuctionCacheKeyConstants;
import com.gupao.edu.auction.dto.AuctionWorkRequest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Set;

/*
 * 描述: 定额限定价格模式
 * @auth zhengkk19738
 * @time 2018/9/28
 */
@Service("quotaHightPriceLimitAuctionProcess")
public class QuotaHightPriceLimitAuctionProcess extends AbstractAuctionTaskProcess {

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public void doProcess(Object auctionContextParam) {
        AuctionContext auctionContext = (AuctionContext) auctionContextParam;
        //判断key是否存在

        AuctionWorkRequest auctionWorkRequest = auctionContext.getAuctionWorkRequest();

        Set<ZSetOperations.TypedTuple> scoreWithScores = redisTemplate.opsForZSet()
                .rangeByScoreWithScores(AuctionCacheKeyConstants.AUCTION_SECURITY_KEY + auctionWorkRequest.getAuctionActivityId(), 0, 0);

        if (!CollectionUtils.isEmpty(scoreWithScores)) {
            for (ZSetOperations.TypedTuple typedTuple : scoreWithScores) {
                String securityKey = typedTuple.getValue().toString();
                if (StringUtils.equals(auctionWorkRequest.getAuctionKey(), securityKey)) {

                    //大于0 表示 真正的获取到价格的资格
                    if (redisTemplate.opsForZSet().remove(AuctionCacheKeyConstants.AUCTION_SECURITY_KEY + auctionWorkRequest.getAuctionActivityId(), securityKey) > 0) {
                        String score = typedTuple.getScore().toString();
                        LOGGER.info("恭喜XXXX获取竞购价格资格");

                        //TODO 该用户竞拍到了之后 走存储数据的流程

                        //TODO 发出一个竞拍成功的消息队列，让消费者去判断是否需要增加 zset的值
                    }
                }
            }
        } else {

        }
        //对比获取到的key是否一致

        //移除key是否大于1

        //如果大于1表示成功

    }

    @Override
    protected int getAuctionType() {
        return 0;
    }

}
