package com.hzm.leetcode.中等;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/3sum/
 *
 * @author Hezeming
 * @version 1.0
 * @date 2020年11月16日
 */
public class 三数之和 {

    public static void main(String[] args) {
//        int[] arr = {-1, 0, 1, 2, -1, -4};
        int[] arr = {-4, -2, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4, 4, 6, 6};
        List<List<Integer>> allList = threeSum(arr);
        for (List<Integer> list : allList) {
            System.out.println(list);
        }
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> allList = new ArrayList<>();
        int len = nums.length;
        // 排除异常情况
        if (nums == null || len < 3) {
            return allList;
        }

        // 排序
        Arrays.sort(nums);

        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) {
                // 排过序，第一个数大于0，直接不成立
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                // 去重
                continue;
            }
            int L = i + 1;
            int R = nums.length - 1;

            while (L < R) {
                int sum = nums[i] + nums[L] + nums[R];
                if (sum == 0) {
                    allList.add(Arrays.asList(nums[i], nums[L], nums[R]));
                    // 下一位去重
                    while (L < R && nums[L] == nums[L + 1]) {
                        L++;
                    }
                    // 下一位去重
                    while (L < R && nums[R] == nums[R - 1]) {
                        R--;
                    }
                    // 指针移动
                    L++;
                    R--;
                } else if (sum > 0) {
                    R--;
                } else if (sum < 0) {
                    L++;
                }
            }
        }
        return allList;
    }
}
