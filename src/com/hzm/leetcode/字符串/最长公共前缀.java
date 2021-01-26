package com.hzm.leetcode.字符串;

/**
 * https://leetcode-cn.com/problems/longest-common-prefix/
 *
 * @author Hezeming
 * @version 1.0
 * @date 2021年01月26日
 */
public class 最长公共前缀 {

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        String pre = strs[0];
        for (int i = 1; i < strs.length; i++) {
            pre = longestCommonPrefix(pre, strs[i]);
            if ("".equals(pre)) {
                return "";
            }
        }
        return pre;
    }

    public String longestCommonPrefix(String str1, String str2) {
        int length = Math.min(str1.length(), str2.length());
        int index = 0;
        while (index < length && str1.charAt(index) == str2.charAt(index)) {
            index++;
        }
        return str1.substring(0, index);
    }
}
