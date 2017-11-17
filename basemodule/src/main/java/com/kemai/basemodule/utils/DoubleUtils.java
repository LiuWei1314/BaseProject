package com.kemai.basemodule.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * double操作类
 */
public class DoubleUtils {
    /**
     * 四舍五入，保留一位小数
     *
     * @param value
     * @return
     */
    public static String round_1f_s(double value) {
        return round_string(value, 1, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * 四舍五入，保留两位小数
     *
     * @param value
     * @return
     */
    public static String round(double value) {
        return round_string(value, 2, BigDecimal.ROUND_HALF_UP);
    }

    public static double round_d(double value) {
        return round(value, 2, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * 四舍五入，保留三位小数
     *
     * @param value
     * @return
     */
    public static String round_3f_s(double value) {
        return round_string(value, 3, BigDecimal.ROUND_HALF_UP);

    }

    public static double round_3f_d(double value) {
        return round(value, 3, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * 四舍五入，保留四位小数
     *
     * @param value
     * @return
     */
    public static double round_4f_d(double value) {
        return round(value, 4, BigDecimal.ROUND_HALF_UP);
    }

    public static String round_4f_s(double value) {
        return round_string(value, 4, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * 四舍五入，保留零位小数
     *
     * @param value
     * @return
     */
    public static String roundZero(double value) {
        return round_string(value, 0, BigDecimal.ROUND_HALF_UP);
    }

    public static double roundDoubleThree(double value) {
        return round(value, 3, BigDecimal.ROUND_HALF_UP);

    }

    public static double roundDoubleTwo(double value) {
        return round(value, 2, BigDecimal.ROUND_HALF_UP);

    }

    public static double roundDoubleOne(double value) {
        return round(value, 1, BigDecimal.ROUND_HALF_UP);
    }

    public static double roundDoubleZero(double value) {
        return round(value, 0, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * 对double数据进行取精度.
     *
     * @param value        double数据.
     * @param scale        精度位数(保留的小数位数).
     * @param roundingMode 精度取值方式.
     * @return 精度计算后的数据.
     */
    public static double round(double value, int scale,
                               int roundingMode) {
        try {
            BigDecimal bd = new BigDecimal(value);
            bd = bd.setScale(scale, roundingMode);
            double d = bd.doubleValue();
            return d;
        } catch (Exception e) {

        }
        return 0;
    }

    public static String round_string(double value, int scale,
                                      int roundingMode) {
        try {
            BigDecimal bd = new BigDecimal(value);
            bd = bd.setScale(scale, roundingMode);
            return bd.toString();
        } catch (Exception e) {

        }
        return "0";
    }

    /**
     * 把String值转换为double
     *
     * @param str 要转化的字符串
     * @return 转化后的值
     */
    public static double valueOf(String str) {
        try {
            return Double.valueOf(str);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    /**
     * double 相加
     *
     * @param d1 double值1
     * @param d2 double值2
     * @return 相加之和
     */
    public static double sum(double d1, double d2) {
        BigDecimal bd1 = new BigDecimal(Double.toString(d1));
        BigDecimal bd2 = new BigDecimal(Double.toString(d2));
        return bd1.add(bd2).doubleValue();
    }


    /**
     * double 相减
     *
     * @param d1 double值1
     * @param d2 double值2
     * @return 相减之和
     */
    public static double sub(double d1, double d2) {
        BigDecimal bd1 = new BigDecimal(Double.toString(d1));
        BigDecimal bd2 = new BigDecimal(Double.toString(d2));
        return bd1.subtract(bd2).doubleValue();
    }

    /**
     * double 乘法
     *
     * @param d1 double值1
     * @param d2 double值2
     * @return 相乘之和
     */
    public static double mul(double d1, double d2) {
        BigDecimal bd1 = new BigDecimal(Double.toString(d1));
        BigDecimal bd2 = new BigDecimal(Double.toString(d2));
        return bd1.multiply(bd2).doubleValue();
    }


    /**
     * double 除法
     *
     * @param d1    double值1
     * @param d2    double值2
     * @param scale 四舍五入 小数点位数
     * @return 相除之和
     */
    public static double div(double d1, double d2, int scale) {
        //  当然在此之前，你要判断分母是否为0，
        //  为0你可以根据实际需求做相应的处理

        BigDecimal bd1 = new BigDecimal(Double.toString(d1));
        BigDecimal bd2 = new BigDecimal(Double.toString(d2));
        return bd1.divide
                (bd2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * 正常显示整数和小数
     *
     * @param num
     * @return
     */
    public static String D2S(double num) {
//        String sNum = String.valueOf(num);
//        if (sNum.contains(".")) {
//            int i = sNum.indexOf(".");
//            String s = sNum.substring(i + 1);
//            if (DoubleUtils.valueOf(s) > 0) {
//                sNum = DoubleUtils.round_3f_s(num);
//            } else {
//                sNum = DoubleUtils.roundZero(num);
//
//            }
//        } else {
//            sNum = DoubleUtils.roundZero(num);
//        }
        DecimalFormat decimalFormat = new DecimalFormat("###################.###########");
        return decimalFormat.format(num);
    }

    /**
     * 正常显示整数和小数,小数保留两位
     *
     * @param num
     * @return
     */
    public static String D2S_2f(double num) {
        String sNum = String.valueOf(num);
        if (sNum.contains(".")) {
            int i = sNum.indexOf(".");
            String s = sNum.substring(i + 1);
            if (DoubleUtils.valueOf(s) > 0) {
                sNum = round_string(num, 2, BigDecimal.ROUND_HALF_UP);
            } else {
                sNum = DoubleUtils.roundZero(num);

            }
        } else {
            sNum = DoubleUtils.roundZero(num);
        }
        return sNum;
    }

    public static String D2S_3f(double num) {
        String sNum = String.valueOf(num);
        if (sNum.contains(".")) {
            int i = sNum.indexOf(".");
            String s = sNum.substring(i + 1);
            if (DoubleUtils.valueOf(s) > 0) {
                sNum = round_string(num, 3, BigDecimal.ROUND_HALF_UP);
            } else {
                sNum = DoubleUtils.roundZero(num);

            }
        } else {
            sNum = DoubleUtils.roundZero(num);
        }
        return sNum;
    }

    /**
     * 正常显示整数和小数
     *
     * @param num
     * @return
     */
    public static String D_S(double num) {
        String sNum = String.valueOf(num);
        if (sNum.contains(".")) {
            int i = sNum.indexOf(".");
            String s = sNum.substring(i + 1);
            if (DoubleUtils.valueOf(s) > 0) {
                sNum = BigDecimal.valueOf(num).stripTrailingZeros().toPlainString();
            } else {
                sNum = DoubleUtils.roundZero(num);
            }
        } else {
            sNum = DoubleUtils.roundZero(num);
        }
        return sNum;
    }

}
