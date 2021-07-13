package com.hzm.leetcode.动态规划;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/delete-and-earn/
 *
 * @author Hezeming
 * @version 1.0
 * @date 2021年07月13日
 */
public class 删除并获得点数 {

    public static void main(String[] args) {
        int[] arr = {3};
        System.out.println(deleteAndEarn(arr));
    }

    public static int deleteAndEarn(int[] nums) {
        // 创建数组：下标为nums的值，对应的值nums中出现的次数
        // 有上述数组则构成《打家劫舍》问题
        // 打家劫舍：max(dp(n - 1), dp(n - 2) + f(n))
        // 转换：max(dp(n - 1), dp(n - 2) + f(n) * n)
        if (nums.length == 1) {
            return nums[0];
        }
        int[] arr = new int[104];
        for (int i = 0; i < nums.length; i++) {
            arr[nums[i]]++;
        }
        int p = 0;
        int q = arr[0];
        int r = 0;
        for (int i = 1; i < arr.length; i++) {
            r = Math.max(q, p + arr[i] * i);
            p = q;
            q = r;
        }
        return r;
    }
}
