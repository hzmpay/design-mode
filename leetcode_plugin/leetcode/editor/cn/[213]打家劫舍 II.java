//你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的
//房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。 
//
// 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,3,2]
//输出：3
//解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,1]
//输出：4
//解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
//     偷窃到的最高金额 = 1 + 3 = 4 。 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 1000 
// 
// Related Topics 数组 动态规划 
// 👍 718 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int rob(int[] nums) {
        // 只有一间屋子
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        } else if (n == 2) {
            return Math.max(nums[0], nums[1]);
        }
        // 根据题意得出，第一间屋子和最后一间屋子只能二选一
        // 所以得出max(F(0, n - 1), F(1, n))
        return Math.max(getMax(nums, 0, n - 1), getMax(nums, 1, n));
    }

    public int getMax(int[] nums, int start, int end) {
        // 两种情况:
        // 假设偷n间屋子，即数组长度为n，下标为k = n - 1
        // 1.最后一间屋子不偷（第一间屋子可偷可不偷）：dp(k - 1)
        // 2.最后一间屋子偷（还得考虑第一间屋子是否被偷过）：dp(k - 2) + f(k)
        int p = 0;
        int q = nums[start];
        int r = 0;
        // 得到最后一间屋子不偷的最大值
        for (int i = start + 1; i < end; i++) {
            r = Math.max(q, p + nums[i]);
            p = q;
            q = r;
        }
        return r;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
