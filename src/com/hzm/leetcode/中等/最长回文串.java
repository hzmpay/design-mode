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

//        System.out.println(longestPalindrome3("abccccdd"));
//        System.out.println(longestPalindrome3("ccc"));
        System.out.println(longestPalindrome("civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperish"));
        System.out.println(longestPalindrome2("civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperish"));
        System.out.println(longestPalindrome3("civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperish"));
        String s = "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperish";
        System.out.println(s.length());
        System.out.println(Character.MAX_VALUE);
    }

    /**
     * 有问题 TODO
     *
     * @param s
     * @return int
     * @author Hezeming
     */
    public static int longestPalindrome3(String s) {
        // 最长回文串的长度 = 所有偶数位的长度 + 最长奇数位
        // 1.将每个字母出现的次数存到map中
        // 2.遍历map，根据次数判断，如果是偶数位直接+，如果是奇数位则判断是否是最大奇数位
        // 3.最后得出奇数位，加上一直累加的偶数位
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>(chars.length * 4 / 3 + 1);
        for (int i = 0; i < chars.length; i++) {
            Integer count = map.get(chars[i]);
            map.put(chars[i], count == null ? 1 : count + 1);
        }
        int totalCount = 0;
        int oddCount = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            Integer value = entry.getValue();
            if (value % 2 == 0) {
                // 偶数
                totalCount += value;
            } else {
                // 奇数
                totalCount += value - 1;
                oddCount = 1;
            }
        }
        return totalCount + oddCount;
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
     * 采用数组存储每个字符串的次数,去除多出来的奇数位 + 1就是长度
     * 比如：aabbcccddddd
     * 最长是：aabbccddddd，去除了c和d然后+1
     *
     * @param s
     * @return int
     * @author Hezeming
     */
    public static int longestPalindrome2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] arr = new int[128];
        char[] chars = s.toCharArray();
        for (char c : chars) {
            arr[c]++;
        }
        int oddCount = 0;
        for (int i : arr) {
            oddCount += i % 2;
        }
        // 没有奇数位则整个字符串都是回文数
        return oddCount == 0 ? s.length() : s.length() - oddCount + 1;
    }


}
