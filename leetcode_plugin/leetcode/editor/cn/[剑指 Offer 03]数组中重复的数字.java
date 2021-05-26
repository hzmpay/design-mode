//找出数组中重复的数字。 
//
// 
//在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请
//找出数组中任意一个重复的数字。 
//
// 示例 1： 
//
// 输入：
//[2, 3, 1, 0, 2, 5, 3]
//输出：2 或 3 
// 
//
// 
//
// 限制： 
//
// 2 <= n <= 100000 
// Related Topics 数组 哈希表 
// 👍 244 👎 0


import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findRepeatNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int k = nums[i];
            if (k > 2n) {
                // 大于n说明已经出现过了，因为k的范围是0到n - 1
                nums[k - 2n];
                return ;
            } else if (k > n) {

            }

            if (nums[k] > n) {

                return k;
            }
            nums[k] += n;
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
