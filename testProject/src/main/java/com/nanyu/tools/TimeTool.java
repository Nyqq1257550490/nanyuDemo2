package com.nanyu.tools;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by NCZ on 2018/7/27.
 */
public class TimeTool {
    /**
     * 得到当前时间
     * @return
     */
    public static String getCurrentTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date());
    }

    /**
     * 得到当前时间（年月日)
     * @return
     */
    public static String getDateTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(new Date());
    }

    /**
     * 得到当前时间(时分秒）
     * @return
     */
    public static String getTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        return sdf.format(new Date());
    }

    /**
     * 时间格式转变为字符串
     * @param date
     * @return
     */
    public static String changeDateClass(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }

    /**
     * 字符串时间变成对应的秒
     * @param time
     * @return
     */
    public static long changeStringTimeToLong(String time){
        String[] my =time.split(":");
        int hour =Integer.parseInt(my[0]);
        int min =Integer.parseInt(my[1]);
        int sec =Integer.parseInt(my[2]);
        long totalSec =hour*3600+min*60+sec;
        return totalSec;
    }
}
