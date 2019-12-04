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
        LocalDateTime afterDate = LocalDateTime.now().plusDays(4);
        LocalDateTime beforeDate = LocalDateTime.now().minusDays(4);
        System.out.println(afterDate);
        System.out.println(beforeDate);

        System.out.println(Duration.between(LocalDateTime.now().minusHours(1), afterDate).toDays());
        System.out.println(Duration.between(LocalDateTime.now().minusHours(1), beforeDate).toDays());
        System.out.println(Duration.between(LocalDateTime.now(),LocalDateTime.now()).toDays());
    }

}
