//给定一个含有 M x N 个元素的矩阵（M 行，N 列），请以对角线遍历的顺序返回这个矩阵中的所有元素，对角线遍历如下图所示。 
//
// 
//
// 示例: 
//
// 输入:
//[
// [ 1, 2, 3 ],
// [ 4, 5, 6 ],
// [ 7, 8, 9 ]
//]
//
//输出:  [1,2,4,7,5,3,6,8,9]
//
//解释:
//
// 
//
// 
//
// 说明: 
//
// 
// 给定矩阵中的元素总数不会超过 100000 。 
// 
// 👍 159 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
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
}
//leetcode submit region end(Prohibit modification and deletion)
