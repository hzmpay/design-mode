package com.hzm.leetcode.二进制;

/**
 * https://leetcode-cn.com/problems/hamming-distance/
 *
 * @author Hezeming
 * @version 1.0
 * @date 2020年09月29日
 */
public class 汉明距离 {

    public static void main(String[] args) {

        System.out.println(hammingDistance1(1,4));

    }

    /**
     * 用异或
     *
     * @param x
     * @param y
     * @return int
     * @author Hezeming
     */
    public static int hammingDistance1(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
}
