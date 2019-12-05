package com.durian.leetcode;

/**
 * @author ying.jiang
 * @define 判断字符串、整型是否是回文
 * @date 2019-12-05-21:17:00
 */
public class Palindrome {

    public static void main(String[] args) {
        System.out.println(isPalindromeInt(123));
        System.out.println(isPalindromeInt(1221));
        System.out.println(isPalindromeInt(12321));

        System.out.println(isPalindromeString("12211"));
        System.out.println(isPalindromeString("12321"));
    }

    private static boolean isPalindromeString(String str) {
        if (str.length() == 1) {
            return true;
        }

        StringBuilder rev = new StringBuilder();
        while (str.length() > rev.length()) {
            rev.append(str.charAt(str.length() - 1));
            str = str.substring(0, str.length() - 1);
        }

        return rev.toString().equals(str) || rev.subSequence(0, rev.toString().length() - 1).toString().equals(str);
    }


    private static boolean isPalindromeInt(int num) {

        /**
         * 当num<0时，肯定不是回文
         * 只有0是以0结尾的回文
         */
        if (num < 0 || (num % 10 == 0 && num != 0)) {
            return false;
        }

        /**
         * 去整数的回文，取到中间位置时，左右相等即为回文。 如： 1221
         * 当回文为奇数时，中间的那位不影响回文：如 12321   12 == 123/10
         */
        int rev = 0;
        while (num > rev) {
            rev = rev * 10 + num % 10;
            num /= 10;
        }
        return rev == num || num == rev / 10;
    }
}
