//在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直
//到到达棋盘的右下角。给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？ 
//
// 
//
// 示例 1: 
//
// 输入: 
//[
//  [1,3,1],
//  [1,5,1],
//  [4,2,1]
//]
//输出: 12
//解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物 
//
// 
//
// 提示： 
//
// 
// 0 < grid.length <= 200 
// 0 < grid[0].length <= 200 
// 
// Related Topics 动态规划 
// 👍 91 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
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
//leetcode submit region end(Prohibit modification and deletion)
