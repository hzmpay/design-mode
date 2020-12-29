package com.hzm.leetcode.字符串;

import java.time.temporal.ValueRange;
import java.util.*;

/**
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 *
 * @author Hezeming
 * @version 1.0
 * @date 2020年11月13日
 */
public class 无重复字符的最长字串 {

    public static void main(String[] args) {
//        System.out.println(lengthOfLongestSubstring("abcabcbb"));
//        System.out.println(lengthOfLongestSubstring("bbbbb"));
//        System.out.println(lengthOfLongestSubstring("pwwkew"));
//        System.out.println(lengthOfLongestSubstring3(" "));
        System.out.println(lengthOfLongestSubstring3("arc"));
        System.out.println(lengthOfLongestSubstring3("abcabcbb"));
        System.out.println(lengthOfLongestSubstring3("bbb"));
    }

    public static int lengthOfLongestSubstring(String s) {
        // 记录最长字串长度
        int maxLength = 0;
        char[] charArr = s.toCharArray();
        if (charArr.length == 1) {
            return 1;
        }
        Map<Character, Integer> map = new HashMap<>();
        LinkedList<Character> linkedList = new LinkedList();

        for (int i = 0; i < charArr.length; i++) {
            char c = charArr[i];
            Integer index = map.get(c);
            // 冲突了
            if (index != null) {
                // 记录之前的长度
                int size = map.size();
                if (size > maxLength) {
                    maxLength = size;
                }

                // 删除小于冲突坐标的值
                Iterator<Character> iterator = linkedList.iterator();
                while (iterator.hasNext()) {
                    Character character = iterator.next();
                    if (map.get(character) <= index) {
                        iterator.remove();
                        map.remove(character);
                    }
                }

            }
            // 覆盖原来的map
            map.put(c, i);
            linkedList.add(c);
            if (i == charArr.length - 1) {
                int size = map.size();
                if (size > maxLength) {
                    maxLength = size;
                }
            }
        }

        return maxLength;

    }


    public static int lengthOfLongestSubstring2(String s) {
        // 记录最长字串长度
        int maxLength = 0;
        char[] charArr = s.toCharArray();
        if (charArr.length == 1) {
            return 1;
        }

        // 创建左右指针
        for (int left = 0, right = 1; right < charArr.length; right++) {

            char c1 = charArr[right];

            for (int i = left; i < right; i++) {

                char c2 = charArr[i];
                // 碰撞了 或者 到达了最后一个字符
                if ((c1 == c2) || (right == charArr.length - 1)) {
                    // 记录碰撞前的长度
                    int length = right - left;
                    if ((right == charArr.length - 1) && (c1 != c2)) {
                        length++;
                    }
                    if (length > maxLength) {
                        maxLength = length;
                    }
                    // 左针移位到当前碰撞位置的后一位
                    left = i + 1;
                    // 结束碰撞判断，进入下一位
                    continue;
                }

            }
        }

        return maxLength;

    }

    public static int lengthOfLongestSubstring3(String s) {
        if (s == null || "".equals(s)) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        int left = 0;
        int len = 0;
        char[] charArr = s.toCharArray();
        for (int i = 1; i < charArr.length; i++) {
            // 和前一个一样则换left
            if (charArr[i] == charArr[i - 1]) {
                len = Integer.max(len, i - left);
                left = i;
            } else if (i == charArr.length - 1) {
                // 到最后一个都不相等直接得到len
                len = Integer.max(len, i - left + 1);
            }
        }
        return len;
    }
}
