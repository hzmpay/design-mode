package com.hzm.leetcode.动态规划;

import java.util.Map;

/**
 * https://leetcode-cn.com/problems/house-robber-ii/
 *
 * @author Hezeming
 * @version 1.0
 * @date 2021年07月13日
 */
public class 打家劫舍II {

    public static void main(String[] args) {
        int[] arr = {1,2,3,1};
        System.out.println(rob(arr));
    }

    public static int rob(int[] nums) {
        // 只有一间屋子
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        // 根据题意得出，第一间屋子和最后一间屋子只能二选一
        // 所以得出max(F(0, n - 2), F(1, n - 1))
        return Math.max(getMax(nums, 0, n - 1), getMax(nums, 1, n - 2));
    }

    public static int getMax(int[] nums, int start, int end) {
        // 两种情况:
        // 假设偷n间屋子，即数组长度为n，下标为k = n - 1
        // 1.最后一间屋子不偷（第一间屋子可偷可不偷）：dp(k - 1)
        // 2.最后一间屋子偷（还得考虑第一间屋子是否被偷过）：dp(k - 2) + f(k)
        int p = 0;
        int q = nums[start];
        int r = 0;
        // 得到最后一间屋子不偷的最大值
        for (int i = start + 1; i < end; i++) {
            r = Math.max(q, p + nums[i]);
            p = q;
            q = r;
        }
        return r;
    }
}
