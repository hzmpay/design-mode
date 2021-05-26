//判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。 
//
// 示例 1: 
//
// 输入: 121
//输出: true
// 
//
// 示例 2: 
//
// 输入: -121
//输出: false
//解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
// 
//
// 示例 3: 
//
// 输入: 10
//输出: false
//解释: 从右向左读, 为 01 。因此它不是一个回文数。
// 
//
// 进阶: 
//
// 你能不将整数转为字符串来解决这个问题吗？ 
// Related Topics 数学 
// 👍 1306 👎 0


import java.util.stream.IntStream;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPalindrome(int x) {
        // 小于0 和 个位数是0的直接返回false（因为最高位不可能为0）
        if (x < 0 || (x != 0 && x % 10 == 0)) {
            // 负数直接返回false
            return false;
        }

        int reverseNum = 0;
        // 直到原数字 小于（奇数位）或等于（偶数位）翻转的数时退出
        while (x > reverseNum) {
            reverseNum = reverseNum * 10 + x % 10;
            x = x / 10;
        }

        return x == reverseNum || x == reverseNum / 10;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
