package com.hzm.leetcode.数字;

/**
 * https://leetcode-cn.com/problems/reverse-integer/solution/hua-jie-suan-fa-7-zheng-shu-fan-zhuan-by-guanpengc/
 *
 * @author Hezeming
 * @version 1.0
 * @date 2020年11月22日
 */
public class 整数反转 {

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);

        System.out.println(reverse2(123));
    }

    public static int reverse2(int x) {
        try {
            boolean isBig = x > 0;
            if (!isBig) {
                x = -x;
            }
            int result = Integer.parseInt(new StringBuilder(String.valueOf(x)).reverse().toString());
            return isBig ? result : -result;
        } catch (Exception e) {
            return 0;
        }
    }

    public static int reverse(int x) {
        if (x == 0) {
            return 0;
        }
        // 遍历从最高位到最低位，只要有一位小于MAX_VALUE的值即可直接反转
        boolean isDel = x > 0;
        if (!isDel) {
            x = -x;
        }
        return 0;
    }
}
