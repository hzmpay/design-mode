package com.hzm.leetcode.数组;

/**
 * https://leetcode-cn.com/problems/non-decreasing-array/
 *
 * @author Hezeming
 * @version 1.0
 * @date 2021年02月07日
 */
public class 非递减数列 {

    public static void main(String[] args) {
        System.out.println(checkPossibility2(new int[]{3,4,2,3}));
    }

    public static boolean checkPossibility2(int[] nums) {
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

    public static boolean checkPossibility(int[] nums) {
        int flag = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            // 不满足
            if (nums[i] > nums[i + 1]) {
                if (flag == 1) {
                    // 第二次不满足直接返回false
                    return false;
                } else { // 第一次不满足
                    nums[i] = nums[i + 1];
                    // 交换的同时还得满足nums[i - 1] <= nums[i + 1]
                    if (i != 0 && nums[i - 1] > nums[i + 1]) {
                        // 前一个数不匹配
                        return false;
                    }
                    flag++;
                }
            }
        }
        return true;
    }
}
