package com.hzm.leetcode.栈;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/daily-temperatures/
 *
 * @author Hezeming
 * @version 1.0
 * @date 2020年11月20日
 */
public class 每日温度 {

    public static void main(String[] args) {
    }

    /**
     * 暴力解法
     *
     * @param T
     * @return int[]
     * @author Hezeming
     */
    public static int[] dailyTemperatures1(int[] T) {
        int length = T.length;

        // 遍历到倒数一个即可，最后一位肯定为0
        for (int i = 0; i < length - 1; i++) {
            j:
            for (int j = i + 1, num = 1; j < length; j++, num++) {
                if (T[j] > T[i]) {
                    // 找到了
                    T[i] = num;
                    break j;
                }
                if (j == length - 1) {
                    // 最后都没找到
                    T[i] = 0;
                }
            }
        }
        // 最后一位肯定为0
        T[length - 1] = 0;
        return T;
    }

    public static int[] dailyTemperatures2(int[] T) {
        int length = T.length;

        int[] result = new int[length];
        Deque<Integer> stack = new LinkedList<>();

        int preIdx = 0;
        for (int i = 0; i < T.length; i++) {
            if (stack.isEmpty()) {
                stack.push(T[i]);
                preIdx = i;
            } else {
                if (T[i] > T[preIdx]) {

                }
            }

        }


        return result;
    }

}
