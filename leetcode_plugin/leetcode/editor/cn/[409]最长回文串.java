//给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。 
//
// 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。 
//
// 注意: 
//假设字符串的长度不会超过 1010。 
//
// 示例 1: 
//
// 
//输入:
//"abccccdd"
//
//输出:
//7
//
//解释:
//我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
// 
// Related Topics 哈希表 
// 👍 258 👎 0


import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] charArr = s.toCharArray();
        for (char c : charArr) {
            Integer num = map.get(c);
            map.put(c, num == null ? 1 : num + 1);
        }
        int doubleNum = 0;
        int maxSingleNum = 0;
        for (Integer value : map.values()) {
            int calcNum = value % 2;
            if (calcNum == 0) {
                // 偶数位
                doubleNum += value;
            } else {
                // 奇数位
                maxSingleNum = Integer.max(maxSingleNum, value);
            }
        }
        return doubleNum + maxSingleNum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
