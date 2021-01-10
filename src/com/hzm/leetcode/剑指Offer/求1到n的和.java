package com.hzm.leetcode.剑指Offer;

/**
 * https://leetcode-cn.com/problems/qiu-12n-lcof/
 *
 * @author Hezeming
 * @version 1.0
 * @date 2021年01月09日
 */
public class 求1到n的和 {

    public static void main(String[] args) {
        System.out.println((9 + 1) >> 2);
    }

    public int sumNums(int n) {
        boolean flag = (n > 0 && (n += sumNums(n - 1)) > 0);
        return n;
    }
}
