package com.hzm.leetcode.数字;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/happy-number/
 *
 * @author Hezeming
 * @version 1.0
 * @date 2021年01月12日
 */
public class 快乐数 {

    private static final Set<Integer> set = new HashSet<>();

    public static void main(String[] args) {
        System.out.println(isHappy(19));
    }

    public static boolean isHappy(int n) {
        /*
         * 1.每次对10取余，从右到左取数
         * 2.直到除以10等于0，说明剩个位数
         */
        int sum = 0;
        // 每次取的右边的数
        int a;
        while (n != 0) {
            a = n % 10;
            n = n / 10;
            sum += a * a;
        }
        if (set.contains(sum)) {
            return false;
        }
        set.add(sum);
        return sum == 1 || isHappy(sum);
    }
}
