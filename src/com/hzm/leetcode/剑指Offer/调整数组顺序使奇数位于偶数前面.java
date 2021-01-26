package com.hzm.leetcode.剑指Offer;

/**
 * https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/
 *
 * @author Hezeming
 * @version 1.0
 * @date 2021年01月21日
 */
public class 调整数组顺序使奇数位于偶数前面 {

    public int[] exchange(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            // 偶数
            if ((nums[left] & 1) == 1) {
                left++;
                continue;
            }
            // 奇数
            if ((nums[right] & 1) == 0) {
                right--;
                continue;
            }
            // 交换值
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }
        return nums;
    }
}
