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

    public static String changeDateClass(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }
}
