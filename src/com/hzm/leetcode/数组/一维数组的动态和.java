package com.hzm.leetcode.数组;

/**
 * https://leetcode-cn.com/problems/running-sum-of-1d-array/
 *
 * @author Hezeming
 * @version 1.0
 * @date 2021年06月28日
 */
public class 一维数组的动态和 {

    public int[] runningSum(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        int[] newNums = new int[nums.length];
        newNums[0] = nums[0];
        int preSum = newNums[0];
        for (int i = 1; i < nums.length; i++) {
            newNums[i] = preSum + nums[i];
            preSum = newNums[i];
        }
        return newNums;
    }
}
