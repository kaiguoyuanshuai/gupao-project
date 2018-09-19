package com.gupao.edu.activity.service.processor;

import com.gupao.edu.activity.dal.entity.ActivityAwardItem;
import com.gupao.edu.activity.service.processor.exception.RewardException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

/*
 * 描述:
 * @auth zhengkk19738
 * @time 2018/9/19
 */
@Service("activityTurntableDrawProxy")
public class ActivityTurntableDrawProxy implements ApplicationContextAware {

    private static final Logger logger = LoggerFactory.getLogger(ActivityTurntableDrawProxy.class);

    // 放大倍数
    private static final int mulriple = 10000;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

    }


    public ActivityDrawContext doDrawForProxy(ActivityDrawContext activityDrawContext) {
        try {
            List<ActivityAwardItem> awardItems = new ArrayList<>();

            ActivityAwardItem activityAwardItem = doPlayAward(awardItems);

            activityDrawContext.setActivityAwardItem(activityAwardItem);

            //抽到奖品之后,进行领奖操作【发放奖品】


        } catch (Exception UnRewardException) {
            logger.info("未抽到奖品或者出现异常的情况下");
        } finally {
            logger.info("ActivityTurntableDrawProxy.doDrawForProxy->{}", activityDrawContext);
        }

        return activityDrawContext;
    }

    /**
     * 抽奖逻辑
     *
     * @param awardItems
     * @return
     */
    private ActivityAwardItem doPlayAward(List<ActivityAwardItem> awardItems) {

        ActivityAwardItem activityAwardItem = null;

        if (awardItems.isEmpty()) {
            throw new RewardException("奖项未设定或未正确初始化");
        }

        int lastScope = 0;
        Collections.shuffle(awardItems);
        Map<Integer, int[]> awardItemScope = new HashMap<Integer, int[]>();
        for (ActivityAwardItem item : awardItems) { //item.getProbability=0.05 = 5%
            int currentScope = lastScope + new BigDecimal(item.getProbability().floatValue()).multiply(new BigDecimal(mulriple)).intValue();
            awardItemScope.put(item.getId(), new int[]{lastScope + 1, currentScope});
            lastScope = currentScope;
        }
        int luckyNumber = new Random().nextInt(mulriple);
        int luckyPrizeId = 0;
        if (!awardItemScope.isEmpty()) {
            Set<Map.Entry<Integer, int[]>> set = awardItemScope.entrySet();
            for (Map.Entry<Integer, int[]> entry : set)
                if (luckyNumber >= entry.getValue()[0] && luckyNumber <= entry.getValue()[1]) {
                    luckyPrizeId = entry.getKey();
                    break;
                }
        }

        for (ActivityAwardItem item : awardItems) {
            if (item.getId().intValue() == luckyPrizeId) {
                activityAwardItem = item;
                break;
            }
        }
        return activityAwardItem;
    }


}
