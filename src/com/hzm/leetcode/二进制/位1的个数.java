package com.hzm.leetcode.二进制;

/**
 * https://leetcode-cn.com/problems/number-of-1-bits/
 *
 * @author Hezeming
 * @version 1.0
 * @date 2021年02月03日
 */
public class 位1的个数 {

    public int hammingWeight(int n) {
        int count = 0;
        int mask = 1;
        // int最多32位
        for (int i = 0; i < 32; i++) {
            // 判断每个位置是否为1
            if ((n & mask) == 1) {
                count++;
            }
            // 每次左移1位，直到为0退出
            mask = mask << 1;
        }
        return count;
    }
}

