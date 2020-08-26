package com.durian.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ying.jiang
 * @define Todo
 * @date 2020-08-25-10:45:00
 */
public class ThreeSum {
    public static void main(String[] args) {
        int [] nums = new int[]{-1,0,1,2,-1,-4};

        List<List<Integer>> list = new ThreeSum().threeSum(nums);
        System.out.println(list);
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < length - 1; i++) {
            if (nums[i] > 0) {
                return list;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int L = i + 1, R = length - 1;
            while (L < R) {
                if (nums[i] + nums[L] + nums[R] == 0) {
                    int temp = i;
                    ArrayList<Integer> singleList = new ArrayList<>();
                    singleList.add(nums[i]);
                    singleList.add(nums[L]);
                    singleList.add(nums[R]);
                    list.add(singleList);
                    while (L < R && nums[L]==nums[L+1]) {
                        ++L;
                    }
                    while (L < R && nums[R]==nums[R-1]) {
                        --R;
                    }
                    ++L;
                    --R;
                } else if (nums[i] + nums[L] + nums[R] < 0) {
                    L++;
                } else {
                    R--;
                }
            }

        }
        return list;
    }
}
