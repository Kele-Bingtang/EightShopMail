package com.eight.utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 处理日期相关的操作
 */
public class DateUtil {

    /**
     * 把日期格式转换成年月日(yyyy-MM-dd)的字符串
     */
    public static String dateConvertString(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(date);
    }

    public static Timestamp dataConvertTimeStamp(String date) {
        if (date.split(":").length != 3) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            try {
                return new Timestamp(sdf.parse(date).getTime());
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return Timestamp.valueOf(date);
    }

    public static Timestamp timestamp8HBefor(Timestamp timestamp) {
        Date date = new Date(timestamp.getTime());
        date.setTime(date.getTime() - 60 * 60 * 8 * 1000);

        return new Timestamp(date.getTime());
    }

    public static Timestamp timestamp1DBefor(Timestamp timestamp) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(timestamp.getTime() - 60 * 60 * 24 * 1000);
        return dataConvertTimeStamp(sdf.format(date));
    }

    public static void main(String[] args) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Timestamp timestamp1 = timestamp1DBefor(timestamp);
        System.out.println(timestamp1);

    }

}

