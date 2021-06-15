package com.hzm.leetcode.动态规划;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 *
 * @author Hezeming
 * @version 1.0
 * @date 2021年06月11日
 */
public class 买卖股票的最佳时机 {

    public static void main(String[] args) {
    }

    /**
     * TODO 暴力法：有问题，会超时
     *
     * @param prices
     * @return int
     * @author Hezeming
     */
    public static int maxProfit(int[] prices) {
        // max(prices[j] - prices[i])
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                max = Math.max(max, prices[j] - prices[i]);
            }
        }
        return max;
    }
    /**
     * 动态规划
     *
     * @param prices
     * @return int
     * @author Hezeming
     */
    public static int maxProfit2(int[] prices) {
        // max(prices[j] - prices[i])
        // 利用最大利润差来解决
        // 状态转移方程式：第i天卖出获取的最大利润 = 第i - 1天卖出获取的最大利润 + 之前的利润差
        // 第i天的利润差：diff(i) = prices[i] - prices[i - 1]
        int result = 0;
        // 前一天卖出获取的最大利润
        int pre = 0;
        // 第一天只能买
        for (int i = 1; i < prices.length; i++) {
            int diff = prices[i] - prices[i - 1];
            pre = Math.max(pre + diff, 0);
            result = Math.max(pre, result);
        }
        return result;
    }
}
