//一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [4,1,4,6]
//输出：[1,6] 或 [6,1]
// 
//
// 示例 2： 
//
// 输入：nums = [1,2,10,4,1,4,3,3]
//输出：[2,10] 或 [10,2] 
//
// 
//
// 限制： 
//
// 
// 2 <= nums.length <= 10000 
// 
//
// 
// 👍 283 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] singleNumbers(int[] nums) {
        int k = 0;
        // 得到所有元素的异或值，即最终a ^ b = k;
        for (int num : nums) {
            k ^= num;
        }
        // 找到所有这个异或值从右往左的第一个1，
        // 说明两个不同数的二进制数对应这个1的位置是不同的，
        // 可以作为分组标识
        int flagK = 1;
        // 直到找到二进制位不同退出
        while ((flagK & k) == 0) {
            flagK <<= 1;
        }
        int a = 0;
        int b = 0;
        for (int num : nums) {
            if ((flagK & num) == 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }
        return new int[]{a, b};
    }
}
//leetcode submit region end(Prohibit modification and deletion)
