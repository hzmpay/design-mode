package com.hzm.leetcode.数组;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array/
 *
 * @author Hezeming
 * @version 1.0
 * @date 2021年02月06日
 */
public class 找到所有数组中消失的数字 {

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
