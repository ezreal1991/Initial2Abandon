package com.gouqi.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName TimeUtil
 * @Description 获取时间
 * @Auther Wangjy
 * @Data 2019/5/14 9:50
 **/
public class TimeUtil {
    /**
     * @Description 获取自定义格式的字符串
     * @Date 9:52 2019/5/14
     * @Param [time] 时间格式例如 yyyy-MM-dd hh:mm:ss
     * @return java.lang.String 字符串类型的时间
     **/
    public static String getTime(String time){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(time);
        String dateTime = sdf.format(date);
        return dateTime;
    }
    /**
     * @Description 获取Long型时间
     * @Date 9:53 2019/5/14
     * @Param []
     * @return java.lang.Long
     **/
    public static Long getTimeMs(){
        Date dt= new Date();
        Long time= dt.getTime();
        return time;
    }
}
