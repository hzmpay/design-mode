package com.hzm.leetcode.集合;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/subsets/
 *
 * @author Hezeming
 * @version 1.0
 * @date 2020年09月29日
 */
public class 子集 {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        List<List<Integer>> subsets = subsets2(arr);
        System.out.println(Arrays.toString(subsets.toArray()));
    }

    private static List<Integer> t = new ArrayList<>();
    private static List<List<Integer>> totalList = new ArrayList<>();

    /**
     * [1，2，3]转换为表示为标识位解决：
     * [0,0,0] -> []
     * [1,0,0] -> [1]
     * [0,1,0] -> [2]
     * [0,0,1] -> [3]
     * [1,1,0] -> [1，2]
     *
     * @param nums
     * @return java.util.List<java.util.List < java.lang.Integer>>
     * @author Hezeming
     */
    public static List<List<Integer>> subsets(int[] nums) {
        int length = nums.length;
        // 从0到（2的length次方 - 1）总共遍历 2的length次方 次数
        for (int mask = 0; mask < (1 << length); mask++) {
            // 每次遍历完清除上一个的子集
            t.clear();
            for (int i = 0; i < length; ++i) {
                // 每次遍历数组长度，进行逐位判断是否存在值
                // &运算 = 一一得一
                // 比如数组为：｛1，2，3｝相当于循环3次：
                // mask & 001
                // mask & 010
                // mask & 100
                // 判断每一位是否有值
                if ((mask & (1 << i)) != 0) {
                    t.add(nums[i]);
                }
            }
            totalList.add(new ArrayList<Integer>(t));
        }
        return totalList;
    }

    /**
     * 优化：第一次肯定是[]空数组，最后一次肯定是集合本身
     *
     * @param nums
     * @return java.util.List<java.util.List < java.lang.Integer>>
     * @author Hezeming
     */
    public static List<List<Integer>> subsets2(int[] nums) {
        int length = nums.length;
        // 第一次肯定是[]空数组，所以循环从1开始
        totalList.add(Collections.emptyList());
        // 从0到（2的length次方 - 1）总共遍历 2的length次方 次数
        for (int mask = 1; mask < ((1 << length) - 1); mask++) {
            // 每次遍历完清除上一个的子集
            for (int i = 0; i < length; ++i) {
                // 每次遍历数组长度，进行逐位判断是否存在值
                // &运算 = 一一得一
                // 比如数组为：｛1，2，3｝相当于循环3次：
                // mask & 001
                // mask & 010
                // mask & 100
                // 判断每一位是否有值
                if ((mask & (1 << i)) != 0) {
                    t.add(nums[i]);
                }
            }
            totalList.add(new ArrayList<Integer>(t));
            t.clear();
        }
        // 最后一次肯定是集合本身，所以循环从(1 << length) - 2结束
        for (int num : nums) {
            t.add(num);
        }
        totalList.add(t);
        return totalList;
    }


}
