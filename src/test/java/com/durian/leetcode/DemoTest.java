package com.durian.leetcode;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author ying.jiang
 * @define
 * @date 2019-12-04-09:48:00
 */
public class DemoTest {
    public static void main(String[] args) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("YYYY-MM-dd");
        System.out.println(simpleDateFormat.format(new Date()));
        System.out.println(simpleDateFormat1.format(new Date()));

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofPattern("YYYY-MM-dd");
        System.out.println(LocalDateTime.now().format(dateTimeFormatter));
        System.out.println(LocalDateTime.now().format(dateTimeFormatter1));
    }


    private static String getApplyDateDesc(LocalDateTime endTime) {
        Duration duration = Duration.between(LocalDateTime.now(), endTime);
        long hours = duration.toHours();
        long days = duration.toDays();
        long minutes = duration.toMinutes();

        if (LocalDateTime.now().isAfter(endTime)) {
            return "(认购已结束)";
        }
        if (days > 0) {
            return "(还剩" + days + "天)";
        }
        if (hours > 0) {
            return "(还剩" + hours + "小时)";
        }

        if (minutes > 0) {
            return "(还剩" + minutes + "分钟)";
        }
        return "(还剩" + 1 + "分钟)";
    }

}
