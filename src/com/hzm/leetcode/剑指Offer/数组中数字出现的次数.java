package com.hzm.leetcode.剑指Offer;

/**
 * https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof/
 *
 * @author Hezeming
 * @version 1.0
 * @date 2021年01月11日
 */
public class 数组中数字出现的次数 {

    public int[] singleNumbers(int[] nums) {
        int k = 0;
        // 得到所有元素的异或值，即最终a ^ b = k;
        for (int num : nums) {
            k ^= num;
        }
        // 找到所有这个异或值从右往左的第一个1，
        // 说明两个不同数的二进制数对应这个1的位置是不同的，
        // 可以作为分组标识
        int flagK = 1;
        // 直到找到二进制位不同退出
        while ((flagK & k) == 0) {
            flagK <<= 1;
        }
        int a = 0;
        int b = 0;
        for (int num : nums) {
            if ((flagK & num) == 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }
        return new int[]{a, b};
    }
}
