//给你一个长度为 n 的整数数组，请你判断在 最多 改变 1 个元素的情况下，该数组能否变成一个非递减数列。 
//
// 我们是这样定义一个非递减数列的： 对于数组中所有的 i (0 <= i <= n-2)，总满足 nums[i] <= nums[i + 1]。 
//
// 
//
// 示例 1: 
//
// 输入: nums = [4,2,3]
//输出: true
//解释: 你可以通过把第一个4变成1来使得它成为一个非递减数列。
// 
//
// 示例 2: 
//
// 输入: nums = [4,2,1]
//输出: false
//解释: 你不能在只改变一个元素的情况下将其变为非递减数列。
// 
//
// 
//
// 说明： 
//
// 
// 1 <= n <= 10 ^ 4 
// - 10 ^ 5 <= nums[i] <= 10 ^ 5 
// 
// Related Topics 数组 
// 👍 472 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean checkPossibility(int[] nums) {
        if (nums == null) {
            return false;
        }
        if (nums.length == 1) {
            return true;
        }
        // 是否存在nums[i] > nums[i + 1]
        boolean isExist = false;
        // 遍历n - 1次
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > nums[i]) {
                if (isExist) {
                    // 已经出现过一次
                    return false;
                }
                isExist = true;
                // 不是第一个的情况下还得判断前一个数是否也大于当前数
                if (i != 1 && nums[i - 2] > nums[i]) {
                    return false;
                }
                // 开始判断修改值是否符合
                nums[i - 1] = nums[i];
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
