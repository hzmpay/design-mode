//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。 
//
// 示例 1： 
//
// 输入: "babad"
//输出: "bab"
//注意: "aba" 也是一个有效答案。
// 
//
// 示例 2： 
//
// 输入: "cbbd"
//输出: "bb"
// 
// Related Topics 字符串 动态规划 
// 👍 2954 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public String longestPalindrome(String s) {
        // 暴力破解法
        if (s == null || s.length() < 2) {
            return s;
        }
        int maxStart = 0;
        int maxLen = 1;
        char[] chars = s.toCharArray();
        // 剩余长度如果小于最大长度那就没必要判断剩下的
        for (int i = 0; i < chars.length && (chars.length - i + 1) > maxLen; i++) {
            for (int j = i + 1; j < chars.length; j++) {
                // 可能是回文子串，进行判断
                int newMaxLen;
                // 当f(i) = f(j)时 而且 i和j的长度大于最大长度时 才判断是否是回文子串
                if (chars[i] == chars[j] && (newMaxLen = j - i + 1) > maxLen && isReverse(chars, i, j)) {
                    maxLen = newMaxLen;
                    maxStart = i;
                }
            }
        }
        return new String(chars, maxStart, maxLen);
    }

    /**
     * 是否是回文数
     *
     * @param charArr
     * @param i
     * @param j
     * @return boolean
     * @author Hezeming
     */
    public boolean isReverse(char[] charArr, int i, int j) {
        boolean isReverse = false;
        // 直到指针碰撞或者判断不是回文数退出
        while (i < j && (isReverse = charArr[i++] == charArr[j--])) {
        }
        return isReverse;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
