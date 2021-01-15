package com.hzm.leetcode.二进制;

/**
 * https://leetcode-cn.com/problems/convert-integer-lcci/
 *
 * @author Hezeming
 * @version 1.0
 * @date 2021年01月15日
 */
public class 整数转换 {

    public static void main(String[] args) {
        System.out.println(convertInteger(14, 16));
    }

    public static int convertInteger(int A, int B) {
        return getInt(A ^ B);
    }

    public static int getInt(int num) {
        int sum = 0;
        while (num != 0) {
            sum ++;
            num &= num - 1;
        }
        return sum;
    }
}
