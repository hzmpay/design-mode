//给定一个范围在 1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。 
//
// 找到所有在 [1, n] 范围之间没有出现在数组中的数字。 
//
// 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。 
//
// 示例: 
//
// 
//输入:
//[4,3,2,7,8,2,3,1]
//
//输出:
//[5,6]
// 
// Related Topics 数组 
// 👍 550 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 思路：数组中的数是1到n的范围，
     * 1.遍历数组，将值当作坐标映射新值，标记为负数
     * 2.再次遍历，负数的坐标+1的数字说明出现过，正数就是消失的数字
     *
     * @param nums
     * @return java.util.List<java.lang.Integer>
     * @author Hezeming
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        // 1.标记负数
        for (int i = 0; i < nums.length; i++) {
            // 数组中的数是1到n的范围，所以对应数组坐标减1
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }
        List<Integer> result = new ArrayList<>();
        // 寻找非负数
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i + 1);
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
