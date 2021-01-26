package com.hzm.leetcode.数组;

/**
 * https://leetcode-cn.com/problems/remove-element/
 *
 * @author Hezeming
 * @version 1.0
 * @date 2021年01月26日
 */
public class 移除元素 {

    public int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                // 定位到第一个不等于val的位置
                nums[i++] = nums[j];
            }
        }
        return i;
    }
}
