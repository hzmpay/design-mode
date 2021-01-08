package com.hzm.leetcode.数列;

/**
 * https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/
 *
 * @author Hezeming
 * @version 1.0
 * @date 2021年01月08日
 */
public class 青蛙跳台阶问题 {

    public static void main(String[] args) {
        System.out.println(numWays(1));
    }

    public static int numWays(int n) {
        // 1, 1, 2, 3, 5
        int a = 1, b = 1, sum;
        for (int i = 0; i < n - 1; i++) {
            // 计算下一个数
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return (a + b) % 1000000007;
    }
}
