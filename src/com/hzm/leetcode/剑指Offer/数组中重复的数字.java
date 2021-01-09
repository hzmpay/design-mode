package com.hzm.leetcode.剑指Offer;

/**
 * https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
 *
 * @author Hezeming
 * @version 1.0
 * @date 2021年01月08日
 */
public class 数组中重复的数字 {

    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 0, 2, 5, 3};
        System.out.println(findRepeatNumber(arr));
    }

    public static int findRepeatNumber(int[] nums) {
        // 1.遍历每个坐标
        // 2.根据值作为新的坐标定位新的值，对值进行＋ｎ
        // 3.如果后面值作为坐标对应的值大于等于n，说明这个值重复
        // 因为数组的值的范围为0到n - 1
        final int n = nums.length;
        for (int i = 0; i < n; i++) {
            int k = nums[i];
            // 说明这个位置的值被改变过，需要恢复原始坐标定位
            if (k >= n) {
                k -= n;
            }
            if (nums[k] >= n) {
                return k;
            } else {
                nums[k] += n;
            }
        }
        return -1;
    }
}
