package com.hzm.leetcode.剑指Offer;

/**
 * https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/
 *
 * @author Hezeming
 * @version 1.0
 * @date 2021年01月09日
 */
public class 二维数组中的查找 {

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        /*
         * 先按行搜索，再按列搜索
         */
        int maxY = -1;
        x:
        for (int i = 0; i < matrix.length; i++) {
            int[] ints = matrix[i];
            y:
            for (int j = 0; j < ints.length && (maxY == -1 || j < maxY); j++) {
                if (target == ints[j]) {
                    return true;
                } else if (target < ints[j]) {
                    if (j == 0) {
                        break x;
                    }
                    // 小于说明这个J为最大列
                    maxY = j;
                    break y;
                }
            }
        }
        return false;
    }
}
