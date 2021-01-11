package com.hzm.leetcode.剑指Offer;

/**
 * https://leetcode-cn.com/problems/li-wu-de-zui-da-jie-zhi-lcof/solution/mian-shi-ti-47-li-wu-de-zui-da-jie-zhi-dong-tai-gu/
 *
 * @author Hezeming
 * @version 1.0
 * @date 2021年01月11日
 */
public class 礼物的最大价值 {

    public int maxValue(int[][] grid) {
        // i为行（横向），j为列（纵向）
        // 当前格子的和 = max（上面格子的和，左边格子的和）+ 当前格子的数
        // f(i, j) = max[f(i, j - 1) + f(i - 1, j)] + gird(i, j);
        if (grid == null || grid.length == 0) {
            return 0;
        }
        // i = 0，左边没和，只有上面有和：f(i, j) = f(i, j - 1) + gird(i, j);
        // j = 0，上面没和，只有左边有和：f(i, j) = f(i - 1, j) + gird(i, j);
        int jLeng = grid.length;
        int iLeng = grid[0].length;
        // 遍历计算每个格子的最大和
        for (int j = 0; j < jLeng; j++) {
            for (int i = 0; i < iLeng; i++) {
                // 起始位置
                if (j == 0 && i == 0) {
                    continue;
                } else if (j == 0) {
                    // 只有左边有和：f(i, j) = f(i - 1, j) + gird(i, j);
                    grid[j][i] = grid[j][i - 1] + grid[j][i];
                } else if (i == 0) {
                    // 只有上面有和：f(i, j) = f(i, j - 1) + gird(i, j);
                    grid[j][i] = grid[j - 1][i] + grid[j][i];
                } else {
                    // f(i, j) = max[f(i, j - 1) + f(i - 1, j)] + gird(i, j);
                    grid[j][i] = Integer.max(grid[j][i - 1], grid[j - 1][i]) + grid[j][i];
                }
            }
        }
        return grid[jLeng - 1][iLeng - 1];
    }
}
