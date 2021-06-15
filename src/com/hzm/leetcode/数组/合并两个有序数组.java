package com.hzm.leetcode.数组;

/**
 * https://leetcode-cn.com/problems/merge-sorted-array/
 *
 * @author Hezeming
 * @version 1.0
 * @date 2021年06月09日
 */
public class 合并两个有序数组 {

    public static void main(String[] args) {

    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
        // 输出：[1,2,2,3,5,6]
        int p1 = m - 1;
        int p2 = n - 1;
    }

    public void swap(int[] nums1, int m, int[] nums2, int n) {
        int temp = nums1[m];
        nums1[m] = nums2[n];
        nums2[n] = temp;
    }
}
