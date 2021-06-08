package com.hzm.leetcode.二进制;

/**
 * https://leetcode-cn.com/problems/single-number/solution/
 *
 * @author Hezeming
 * @version 1.0
 * @date 2020年09月30日
 */
public class 只出现一次的数字 {

    public static void main(String[] args) {
        System.out.println(0 ^ 56156);
        System.out.println(singleNumber(new int[]{1, 2, 1, 2, 3}));
    }

    /**
     * 利用同一个数异或2次得到结果和原来一样
     *
     * @param nums
     * @return int
     * @author Hezeming
     */
    public static int singleNumber(int[] nums) {
        int temp = 0;
        for (int num : nums) {
            // 利用同一个数异或2次得到结果和原来一样
            temp ^= num;
        }
        return temp;
    }
}
