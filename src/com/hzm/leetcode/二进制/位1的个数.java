package com.hzm.leetcode.二进制;

/**
 * https://leetcode-cn.com/problems/number-of-1-bits/
 *
 * @author Hezeming
 * @version 1.0
 * @date 2021年02月03日
 */
public class 位1的个数 {

    public static void main(String[] args) {
        System.out.println(8 >> 1);
    }

    public static int hammingWeight4(int n) {
        int count = 0;
        while (n != 0) {
            // 每次去除当前n倒数第二个1的后面所有数
            // 比如：11110000001
            // 运算后：11110000001 & 11110000000 = 1111
            n = n & (n - 1);
            count++;
        }
        return count;
    }

    public static int hammingWeight3(int n) {
        n = n - ((n >>> 1) & 0x55555555);
        n = (n & 0x33333333) + ((n >>> 2) & 0x33333333);
        n = (n + (n >>> 4)) & 0x0f0f0f0f;
        n = n + (n >>> 8);
        n = n + (n >>> 16);
        return n & 0x3f;
    }

    public static int hammingWeight2(int n) {
        int count = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) {
                count++;
            }
            mask <<= 1;
        }
        return count;
    }

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

