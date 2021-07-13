package com.hzm.leetcode.动态规划;

/**
 * https://leetcode-cn.com/problems/min-cost-climbing-stairs/
 *
 * @author Hezeming
 * @version 1.0
 * @date 2021年07月13日
 */
public class 使用最小花费爬楼梯 {

    public static void main(String[] args) {
        int[] arr = {1, 100};
        System.out.println(minCostClimbingStairs(arr));
    }

    public static int minCostClimbingStairs(int[] cost) {
        // 当前位置的最小消费 = 之前位置的最小消费 + 之前位置的体力
        // dp(n) = min(dp(n - 2) + f(n - 2), dp(n - 1) + f(n - 1))
        // p = dp(n - 2)
        int p = 0;
        // q = dp(n - 1)
        int q = 0;
        // 当前的dp值
        int r = 0;
        for (int i = 2; i <= cost.length; i++) {
            r = Math.min(p + cost[i - 2], q + cost[i - 1]);
            p = q;
            q = r;
        }
        return r;
    }
}
