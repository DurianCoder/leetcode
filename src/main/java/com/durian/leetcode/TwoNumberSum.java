package com.durian.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 类说明：求两数之和
 * <p>
 * 详细描述：
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * @author Jiang
 * @since 2019年09月22日
 */
public class TwoNumberSum {

    public static void main(String[] args) {

        HashMap<Object, Object> map = new HashMap<>();
        map.containsKey("1");

    }

    /**
     * 使用暴力的方法，两次for循环
     *
     * @param nums nums
     * @param target target
     * @return 时间复杂度 f(n^2)  空间复杂度f(1)
     */
    public int[] twoSumSolution1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        throw new IllegalArgumentException("No two sum solution!");
    }


    /**
     * 使用map灵活应用，使用map.containsKey(key)的时候可能会存在对链表的一个遍历。
     * @param nums nums
     * @param target target
     * @return  时间复杂度 f(n)  空间复杂度f(n)
     */
    public int[] twoSumSolution2(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            }

            map.put(nums[i], i);
        }

        throw new IllegalArgumentException("No two sum solution!");
    }

}