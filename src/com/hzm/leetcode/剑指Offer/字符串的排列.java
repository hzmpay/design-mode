package com.hzm.leetcode.剑指Offer;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof/
 *
 * @author Hezeming
 * @version 1.0
 * @date 2021年01月12日
 */
public class 字符串的排列 {

    public String[] permutation(String s) {
        // 1 2 6
        // f(n) = f(n - 1) * n
        Set<Character> set = new HashSet<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            set.add(c);
        }
        Character[] newChars = set.toArray(new Character[set.size()]);
        for (int i = 0; i < newChars.length; i++) {
            Character newChar = newChars[i];

        }
        return null;
    }

    public void demo(Character[] newChars, int start) {

    }
}
