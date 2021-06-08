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
    /**
     * 采用数组存储每个字符串的次数,去除多出来的奇数位 + 1就是长度
     * 比如：aabbcccddddd
     * 最长是：aabbccddddd，去除了c和d然后+1
     *
     * @param s
     * @return int
     * @author Hezeming
     */
    public int longestPalindrome(String s) {
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
//leetcode submit region end(Prohibit modification and deletion)
