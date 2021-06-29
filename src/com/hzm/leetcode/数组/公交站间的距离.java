package com.hzm.leetcode.数组;

/**
 * https://leetcode-cn.com/problems/distance-between-bus-stops/
 *
 * @author Hezeming
 * @version 1.0
 * @date 2021年06月24日
 */
public class 公交站间的距离 {

    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int n = distance.length;
        if (start == destination) { // start和destinattion重叠
            return 0;
        }
        int diff = destination - start;
        if (diff < 0) {
            // 调换位置，保持destination在start后面
            int temp = start;
            start = destination;
            destination = temp;
        }
        // 因为坐标对应的值是坐标+1
        // start - destination
        int num1 = 0;
        for (int i = start; i < destination; i++) {
            num1 += distance[i];
        }
        // 0 - start
        // destination - distance.length
        int num2 = 0;
        for (int i = 0; i < start; i++) {
            num2 += distance[i];
        }
        for (int i = destination; i < n; i++) {
            num2 += distance[i];
        }
        return Math.min(num1, num2);
    }
}
