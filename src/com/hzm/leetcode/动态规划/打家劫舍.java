package com.hzm.leetcode.动态规划;

/**
 * https://leetcode-cn.com/problems/house-robber/
 *
 * @author Hezeming
 * @version 1.0
 * @date 2021年07月13日
 */
public class 打家劫舍 {

    public int rob(int[] nums) {
        // 只有一间屋子
        if (nums.length == 1) {
            return nums[0];
        }
        // 假设偷n间屋子，即数组长度为n，下标为k = n - 1
        // 1.最后一间屋子不偷：dp(k - 1)
        // 2.最后一间屋子偷：dp(k - 2) + f(k)
        // dp(k) = max(dp(k - 1), dp(k - 2) + f(k))
        int p = 0;
        int q = nums[0];
        int r = q;
        for (int i = 1; i < nums.length; i++) {
            int temp = Math.max(q, p + nums[i]);
            p = q;
            q = temp;
            r = Math.max(r, temp);
        }
        return r;
    }
}
