package com.hzm.leetcode.中等;

/**
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 *
 * @author Hezeming
 * @version 1.0
 * @date 2020年11月16日
 */
public class 最长回文字串 {

    public static void main(String[] args) {
        System.out.println(longestPalindrome2("nn"));
        System.out.println(longestPalindrome2("ac"));
        System.out.println(longestPalindrome2("babad"));
        System.out.println(longestPalindrome2("cbbbcd"));
//        System.out.println(isReverse("babad".toCharArray(), 0, 3));
    }

    /**
     * 暴力破解法
     * 两种情况：
     * 1.aba
     * 2.bb
     *
     * @param s
     * @return int
     * @author Hezeming
     */
    public static String longestPalindrome2(String s) {
        if (s.length() < 2) {
            return s;
        }
        // 定义最长字串长度
        String maxStr = "";
        int length = s.length();
        char[] charArr = s.toCharArray();
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                // 如果是回文数 而且 大于最长字串长度
                int newStrLength = j - i + 1;
                if (isReverse(charArr, i, j) &&  newStrLength> maxStr.length()) {
                    maxStr = new String(charArr, i, newStrLength);
                }
            }
        }
        // 等于空串说明没有一位数以上的回文数，默认返回第一个字符
        if ("".equals(maxStr)) {
            return new String(charArr, 0, 1);
        }
        return maxStr;
    }

    public static boolean isReverse(char[] charArr, int left, int right) {
        while (right > left) {
            if (charArr[left++] != charArr[right--]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 中心扩散法
     * 两种情况：
     * 1.aba
     * 2.bb
     *
     * @param s
     * @return int
     * @author Hezeming
     */
    public static String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }
        // 定义最长字串长度
        int maxLength = 0;
        String maxStr = "";
        // 中心位置开始
        int middleLength = s.length() / 2;

        char[] charArr = s.toCharArray();

        // 开始判断
//        if

        // 向左

        return maxStr;
    }
}
