package com.hzm.leetcode.数字;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/maximum-subarray/solution/zui-da-zi-xu-he-by-leetcode-solution/
 * TODO 有问题
 *
 * @author Hezeming
 * @version 1.0
 * @date 2021年01月05日
 */
public class 最大子序和 {

    public static void main(String[] args) {
        int[] nums = new int[]{9, 0, -2, -2, -3, -4, 0, 1, -4, 5, -8, 7, -3, 7, -6, -4, -7, -8};
        System.out.println(maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {
        // TODO 思路有问题，应该先把所有的连续正数进行整合成一个新数组，再进行下面请求
        if (nums.length == 1) {
            return nums[0];
        }
        List<Integer> newList = new ArrayList<>();
        int preSum = 0;
        // 标识上一个数时大于0还是小于0
        boolean isPreOk = true;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                if (isPreOk && preSum != 0) {
                    // 前一个大于0
                    newList.add(preSum);
                    preSum = 0;
                }
                newList.add(nums[i]);
            } else if (nums[i] < 0) {
                if (isPreOk && preSum != 0) {
                    // 前一个大于0
                    newList.add(preSum);
                    preSum = 0;
                }
                newList.add(nums[i]);
            } else {
                preSum += nums[i];
            }

            // 处理最后一个数入集合
            if (i == nums.length - 1 && preSum != 0) {
                newList.add(preSum);
            }
            isPreOk = nums[i] > 0;
        }
        nums = new int[newList.size()];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = newList.get(i);
        }

        // 1.找到所有最大正数的坐标
        // 2.根据最大正数向向边拓展计算出和
        int maxNum = Integer.MIN_VALUE;
        // 正整数个数
        int positiveNum = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            // 记录最大数字
            if (num > maxNum) {
                maxNum = num;
                list.clear();
                list.add(i);
            } else if (num == maxNum) {
                // 存在多个最大数字
                list.add(i);
            }
            if (num > 0) {
                positiveNum++;
            }
        }

        if (positiveNum < 2) {
            // 正整数个数小于2则直接返回最大
            return maxNum;
        }
        for (Integer maxNumIndex : list) {
            maxNum = Math.max(calc(nums, maxNumIndex), maxNum);
        }
        return maxNum;
    }

    public static int calc(int[] nums, int maxNumIndex) {
        // 围绕最大值的坐标向左右计算最大和

        int maxNum = nums[maxNumIndex];
        // 左数最大
        int maxNum0 = maxNum;
        int totalSum = nums[maxNumIndex];
        for (int i = maxNumIndex - 1; i >= 0; i--) {
            if (i != maxNumIndex) {
                totalSum += nums[i];
                if (nums[i] > 0) {
                    maxNum0 = Math.max(maxNum0, totalSum);
                }
            }
        }

        // 右数最大
        int maxNum1 = maxNum;
        totalSum = nums[maxNumIndex];
        for (int i = maxNumIndex + 1; i < nums.length; i++) {
            if (i != maxNumIndex) {
                totalSum += nums[i];
                if (nums[i] > 0) {
                    maxNum1 = Math.max(maxNum1, totalSum);
                }
            }
        }
        // 对比左右区域合并
        maxNum = Math.max(maxNum, maxNum0 + maxNum1 - maxNum);

        return maxNum;
    }
}
