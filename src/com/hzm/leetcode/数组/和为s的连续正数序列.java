package com.hzm.leetcode.数组;

/**
 * https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/
 *
 * @author Hezeming
 * @version 1.0
 * @date 2021年01月13日
 */
public class 和为s的连续正数序列 {

    public int[][] findContinuousSequence(int target) {
        // 1到target / 2 + 1中存在：
        // 1.两个连续的数相加等于target（奇数才存在）0，2n + 1 = target
        // 2.存在数的倍数刚是target，比如target=9，1，3，9，3n = target
        // 不可能超过target的一半+1，因为后面的数相加都大于target

        // 2n + 1 = target
        // target = 3n + (2n) << i



        // n < target / 2 + 1

//        int[][] result = new

        int len = target / 2 + 1;
        for (int i = 0; i < len; i++) {

        }
        return null;
    }
}
