package com.hzm.leetcode.数字;

/**
 * https://leetcode-cn.com/problems/palindrome-number/
 *
 * @author Hezeming
 * @version 1.0
 * @date 2021年05月28日
 */
public class 回文数 {

    public static void main(String[] args) {
        System.out.println(isPalindrome(123211));
    }

    public static boolean isPalindrome(int x) {
        // x小于零和个位数是0的直接是不对（数字开头不会是0）
        if (x < 0 || (x != 0 && x % 10 == 0)) {
            return false;
        }
        // x    reverseNum
        // 1234321  0      123321  0
        // 123432   1      12332   1
        // 12343    12     1233    12
        // 1234     123    123     123
        // 123      1234
        int reverseNum = 0;
        while (reverseNum < x) {
            reverseNum = reverseNum * 10 + x % 10;
            x = x / 10;
        }
        return x == reverseNum || x == reverseNum / 10;
    }
}
