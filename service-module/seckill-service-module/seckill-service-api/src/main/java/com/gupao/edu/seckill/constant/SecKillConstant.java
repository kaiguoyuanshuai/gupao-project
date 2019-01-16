package com.gupao.edu.seckill.constant;

/*
 * 描述:
 * @auth zhengkk19738
 * @time 2019/1/11
 */
public class SecKillConstant {

    public static final int CALL_COUNT = 10;

    public static final String SECKILL_PRE_COUNT = "SECKILL_PRE_COUNT:";

    public static final String SECKILL_CACHE_KEY ="SECKILL:INFO:" ;



    //==================MQ=====================

    public static final String SECKILL_DO_MQ_MESSAGE = "seckill.kill.event" ;













    //===========================LUA==========================

    //初始化秒杀预留的数据,返回1表示成功
    public static final String INIT_SECKILL_GOODS__COUNT_SCRIPT =
            "local key = \"rate.limit:\" .. KEYS[1] ;" +
            "local expire = tonumber(ARGV[1]);" +
            "local number = tonumber(ARGV[2]);" +
            "local count = tonumber(redis.call(\"GET\",key));" +
            "if count == nil then " +
                "redis.call(\"SET\",tostring(key),number);"+
                "redis.call(\"EXPIRE\",tostring(key),expire);" +
                "return \"1\";" +
            "else " +
                "redis.call(\"SET\",tostring(key),number);"+
                "redis.call(\"EXPIRE\",tostring(key),expire);" +
                "return \"1\";" +
            "end " ;

    //递减器
    // 返回 ： >=0 成功递减,返回数值 ; -1 递减失败，值为0   ; -2 没有该值
    public static final String DECR_SECKILL_GOODS__COUNT_SCRIPT =
            "local key = \"rate.limit:\" .. KEYS[1] ;" +
            "local count = tonumber(redis.call(\"GET\",key));" +
           "if count == nil then " +
            "        return \"-2\";" +
             "else " +
            "        if count > 0 then " +
            "            local curr = redis.call(\"DECR\",key); " +
            "                return curr; " +
            "        else " +
            "                return \"-1\"; " +
            "        end " +
            "end " ;

    //中途叠加 -1 表示不存在  ；返回数值为增加后的值
    public static final String ADD_SECKILL_GOODS__COUNT_SCRIPT =
            "local key = \"rate.limit:\" .. KEYS[1] ;" +
            "local addCount = tonumber(ARGV[1]); " +
            "local count = tonumber(redis.call(\"GET\",key)); " +
            "if count == nil then " +
            "        return \"-1\"; " +
            "else " +
            "   local curr = count+addCount ; "+
            "   redis.call(\"SET\",key,count+addCount); " +
            "   return curr ; " +
            "end" ;
}
