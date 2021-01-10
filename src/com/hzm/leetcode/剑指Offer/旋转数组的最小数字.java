package com.hzm.leetcode.剑指Offer;

/**
 * https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/
 *
 * @author Hezeming
 * @version 1.0
 * @date 2021年01月09日
 */
public class 旋转数组的最小数字 {

    public int minArray(int[] numbers) {
        if (numbers == null || numbers.length == 1) {
            return numbers[0];
        }
        int pre = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            int num = numbers[i];
            if (num < pre) {
                return num;
            }
            pre = num;
        }
        return numbers[0];
    }
}
