package com.hzm.leetcode.堆;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * https://leetcode-cn.com/problems/top-k-frequent-elements/
 *
 * @author Hezeming
 * @version 1.0
 * @date 2020年12月22日
 */
public class 前K个高频元素 {

    public static void main(String[] args) {
        int[] nums = {5, 6, 8, 7, 10, 1};
        sort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    public static int[] topKFrequent(int[] nums, int k) {
        // 构建出现次数Map<值，出现次数>
        Map<Integer, Integer> map = new HashMap<>(nums.length / 3 * 4);
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        map.keySet();

        return nums;
    }

    public static void sort(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        int left = l;
        int right = r;

        // 最左边的当做中间值
        int diffNum = left;
        // 直到左右指针相遇
        while (left < right) {
            while (nums[left] <= nums[diffNum] && left < right) {
                left++;
            }
            swap(nums, left, diffNum);

            while (nums[right] >= nums[diffNum] && left < right) {
                right--;
            }
            swap(nums, right, diffNum);
        }
        sort(nums, l, left);
        sort(nums, left + 1, r);
    }

    public static void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}
