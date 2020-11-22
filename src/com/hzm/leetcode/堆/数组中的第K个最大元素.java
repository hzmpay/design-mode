package com.hzm.leetcode.堆;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
 *
 * @author Hezeming
 * @version 1.0
 * @date 2020年11月22日
 */
public class 数组中的第K个最大元素 {

    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 5, 6, 4};
        System.out.println(findKthLargest(arr, 2));
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * 冒泡
     *
     * @param nums
     * @param k
     * @return int
     * @author Hezeming
     */
    public static int findKthLargest(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] < nums[j]) {
                    swap(nums, i, j);
                }
            }
        }
        return nums[k - 1];
    }
}
