package com.hzm.leetcode.中等;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/climbing-stairs/solution/pa-lou-ti-by-leetcode-solution/
 *
 * @author Hezeming
 * @version 1.0
 * @date 2021年01月05日
 */
public class 爬楼梯 {

    public static void main(String[] args) {
//        System.out.println(climbStairs(44));
        System.out.println(climbStairs2(44));
        System.out.println(climbStairs3(44));
    }

    public static int climbStairs3(int n) {
        // 1 2 3 5
        int p = 0, q = 1, r = 1;
        for (int i = 0; i < n; i++) {
            r = p + q;
            p = q;
            q = r;
        }
        return r;
    }




    public static int climbStairs2(int n) {
        int p = 0, q = 0, r = 1;
        for (int i = 0; i < n; i++) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }

    /**
     * 斐波那契数列
     *
     * @param n
     * @return int
     * @author Hezeming
     */
    public static int climbStairs(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        if (n <= 0) {
            return 0;
        } else if (n == 1 || n == 2) {
            return n;
        } else if (map.containsKey(n)) {
            return map.get(n);
        } else {
            int value = climbStairs(n - 1) + climbStairs(n - 2);
            map.put(n, value);
            return value;
        }
    }
}
