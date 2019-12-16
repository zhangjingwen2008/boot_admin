package com.zhangjingwen.web.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

public class TimeAndDateUtils {

    //获取时间戳
    public static long getTimestamp() {
        return Instant.now().getEpochSecond();
    }

    //时间戳转日期
    public static String getDateFromTimestamp(long timestamp) {
        String df1="yyyy-MM-dd HH:mm:ss";
        return new SimpleDateFormat(df1).format(timestamp * 1000);
    }

    //获得指定时间前后的时间戳
    public static long getAfterTime(int days) {
        long time = (long) days * 86400000;
        long afterTime = new Date(System.currentTimeMillis() + time).getTime()/1000;
        return afterTime;
    }

}
