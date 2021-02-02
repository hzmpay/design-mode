package com.hzm.leetcode.排序;

import java.util.Arrays;

/**
 * @author Hezeming
 * @version 1.0
 * @date 2021年01月28日
 */
public class 快排 {

    public static void main(String[] args) {

        int[] arr = {2, 5, 6, 7, 8, 1, 2, 6};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

    }

    public static void quickSort(int[] arr, int left, int right) {
        if (left > right) {
            return;
        }
        int l = left;
        int r = right;
        int temp = arr[r];
        while (l < r) {
            while (arr[l] >= temp && l < r) {
                l++;
            }
            swap(arr, l, r);
            while (arr[r] <= temp && l < r) {
                r--;
            }
            swap(arr, l, r);
        }
        quickSort(arr, left, r - 1);
        quickSort(arr, r + 1, right);
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
