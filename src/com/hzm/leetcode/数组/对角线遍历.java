package com.hzm.leetcode.数组;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/diagonal-traverse/
 *
 * @author Hezeming
 * @version 1.0
 * @date 2021年01月13日
 */
public class 对角线遍历 {

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        int[] diagonalOrder = findDiagonalOrder(matrix);
        System.out.println(Arrays.toString(diagonalOrder));
    }

    public static int[] findDiagonalOrder(int[][] matrix) {
        int nLen = matrix.length;
        int mLen = matrix[0].length;
        int[] result = new int[nLen * mLen];
        int num = 0;

        // 是否是从下往上
        boolean isUp = true;

        //
        int i = 0, j = 0;
        b:
        while (true) {
            if (isUp) {
                isUp = !isUp;
                // 下 -> 上：
                a:
                while (true) {
                    result[num++] = matrix[i][j];
                    // 右移
                    if (i == 0 && j != mLen - 1) {
                        j = j + 1;
                        break a;
                    }
                    // 下移
                    if (j == mLen - 1) {
                        // 到最后一个节点
                        if (i == nLen - 1) {
                            break b;
                        }
                        i = i + 1;
                        break a;
                    }
                    i = i - 1;
                    j = j + 1;
                }
            } else {
                isUp = !isUp;
                // 上 -> 下：
                a:
                while (true) {
                    result[num++] = matrix[i][j];
                    // 下移
                    if (j == 0 && i != nLen - 1) {
                        i = i + 1;
                        break a;
                    }
                    // 右移
                    if (i == nLen - 1) {
                        // 到最后一个节点
                        if (j == mLen - 1) {
                            break b;
                        }
                        j = j + 1;
                        break a;
                    }
                    i = i + 1;
                    j = j - 1;
                }
            }
        }
        return result;
    }

    //  1   2   3
    //  4   5   6
    //  7   8   9

}
