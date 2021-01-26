package com.hzm.leetcode.数组;

/**
 * https://leetcode-cn.com/problems/rotate-array/
 *
 * @author Hezeming
 * @version 1.0
 * @date 2021年01月26日
 */
public class 旋转数组 {

    public void rotate1(int[] nums, int k) {
        while (k > 0) {
            int pre = nums[nums.length - 1];
            for (int i = 0; i < nums.length; i++) {
                int temp = nums[i];
                nums[i] = pre;
                pre = temp;
            }
            k--;
        }
    }
}
