package com.durian.leetcode;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * @author ying.jiang
 * @define
 * @date 2019-12-04-09:48:00
 */
public class DemoTest {
    public static void main(String[] args) {
        System.out.println(getApplyDateDesc(LocalDateTime.now().plusSeconds(10)));
        System.out.println(getApplyDateDesc(LocalDateTime.now().plusMinutes(10)));
        System.out.println(getApplyDateDesc(LocalDateTime.now().plusDays(10)));
        System.out.println(getApplyDateDesc(LocalDateTime.now().plusHours(10)));

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
