//给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。 
//
// 示例: 
//
// 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
//输出: [3,3,5,5,6,7] 
//解释: 
//
//  滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7 
//
// 
//
// 提示： 
//
// 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。 
//
// 注意：本题与主站 239 题相同：https://leetcode-cn.com/problems/sliding-window-maximum/ 
// Related Topics 队列 Sliding Window 
// 👍 181 👎 0


import java.util.Deque;
import java.util.LinkedList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // 临界点判断
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        //
        int count = nums.length - k + 1;
        int[] result = new int[count];

        // 1.维护k队列，从大到小
        // 2.每次从队尾入队列，小于的直接删除
        Deque<Integer> deque = new LinkedList<>();
        // 准备第一个窗口
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.removeLast();
            }
            deque.addLast(nums[i]);
        }
        result[0] = deque.peekFirst();
        // 从i + k - 1开始窗口滑动
        for (int i = 1, j = k; i < count; i++, j++) {
            // 判断这次剔除的值是否刚好是队列头部
            if (nums[i - 1] == deque.peekFirst()) {
                deque.removeFirst();
            }

            // 队列中小于新加的值直接剔除队列
            while (!deque.isEmpty() && deque.peekLast() < nums[j]) {
                deque.removeLast();
            }
            deque.addLast(nums[j]);
            // 队列头部是最大值
            result[i] = deque.peekFirst();
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
