package com.hzm.leetcode.中等;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/longest-palindrome/
 *
 * @author Hezeming
 * @version 1.0
 * @date 2020年11月15日
 */
public class 最长回文串 {

    public static void main(String[] args) {

        System.out.println(longestPalindrome2("abccccdd"));
        System.out.println(longestPalindrome2("ccc"));
    }

    public static int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] charArr = s.toCharArray();
        for (int i = 0; i < charArr.length; i++) {
            char c = charArr[i];
            Integer count = map.get(c);
            map.put(c, count == null ? 1 : ++count);
        }
        int doubleNum = 0;
        int singleNum = 0;
        for (Integer value : map.values()) {
            int calc = value / 2;
            if (calc >= 1) {
                doubleNum += calc;
                if (value % 2 != 0) {
                    singleNum = 1;
                }
            }
            else {
                singleNum = 1;
            }
        }
        return doubleNum * 2 + singleNum;
    }


    /**
     * 有问题 TODO
     *
     * @param s
     * @return int
     * @author Hezeming
     */
    public static int longestPalindrome2(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] charArr = s.toCharArray();
        for (char c : charArr) {
            Integer num = map.get(c);
            map.put(c, num == null ? 1 : num + 1);
        }
        int doubleNum = 0;
        int maxSingleNum = 0;
        for (Integer value : map.values()) {
            int calcNum = value % 2;
            if (calcNum == 0) {
                // 偶数位
                doubleNum += value;
            } else {
                // 奇数位
                maxSingleNum = Integer.max(maxSingleNum, value);
            }
        }
        return doubleNum + maxSingleNum;
    }


}
