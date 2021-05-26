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

    public String longestPalindrome2(String s) {
        P(i, j) =
    }

    public String longestPalindrome(String s) {
        // 暴力破解法
        if (s == null || s.length() < 2) {
            return s;
        }
        char[] charArr = s.toCharArray();
        // 定义最长子串的起始坐标和长度
        int start = 0;
        int maxLen = 1;
        for (int i = 0; i < charArr.length - 1; i++) {
            for (int j = i + 1; j < charArr.length; j++) {
                // 判断是否是回文子串 而且 长度大于原来长度，是的话记录，进行下一次循环，不是的话跳出循环
                int curLen = j - i + 1;
                if (isReverse(charArr, i, j) && curLen > maxLen) {
                    start = i;
                    maxLen = curLen;
                }
            }
        }
        return new String(charArr, start, maxLen);
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
