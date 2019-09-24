package com.durian.leetcode;

import java.util.HashMap;

/**
 * 类说明：求最长不重复子字符串
 * <p>
 * 详细描述：
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * @author Jiang
 * @since 2019年09月24日
 */
public class LengthOfLongestSubStr {

    public static void main(String[] args) {

//        int[] a = new int[]{'a', 'b', 'z'};
//        for (int i : a) {
//            System.out.println(i);
//        }

        System.out.println(lengthOfLongestSubstring("aaa"));
        System.out.println(lengthOfLongestSubstring("sasdaa"));
        System.out.println(lengthOfLongestSubstring("sdfagdeaa"));
    }


    /**
     * 滑动窗口法，[i,j]数组，j一直往右移，当出现重复j时，将i置为j'+1
     *
     * @param s str
     * @return 时间复杂度 O(n), 空间复杂度：O(max(m,n))
     */
    private static int lengthOfLongestSubstring(String s) {
        int len = s.length(), ans = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0, j = 0; j < len; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }

            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }

        return ans;
    }

    /**
     * 使用int[]来保存char对应在字符串中的位置
     *
     * @param s s
     * @return 时间复杂度 O(n), 空间复杂度：O(m)
     */
    private static int lengthOfLongestSubstringByASCII(String s) {
        int n = s.length(), ans = 0;
        int[] index = new int[128]; // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            i = Math.max(index[s.charAt(j)], i);
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }
        return ans;
    }


}