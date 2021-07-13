package com.hzm.leetcode.动态规划;

/**
 * https://leetcode-cn.com/problems/n-th-tribonacci-number/
 *
 * @author Hezeming
 * @version 1.0
 * @date 2021年07月13日
 */
public class 第N个泰波那契数 {

    public static void main(String[] args) {
        System.out.println(tribonacci(4));
    }

    public static int tribonacci(int n) {
        if (n < 2) {
            return n;
        }
        int p = 0;
        int q = 1;
        int r = 1;
        for(int i = 2; i < n; i++) {
            int cur = p + q;
            r += cur;
            p = q;
            q = cur;
        }
        return r;
    }
}
