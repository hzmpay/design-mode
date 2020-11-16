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

        System.out.println(longestPalindrome("abccccdd"));
        System.out.println(longestPalindrome("ccc"));
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


}
