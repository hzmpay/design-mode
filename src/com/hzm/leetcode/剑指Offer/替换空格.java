package com.hzm.leetcode.剑指Offer;

/**
 * https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/
 *
 * @author Hezeming
 * @version 1.0
 * @date 2021年01月09日
 */
public class 替换空格 {

    public String replaceSpace(String s) {
        StringBuilder builder = new StringBuilder();
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            if (c == ' ') {
                builder.append("%20");
            } else {
                builder.append(c);
            }
        }
        return builder.toString();
    }

    public String replaceSpace2(String s) {
        char[] charArray = s.toCharArray();
        char[] newChar = new char[charArray.length * 3];
        int j = 0;
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            if (c == ' ') {
                newChar[j++] = '%';
                newChar[j++] = '2';
                newChar[j++] = '0';
            } else {
                newChar[j++] = c;
            }
        }
        return new String(newChar, 0, j);
    }
}
