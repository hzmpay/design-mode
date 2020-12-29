package com.hzm.leetcode.字符串;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/reverse-string/
 *
 * @author Hezeming
 * @version 1.0
 * @date 2020年12月22日
 */
public class 反转字符串 {

    public static void main(String[] args) {
        char[] arr = new char[]{'h','e','l','l','o'};
        reverseString(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void reverseString(char[] s) {
        if (s == null || s.length == 1) {
            return;
        }
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}
