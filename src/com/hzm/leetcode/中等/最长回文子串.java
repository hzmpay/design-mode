package com.hzm.leetcode.中等;

/**
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 *
 * @author Hezeming
 * @version 1.0
 * @date 2020年11月16日
 */
public class 最长回文子串 {

    public static void main(String[] args) {
        System.out.println(longestPalindrome2("nn"));
        System.out.println(longestPalindrome2("ac"));
        System.out.println(longestPalindrome2("babad"));
        System.out.println(longestPalindrome2("cbbbcd"));
//        System.out.println(isReverse("babad".toCharArray(), 0, 3));
    }

    /**
     * 动态规划
     *
     * @param s
     * @return int
     * @author Hezeming
     */
    public static String longestPalindrome3(String s) {
        // f(i, j) = f(i + 1, j - 1) && Si = Sj
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        int start = 0;
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    dp[i][j] = true;
                } else {
                    int iVal = s.indexOf(i);
                    int jVal = s.indexOf(j);
                    dp[i][j] = dp[i - 1][j + 1] && (iVal == jVal);
                }
                if (dp[i][j]) {
                    start = i;
                    maxLen = j - i + 1;
                }
            }
        }

        return null;
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
        // 暴力破解法
        if (s == null || s.length() < 2) {
            return s;
        }
        char[] charArr = s.toCharArray();
        // 定义最长子串的起始坐标和长度
        int start = 0;
        int maxLen = 1;
        for (int i = 0; i < charArr.length - 1; i++) {
            for (int j = i + 1; j < charArr.length; j++) {
                // 判断是否是回文子串 而且 长度大于原来长度，是的话记录，进行下一次循环，不是的话跳出循环
                int curLen = j - i + 1;
                if (isReverse(charArr, i, j) && curLen > maxLen) {
                    start = i;
                    maxLen = curLen;
                }
            }
        }
        return new String(charArr, start, maxLen);
    }

    /**
     * 是否是回文数
     *
     * @param charArr
     * @param i
     * @param j
     * @return boolean
     * @author Hezeming
     */
    public static boolean isReverse(char[] charArr, int i, int j) {
        boolean isReverse = false;
        // 直到指针碰撞或者判断不是回文数退出
        while (i < j && (isReverse = charArr[i++] == charArr[j--])) {
        }
        return isReverse;
    }

    /**
     * 中心扩散法
     * 两种情况：
     * 1.aba
     * 2.abba
     *
     * @param s
     * @return int
     * @author Hezeming
     */
    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        // 定义最长子串的起始坐标和长度
        int start = 0;
        int maxLen = 1;
        char[] charArr = s.toCharArray();

        // 中心位置开始
        int middleLength = s.length() / 2;


        // 开始判断
//        if

        // 向左

        return null;
    }
}
