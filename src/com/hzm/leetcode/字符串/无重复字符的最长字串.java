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
//        System.out.println(lengthOfLongestSubstring4("arc"));
//        System.out.println(lengthOfLongestSubstring4("abcabcbb"));
//        System.out.println(lengthOfLongestSubstring4("bbb"));
//        System.out.println(lengthOfLongestSubstring4("anviaj"));
//        System.out.println(lengthOfLongestSubstring4("qrsvbspk"));
        System.out.println(lengthOfLongestSubstring4("bpfbhmipx"));
    }

    public static int lengthOfLongestSubstring4(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] charArr = s.toCharArray();
        /*
         * 1.定义双指针，遍历charArr
         * 2.将指针区间的值和坐标放到map中
         * 3.遍历到重复char，记录长度，将左指针定位到重复char的下一个坐标，将map中左指针之前的值都remove掉
         * 4.直到遍历到结尾，如果没有重复则记录左右指针长度，比较最长子串长度
         */
        int maxLen = 1;
        int l = 0;
        Map<Character, Integer> map = new HashMap<>();
        map.put(charArr[l], l);
        for (int r = 1; r < charArr.length; r++) {
            Character rVal = charArr[r];
            Integer idx = map.get(rVal);
            // 重复char
            if (idx != null) {
                // 记录长度
                maxLen = Math.max(maxLen, map.size());
                // 重新初始化map
                int newL = idx + 1;
                for (int i = idx; i >= l; i--) {
                    Integer oldVal = map.remove(charArr[i]);
                    if (oldVal == null) {
                        // 说明已经没有了
                        break;
                    }
                }
                // 将左指针定位到重复char的下一个坐标
                l = newL;
            }
            map.put(charArr[r], r);
            if (r == charArr.length - 1) {
                // 直到遍历到结尾，如果没有重复则记录左右指针长度，比较最长子串长度
                maxLen = Math.max(maxLen, map.size());
            }
        }
        return maxLen;
    }

    /**
     * 初始化map
     *
     * @param oldL
     * @param newL
     * @return java.util.Map<java.lang.Character, java.lang.Integer>
     * @author Hezeming
     */
    public static Map<Character, Integer> initMap(char[] charArr, int oldL, int newL) {
        Map<Character, Integer> map = new HashMap<>();
        map.put(charArr[newL], newL);
        return map;
    }

    public static int lengthOfLongestSubstring3(String s) {
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

    public static int lengthOfLongestSubstring1(String s) {
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
