//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 示例 4: 
//
// 
//输入: s = ""
//输出: 0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 104 
// s 由英文字母、数字、符号和空格组成 
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window 
// 👍 4660 👎 0


import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {
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

}
//leetcode submit region end(Prohibit modification and deletion)
