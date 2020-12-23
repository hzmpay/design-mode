package com.hzm.leetcode.堆;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * https://leetcode-cn.com/problems/top-k-frequent-elements/
 *
 * @author Hezeming
 * @version 1.0
 * @date 2020年12月22日
 */
public class 前K个高频元素 {

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,33333333};
//        sort(nums, 0, nums.length - 1);
        int[] ints = topKFrequent2(nums, 2);
        System.out.println(Arrays.toString(ints));
    }

    public static int[] topKFrequent2(int[] nums, int k) {
        // 构建出现次数Map<值，出现次数>
        Map<Integer, Integer> map = new HashMap<>(nums.length / 3 * 4);
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // 按照value值从小到大排
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue((Comparator<Map.Entry<Integer, Integer>>) (o1, o2) -> o1.getValue() - o2.getValue());

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            // 存入K个数即可
            if (queue.size() == k) {
                // 判断是否比栈顶的值大
                if (entry.getValue() > queue.peek().getValue()) {
                    // 出栈
                    queue.poll();
                    // 入栈
                    queue.offer(entry);
                }
            } else {
                queue.offer(entry);
            }
        }
        int[] result = new int[k];
        for (int i = 0; i < result.length; i++) {
            result[i] = queue.poll().getKey();
        }
        return result;
    }

    /**
     * 快排方式
     *
     * @param nums
     * @param k
     * @return int[]
     * @author Hezeming
     */
    public static int[] topKFrequent1(int[] nums, int k) {
        // 构建出现次数Map<值，出现次数>
        Map<Integer, Integer> map = new HashMap<>(nums.length / 3 * 4);
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        map.keySet();
        Map.Entry[] entryArr = map.entrySet().toArray(new Map.Entry[0]);
        sort(entryArr, 0, entryArr.length - 1);


        int[] result = new int[k];
        for (int i = 0; i < result.length; i++) {
            result[i] = (int) entryArr[i].getKey();
        }

        return result;
    }

    public static void sort(Map.Entry[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        int left = l;
        int right = r;

        // 最左边的当做中间值
        int temp = (int) nums[l].getValue();
        // 直到左右指针相遇
        while (left < right) {
            while (((int) nums[right].getValue() <= temp) && (left < right)) {
                right--;
            }
            swap(nums, right, left);

            while (((int) nums[left].getValue() >= temp) && (left < right)) {
                left++;
            }
            swap(nums, left, right);
        }
        sort(nums, l, left);
        sort(nums, left + 1, r);
    }

    public static void swap(Map.Entry[] nums, int l, int r) {
        Map.Entry temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}
