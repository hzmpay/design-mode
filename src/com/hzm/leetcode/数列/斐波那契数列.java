package com.hzm.leetcode.数列;

/**
 * https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof/solution/di-gui-he-fei-di-gui-liang-chong-fang-shi-du-ji-ba/
 *
 * @author Hezeming
 * @version 1.0
 * @date 2021年01月08日
 */
public class 斐波那契数列 {

    public static void main(String[] args) {
        System.out.println(fib(5));
    }

    public static int fib(int n) {
        int a = 0, b = 1, sum;
        for (int i = 0; i < n; i++) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }
}
