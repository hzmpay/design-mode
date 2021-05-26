//给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。 
//
// 示例: 
//
// 输入: [-2,1,-3,4,-1,2,1,-5,4]
//输出: 6
//解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
// 
//
// 进阶: 
//
// 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。 
// Related Topics 数组 分治算法 动态规划 
// 👍 2782 👎 0


import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxSubArray(int[] nums) {
        // f(i) = max[f(n - 1) + nums(i), nums(i)]
        if (nums.length == 1) {
            return nums[0];
        }
        int maxNum = nums[0];
        int preNum = maxNum;
        for (int i = 1; i < nums.length; i++) {
            preNum = Math.max(preNum + nums[i], nums[i]);
            maxNum = Math.max(preNum, maxNum);
        }
        return maxNum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
