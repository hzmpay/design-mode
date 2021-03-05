package com.hzm.leetcode.数字;

/**
 * https://leetcode-cn.com/problems/two-sum/
 *
 * @author Hezeming
 * @version 1.0
 * @date 2021年03月04日
 */
public class 两数之和 {

    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (diff == nums[j]) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[2];
    }
}
