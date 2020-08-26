package com.durian.leetcode;

import java.util.Arrays;

/**
 * @author ying.jiang
 * @define Todo
 * @date 2020-06-29-11:48:00
 */
public class FindKthLargest {


    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

}
