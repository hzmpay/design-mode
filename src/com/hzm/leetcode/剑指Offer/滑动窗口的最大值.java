package com.hzm.leetcode.剑指Offer;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof/
 *
 * @author Hezeming
 * @version 1.0
 * @date 2021年02月06日
 */
public class 滑动窗口的最大值 {

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        maxSlidingWindow(nums, 3);
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
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
