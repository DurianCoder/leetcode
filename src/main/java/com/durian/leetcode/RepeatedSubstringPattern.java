package com.durian.leetcode;

/**
 * @author ying.jiang
 * @define
 * @date 2020-08-24-15:01:00
 *
 * 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。
 *
 * 示例 1:
 *
 * 输入: "abab"
 *
 * 输出: True
 *
 * 解释: 可由子字符串 "ab" 重复两次构成。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/repeated-substring-pattern
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RepeatedSubstringPattern {

    public static void main(String[] args) {
        int n = 2;
    }

    public boolean repeatedSubstringPattern(String s) {
        return (s + s).indexOf(s, 1) != s.length();
    }

    public boolean repeatedSubstringPattern1(String s) {
        int length = s.length();
        for (int i = 1; i * 2 <= length; i++) {

            // 如果是由子串组成，s.len = n * s'.len
            if (length % i == 0) {
                boolean match = true;
                for (int j = i; j < length; j++) {
                    if (s.charAt(j) != s.charAt(j - i)) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    return true;
                }
            }
        }
        return false;
    }
}
