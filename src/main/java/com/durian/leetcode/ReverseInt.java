package com.durian.leetcode;

/**
 * @author ying.jiang
 * @define 整数反转
 *      1、不要用String.reverse  因为reverse底层会调用很多函数，影响性能
 *      2、可以通过整数模10来反转：
 *          需要注意整数溢出问题：
 *              1、rev > Integer.MAX_VALUE/10 必然溢出； rev == Integer.MAX_VALUE/10 时，当pop > Integer.MAX_VALUE % 10 时溢出
 *              2、rev < Integer.MAX_VALUE/10 必然溢出； rev == Integer.MAX_VALUE/10 时，当pop < Integer.MAX_VALUE % 10 时溢出
 * @date 2019-12-04-20:53:00
 */
public class ReverseInt {

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE % 10);
        System.out.println(reverseInt(Integer.MAX_VALUE - 6));
        System.out.println(reverseInt(Integer.MAX_VALUE + 1));
        System.out.println(reverseInt(Integer.MIN_VALUE + 7));
    }

    private static int reverseInt(int num) {
        int rev = 0;
        while (num != 0) {
            int pop = num % 10;
            num /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MIN_VALUE/10 && pop > Integer.MAX_VALUE % 10)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE/10 && pop < Integer.MIN_VALUE % 10)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }
}
