package com.durian.leetcode;

/**
 * @author ying.jiang
 * @desc  中位数 :将一个集合划分为两个长度相等的子集，其中一个子集中的元素总是大于另一个子集中的元素。：
 *
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 *
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 * 示例 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * 则中位数是 2.0
 * 示例 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * 则中位数是 (2 + 3)/2 = 2.5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2019-09-25-17:27:00
 */
public class FindMedianSortedArrays {
    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1,2,3,4}, new int[]{2,5,7,8}));
        System.out.println(findMedianSortedArrays(new int[]{1,2,3}, new int[]{2,4,5,7}));
        System.out.println(findMedianSortedArrays(new int[]{1,2,3}, new int[]{4,5,7}));
    }


    /**
     * 中位数
     * 1、特殊情况处理：当nums1最大值小于nums2最小值；当nums2最大值小于nums1最小值；
     *
     * @param nums1 nums1
     * @param nums2 nums2
     * @return 时间复杂度：O(min(m,n))  空间复杂度：O(min(m,n))
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double mid = 0;
        int m = Math.min(nums1.length, nums2.length);
        int n = Math.max(nums1.length, nums2.length);

        /**
         * 1、特殊情况处理：当nums1最大值小于nums2最小值；当nums2最大值小于nums1最小值；
         *  2、普通情况处理：
         *              将两个数组放在一起，结构类似：
         *            数组A:      1  2  3  5       2  4  6
         *            数组B:      3  6  7  8       4  6  7 9
         *            在数组A和B中各找到一个位置pa,pb,保证pa,pb将两个组个个数平分；当pa左边的值小于pb右边的值
         *            且pb左边的值小于pa右边的值时，中位数为pa,pb左边最大值与pa,pb右边最小值之和除2
         */
        if (nums1[nums1.length - 1] < nums2[0]) {
            return (nums1[nums1.length - 1] + nums2[0])/2d;
        } else if (nums1[0] > nums2[nums2.length - 1]) {
            return (nums1[0] + nums2[nums2.length - 1])/2d;
        }


        /**
         * 2、普通情况处理：
         *    将两个数组放在一起，结构类似：
         *  数组A:      1  2  3  5       2  4  6
         *  数组B:      3  6  7  8       4  6  7 9
         *  在数组A和B中各找到一个位置pa,pb,保证pa,pb将两个组个个数平分；当pa左边的值小于pb右边的值
         *  且pb左边的值小于pa右边的值时，中位数为pa,pb左边最大值与pa,pb右边最小值之和除2
         */
        int leftAVaue, rightAValue, leftBVaue, rightBValue, bPosi, aPosi;
        for (int i = 0; i < m; i++) {
            aPosi = i;

            leftAVaue = nums1[aPosi];
            rightAValue = nums1[aPosi + 1];

            bPosi = (m + n) / 2 - i - 2;

            leftBVaue = nums2[bPosi];
            rightBValue = nums2[bPosi + 1];

            if (leftAVaue < rightBValue && leftBVaue < rightAValue) {
                return (Math.max(leftAVaue, leftBVaue) + Math.min(rightAValue, rightBValue)) / 2d;
            }

            if ((m + n) % 2 != 0) {
                bPosi = (m + n) / 2 - i - 1;

                leftBVaue = nums2[bPosi];
                rightBValue = nums2[bPosi + 1];

                if (leftAVaue < rightBValue && leftBVaue < rightAValue) {
                    return (Math.max(leftAVaue, leftBVaue) + Math.min(rightAValue, rightBValue)) / 2d;
                }
            }
        }

        return mid;
    }
}
