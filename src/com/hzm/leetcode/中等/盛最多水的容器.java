package com.hzm.leetcode.中等;

/**
 * https://leetcode-cn.com/problems/container-with-most-water/solution/sheng-zui-duo-shui-de-rong-qi-by-leetcode-solution/
 *
 * @author Hezeming
 * @version 1.0
 * @date 2020年11月15日
 */
public class 盛最多水的容器 {

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }

    public static int maxArea(int[] height) {
        // 数组长度
        int length = height.length;
        // 返回的最大面积
        int maxArea = 0;

        // 定义左右指针
        int left = 0;
        int right = length - 1;
        // 直到指针碰撞
        while (right > left) {

            int leftHeight = height[left];
            int rightHeight = height[right];
            int newArea;
            // 左指针高小于或等于右指针高
            if (leftHeight <= rightHeight) {
                // 算出水桶面积
                newArea = leftHeight * (right - left);
                // 左指针向右移
                left++;
            } else {
                // 算出水桶面积
                newArea = rightHeight * (right - left);
                // 右指针向左移
                right--;
            }
            maxArea = Math.max(newArea, maxArea);

        }
        return maxArea;

    }
}
