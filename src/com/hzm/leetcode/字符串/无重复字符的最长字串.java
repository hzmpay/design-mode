package com.hzm.leetcode.字符串;

import java.time.temporal.ValueRange;
import java.util.*;
import java.util.stream.IntStream;

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
//        System.out.println(lengthOfLongestSubstring4("bpfbhmipx"));
        System.out.println(lengthOfLongestSubstring6("bpfbhmipx"));
    }

    /**
     * 双指针，滑动窗口解决，不采用删除hashmap的操作，利用坐标计算长度
     *
     * @param s
     * @return int
     * @author Hezeming
     */
    public static int lengthOfLongestSubstring6(String s) {
        if (s == null || s.equals("")) {
            return 0;
        }
        int maxLen = 1;
        int left = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            /**
             1、首先，判断当前字符是否包含在map中，如果不包含，将该字符添加到map（字符，字符在数组下标）,
             此时没有出现重复的字符，左指针不需要变化。此时不重复子串的长度为：i-left+1，与原来的maxLen比较，取最大值；

             2、如果当前字符 ch 包含在 map中，此时有2类情况：
             1）当前字符包含在当前有效的子段中，如：abca，当我们遍历到第二个a，当前有效最长子段是 abc，我们又遍历到a，
             那么此时更新 left 为 map.get(a)+1=1，当前有效子段更新为 bca；
             2）当前字符不包含在当前最长有效子段中，如：abba，我们先添加a,b进map，此时left=0，我们再添加b，发现map中包含b，
             而且b包含在最长有效子段中，就是1）的情况，我们更新 left=map.get(b)+1=2，此时子段更新为 b，而且map中仍然包含a，map.get(a)=0；
             随后，我们遍历到a，发现a包含在map中，且map.get(a)=0，如果我们像1）一样处理，就会发现 left=map.get(a)+1=1，实际上，left此时
             应该不变，left始终为2，子段变成 ba才对。

             为了处理以上2类情况，我们每次更新left，left=Math.max(left , map.get(ch)+1).
             另外，更新left后，不管原来的 s.charAt(i) 是否在最长子段中，我们都要将 s.charAt(i) 的位置更新为当前的i，
             因此此时新的 s.charAt(i) 已经进入到 当前最长的子段中！
             */
            char ch = s.charAt(i);
            Integer idx = map.get(ch);
            if (idx != null) {
                // 因为最新left之前的字符还在map中，所以可能存在abba，遍历到第二个a的是时候，left=2，新的left为旧的a坐标0+1 = 1
                left = Math.max(left, idx + 1);
            }
            // 不管是否更新left，都要更新 s.charAt(i) 的位置！
            map.put(ch, i);
            maxLen = Math.max(maxLen, i - left + 1);
        }
        return maxLen;
    }

    /**
     * 双指针，滑动窗口解决，HashMap
     *
     * @param s
     * @return int
     * @author Hezeming
     */
    public static int lengthOfLongestSubstring5(String s) {
        if (s == null || s.equals("")) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int maxLen = 1;
        int left = 0, right = 1;
        // <值，坐标>
        Map<Character, Integer> map = new HashMap<>();
        map.put(chars[left], left);
        int len = chars.length;
        Integer idx = null;
        while (right < len) {
            char ch = chars[right];
            idx = map.get(ch);
            // 判断map中是否存在
            if (idx != null) {
                // 存在的话说明坐标碰到重复字符，开始处理
                // 1.记录最长不重复子串长度
                // 2.将map中value，也就是坐标小于重复字符的坐标，大于等于left坐标的字符remove
                maxLen = Math.max(maxLen, map.size());
                IntStream.rangeClosed(left, idx).forEach(e -> map.remove(chars[e]));
                // 3.改变左下标
                left = idx + 1;
            }
            map.put(ch, right);
            right++;
        }
        // 最后一次还未重复，需要记录
        if (idx == null) {
            maxLen = Math.max(maxLen, map.size());
        }
        return maxLen;
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
