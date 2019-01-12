package com.yidiandian.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @Author: 一点点
 * @Date: 2019/1/12 17:09
 * @Version 1.0
 */
public class DateUtils {

    public static String localDate2TimeString(LocalDateTime localDateTime) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return df.format(localDateTime);
    }

}
