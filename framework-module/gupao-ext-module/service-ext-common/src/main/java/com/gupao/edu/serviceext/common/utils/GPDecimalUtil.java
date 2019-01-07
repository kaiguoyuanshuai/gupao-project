package com.gupao.edu.serviceext.common.utils;

import java.math.BigDecimal;

/*
 * 描述:
 * @auth zhengkk19738
 * @time 2019/1/7
 */
public class GPDecimalUtil {
    private GPDecimalUtil() {
    }

    /**
     * 加
     *
     * @param v1
     * @param v2
     * @return
     */
    public static BigDecimal add(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.add(b2);
    }

    public static BigDecimal add(Object v1, Object v2) {
        BigDecimal b1 = new BigDecimal(String.valueOf(v1));
        BigDecimal b2 = new BigDecimal(String.valueOf(v2));
        return b1.add(b2);
    }

    /**
     * 减
     *
     * @param v1
     * @param v2
     * @return
     */
    public static BigDecimal sub(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.subtract(b2);
    }

    public static BigDecimal sub(Object v1, Object v2) {
        BigDecimal b1 = new BigDecimal(String.valueOf(v1));
        BigDecimal b2 = new BigDecimal(String.valueOf(v2));
        return b1.subtract(b2);
    }

    /**
     * 乘
     *
     * @param v1
     * @param v2
     * @return
     */
    public static BigDecimal mul(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.multiply(b2);
    }


    public static BigDecimal mul(Object v1, Object v2) {
        BigDecimal b1 = new BigDecimal(String.valueOf(v1));
        BigDecimal b2 = new BigDecimal(String.valueOf(v2));
        return b1.multiply(b2);
    }

    /**
     * 除法 :四舍五入,保留2位小数
     *
     * @param v1
     * @param v2
     * @return
     */
    public static BigDecimal div(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.divide(b2, 2, BigDecimal.ROUND_HALF_UP);//四舍五入,保留2位小数
    }


    /**
     * 除法 :四舍五入,保留2位小数
     *
     * @param v1
     * @param v2
     * @return
     */
    public static BigDecimal div(Object v1, Object v2) {
        BigDecimal b1 = new BigDecimal(String.valueOf(v1));
        BigDecimal b2 = new BigDecimal(String.valueOf(v2));
        return b1.divide(b2, 2, BigDecimal.ROUND_HALF_UP);//四舍五入,保留2位小数
    }

    /**
     * 比较大小
     *
     * @param v1
     * @param v2
     * @return
     */
    public static boolean campare(Object v1, Object v2) {
        BigDecimal b1 = new BigDecimal(String.valueOf(v1));
        BigDecimal b2 = new BigDecimal(String.valueOf(v2));
        return b1.compareTo(b2) > 0;
    }

    /**
     * 比较相等
     *
     * @param v1
     * @param v2
     * @return
     */
    public static boolean eq(Object v1, Object v2) {
        BigDecimal b1 = new BigDecimal(String.valueOf(v1));
        BigDecimal b2 = new BigDecimal(String.valueOf(v2));
        return b1.compareTo(b2) == 0;
    }


    public static void main(String[] args) {
        System.out.println(GPDecimalUtil.add(1, 1));
        System.out.println(GPDecimalUtil.add(new Integer(1), new Integer(1)));
        System.out.println(GPDecimalUtil.add(1.0, 1f));
        System.out.println(GPDecimalUtil.add(1, 1));

        System.out.println(GPDecimalUtil.sub(1, 1));
        System.out.println(GPDecimalUtil.sub(new Integer(1), new Integer(1)));
        System.out.println(GPDecimalUtil.sub(1.0, 1f));
        System.out.println(GPDecimalUtil.sub(1, 1));

        System.out.println(GPDecimalUtil.mul(2, 1));
        System.out.println(GPDecimalUtil.mul(new Integer(2), new Integer(1)));
        System.out.println(GPDecimalUtil.mul(2.0, 1f));
        System.out.println(GPDecimalUtil.mul(2, 1));

        System.out.println(GPDecimalUtil.div(1, 1));
        System.out.println(GPDecimalUtil.div(new Integer(1), new Integer(1)));
        System.out.println(GPDecimalUtil.div(1.0, 1f));
        System.out.println(GPDecimalUtil.div(1, 1));
    }

}
