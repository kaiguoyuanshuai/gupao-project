package com.gupao.edu.auction.factory;

import com.gupao.edu.auction.internal.AuctionPriceThresholdProcess;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by zhengkk19738 on 2018/6/14.
 */

@Component
public class PriceThresholdModelFactory implements ApplicationContextAware {

    private static Map<String, AuctionPriceThresholdProcess> trafficBeanMap;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        trafficBeanMap = new HashedMap();
        Map<String, AuctionPriceThresholdProcess> beansOfTypeServices = applicationContext.getBeansOfType(AuctionPriceThresholdProcess.class);

        for (AuctionPriceThresholdProcess auctionPriceThresholdProcess : beansOfTypeServices.values()) {
            trafficBeanMap.put(auctionPriceThresholdProcess.priceType(), auctionPriceThresholdProcess);
        }
    }


    /**
     * 根据业务类型选择对应的实现类
     *
     * @param type 业务类型
     * @param <T>
     * @return
     */
    public static <T extends AuctionPriceThresholdProcess> T getAuctionPriceProcess(String type) {
        return (T) trafficBeanMap.get(type);
    }


}
