package com.hzm.leetcode.剑指Offer;

/**
 * https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/
 *
 * @author Hezeming
 * @version 1.0
 * @date 2021年01月09日
 */
public class 左旋转字符串 {

    public static void main(String[] args) {
        System.out.println(reverseLeftWords("a", 1));
    }

    public static String reverseLeftWords(String s, int n) {
        if (n == 0) {
            return s;
        }
        char[] charArr = s.toCharArray();
        char[] nCharArr = new char[n];
        for (int i = 0; i < n; i++) {
            nCharArr[i] = charArr[i];
        }
        for (int i = n, j = 0; i < charArr.length; i++, j++) {
            charArr[j] = charArr[i];
        }
        for (int i = charArr.length - n, j = 0; i < charArr.length; i++, j++) {
            charArr[i] = nCharArr[j];
        }
        return new String(charArr);
    }
}
