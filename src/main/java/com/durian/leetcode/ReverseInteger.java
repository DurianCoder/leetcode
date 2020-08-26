package com.durian.leetcode;

/**
 * @author ying.jiang
 * @define Todo
 * @date 2020-06-30-10:08:00
 */
public class ReverseInteger {

    public static void main(String[] args) {
        System.out.println(new ReverseInteger().reverse(1534236469));
    }

    /**
     * 1534236469
     * 输出
     * 1056389759
     * @param x
     * @return
     */
    public int reverse(int x) {
        long ans = 0;
        while (x != 0) {
            ans = ans * 10 + x % 10;
            x = x / 10;
        }
        return (int) ans;
    }
}
